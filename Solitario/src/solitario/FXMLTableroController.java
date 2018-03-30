package solitario;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLTableroController implements Initializable {

    //Creación variables
    private final Button[][] btns = new Button[7][7];
    private boolean modificable = false;
    private final Operaciones operaciones = new Operaciones();
    private String msg = "Movimientos";
    ScheduledExecutorService reloj;

    @FXML
    private Button btn02;
    @FXML
    private Button btn03;
    @FXML
    private Button btn04;
    @FXML
    private Button btn12;
    @FXML
    private Button btn13;
    @FXML
    private Button btn14;
    @FXML
    private Button btn20;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
    @FXML
    private Button btn23;
    @FXML
    private Button btn24;
    @FXML
    private Button btn25;
    @FXML
    private Button btn26;
    @FXML
    private Button btn30;
    @FXML
    private Button btn31;
    @FXML
    private Button btn32;
    @FXML
    private Button btn33;
    @FXML
    private Button btn34;
    @FXML
    private Button btn35;
    @FXML
    private Button btn36;
    @FXML
    private Button btn40;
    @FXML
    private Button btn41;
    @FXML
    private Button btn42;
    @FXML
    private Button btn43;
    @FXML
    private Button btn44;
    @FXML
    private Button btn45;
    @FXML
    private Button btn46;
    @FXML
    private Button btn52;
    @FXML
    private Button btn53;
    @FXML
    private Button btn54;
    @FXML
    private Button btn62;
    @FXML
    private Button btn63;
    @FXML
    private Button btn64;
    @FXML
    private TextArea textoSol;
    @FXML
    private ComboBox selecModo;
    @FXML
    private Button Acción;

    final Runnable tarea = new Runnable() {
        @Override
        public void run() {
            if (!operaciones.pila.isEmpty()) {
                String mov = operaciones.pila.pop();
                msg = msg + "\n" + mov;
                textoSol.setText(msg);
                int x1 = Integer.parseInt(mov.substring(0, 1));
                int y1 = Integer.parseInt(mov.substring(2, 3));
                int x2 = Integer.parseInt(mov.substring(4, 5));
                int y2 = Integer.parseInt(mov.substring(6, 7));

                btns[x1][y1].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
                btns[x2][y2].setStyle("-fx-background-image: url('file:src/IMG/CFondo.png')");

                if (x1 == x2) {
                    if (y2 < y1) {
                        btns[x1][y1 - 1].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
                    } else {
                        btns[x1][y1 + 1].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
                    }
                } else {
                    if (x2 < x1) {
                        btns[x1 - 1][y1].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
                    } else {
                        btns[x1 + 1][y1].setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
                    }
                }
            } else {
                selecModo.setDisable(false);
                reloj.shutdownNow();
                if (!selecModo.getValue().toString().equals("Clásico")) {
                    modificable = true;
                    Acción.setDisable(false);
                }
            }

        }

    };//clock

    //Fin creación variables
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selecModo.getItems().addAll("Clásico", "Personalizado");
        textoSol.setText(msg);
        btns[0][2] = btn02;
        btns[0][3] = btn03;
        btns[0][4] = btn04;
        btns[1][2] = btn12;
        btns[1][3] = btn13;
        btns[1][4] = btn14;
        btns[2][0] = btn20;
        btns[2][1] = btn21;
        btns[2][2] = btn22;
        btns[2][3] = btn23;
        btns[2][4] = btn24;
        btns[2][5] = btn25;
        btns[2][6] = btn26;
        btns[3][0] = btn30;
        btns[3][1] = btn31;
        btns[3][2] = btn32;
        btns[3][3] = btn33;
        btns[3][4] = btn34;
        btns[3][5] = btn35;
        btns[3][6] = btn36;
        btns[4][0] = btn40;
        btns[4][1] = btn41;
        btns[4][2] = btn42;
        btns[4][3] = btn43;
        btns[4][4] = btn44;
        btns[4][5] = btn45;
        btns[4][6] = btn46;
        btns[5][2] = btn52;
        btns[5][3] = btn53;
        btns[5][4] = btn54;
        btns[6][2] = btn62;
        btns[6][3] = btn63;
        btns[6][4] = btn64; //Agrega los botones a una matriz
        Acción.setDisable(true);
    }

    public void seleccion() {
        String x = "Clásico";
        if (selecModo.getValue().toString().equals(x)) {
            modificable = false;
            Acción.setDisable(false);
            Acción.setText("Aceptar");//cambia el texto del botón de acción
            Acción.setOnAction(this::iniciar);
            operaciones.llenarTablero(btns);

        } else {
            modificable = true;
            Acción.setDisable(false);
            Acción.setText("Aceptar");//cambia el texto del botón de acción
            Acción.setOnAction(this::iniciar);
            operaciones.vaciarTablero(btns);
        }
    } //Cambia entre el modo clásico y el personalizado

    public void ponerPieza(ActionEvent j) {
        Button h = (Button) j.getSource();
        if (modificable) {
            if (h.getStyle().equals("-fx-background-image: url('file:src/IMG/SFondo.png')")) {
                h.setStyle("-fx-background-image: url('file:src/IMG/CFondo.png')");
            } else {
                h.setStyle("-fx-background-image: url('file:src/IMG/SFondo.png')");
            }
        }
    } //Permite la modificación de las fichas para el modo personalizado

    public void yolo() {
        Acción.setOnAction(this::iniciar);
    }

    public void iniciar(ActionEvent event) {
        modificable = false;
        msg = "Movimientos";
        textoSol.setText(msg);
        operaciones.pila.removeAllElements();
        int[][] m = operaciones.generaMatriz(btns);
        int x = operaciones.getNumeroPiezas(m);
        boolean backtracking;
        String u = "Clásico";
        if (selecModo.getValue().toString().equals(u)) {
            backtracking = operaciones.backtracking(x, m);
        } else {
            backtracking = operaciones.backtrackingS(x, m);
        }
        operaciones.ventana(backtracking);
        if (backtracking) {
            Acción.setText("Iniciar");
            Acción.setOnAction(this::auto);
        }
    } //Prepara el programa para encender el clock y comenzar la solución

    public void auto(ActionEvent event) {
        selecModo.setDisable(true);
        Acción.setDisable(true);
        reloj = Executors.newSingleThreadScheduledExecutor();
        reloj.scheduleAtFixedRate(tarea, 0, 1, TimeUnit.SECONDS);
        Acción.setOnAction(this::iniciar);
    } //Inicia la ejecución automática del programa

}
