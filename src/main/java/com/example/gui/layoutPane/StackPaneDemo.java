package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class StackPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        ListView<String> list = new ListView<>();

        ObservableList<String> months = FXCollections.observableArrayList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December");

        list.setItems(months);

        Label label = new Label("Stack Pane");
        label.setFont(Font.font("Verdana", 14));

        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/layoutPane/images/dukeWave.gif")));

        StackPane stackpane = new StackPane();

        // Set the Layout Pane of Scene
        Scene scene = new Scene(stackpane);

        // Read the content of CSS file
        scene.getStylesheets().add(getClass().getResource("/layoutPane/LayoutPane.css").toString());

        // Set the CSS styling for StackPane
        stackpane.getStyleClass().addAll("pane", "stackpane");

        // Add all components to Stack Pane
        stackpane.getChildren().addAll(list, label, image);

        // Set the title of Stage
        primaryStage.setTitle("Stack Pane with CSS Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);

        // Show Stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
