package com.example.gui.effect.glow;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * @author Leo Huang
 */
public class GlowDemo extends Application {
    Glow glow;

    ImageView imageview;

    @Override
    public void start(Stage primaryStage) {
        glow = new Glow();
        glow.setLevel(0.8);

        imageview = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/JavaFX.png")));
        imageview.setEffect(glow);

        GridPane gridpane = createPane();

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(imageview);
        borderpane.setBottom(gridpane);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Glow Demo");
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

        // Set Level
        Label title1 = new Label("Level:");
        title1.setPrefWidth(70);

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(glow.getLevel()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(1.0);
        slider1.setValue(glow.getLevel());
        slider1.setMajorTickUnit(0.1);
        slider1.setBlockIncrement(0.1);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            glow.setLevel(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);

        return gridpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}