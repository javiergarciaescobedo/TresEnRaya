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
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 250);
                
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        Label labelFila = new Label("Fila:");
        grid.add(labelFila, 0, 0);
        Label labelColumna = new Label("Columna:");
        grid.add(labelColumna, 0, 1);
        Label labelJugador = new Label("Jugador:");
        grid.add(labelJugador, 0, 2);
        
        TextField textFieldFila = new TextField();
        grid.add(textFieldFila, 1, 0);
        TextField textFieldColumna = new TextField();
        grid.add(textFieldColumna, 1, 1);
        TextField textFieldJugador = new TextField();
        grid.add(textFieldJugador, 1, 2);
        
        Tablero tablero = new Tablero();
        tablero.inicializar();

        Button btnColocarFicha = new Button("Colocar ficha");
        grid.add(btnColocarFicha, 0, 3);
        btnColocarFicha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int x = Integer.valueOf(textFieldColumna.getText());
                int y = Integer.valueOf(textFieldFila.getText());
                int jug = Integer.valueOf(textFieldJugador.getText());
                tablero.ponerFicha(x, y, jug);
            }
        });
        
//        tablero.ponerFicha(1, 2, Tablero.JUGADOR1);
//        if(!tablero.ponerFicha(1, 2, Tablero.JUGADOR2)) {
//            System.out.println("No se ha podido poner la ficha");
//        }
//        tablero.ponerFicha(0, 1, 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
