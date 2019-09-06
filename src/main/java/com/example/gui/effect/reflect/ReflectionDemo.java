package com.example.gui.effect.reflect;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * @author Leo Huang
 */
public class ReflectionDemo extends Application {
    Reflection reflection = null;

    ImageView imageview;

    @Override
    public void start(Stage primaryStage) {

        reflection = new Reflection();
        reflection.setTopOffset(0.0);
        reflection.setFraction(1.0);
        reflection.setTopOpacity(0.5);
        reflection.setBottomOpacity(0.0);

        imageview = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/JavaFX.png")));
        imageview.setEffect(reflection);

        GridPane gridpane = createPane();

        AnchorPane anchorpane = new AnchorPane();
        AnchorPane.setTopAnchor(imageview, 30.0);
        AnchorPane.setLeftAnchor(imageview, 150.0);
        anchorpane.getChildren().add(imageview);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(anchorpane);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Reflection Demo");
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

        // Set Top Offset
        Label title1 = new Label("Top Offset:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(reflection.getTopOffset()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(20.0);
        slider1.setValue(reflection.getTopOffset());
        slider1.setMajorTickUnit(1.0);
        slider1.setBlockIncrement(1.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setTopOffset(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Fraction
        Label title2 = new Label("Fraction:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(reflection.getFraction()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(1.0);
        slider2.setValue(reflection.getFraction());
        slider2.setMajorTickUnit(0.1);
        slider2.setBlockIncrement(0.1);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setFraction(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Top Opacity
        Label title3 = new Label("Top Opacity:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(reflection.getTopOpacity()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(1.0);
        slider3.setValue(reflection.getTopOpacity());
        slider3.setMajorTickUnit(0.1);
        slider3.setBlockIncrement(0.1);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setTopOpacity(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Bottom Opacity
        Label title4 = new Label("Bottom Opacity:");
        title4.setPrefSize(120, 25);

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(reflection.getBottomOpacity()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(1.0);
        slider4.setValue(reflection.getBottomOpacity());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setBottomOpacity(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
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

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
