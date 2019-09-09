package com.example.gui.events.drag;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class DragEventDemo1 extends Application {

    ImageView[] source = new ImageView[3];
    ImageView target;

    Image empty = new Image(getClass().getResourceAsStream("/events/images/empty.png"));
    Image full = new Image(getClass().getResourceAsStream("/events/images/full.png"));

    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();

        for (int i = 0; i < source.length; i++) {
            source[i] = new ImageView(new Image(getClass().getResourceAsStream("/events/images/file" + (i + 1) + ".png")));
            source[i].setCursor(Cursor.HAND);
            source[i].setTranslateX(i * 85 + 5);
            source[i].setTranslateY(5);

            group.getChildren().add(source[i]);

            source[i].setOnDragDetected((MouseEvent e) -> {
                ImageView imageview = (ImageView) e.getSource();

                Dragboard dragboard = imageview.startDragAndDrop(TransferMode.ANY);

                // Put an image to the Clipboard
                ClipboardContent content = new ClipboardContent();
                content.putImage(imageview.getImage());
                dragboard.setContent(content);

                e.consume();
            });

            source[i].setOnDragDone((DragEvent e) -> {
                if (e.getTransferMode() == TransferMode.MOVE) {
                    ImageView imageview = (ImageView) e.getSource();
                    imageview.setVisible(false);
                }

                e.consume();
            });
        }

        target = new ImageView(empty);
        target.setTranslateX(320);
        target.setTranslateY(100);
        target.setOnDragOver((DragEvent e) -> {
            if (e.getGestureSource() != target && e.getDragboard().hasImage()) {
                e.acceptTransferModes(TransferMode.ANY);
            }

            e.consume();
        });

        target.setOnDragDropped((DragEvent e) -> {
            Dragboard dragboard = e.getDragboard();
            boolean success = false;

            if (dragboard.hasImage()) {
                target.setImage(full);
                success = true;
            }

            e.setDropCompleted(success);

            e.consume();
        });

        target.setOnDragEntered((DragEvent e) -> {
            target.setEffect(new DropShadow());
            e.consume();
        });

        target.setOnDragExited((DragEvent e) -> {
            target.setEffect(null);
            e.consume();
        });

        group.getChildren().add(target);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);
        // Set the title of Stage
        primaryStage.setTitle("Drag Event Demo");
        // Set the width of Stage
        primaryStage.setWidth(450);
        // Set the height of Stage
        primaryStage.setHeight(250);
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
