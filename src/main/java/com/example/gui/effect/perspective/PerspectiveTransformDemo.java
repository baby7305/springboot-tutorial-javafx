package com.example.gui.effect.perspective;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.PerspectiveTransform;
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
public class PerspectiveTransformDemo extends Application {
    PerspectiveTransform perspectiveTrasform;
    Group group;

    @Override
    public void start(Stage primaryStage) {

        perspectiveTrasform = new PerspectiveTransform();
        perspectiveTrasform.setUlx(150.0);
        perspectiveTrasform.setUly(5.0);
        perspectiveTrasform.setUrx(420.0);
        perspectiveTrasform.setUry(55.0);
        perspectiveTrasform.setLrx(450.0);
        perspectiveTrasform.setLry(100.0);
        perspectiveTrasform.setLlx(25.0);
        perspectiveTrasform.setLly(185.0);

        Text text = new Text();
        text.setText("Perspective Transform");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        group = new Group();
        group.setCache(true);
        group.getChildren().add(text);

        group.setEffect(perspectiveTrasform);

        GridPane gridpane = createPane();

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(group);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Perspective Transform Demo");
        // Set the width of Stage
        primaryStage.setWidth(500);
        // Set the height of Stage
        primaryStage.setHeight(550);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        // Show Stage
        primaryStage.show();
    }

    private GridPane createPane() {

        // Set X Coordinate of the Upper Left Corner
        Label title1 = new Label("Upper Left X:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUlx()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(500.0);
        slider1.setValue(perspectiveTrasform.getUlx());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(2.0);
        slider1.setBlockIncrement(2.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUlx(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Y Coordinate of the Upper Left Corner
        Label title2 = new Label("Upper Left Y:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUly()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(200.0);
        slider2.setValue(perspectiveTrasform.getUly());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUly(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set X Coordinate of the Upper Right Corner
        Label title3 = new Label("Upper Right X:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUrx()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(500.0);
        slider3.setValue(perspectiveTrasform.getUrx());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(2.0);
        slider3.setBlockIncrement(2.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUrx(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Y Coordinate of the Upper Right Corner
        Label title4 = new Label("Upper Right Y:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUry()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(200.0);
        slider4.setValue(perspectiveTrasform.getUry());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUry(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set X Coordinate of the Lower Right Corner
        Label title5 = new Label("Lower Right X:");

        final Label lblValue5 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLrx()));
        lblValue5.setPrefSize(100, 25);

        final Slider slider5 = new Slider();
        slider5.setOrientation(Orientation.HORIZONTAL);
        slider5.setMin(0.0);
        slider5.setMax(500.0);
        slider5.setValue(perspectiveTrasform.getLrx());
        slider5.setMinorTickCount(1);
        slider5.setMajorTickUnit(2.0);
        slider5.setBlockIncrement(2.0);
        slider5.setPrefSize(200, 25);
        slider5.setSnapToTicks(true);

        slider5.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLrx(slider5.getValue());
            lblValue5.setText(new DecimalFormat("0.0").format(slider5.getValue()));
        });

        // Set Y Coordinate of the Lower Right Corner
        Label title6 = new Label("Lower Right Y:");

        final Label lblValue6 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLry()));
        lblValue6.setPrefSize(100, 25);

        final Slider slider6 = new Slider();
        slider6.setOrientation(Orientation.HORIZONTAL);
        slider6.setMin(0.0);
        slider6.setMax(200.0);
        slider6.setValue(perspectiveTrasform.getLry());
        slider6.setMajorTickUnit(0.1);
        slider6.setBlockIncrement(0.1);
        slider6.setPrefSize(200, 25);
        slider6.setSnapToTicks(true);

        slider6.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLry(slider6.getValue());
            lblValue6.setText(new DecimalFormat("0.0").format(slider6.getValue()));
        });

        // Set X Coordinate of the Lower Left Corner
        Label title7 = new Label("Lower Left X:");

        final Label lblValue7 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLlx()));
        lblValue7.setPrefSize(100, 25);

        final Slider slider7 = new Slider();
        slider7.setOrientation(Orientation.HORIZONTAL);
        slider7.setMin(0.0);
        slider7.setMax(500.0);
        slider7.setValue(perspectiveTrasform.getLlx());
        slider7.setMinorTickCount(1);
        slider7.setMajorTickUnit(2.0);
        slider7.setBlockIncrement(2.0);
        slider7.setPrefSize(200, 25);
        slider7.setSnapToTicks(true);

        slider7.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLlx(slider7.getValue());
            lblValue7.setText(new DecimalFormat("0.0").format(slider7.getValue()));
        });

        // Set Y Coordinate of the Lower Left Corner
        Label title8 = new Label("Lower Left Y:");

        final Label lblValue8 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLly()));
        lblValue8.setPrefSize(100, 25);

        final Slider slider8 = new Slider();
        slider8.setOrientation(Orientation.HORIZONTAL);
        slider8.setMin(0.0);
        slider8.setMax(200.0);
        slider8.setValue(perspectiveTrasform.getLly());
        slider8.setMajorTickUnit(0.1);
        slider8.setBlockIncrement(0.1);
        slider8.setPrefSize(200, 25);
        slider8.setSnapToTicks(true);

        slider8.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLly(slider8.getValue());
            lblValue8.setText(new DecimalFormat("0.0").format(slider8.getValue()));
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
        gridpane.add(title4, 0, 3);
        gridpane.add(slider4, 1, 3);
        gridpane.add(lblValue4, 2, 3);
        gridpane.add(title5, 0, 4);
        gridpane.add(slider5, 1, 4);
        gridpane.add(lblValue5, 2, 4);
        gridpane.add(title6, 0, 5);
        gridpane.add(slider6, 1, 5);
        gridpane.add(lblValue6, 2, 5);
        gridpane.add(title7, 0, 6);
        gridpane.add(slider7, 1, 6);
        gridpane.add(lblValue7, 2, 6);
        gridpane.add(title8, 0, 7);
        gridpane.add(slider8, 1, 7);
        gridpane.add(lblValue8, 2, 7);

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
