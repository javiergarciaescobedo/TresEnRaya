/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Javier
 */
public class TresEnRaya extends Application {

    @Override
    public void start(Stage primaryStage) {

        Tablero tablero = new Tablero();
        tablero.inicializar();

        // Elementos principales de la ventana        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 500, 250);
        primaryStage.setTitle("3 en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Campos de texto del formulario
        Label labelX = new Label("X:");
        grid.add(labelX, 0, 0);
        TextField textFieldX = new TextField();
        /* Para asignar tamaño fijo
        textFieldFila.setPrefWidth(50);
        textFieldFila.setMinWidth(50);
        textFieldFila.setMaxWidth(50);*/
        grid.add(textFieldX, 1, 0);

        Label labelY = new Label("Y:");
        grid.add(labelY, 0, 1);
        TextField textFieldY = new TextField();
        grid.add(textFieldY, 1, 1);

        Label labelX2 = new Label("A X:");
        grid.add(labelX2, 2, 0);
        TextField textFieldX2 = new TextField();
        grid.add(textFieldX2, 3, 0);

        Label labelY2 = new Label("A Y:");
        grid.add(labelY2, 2, 1);
        TextField textFieldY2 = new TextField();
        grid.add(textFieldY2, 3, 1);

        Label labelJugador = new Label("Jugador:");
        grid.add(labelJugador, 0, 2);
        TextField textFieldJugador = new TextField();
        grid.add(textFieldJugador, 1, 2);

        // Tablero en pantalla
//        Label labelTablero = new Label("");
//        labelTablero.setText(tablero.toString());
//        labelTablero.setMinHeight(50);
//        grid.add(labelTablero, 1, 3);
        TableroView tableroView = new TableroView();  
//        tableroView.crear();
        grid.add(tableroView.getGridTableroFichas(), 1, 3);

        Label labelInfo = new Label("");
        labelInfo.setMinHeight(50);
        grid.add(labelInfo, 3, 3);
        


        Button btnMoverFicha = new Button("Mover ficha");
        grid.add(btnMoverFicha, 3, 2);
        btnMoverFicha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int x1 = Integer.valueOf(textFieldY.getText());
                int y1 = Integer.valueOf(textFieldX.getText());
                int x2 = Integer.valueOf(textFieldY2.getText());
                int y2 = Integer.valueOf(textFieldX2.getText());
                int jug = Integer.valueOf(textFieldJugador.getText());
                tablero.moverFicha(x1, y1, x2, y2, jug);
                // Mostrar el tablero como texto
//                labelTablero.setText(tablero.toString());
            }
        });

        // Contadores de fichas colocadas
        grid.add(new Label("Fichas Jug.1:"), 0, 4);
        grid.add(new Label("Fichas Jug.2:"), 0, 5);
        Label labelNumFichasJ1 = new Label("0");
        grid.add(labelNumFichasJ1, 1, 4);
        Label labelNumFichasJ2 = new Label("0");
        grid.add(labelNumFichasJ2, 1, 5);

        // Botón "Colocar Ficha"
        Button btnColocarFicha = new Button("Colocar ficha");
        grid.add(btnColocarFicha, 0, 3);
        btnColocarFicha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    // Obtener datos introducidos por el usuario
                    int x = Integer.valueOf(textFieldY.getText());
                    int y = Integer.valueOf(textFieldX.getText());
                    int jug = Integer.valueOf(textFieldJugador.getText());
                    // Colocar la ficha indicada por el usuario
                    tablero.ponerFicha(x, y, jug);
                    // Mostrar el tablero como texto
//                    labelTablero.setText(tablero.toString());
                    // Mostrar el número de fichas colocadas por cada jugador
                    switch (jug) {
                        case Tablero.JUGADOR1:
                            labelNumFichasJ1.setText(String.valueOf(
                                    tablero.getNumFichas(Tablero.JUGADOR1))
                            );
                            break;
                        case Tablero.JUGADOR2:
                            labelNumFichasJ2.setText(String.valueOf(
                                    tablero.getNumFichas(Tablero.JUGADOR2))
                            );
                            break;
                    }
                    byte ganador = tablero.comprobarResultado();
                    if (ganador != 0) {
                        labelInfo.setText("Ha ganado el jugador: " + ganador);
                    }
                    // Controlar que los valores indicados son numéricos
                } catch (NumberFormatException ex) {
//                    labelTablero.setText("Valor incorrecto");
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
