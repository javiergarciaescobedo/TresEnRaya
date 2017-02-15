/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Javier
 */
public class TresEnRaya extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Rectangle r = new Rectangle();
        
        Tablero tablero = new Tablero();
        tablero.inicializar();
        tablero.ponerFicha(1, 2, 1);
        if(!tablero.ponerFicha(1, 2, 2)) {
            System.out.println("No se ha podido poner la ficha");
        }
        tablero.ponerFicha(0, 1, 2);
//        tablero.arrayTablero[1][2] = 2;
//        tablero.mostrar();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
