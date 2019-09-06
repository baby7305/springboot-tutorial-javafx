package com.example.gui.effect.blur;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * @author Leo Huang
 */
public class BoxBlurDemo extends Application {
    BoxBlur boxblur;

    Text text;

    @Override
    public void start(Stage primaryStage) {
        boxblur = new BoxBlur();
        boxblur.setWidth(10.0);
        boxblur.setHeight(10.0);
        boxblur.setIterations(3);

        text = new Text();
        text.setEffect(boxblur);
        text.setText("Box Blur");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        GridPane gridpane = createPane();

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Box Blur Demo");
        // Set the width of Stage
        primaryStage.setWidth(500);
        // Set the height of Stage
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        // Show Stage
        primaryStage.show();
    }

    private GridPane createPane() {

        // Set Width
        Label title1 = new Label("Width:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(boxblur.getWidth()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(255.0);
        slider1.setValue(boxblur.getWidth());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(5.0);
        slider1.setBlockIncrement(5.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boxblur.setWidth(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Height
        Label title2 = new Label("Height:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(boxblur.getHeight()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(255.0);
        slider2.setValue(boxblur.getHeight());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(5.0);
        slider2.setBlockIncrement(5.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boxblur.setHeight(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Iterations
        Label title3 = new Label("Iterations:");
        title3.setPrefWidth(90);

        final Label lblValue3 = new Label(new DecimalFormat("0").format(boxblur.getIterations()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0);
        slider3.setMax(3);
        slider3.setValue(boxblur.getIterations());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(1);
        slider3.setBlockIncrement(1);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boxblur.setIterations((int) slider3.getValue());
            lblValue3.setText(new DecimalFormat("0").format(slider3.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);
        gridpane.add(title3, 0, 2);
        gridpane.add(slider3, 1, 2);
        gridpane.add(lblValue3, 2, 2);

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
