package com.example.gui.effect.blur;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.MotionBlur;
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
public class MotionBlurDemo extends Application {
    MotionBlur motionblur;

    Text text;

    @Override
    public void start(Stage primaryStage) {
        motionblur = new MotionBlur();
        motionblur.setAngle(180.0);
        motionblur.setRadius(20.0);

        text = new Text();
        text.setEffect(motionblur);
        text.setText("Motion Blur");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        GridPane gridpane = createPane();

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Motion Blur Demo");
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

        // Set Angle
        Label title1 = new Label("Angle:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(motionblur.getAngle()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(-360.0);
        slider1.setMax(360.0);
        slider1.setValue(motionblur.getAngle());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(5.0);
        slider1.setBlockIncrement(5.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            motionblur.setAngle(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Radius
        Label title2 = new Label("Radius:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(motionblur.getRadius()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(63.0);
        slider2.setValue(motionblur.getRadius());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            motionblur.setRadius(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
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

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
