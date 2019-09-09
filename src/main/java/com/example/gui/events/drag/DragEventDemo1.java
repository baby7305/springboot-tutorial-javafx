package com.example.gui.events.drag;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class DragEventDemo1 extends Application {

    Text source, target;

    DropShadow shadow = new DropShadow();

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @Override
    public void start(Stage primaryStage) {

        source = new Text("Source");
        source.setCursor(Cursor.HAND);
        source.setFont(Font.font("Verdana", 16));
        source.setFill(Color.DARKGREEN);
        source.setTranslateX(50);
        source.setTranslateY(50);

        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Source: Drag Detected");

                Dragboard dragboard = source.startDragAndDrop(TransferMode.ANY);

                // Put a string to the Clipboard
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                dragboard.setContent(content);

                e.consume();
            }
        });

        source.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                System.out.println("Source: Drag Done");

                if (e.getTransferMode() == TransferMode.MOVE) {
                    source.setText("");
                }

                e.consume();
            }
        });

        target = new Text("Target");
        target.setFont(Font.font("Verdana", 16));
        target.setFill(Color.BLUE);
        target.setTranslateX(200);
        target.setTranslateY(50);

        target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                System.out.println("Target: Drag Over");

                if (e.getGestureSource() != target && e.getDragboard().hasString()) {
                    e.acceptTransferModes(TransferMode.ANY);
                }

                e.consume();
            }
        });

        target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                System.out.println("Target: Drag Entered");

                target.setEffect(shadow);
                target.setFill(Color.RED);
                e.consume();
            }
        });

        target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                System.out.println("Target: Drag Exited");

                target.setEffect(null);
                target.setFill(Color.BLUE);
                e.consume();
            }
        });

        target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                System.out.println("Target: Drag Dropped");

                Dragboard dragboard = e.getDragboard();
                boolean success = false;

                if (dragboard.hasString()) {
                    target.setText(dragboard.getString());
                    success = true;
                }

                e.setDropCompleted(success);

                e.consume();
            }
        });

        Group group = new Group();
        group.getChildren().addAll(source, target);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);
        // Set the title of Stage
        primaryStage.setTitle("Drag Event Demo");
        // Set the width of Stage
        primaryStage.setWidth(300);
        // Set the height of Stage
        primaryStage.setHeight(150);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

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
