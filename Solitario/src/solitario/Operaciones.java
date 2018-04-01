    
package solitario;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;


public class Operaciones {
    public static Stack<String> pila = new Stack<String>();
    
    public static void Operaciones(){
        
    }
    
    public void llenarTablero(Button[][] x){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i < 2 && j < 2) || (i < 2 && j > 4) || (i > 4 && j < 2) || (i > 4 && j > 4)) {

                } else {
                    x[i][j].setStyle("-fx-background-image: url('file:src/IMG/CFondo.png')");
                }
            }
        }
        x[3][3].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
    }
    
    public void vaciarTablero(Button[][] x){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i < 2 && j < 2) || (i < 2 && j > 4) || (i > 4 && j < 2) || (i > 4 && j > 4)) {

                } else {
                    x[i][j].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
                }
            }
        }
    }
    
    public int[][] generaMatriz(Button[][] x) {
        int[][] matriz = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i < 2 && j < 2) || (i < 2 && j > 4) || (i > 4 && j < 2) || (i > 4 && j > 4)) {
                    matriz[i][j] = 0;
                } else {
                    if (x[i][j].getStyle().equals("-fx-background-image: url('file:src/IMG/SFondo.png')")) {
                        matriz[i][j] = 1;
                    } else {
                        matriz[i][j] = 2;
                    }
                }
            }
        }
        return matriz;
    }
    
    public int getNumeroPiezas(int[][] m) {
        int x = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (m[i][j] == 2) {
                    x++;
                }
            }
        }
        return x;
    }
    
    public boolean backtracking(int n, int[][] l) {
        int[][] m = l;
        
        if (n == 1&& m[3][3]==2) {
            return true;
        }
        
        ArrayList<Posicion> j = soluciones(m);
        while (!j.isEmpty()) {
            Posicion k = j.get(0);
            if (k.izquierda) {
                saltar(k.saltoIzquierda, m);
                if (backtracking(n - 1, m)) {
                    pila.add(k.saltoIzquierda.x1 + "," + k.saltoIzquierda.y1 + "-" + k.saltoIzquierda.x2 + "," + k.saltoIzquierda.y2);
                    return true;
                }
                restaurar(k.saltoIzquierda, m);
            }
            if (k.arriba) {
                saltar(k.saltoArriba, m);
                if (backtracking(n - 1, m)) {
                    pila.add(k.saltoArriba.x1 + "," + k.saltoArriba.y1 + "-" + k.saltoArriba.x2 + "," + k.saltoArriba.y2);
                    return true;
                }
                restaurar(k.saltoArriba, m);
            }
            if (k.derecha) {
                saltar(k.saltoDerecha, m);
                if (backtracking(n - 1, m)) {
                    pila.add(k.saltoDerecha.x1 + "," + k.saltoDerecha.y1 + "-" + k.saltoDerecha.x2 + "," + k.saltoDerecha.y2);
                    return true;
                }
                restaurar(k.saltoDerecha, m);
            }
            if (k.abajo) {
                saltar(k.saltoAbajo, m);
                if (backtracking(n - 1, m)) {
                    pila.add(k.saltoAbajo.x1 + "," + k.saltoAbajo.y1 + "-" + k.saltoAbajo.x2 + "," + k.saltoAbajo.y2);
                    return true;
                }
                restaurar(k.saltoAbajo, m);
            }
            j.remove(0);
        }
            
        return false;
    }
    
    public boolean backtrackingS(int n, int[][] l) {
        int[][] m = l;
        
        if (n == 1) {
            //return resultado = true;
            return true;
        }
        
        ArrayList<Posicion> j = soluciones(m);
        while (!j.isEmpty()) {
            Posicion k = j.get(0);
            if (k.izquierda) {
                saltar(k.saltoIzquierda, m);
                if (backtrackingS(n - 1, m)) {
                    pila.add(k.saltoIzquierda.x1 + "," + k.saltoIzquierda.y1 + "-" + k.saltoIzquierda.x2 + "," + k.saltoIzquierda.y2);
                    return true;
                }
                restaurar(k.saltoIzquierda, m);
            }
            if (k.arriba) {
                saltar(k.saltoArriba, m);
                if (backtrackingS(n - 1, m)) {
                    pila.add(k.saltoArriba.x1 + "," + k.saltoArriba.y1 + "-" + k.saltoArriba.x2 + "," + k.saltoArriba.y2);
                    return true;
                }
                restaurar(k.saltoArriba, m);
            }
            if (k.derecha) {
                saltar(k.saltoDerecha, m);
                if (backtrackingS(n - 1, m)) {
                    pila.add(k.saltoDerecha.x1 + "," + k.saltoDerecha.y1 + "-" + k.saltoDerecha.x2 + "," + k.saltoDerecha.y2);
                    return true;
                }
                restaurar(k.saltoDerecha, m);
            }
            if (k.abajo) {
                saltar(k.saltoAbajo, m);
                if (backtrackingS(n - 1, m)) {
                    pila.add(k.saltoAbajo.x1 + "," + k.saltoAbajo.y1 + "-" + k.saltoAbajo.x2 + "," + k.saltoAbajo.y2);
                    return true;
                }
                restaurar(k.saltoAbajo, m);
            }
            j.remove(0);
        }
            
        return false;
    }
    
    public static ArrayList soluciones(int[][] m) {
        ArrayList<Posicion> lista = new ArrayList<>();
        Posicion punto;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                if (m[i][j] == 2) {
                    punto = solucion(i, j, m);
                    if (punto.isViable()) {
                        lista.add(punto);
                    }
                }
            }
        }
        return lista;
    }
    
    public static Posicion solucion(int x, int y, int[][] m) {
        Posicion clavija = new Posicion(x, y);

        if ((x - 2 > -1) && m[x - 2][y] == 1) {
            if (m[x - 1][y] == 2) {
                clavija.setArriba(true);
                clavija.setViable(true);
            }
        }
        if ((x + 2 < 7) && m[x + 2][y] == 1) {
            if (m[x + 1][y] == 2) {
                clavija.setAbajo(true);
                clavija.setViable(true);
            }
        }
        if ((y - 2 > -1) && m[x][y - 2] == 1) {
            if (m[x][y - 1] == 2) {
                clavija.setIzquierda(true);
                clavija.setViable(true);
            }
        }
        if ((y + 2 < 7) && m[x][y + 2] == 1) {
            if (m[x][y + 1] == 2) {
                clavija.setDerecha(true);
                clavija.setViable(true);
            }
        }

        return clavija;
    }
    
    public static int[][] saltar(Salto j, int[][] m) {
        m[j.x1][j.y1] = 1;
        m[j.x2][j.y2] = 2;

        if (j.x1 == j.x2) {
            if (j.y2 < j.y1) {
                m[j.x1][j.y1 - 1] = 1;
            } else {
                m[j.x1][j.y1 + 1] = 1;
            }
        } else {
            if (j.x2 < j.x1) {
                m[j.x1 - 1][j.y1] = 1;
            } else {
                m[j.x1 + 1][j.y1] = 1;
            }
        }
        return m;
    }
    
    public static int[][] restaurar(Salto j, int[][] m) {
        m[j.x1][j.y1] = 2;
        m[j.x2][j.y2] = 1;
        if (j.x1 == j.x2) {
            if (j.y2 < j.y1) {
                m[j.x1][j.y1 - 1] = 2;
            } else {
                m[j.x1][j.y1 + 1] = 2;
            }
        } else {
            if (j.x2 < j.x1) {
                m[j.x1 - 1][j.y1] = 2;
            } else {
                m[j.x1 + 1][j.y1] = 2;
            }
        }

        return m;
    }
    
    public void ventana(boolean h) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        if (h == true) {
            alert.setContentText("Solución encontrada, click en el boton !Iniciar! para visualizar");
        } else {
            alert.setContentText("Este tablero no tiene solución, por favor cambielo");
        }
        alert.show();
    }
    
}
