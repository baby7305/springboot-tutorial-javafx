package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class AnchorPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Define Button
        Button button1 = new Button("Top-Left");
        button1.setPrefSize(100, 20);

        // Set the Top and Left anchor for Button 1
        AnchorPane.setTopAnchor(button1, 10.0);
        AnchorPane.setLeftAnchor(button1, 10.0);

        Button button2 = new Button("Bottom-Left");
        button2.setPrefSize(100, 20);

        // Set the Bottom and Left anchor for Button 2
        AnchorPane.setBottomAnchor(button2, 10.0);
        AnchorPane.setLeftAnchor(button2, 10.0);

        Button button3 = new Button("Top-Right");
        button3.setPrefSize(100, 20);
        // Set the Top and Right anchor for Button 3
        AnchorPane.setTopAnchor(button3, 10.0);
        AnchorPane.setRightAnchor(button3, 10.0);

        Button button4 = new Button("Bottom-Right");
        button4.setPrefSize(100, 20);

        // Set the Bottom and Right anchor for Button 4
        AnchorPane.setBottomAnchor(button4, 10.0);
        AnchorPane.setRightAnchor(button4, 10.0);

        // Define AnchorPane
        AnchorPane anchorpane = new AnchorPane();

        // Set the Layout Pane of Scene
        Scene scene = new Scene(anchorpane);
        // Read the content of CSS file
        scene.getStylesheets().add(getClass().getResource("/layoutPane/LayoutPane.css").toString());

        // Set the CSS styling for AnchorPane
        anchorpane.getStyleClass().add("pane");

        // Add all components to Anchor Pane
        anchorpane.getChildren().addAll(button1, button2, button3, button4);

        primaryStage.setScene(scene);
        // Set the title of Stage
        primaryStage.setTitle("Anchor Pane with CSS Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
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
