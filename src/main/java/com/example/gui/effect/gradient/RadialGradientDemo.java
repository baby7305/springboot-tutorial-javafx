package com.example.gui.effect.gradient;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * @author Leo Huang
 */
public class RadialGradientDemo extends Application {

    Rectangle rectangle = null;

    ColorPicker colorpicker1, colorpicker2;

    Stop[] stops;

    RadialGradient radialgradient;

    @Override
    public void start(Stage primaryStage) {

        stops = new Stop[]{
                new Stop(0.0, Color.RED),
                new Stop(0.5, Color.ORANGE),
                new Stop(1.0, Color.YELLOW)
        };

        radialgradient = new RadialGradient(0.0, 0.0, 0.5, 0.5, 0.1, true, CycleMethod.REFLECT, stops);

        rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setHeight(150);
        rectangle.setWidth(150);
        rectangle.setFill(radialgradient);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1.0);

        Group group = new Group();
        group.getChildren().add(rectangle);

        GridPane gridpane = createPane();

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(group);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Radial Gradient Demo");
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

        // Set Focus Angle
        Label title1 = new Label("Focus Angle:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(radialgradient.getFocusAngle()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(360.0);
        slider1.setValue(radialgradient.getFocusAngle());
        slider1.setMinorTickCount(5);
        slider1.setMajorTickUnit(10);
        slider1.setBlockIncrement(10);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = slider1.getValue();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = radialgradient.getCenterX();
            double centerY = radialgradient.getCenterY();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops);

            rectangle.setFill(radialgradient);
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set FocusDistance
        Label title2 = new Label("FocusDistance:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(radialgradient.getFocusDistance()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(1.0);
        slider2.setValue(radialgradient.getFocusDistance());
        slider2.setMajorTickUnit(0.1);
        slider2.setBlockIncrement(0.1);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = slider2.getValue();
            double centerX = radialgradient.getCenterX();
            double centerY = radialgradient.getCenterY();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops);

            rectangle.setFill(radialgradient);
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Center X
        Label title3 = new Label("Center X:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(radialgradient.getCenterX()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(20.0);
        slider3.setValue(radialgradient.getCenterX());
        slider3.setMajorTickUnit(1.0);
        slider3.setBlockIncrement(1.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = slider3.getValue();
            double centerY = radialgradient.getCenterY();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops);

            rectangle.setFill(radialgradient);
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Center Y
        Label title4 = new Label("Center Y:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(radialgradient.getCenterY()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(20.0);
        slider4.setValue(radialgradient.getCenterY());
        slider4.setMajorTickUnit(1.0);
        slider4.setBlockIncrement(1.0);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = radialgradient.getCenterX();
            double centerY = slider4.getValue();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops);

            rectangle.setFill(radialgradient);
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set Radius
        Label title5 = new Label("Radius:");

        final Label lblValue5 = new Label(new DecimalFormat("0.0").format(radialgradient.getRadius()));
        lblValue5.setPrefSize(100, 25);

        final Slider slider5 = new Slider();
        slider5.setOrientation(Orientation.HORIZONTAL);
        slider5.setMin(0.1);
        slider5.setMax(20.0);
        slider5.setValue(radialgradient.getRadius());
        slider5.setMajorTickUnit(2.0);
        //slider5.setBlockIncrement(2.0);
        slider5.setPrefSize(200, 25);
        slider5.setSnapToTicks(true);

        slider5.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = radialgradient.getCenterX();
            double centerY = radialgradient.getCenterY();
            double radius = slider5.getValue();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops);

            rectangle.setFill(radialgradient);
            lblValue5.setText(new DecimalFormat("0.0").format(slider5.getValue()));
        });

        // Set Cycle Method
        Label title6 = new Label("Cycle Method:");
        title6.setPrefWidth(90);

        final Label lblValue6 = new Label("No Cycle");
        lblValue6.setPrefSize(100, 25);

        String type[] = {"No Cycle", "Reflect", "Repeat"};

        final ComboBox combobox1 = new ComboBox();

        combobox1.setItems(FXCollections.observableArrayList(type));
        // select the first element
        combobox1.getSelectionModel().selectFirst();
        ;
        combobox1.setEditable(false);
        combobox1.setPrefWidth(200);

        // Change Event
        combobox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                CycleMethod cyclemethod = CycleMethod.NO_CYCLE;

                switch (newValue) {
                    case "No Cycle":
                        cyclemethod = CycleMethod.NO_CYCLE;
                        break;
                    case "Reflect":
                        cyclemethod = CycleMethod.REFLECT;
                        break;
                    case "Repeat":
                        cyclemethod = CycleMethod.REPEAT;
                        break;
                }

                double forcusAngle = radialgradient.getFocusAngle();
                double focusDistance = radialgradient.getFocusDistance();
                double centerX = radialgradient.getCenterX();
                double centerY = radialgradient.getCenterY();
                double radius = radialgradient.getRadius();

                radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops);

                rectangle.setFill(radialgradient);

                lblValue6.setText(newValue);
            }
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
        gridpane.add(combobox1, 1, 5);
        gridpane.add(lblValue6, 2, 5);

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
