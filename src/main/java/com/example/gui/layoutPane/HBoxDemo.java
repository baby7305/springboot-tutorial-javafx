package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class HBoxDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label lblURL = new Label("URL:");

        TextField txtURL = new TextField();

        Button btnGo = new Button("Go");
        btnGo.setPrefSize(60, 20);

        // Define HBox
        HBox hbox = new HBox();

        // Set the Layout Pane of Scene
        Scene scene = new Scene(hbox);

        // Read the content of CSS file
        scene.getStylesheets().add(getClass().getResource("/layoutPane/LayoutPane.css").toString());

        // Set the CSS styling for HBox
        hbox.getStyleClass().addAll("pane", "hbox");

        // Sets the horizontal grow priority to ALWAYS
        HBox.setHgrow(txtURL, Priority.ALWAYS);

        // Add all components to HBox
        hbox.getChildren().addAll(lblURL, txtURL, btnGo);

        // Set the title of Stage
        primaryStage.setTitle("HBox with CSS Demo");
        // Set the width of Stage
        primaryStage.setWidth(300);
        // Set the height of Stage
        primaryStage.setHeight(100);
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
