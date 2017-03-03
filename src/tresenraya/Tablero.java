package tresenraya;

public class Tablero {
    
    public static final byte JUGADOR1 = 1;
    public static final byte JUGADOR2 = 2;

    private byte[][] arrayTablero = new byte[3][3];
    // Contadores para almacenar el número de fichas colocadas por
    //  cada jugador. Se deja la celda 0 sin uso.
    private int[] numFichasJug = new int[3];
    
    public void inicializar() {
        // TODO: Hacer esto con bucles
        arrayTablero[0][0] = 0;
        arrayTablero[0][1] = 0;
        arrayTablero[0][2] = 0;
        arrayTablero[1][0] = 0;
        arrayTablero[1][1] = 0;
        arrayTablero[1][2] = 0;
        arrayTablero[2][0] = 0;
        arrayTablero[2][1] = 0;
        arrayTablero[2][2] = 0;
        
        // Número de fichas iniciales de cada jugador
        // No se utiliza la posición 0 del array por claridad de código
        numFichasJug[JUGADOR1] = 0;
        numFichasJug[JUGADOR2] = 0;
    }
    
    private void mostrar() {
        // TODO: Hacer esto con bucles
        System.out.print(arrayTablero[0][0]);
        System.out.print(arrayTablero[0][1]);
        System.out.println(arrayTablero[0][2]);
        System.out.print(arrayTablero[1][0]);
        System.out.print(arrayTablero[1][1]);
        System.out.println(arrayTablero[1][2]);
        System.out.print(arrayTablero[2][0]);
        System.out.print(arrayTablero[2][1]);
        System.out.println(arrayTablero[2][2]);
    }

    public boolean ponerFicha(int x, int y, int jugador) {
        // Si hay una ficha en esa posición, retornar false
        if(arrayTablero[x][y] > 0 || x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        } else {
            // Poner la ficha
            arrayTablero[x][y] = (byte)jugador;
            numFichasJug[jugador]++;
            this.mostrar();
            return true;
        }
    }
    
    public boolean moverFicha(int xOrig, int yOrig, int xDest, int yDest, int jugador) {
        // Si hay una ficha en la posición de destino, no permitirlo
        if(arrayTablero[xDest][yDest] == 0 && arrayTablero[xOrig][yOrig] == jugador) {
            arrayTablero[xDest][yDest] = arrayTablero[xOrig][yOrig];
            // La posición de origen se deja sin ficha
            arrayTablero[xOrig][yOrig] = 0;
            return true;
        } else {  // Ya hay una ficha en esa posición
            return false;
        }
    }
    
    @Override
    public String toString() {
        String strTablero = "";
        // TODO: Hacer esto con bucles
        strTablero += arrayTablero[0][0];
        strTablero += arrayTablero[0][1];
        strTablero += arrayTablero[0][2];
        strTablero += "\n";
        strTablero += arrayTablero[1][0];
        strTablero += arrayTablero[1][1];
        strTablero += arrayTablero[1][2];
        strTablero += "\n";
        strTablero += arrayTablero[2][0];
        strTablero += arrayTablero[2][1];
        strTablero += arrayTablero[2][2];
        return strTablero;
    }
    
    public int getNumFichas(int jugador) {
        return numFichasJug[jugador];
    }
    
}
