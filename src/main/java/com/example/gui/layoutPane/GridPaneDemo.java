package com.example.gui.layoutPane;

import javafx.application.Application;
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
        gridpane.setGridLinesVisible(true);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(gridpane);

        // Read the content of CSS file
        scene.getStylesheets().add(getClass().getResource("/layoutPane/LayoutPane.css").toString());

        // Set the CSS styling for GridPane
        gridpane.getStyleClass().addAll("pane", "gridpane");

        final int column = 3;
        final int row = 4;

        Button button[][] = new Button[column][row];

        button[0][0] = new Button("(" + 0 + ":" + 0 + ")");
        button[0][0].setPrefSize(130, 20);
        // Start at (0, 0) and colspan = 2
        gridpane.add(button[0][0], 0, 0, 2, 1);

        button[2][0] = new Button("(" + 0 + ":" + 2 + ")");
        button[2][0].setPrefSize(60, 20);
        // Start at (0, 2)
        gridpane.add(button[2][0], 2, 0);

        button[0][1] = new Button("(" + 1 + ":" + 0 + ")");
        button[0][1].setPrefSize(60, 20);
        // Start at (1, 0)
        gridpane.add(button[0][1], 0, 1);

        button[1][1] = new Button("(" + 1 + ":" + 1 + ")");
        button[1][1].setPrefSize(130, 20);
        // Start at (1, 1) and colspan = 2
        gridpane.add(button[1][1], 1, 1, 2, 1);

        button[0][2] = new Button("(" + 2 + ":" + 0 + ")");
        button[0][2].setPrefSize(60, 50);
        // Start at (2, 0) and rowspan = 2
        gridpane.add(button[0][2], 0, 2, 1, 2);

        button[1][2] = new Button("(" + 2 + ":" + 1 + ")");
        button[1][2].setPrefSize(60, 20);
        // Start at (2, 1)
        gridpane.add(button[1][2], 1, 2);

        button[1][3] = new Button("(" + 3 + ":" + 1 + ")");
        button[1][3].setPrefSize(60, 20);
        // Start at (3, 1)
        gridpane.add(button[1][3], 1, 3);

        button[2][2] = new Button("(" + 2 + ":" + 2 + ")");
        button[2][2].setPrefSize(60, 50);
        // Start at (2, 2) and rowspan = 2
        gridpane.add(button[2][2], 2, 2, 1, 2);

        // Set the title of Stage
        primaryStage.setTitle("Grid Pane with CSS Demo");
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
