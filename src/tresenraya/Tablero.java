package tresenraya;

public class Tablero {
    
    byte[][] tablero = new byte[3][3];
    
    public void inicializar() {
        // TODO: Hacer esto con bucles
        tablero[0][0] = 0;
        tablero[0][1] = 0;
        tablero[0][2] = 0;
        tablero[1][0] = 0;
        tablero[1][1] = 0;
        tablero[1][2] = 0;
        tablero[2][0] = 0;
        tablero[2][1] = 0;
        tablero[2][2] = 0;
    }
    
    public void mostrar() {
        // TODO: Hacer esto con bucles
        System.out.print(tablero[0][0]);
        System.out.print(tablero[0][1]);
        System.out.println(tablero[0][2]);
        System.out.print(tablero[1][0]);
        System.out.print(tablero[1][1]);
        System.out.println(tablero[1][2]);
        System.out.print(tablero[2][0]);
        System.out.print(tablero[2][1]);
        System.out.println(tablero[2][2]);
    }

    public boolean ponerFicha(int x, int y, int jugador) {
        // Si hay una ficha en esa posición, retornar false
        if(tablero[x][y] > 0 || x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        } else {
            // Poner la ficha
            tablero[x][y] = (byte)jugador;
            return true;
        }
    }
    
}
