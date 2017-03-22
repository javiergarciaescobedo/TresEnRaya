package tresenraya;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TableroView {

    GridPane gridTableroFichas;
    
    public TableroView() {
        // load the image
        Image image = new Image("tresenraya/pokerchip1.png");
         
        gridTableroFichas = new GridPane();
        for(int x=0; x<3; x++) {
            for(int y=0; y<3; y++) {
                ImageView ivFichaRoja = new ImageView();
                ivFichaRoja.setImage(image);
                gridTableroFichas.add(ivFichaRoja, x, y);
            }
        }        
    }

    public GridPane getGridTableroFichas() {
        return gridTableroFichas;
    }
    
    
}
