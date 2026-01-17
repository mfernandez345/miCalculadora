package miCalculadora;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        int w = 70, h = 70;

        // === GRID PRINCIPAL ===
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // === DISPLAY (fila 0, ocupa 4 columnas) ===
        TextField display = new TextField();
        display.setEditable(false);
        display.getStyleClass().add("display");
        grid.add(display, 0, 0, 4, 1);

        // === FILA 1 ===
        Button btnC = new Button("C");
        Button btnComa = new Button("，");
        Button btnDiv = new Button("÷");
        Button btnMul = new Button("×");

        btnC.setPrefSize(w, h);
        btnComa.setPrefSize(w, h);
        btnDiv.setPrefSize(w, h);
        btnMul.setPrefSize(w, h);

        btnC.getStyleClass().add("calc-button");
        btnComa.getStyleClass().add("calc-button");
        btnDiv.getStyleClass().add("calc-button");
        btnMul.getStyleClass().add("calc-button");

        grid.add(btnC, 0, 1);
        grid.add(btnComa, 1, 1);
        grid.add(btnDiv, 2, 1);
        grid.add(btnMul, 3, 1);

        // === FILA 2 ===
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnMenos = new Button("−");

        btn7.setPrefSize(w, h);
        btn8.setPrefSize(w, h);
        btn9.setPrefSize(w, h);
        btnMenos.setPrefSize(w, h);

        btn7.getStyleClass().add("calc-button");
        btn8.getStyleClass().add("calc-button");
        btn9.getStyleClass().add("calc-button");
        btnMenos.getStyleClass().add("calc-button");

        grid.add(btn7, 0, 2);
        grid.add(btn8, 1, 2);
        grid.add(btn9, 2, 2);
        grid.add(btnMenos, 3, 2);

        // === FILA 3 ===
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btnMas = new Button("＋");

        btn4.setPrefSize(w, h);
        btn5.setPrefSize(w, h);
        btn6.setPrefSize(w, h);
        btnMas.setPrefSize(w, h);

        btn4.getStyleClass().add("calc-button");
        btn5.getStyleClass().add("calc-button");
        btn6.getStyleClass().add("calc-button");
        btnMas.getStyleClass().add("calc-button");

        grid.add(btn4, 0, 3);
        grid.add(btn5, 1, 3);
        grid.add(btn6, 2, 3);
        grid.add(btnMas, 3, 3);

        // === FILA 4 ===
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btnIgual = new Button("=");

        btn1.setPrefSize(w, h);
        btn2.setPrefSize(w, h);
        btn3.setPrefSize(w, h);

        btnIgual.setPrefSize(w, h * 2 + 10);

        btn1.getStyleClass().add("calc-button");
        btn2.getStyleClass().add("calc-button");
        btn3.getStyleClass().add("calc-button");
        btnIgual.getStyleClass().add("calc-button");

        grid.add(btn1, 0, 4);
        grid.add(btn2, 1, 4);
        grid.add(btn3, 2, 4);

        // "=" ocupa filas 4 y 5
        grid.add(btnIgual, 3, 4, 1, 2);

        // === FILA 5 ===
        Button btn0 = new Button("0");
        btn0.setPrefSize(w * 3 + 20, h);
        btn0.getStyleClass().add("calc-button");

        grid.add(btn0, 0, 5, 3, 1);

        // === ESCENA ===
        Scene scene = new Scene(grid, 300, 440);
        scene.getStylesheets().add(getClass().getResource("calculadora.css").toExternalForm());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Calculadora");
        stage.show();
    }

    public static void main(String[] args) {
        //commit firmado como mfernandez345
        System.out.println("Probando CI desde main()");
        launch();
    }
}
