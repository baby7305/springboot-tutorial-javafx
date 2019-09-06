package com.example.gui.effect.shadow;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
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
public class DropShadowDemo extends Application {
    DropShadow dropshadow;

    Text text;

    ColorPicker colorpicker1;

    @Override
    public void start(Stage primaryStage) {
        dropshadow = new DropShadow();
        dropshadow.setColor(Color.GREY);
        dropshadow.setOffsetX(5.0);
        dropshadow.setOffsetY(5.0);
        dropshadow.setRadius(5.0);

        text = new Text();
        text.setEffect(dropshadow);
        text.setText("Drop Shadow");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        GridPane gridpane = createPane();

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Drop Shadow Demo");
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

        // Set Shadow Color
        Label lblColor1 = new Label("Shadow Color:");
        colorpicker1 = new ColorPicker(Color.GREY);
        colorpicker1.setPrefWidth(90);

        colorpicker1.setOnAction((ActionEvent e) -> {
            dropshadow.setColor(colorpicker1.getValue());
        });

        // Set Offset X
        Label title1 = new Label("Offset X:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(dropshadow.getOffsetX()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(-20.0);
        slider1.setMax(20.0);
        slider1.setValue(dropshadow.getOffsetX());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(2.0);
        slider1.setBlockIncrement(2.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setOffsetX(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Offset Y
        Label title2 = new Label("Offset Y:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(dropshadow.getOffsetY()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(-20.0);
        slider2.setMax(20.0);
        slider2.setValue(dropshadow.getOffsetY());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setOffsetY(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Radius
        Label title3 = new Label("Radius:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(dropshadow.getRadius()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(30.0);
        slider3.setValue(dropshadow.getRadius());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(2.0);
        slider3.setBlockIncrement(2.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setRadius(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Spread
        Label title4 = new Label("Spread:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(dropshadow.getSpread()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(1.0);
        slider4.setValue(dropshadow.getSpread());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setSpread(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set Blur Type
        Label title5 = new Label("Blur Type:");

        final Label lblValue5 = new Label("Gaussian");
        lblValue5.setPrefSize(100, 25);

        String type[] = {"Gaussian", "One Pass Box", "Two Pass Box", "Three Pass Box"};

        final ComboBox combobox1 = new ComboBox();

        combobox1.setItems(FXCollections.observableArrayList(type));
        // select the first element
        combobox1.getSelectionModel().selectFirst();
        combobox1.setEditable(false);
        combobox1.setPrefWidth(200);

        // Change Event
        combobox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue) {
                    case "Gaussian":
                        dropshadow.setBlurType(BlurType.GAUSSIAN);
                        break;
                    case "One Pass Box":
                        dropshadow.setBlurType(BlurType.ONE_PASS_BOX);
                        break;
                    case "Two Pass Box":
                        dropshadow.setBlurType(BlurType.TWO_PASS_BOX);
                        break;
                    case "Three Pass Box":
                        dropshadow.setBlurType(BlurType.THREE_PASS_BOX);
                        break;
                }

                lblValue5.setText(newValue);
            }
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(lblColor1, 0, 0);
        gridpane.add(colorpicker1, 1, 0);
        gridpane.add(title1, 0, 1);
        gridpane.add(slider1, 1, 1);
        gridpane.add(lblValue1, 2, 1);
        gridpane.add(title2, 0, 2);
        gridpane.add(slider2, 1, 2);
        gridpane.add(lblValue2, 2, 2);
        gridpane.add(title3, 0, 3);
        gridpane.add(slider3, 1, 3);
        gridpane.add(lblValue3, 2, 3);
        gridpane.add(title4, 0, 4);
        gridpane.add(slider4, 1, 4);
        gridpane.add(lblValue4, 2, 4);
        gridpane.add(title5, 0, 5);
        gridpane.add(combobox1, 1, 5);
        gridpane.add(lblValue5, 2, 5);

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
