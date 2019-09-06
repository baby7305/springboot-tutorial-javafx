package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class GridPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane gridpane = new GridPane();

        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(10, 10, 10, 10));

        final int column = 3;
        final int row = 4;

        Button button[][] = new Button[column][row];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                button[i][j] = new Button("(" + j + ":" + i + ")");
                button[i][j].setPrefSize(60, 20);

                gridpane.add(button[i][j], i, j);
            }
        }

        // Set the Layout Pane of Scene
        Scene scene = new Scene(gridpane);

        // Set the title of Stage
        primaryStage.setTitle("Grid Pane Demo");
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
