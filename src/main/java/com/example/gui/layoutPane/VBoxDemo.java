package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class VBoxDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("Month");
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        ListView<String> list = new ListView<>();

        ObservableList<String> months = FXCollections.observableArrayList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        list.setItems(months);

        // Define VBox
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);

        // Sets the Vertical grow priority to ALWAYS
        VBox.setVgrow(list, Priority.ALWAYS);

        // Add components to VBox
        vbox.getChildren().addAll(label, list);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(vbox);

        // Set the title of Stage
        primaryStage.setTitle("VBox Demo");
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
