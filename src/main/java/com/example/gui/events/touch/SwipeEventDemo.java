package com.example.gui.events.touch;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Leo Huang
 */
public class SwipeEventDemo extends Application {

    private static final double WIDTH = 150;
    private static final double HEIGHT = 128;
    private static final Duration duration = Duration.millis(200);

    TranslateTransition transition;

    @Override
    public void start(Stage primaryStage) {

        final ImageView imageview = new ImageView(new Image(getClass().getResourceAsStream("/events/images/duke.png")));
        transition = new TranslateTransition(duration, imageview);

        // Swipe Up
        imageview.setOnSwipeUp((SwipeEvent e) -> {
            if (imageview.getTranslateY() > 0) {
                transition.setByX(0);
                transition.setByY(-HEIGHT);
                transition.playFromStart();
            }
        });

        // Swipe Down
        imageview.setOnSwipeDown((SwipeEvent e) -> {
            if (imageview.getTranslateY() <= 0) {
                transition.setByX(0);
                transition.setByY(HEIGHT);
                transition.playFromStart();
            }
        });

        // Swipe Left
        imageview.setOnSwipeLeft((SwipeEvent e) -> {
            if (imageview.getTranslateX() > 0) {
                transition.setByX(-WIDTH);
                transition.setByY(0);
                transition.playFromStart();
            }
        });

        // Swipe Right
        imageview.setOnSwipeRight((SwipeEvent e) -> {
            if (imageview.getTranslateX() <= 0) {
                transition.setByX(WIDTH);
                transition.setByY(0);
                transition.playFromStart();
            }
        });

        Group group = new Group();
        group.getChildren().add(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);
        // Set the title of Stage
        primaryStage.setTitle("Swipe Event Demo");
        // Set the width of Stage
        primaryStage.setWidth(300);
        // Set the height of Stage
        primaryStage.setHeight(300);
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
