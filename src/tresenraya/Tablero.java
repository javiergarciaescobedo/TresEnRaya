package tresenraya;

public class Tablero {
    
    private byte[][] arrayTablero = new byte[3][3];
    public static final byte JUGADOR1 = 1;
    public static final byte JUGADOR2 = 2;
    
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
            this.mostrar();
            return true;
        }
    }
    
}
