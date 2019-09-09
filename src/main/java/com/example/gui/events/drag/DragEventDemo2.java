package com.example.gui.events.drag;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Leo Huang
 */
public class DragEventDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        final TextArea textarea = new TextArea();

        textarea.setOnDragOver((DragEvent e) -> {
            Dragboard db = e.getDragboard();

            if (e.getGestureSource() != textarea && db.hasFiles()) {
                e.acceptTransferModes(TransferMode.COPY);
            } else {
                e.consume();
            }
        });

        textarea.setOnDragDropped((DragEvent e) -> {
            Dragboard db = e.getDragboard();
            boolean success = false;

            if (db.hasFiles()) {
                success = true;

                String filePath = db.getFiles().get(0).getAbsolutePath();

                if (filePath.endsWith(".txt") || filePath.endsWith(".html") || filePath.endsWith(".java")) {
                    Scanner filescanner;
                    String text = "";

                    try {
                        filescanner = new Scanner(db.getFiles().get(0));

                        while (filescanner.hasNext()) {
                            text += filescanner.nextLine() + "\r\n";
                        }

                        filescanner.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex.toString());
                    }

                    textarea.setText(text);
                }
            }

            e.setDropCompleted(success);
            e.consume();
        });

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(textarea);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Drag Event Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
        primaryStage.setScene(scene);

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
