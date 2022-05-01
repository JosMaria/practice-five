package org.genesiscode.practicefive.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicefive.model.ReachMethod;
import org.genesiscode.practicefive.model.util.MyFunction;

public class PaneReachMethod {

    private static PaneReachMethod paneReachMethod;
    private ReachMethod reachMethod;
    // pane top
    private TextField valueR1, valueR2;
    private TextField txtMultiplicativeByXF1, txtMultiplicativeByXF2, txtConstantF1, txtConstantF2;
    private Label lblR1, lblR2, lblFunction1, lblFunction2;

    private Label lblMultiplicativeByXF1, lblMultiplicativeByXF2, lblConstantF1, lblConstantF2;

    // pane medium
    private TextField valueA, valueB, valueM;
    private Label lblA, lblB, lblM;
    private Button btnStart;

    // pane bottom
    private Label lblResultTitle, lblResultValue;

    private VBox mainPane;

    private static final int COUNT_COLUMNS = 4;

    private PaneReachMethod() {
        loadControls();
        buildPane();
    }

    public synchronized static PaneReachMethod getInstance() {
        if (paneReachMethod == null) {
            paneReachMethod = new PaneReachMethod();
        }
        return paneReachMethod;
    }

    private void loadControls() {
        valueR1 = new TextField();
        valueR1.setPrefColumnCount(COUNT_COLUMNS);

        valueR2 = new TextField();
        valueR2.setPrefColumnCount(COUNT_COLUMNS);

        lblR1 = new Label("R1");
        lblR2 = new Label("R2");

        lblA = new Label("a");
        lblB = new Label("b");
        lblM = new Label("M");

        lblFunction1 = new Label("Funcion 1");
        lblFunction2 = new Label("Funcion 2");

        lblMultiplicativeByXF1 = new Label("?x");
        txtMultiplicativeByXF1 = new TextField();
        txtMultiplicativeByXF1.setPrefColumnCount(COUNT_COLUMNS);

        lblMultiplicativeByXF2 = new Label("?x");
        txtMultiplicativeByXF2 = new TextField();
        txtMultiplicativeByXF2.setPrefColumnCount(COUNT_COLUMNS);

        lblConstantF1 = new Label("constant");
        txtConstantF1 = new TextField();
        txtConstantF1.setPrefColumnCount(COUNT_COLUMNS);

        lblConstantF2 = new Label("constant");
        txtConstantF2 = new TextField();
        txtConstantF2.setPrefColumnCount(COUNT_COLUMNS);

        valueA = new TextField();
        valueA.setPrefColumnCount(COUNT_COLUMNS);

        valueB= new TextField();
        valueB.setPrefColumnCount(COUNT_COLUMNS);

        valueM = new TextField();
        valueM.setPrefColumnCount(COUNT_COLUMNS);

        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> clickStart());

        lblResultTitle = new Label("R2 <= R1");
        lblResultValue = new Label("");
    }

    private void clickStart() {
        double valueA = Double.parseDouble(this.valueA.getText().trim());
        double valueB = Double.parseDouble(this.valueB.getText().trim());
        double valueM = Double.parseDouble(this.valueM.getText().trim());

        double constant1 = Double.parseDouble(txtConstantF1.getText().trim());
        double constant2 = Double.parseDouble(txtConstantF2.getText().trim());
        double multiplicativeX1 = Double.parseDouble(txtConstantF1.getText().trim());
        double multiplicativeX2 = Double.parseDouble(txtConstantF2.getText().trim());

        MyFunction myFunction1 = new MyFunction(constant1, multiplicativeX1);
        MyFunction myFunction2 = new MyFunction(constant2, multiplicativeX2);

        reachMethod = new ReachMethod(valueA, valueB, valueM, myFunction1, myFunction2);
        reachMethod.start();

        lblResultValue.setText(String.format("%s <= %s", reachMethod.getR2(), reachMethod.getR1()));

    }

    private void buildPane() {
        HBox topPane = new HBox(10, new VBox(10, new HBox(10, lblR1, valueR1),
                                                       new HBox(10, lblR2, valueR2)));
        HBox mediumPane = new HBox(20, new HBox(10, lblA, valueA),
                new HBox(10, lblB, valueB),
                new HBox(10, lblM, valueM),
                btnStart);

        VBox mediumFunctionPane = new VBox(10,
                new HBox(10, lblFunction1, lblConstantF1, txtConstantF1, lblMultiplicativeByXF1, txtMultiplicativeByXF1),
                new HBox(10, lblFunction2, lblConstantF2, txtConstantF2, lblMultiplicativeByXF2, txtMultiplicativeByXF2));

        VBox bottomPane = new VBox(10, lblResultTitle, lblResultValue);

        mainPane = new VBox(10, topPane, new VBox(10, mediumPane, mediumFunctionPane), bottomPane);
        mainPane.setPadding(new Insets(20));
    }

    public VBox getMainPane() {
        return mainPane;
    }

}
