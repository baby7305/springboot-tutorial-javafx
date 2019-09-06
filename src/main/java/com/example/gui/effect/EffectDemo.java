package com.example.gui.effect;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * @author Leo Huang
 */
public class EffectDemo extends Application {

    DropShadow dropshadow;
    InnerShadow innershadow;
    LinearGradient lineargradient;
    RadialGradient radialgradient;
    BoxBlur boxblur;
    GaussianBlur gaussianblur;
    MotionBlur motionblur;
    Reflection reflection;
    Glow glow;
    Bloom bloom;
    SepiaTone sepiatone;
    PerspectiveTransform perspectiveTrasform;

    ImageView imageview1, imageview2, imageview3, imageview4;

    Rectangle rectangle1 = null, rectangle2 = null;

    Stop[] stops1, stops2;

    Text text1, text2, text3, text4, text5, text6;

    ColorPicker colorpicker1, colorpicker2;

    Group group;

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        BorderPane DropShadowPane = createDropShadowPane();
        BorderPane InnerShadowPane = createInnerShadowPane();
        BorderPane LinearGradientPane = createLinearGradientPane();
        BorderPane RadialGradientPane = createRadialGradientPane();
        BorderPane BoxBlurPane = createBoxBlurPane();
        BorderPane GaussianBlurPane = createGaussianBlurPane();
        BorderPane MotionBlurPane = createMotionBlurPane();
        BorderPane ReflectionPane = createReflectionPane();
        BorderPane GlowPane = createGlowPane();
        BorderPane BloomPane = createBloomPane();
        BorderPane SepiaTonePane = createSepiaTonePane();
        BorderPane PerspectiveTransformPane = createPerspectiveTransformPane();

        Tab tab = new Tab();
        tab.setText("Drop Shadow");
        tab.setContent(DropShadowPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Inner Shadow");
        tab.setContent(InnerShadowPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Linear Gradient");
        tab.setContent(LinearGradientPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Radial Gradient");
        tab.setContent(RadialGradientPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Box Blur");
        tab.setContent(BoxBlurPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Gaussian Blur");
        tab.setContent(GaussianBlurPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Motion Blur");
        tab.setContent(MotionBlurPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Reflection");
        tab.setContent(ReflectionPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Glow");
        tab.setContent(GlowPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Bloom");
        tab.setContent(BloomPane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Sepia Tone");
        tab.setContent(SepiaTonePane);
        tabPane.getTabs().add(tab);

        tab = new Tab();
        tab.setText("Perspective Transform");
        tab.setContent(PerspectiveTransformPane);
        tabPane.getTabs().add(tab);

        BorderPane borderpane = new BorderPane();

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        borderpane.prefHeightProperty().bind(scene.heightProperty());
        borderpane.prefWidthProperty().bind(scene.widthProperty());

        borderpane.setCenter(tabPane);

        // Set the title1 of Stage
        primaryStage.setTitle("Effect Demo");
        // Set the width of Stage
        primaryStage.setWidth(600);
        // Set the height of Stage
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        // Show Stage
        primaryStage.show();
    }

    private BorderPane createDropShadowPane() {
        dropshadow = new DropShadow();
        dropshadow.setColor(Color.GREY);
        dropshadow.setOffsetX(5.0);
        dropshadow.setOffsetY(5.0);
        dropshadow.setRadius(5.0);

        text1 = new Text();
        text1.setEffect(dropshadow);
        text1.setText("Drop Shadow");
        text1.setFill(Color.BLACK);
        text1.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        // Set Shadow Color
        Label lblColor1 = new Label("Shadow Color:");
        colorpicker1 = new ColorPicker(Color.GREY);
        colorpicker1.setPrefWidth(90);

        colorpicker1.setOnAction((ActionEvent e) -> {
            dropshadow.setColor(colorpicker1.getValue());
        });

        // Set Offset X
        Label title1 = new Label("Offset X:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(dropshadow.getOffsetX()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(-20.0);
        slider1.setMax(20.0);
        slider1.setValue(dropshadow.getOffsetX());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(2.0);
        slider1.setBlockIncrement(2.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setOffsetX(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Offset Y
        Label title2 = new Label("Offset Y:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(dropshadow.getOffsetY()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(-20.0);
        slider2.setMax(20.0);
        slider2.setValue(dropshadow.getOffsetY());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setOffsetY(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Radius
        Label title3 = new Label("Radius:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(dropshadow.getRadius()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(30.0);
        slider3.setValue(dropshadow.getRadius());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(2.0);
        slider3.setBlockIncrement(2.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setRadius(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Spread
        Label title4 = new Label("Spread:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(dropshadow.getSpread()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(1.0);
        slider4.setValue(dropshadow.getSpread());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            dropshadow.setSpread(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set Blur Type
        Label title5 = new Label("Blur Type:");

        final Label lblValue5 = new Label("Gaussian");
        lblValue5.setPrefSize(100, 25);

        String type[] = {"Gaussian", "One Pass Box", "Two Pass Box", "Three Pass Box"};

        final ComboBox combobox1 = new ComboBox();

        combobox1.setItems(FXCollections.observableArrayList(type));
        // select the first element
        combobox1.getSelectionModel().selectFirst();
        ;
        combobox1.setEditable(false);
        combobox1.setPrefWidth(200);

        // Change Event
        combobox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                switch (newValue) {
                    case "Gaussian":
                        dropshadow.setBlurType(BlurType.GAUSSIAN);
                        break;
                    case "One Pass Box":
                        dropshadow.setBlurType(BlurType.ONE_PASS_BOX);
                        break;
                    case "Two Pass Box":
                        dropshadow.setBlurType(BlurType.TWO_PASS_BOX);
                        break;
                    case "Three Pass Box":
                        dropshadow.setBlurType(BlurType.THREE_PASS_BOX);
                        break;
                }

                lblValue5.setText(newValue);
            }
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(lblColor1, 0, 0);
        gridpane.add(colorpicker1, 1, 0);
        gridpane.add(title1, 0, 1);
        gridpane.add(slider1, 1, 1);
        gridpane.add(lblValue1, 2, 1);
        gridpane.add(title2, 0, 2);
        gridpane.add(slider2, 1, 2);
        gridpane.add(lblValue2, 2, 2);
        gridpane.add(title3, 0, 3);
        gridpane.add(slider3, 1, 3);
        gridpane.add(lblValue3, 2, 3);
        gridpane.add(title4, 0, 4);
        gridpane.add(slider4, 1, 4);
        gridpane.add(lblValue4, 2, 4);
        gridpane.add(title5, 0, 5);
        gridpane.add(combobox1, 1, 5);
        gridpane.add(lblValue5, 2, 5);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text1);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createInnerShadowPane() {
        innershadow = new InnerShadow();
        innershadow.setColor(Color.BLACK);
        innershadow.setChoke(0.5);
        innershadow.setOffsetX(2.0);
        innershadow.setOffsetY(2.0);
        innershadow.setRadius(5.0);

        text2 = new Text();
        text2.setEffect(innershadow);
        text2.setText("Inner Shadow");
        text2.setFill(Color.web("#BBBBBB"));
        text2.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        // Set Shadow Color
        Label lblColor1 = new Label("Shadow Color:");
        colorpicker2 = new ColorPicker(Color.GREY);
        colorpicker2.setPrefWidth(90);

        colorpicker2.setOnAction((ActionEvent e) -> {
            innershadow.setColor(colorpicker2.getValue());
        });

        // Set Offset X
        Label title1 = new Label("Offset X:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(innershadow.getOffsetX()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(-20.0);
        slider1.setMax(20.0);
        slider1.setValue(innershadow.getOffsetX());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(2.0);
        slider1.setBlockIncrement(2.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            innershadow.setOffsetX(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Offset Y
        Label title2 = new Label("Offset Y:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(innershadow.getOffsetY()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(-20.0);
        slider2.setMax(20.0);
        slider2.setValue(innershadow.getOffsetY());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            innershadow.setOffsetY(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Radius
        Label title3 = new Label("Radius:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(innershadow.getRadius()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(30.0);
        slider3.setValue(innershadow.getRadius());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(2.0);
        slider3.setBlockIncrement(2.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            innershadow.setRadius(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Choke
        Label title4 = new Label("Choke:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(innershadow.getChoke()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(1.0);
        slider4.setValue(innershadow.getChoke());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            innershadow.setChoke(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set Blur Type
        Label title5 = new Label("Blur Type:");

        final Label lblValue5 = new Label("Gaussian");
        lblValue5.setPrefSize(100, 25);

        String type[] = {"Gaussian", "One Pass Box", "Two Pass Box", "Three Pass Box"};

        final ComboBox combobox1 = new ComboBox();

        combobox1.setItems(FXCollections.observableArrayList(type));
        // select the first element
        combobox1.getSelectionModel().selectFirst();
        ;
        combobox1.setEditable(false);
        combobox1.setPrefWidth(200);

        // Change Event
        combobox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                switch (newValue) {
                    case "Gaussian":
                        innershadow.setBlurType(BlurType.GAUSSIAN);
                        break;
                    case "One Pass Box":
                        innershadow.setBlurType(BlurType.ONE_PASS_BOX);
                        break;
                    case "Two Pass Box":
                        innershadow.setBlurType(BlurType.TWO_PASS_BOX);
                        break;
                    case "Three Pass Box":
                        innershadow.setBlurType(BlurType.THREE_PASS_BOX);
                        break;
                }

                lblValue5.setText(newValue);
            }
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(lblColor1, 0, 0);
        gridpane.add(colorpicker2, 1, 0);
        gridpane.add(title1, 0, 1);
        gridpane.add(slider1, 1, 1);
        gridpane.add(lblValue1, 2, 1);
        gridpane.add(title2, 0, 2);
        gridpane.add(slider2, 1, 2);
        gridpane.add(lblValue2, 2, 2);
        gridpane.add(title3, 0, 3);
        gridpane.add(slider3, 1, 3);
        gridpane.add(lblValue3, 2, 3);
        gridpane.add(title4, 0, 4);
        gridpane.add(slider4, 1, 4);
        gridpane.add(lblValue4, 2, 4);
        gridpane.add(title5, 0, 5);
        gridpane.add(combobox1, 1, 5);
        gridpane.add(lblValue5, 2, 5);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text2);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createLinearGradientPane() {
        stops1 = new Stop[]{
                new Stop(0.0, Color.RED),
                new Stop(0.5, Color.ORANGE),
                new Stop(1.0, Color.YELLOW)
        };

        lineargradient = new LinearGradient(0.0, 0.0, 1.0, 1.0, true, CycleMethod.REFLECT, stops1);

        rectangle1 = new Rectangle();
        rectangle1.setX(50);
        rectangle1.setY(50);
        rectangle1.setHeight(150);
        rectangle1.setWidth(150);
        rectangle1.setFill(lineargradient);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeWidth(1.0);

        Group group = new Group();
        group.getChildren().add(rectangle1);

        // Set Start X
        Label title1 = new Label("Start X:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(lineargradient.getStartX()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(1.0);
        slider1.setValue(lineargradient.getStartX());
        slider1.setMajorTickUnit(0.1);
        slider1.setBlockIncrement(0.1);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double startX = slider1.getValue();
            double startY = lineargradient.getStartY();
            double endX = lineargradient.getEndX();
            double endY = lineargradient.getEndY();
            CycleMethod cyclemethod = lineargradient.getCycleMethod();

            lineargradient = new LinearGradient(startX, startY, endX, endY, true, cyclemethod, stops1);

            rectangle1.setFill(lineargradient);
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Start Y
        Label title2 = new Label("Start Y:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(lineargradient.getStartY()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(1.0);
        slider2.setValue(lineargradient.getStartY());
        slider2.setMajorTickUnit(0.1);
        slider2.setBlockIncrement(0.1);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double startX = lineargradient.getStartX();
            double startY = slider2.getValue();
            double endX = lineargradient.getEndX();
            double endY = lineargradient.getEndY();
            CycleMethod cyclemethod = lineargradient.getCycleMethod();

            lineargradient = new LinearGradient(startX, startY, endX, endY, true, cyclemethod, stops1);

            rectangle1.setFill(lineargradient);
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set End X
        Label title3 = new Label("End X:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(lineargradient.getEndX()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(1.0);
        slider3.setValue(lineargradient.getEndX());
        slider3.setMajorTickUnit(0.1);
        slider3.setBlockIncrement(0.1);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double startX = lineargradient.getStartX();
            double startY = lineargradient.getStartY();
            double endX = slider3.getValue();
            double endY = lineargradient.getEndY();
            CycleMethod cyclemethod = lineargradient.getCycleMethod();

            lineargradient = new LinearGradient(startX, startY, endX, endY, true, cyclemethod, stops1);

            rectangle1.setFill(lineargradient);
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set End Y
        Label title4 = new Label("End Y:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(lineargradient.getEndY()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(1.0);
        slider4.setValue(lineargradient.getEndY());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double startX = lineargradient.getStartX();
            double startY = lineargradient.getStartY();
            double endX = lineargradient.getEndX();
            double endY = slider4.getValue();
            CycleMethod cyclemethod = lineargradient.getCycleMethod();

            lineargradient = new LinearGradient(startX, startY, endX, endY, true, cyclemethod, stops1);

            rectangle1.setFill(lineargradient);
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set Cycle Method
        Label title5 = new Label("Cycle Method:");
        title5.setPrefWidth(90);

        final Label lblValue5 = new Label("No Cycle");
        lblValue5.setPrefSize(100, 25);

        String type[] = {"No Cycle", "Reflect", "Repeat"};

        final ComboBox combobox1 = new ComboBox();

        combobox1.setItems(FXCollections.observableArrayList(type));
        // select the first element
        combobox1.getSelectionModel().selectFirst();
        ;
        combobox1.setEditable(false);
        combobox1.setPrefWidth(200);

        // Change Event
        combobox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                CycleMethod cyclemethod = CycleMethod.NO_CYCLE;

                switch (newValue) {
                    case "No Cycle":
                        cyclemethod = CycleMethod.NO_CYCLE;
                        break;
                    case "Reflect":
                        cyclemethod = CycleMethod.REFLECT;
                        break;
                    case "Repeat":
                        cyclemethod = CycleMethod.REPEAT;
                        break;
                }

                double startX = lineargradient.getStartX();
                double startY = lineargradient.getStartY();
                double endX = lineargradient.getEndX();
                double endY = lineargradient.getEndY();

                lineargradient = new LinearGradient(startX, startY, endX, endY, true, cyclemethod, stops1);

                rectangle1.setFill(lineargradient);

                lblValue5.setText(newValue);
            }
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);
        gridpane.add(title3, 0, 2);
        gridpane.add(slider3, 1, 2);
        gridpane.add(lblValue3, 2, 2);
        gridpane.add(title4, 0, 3);
        gridpane.add(slider4, 1, 3);
        gridpane.add(lblValue4, 2, 3);
        gridpane.add(title5, 0, 4);
        gridpane.add(combobox1, 1, 4);
        gridpane.add(lblValue5, 2, 4);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(group);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createRadialGradientPane() {
        stops2 = new Stop[]{
                new Stop(0.0, Color.RED),
                new Stop(0.5, Color.ORANGE),
                new Stop(1.0, Color.YELLOW)
        };

        radialgradient = new RadialGradient(0.0, 0.0, 0.5, 0.5, 0.1, true, CycleMethod.REFLECT, stops2);

        rectangle2 = new Rectangle();
        rectangle2.setX(50);
        rectangle2.setY(50);
        rectangle2.setHeight(150);
        rectangle2.setWidth(150);
        rectangle2.setFill(radialgradient);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setStrokeWidth(1.0);

        Group group = new Group();
        group.getChildren().add(rectangle2);

        // Set Focus Angle
        Label title1 = new Label("Focus Angle:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(radialgradient.getFocusAngle()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(360.0);
        slider1.setValue(radialgradient.getFocusAngle());
        slider1.setMinorTickCount(5);
        slider1.setMajorTickUnit(10);
        slider1.setBlockIncrement(10);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = slider1.getValue();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = radialgradient.getCenterX();
            double centerY = radialgradient.getCenterY();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops2);

            rectangle2.setFill(radialgradient);
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set FocusDistance
        Label title2 = new Label("FocusDistance:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(radialgradient.getFocusDistance()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(1.0);
        slider2.setValue(radialgradient.getFocusDistance());
        slider2.setMajorTickUnit(0.1);
        slider2.setBlockIncrement(0.1);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = slider2.getValue();
            double centerX = radialgradient.getCenterX();
            double centerY = radialgradient.getCenterY();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops2);

            rectangle2.setFill(radialgradient);
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Center X
        Label title3 = new Label("Center X:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(radialgradient.getCenterX()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(20.0);
        slider3.setValue(radialgradient.getCenterX());
        slider3.setMajorTickUnit(1.0);
        slider3.setBlockIncrement(1.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = slider3.getValue();
            double centerY = radialgradient.getCenterY();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops2);

            rectangle2.setFill(radialgradient);
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Center Y
        Label title4 = new Label("Center Y:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(radialgradient.getCenterY()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(20.0);
        slider4.setValue(radialgradient.getCenterY());
        slider4.setMajorTickUnit(1.0);
        slider4.setBlockIncrement(1.0);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = radialgradient.getCenterX();
            double centerY = slider4.getValue();
            double radius = radialgradient.getRadius();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops2);

            rectangle2.setFill(radialgradient);
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set Radius
        Label title5 = new Label("Radius:");

        final Label lblValue5 = new Label(new DecimalFormat("0.0").format(radialgradient.getRadius()));
        lblValue5.setPrefSize(100, 25);

        final Slider slider5 = new Slider();
        slider5.setOrientation(Orientation.HORIZONTAL);
        slider5.setMin(0.1);
        slider5.setMax(20.0);
        slider5.setValue(radialgradient.getRadius());
        slider5.setMajorTickUnit(2.0);
        //slider5.setBlockIncrement(2.0);
        slider5.setPrefSize(200, 25);
        slider5.setSnapToTicks(true);

        slider5.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            double forcusAngle = radialgradient.getFocusAngle();
            double focusDistance = radialgradient.getFocusDistance();
            double centerX = radialgradient.getCenterX();
            double centerY = radialgradient.getCenterY();
            double radius = slider5.getValue();
            CycleMethod cyclemethod = radialgradient.getCycleMethod();

            radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops2);

            rectangle2.setFill(radialgradient);
            lblValue5.setText(new DecimalFormat("0.0").format(slider5.getValue()));
        });

        // Set Cycle Method
        Label title6 = new Label("Cycle Method:");
        title6.setPrefWidth(90);

        final Label lblValue6 = new Label("No Cycle");
        lblValue6.setPrefSize(100, 25);

        String type[] = {"No Cycle", "Reflect", "Repeat"};

        final ComboBox combobox1 = new ComboBox();

        combobox1.setItems(FXCollections.observableArrayList(type));
        // select the first element
        combobox1.getSelectionModel().selectFirst();
        ;
        combobox1.setEditable(false);
        combobox1.setPrefWidth(200);

        // Change Event
        combobox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                CycleMethod cyclemethod = CycleMethod.NO_CYCLE;

                switch (newValue) {
                    case "No Cycle":
                        cyclemethod = CycleMethod.NO_CYCLE;
                        break;
                    case "Reflect":
                        cyclemethod = CycleMethod.REFLECT;
                        break;
                    case "Repeat":
                        cyclemethod = CycleMethod.REPEAT;
                        break;
                }

                double forcusAngle = radialgradient.getFocusAngle();
                double focusDistance = radialgradient.getFocusDistance();
                double centerX = radialgradient.getCenterX();
                double centerY = radialgradient.getCenterY();
                double radius = radialgradient.getRadius();

                radialgradient = new RadialGradient(forcusAngle, focusDistance, centerX, centerY, radius, true, cyclemethod, stops2);

                rectangle2.setFill(radialgradient);

                lblValue6.setText(newValue);
            }
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);
        gridpane.add(title3, 0, 2);
        gridpane.add(slider3, 1, 2);
        gridpane.add(lblValue3, 2, 2);
        gridpane.add(title4, 0, 3);
        gridpane.add(slider4, 1, 3);
        gridpane.add(lblValue4, 2, 3);
        gridpane.add(title5, 0, 4);
        gridpane.add(slider5, 1, 4);
        gridpane.add(lblValue5, 2, 4);
        gridpane.add(title6, 0, 5);
        gridpane.add(combobox1, 1, 5);
        gridpane.add(lblValue6, 2, 5);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(group);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createBoxBlurPane() {
        boxblur = new BoxBlur();
        boxblur.setWidth(10.0);
        boxblur.setHeight(10.0);
        boxblur.setIterations(3);

        text3 = new Text();
        text3.setEffect(boxblur);
        text3.setText("Box Blur");
        text3.setFill(Color.BLACK);
        text3.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        // Set Width
        Label title1 = new Label("Width:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(boxblur.getWidth()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(255.0);
        slider1.setValue(boxblur.getWidth());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(5.0);
        slider1.setBlockIncrement(5.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boxblur.setWidth(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Height
        Label title2 = new Label("Height:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(boxblur.getHeight()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(255.0);
        slider2.setValue(boxblur.getHeight());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(5.0);
        slider2.setBlockIncrement(5.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boxblur.setHeight(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Iterations
        Label title3 = new Label("Iterations:");
        title3.setPrefWidth(90);

        final Label lblValue3 = new Label(new DecimalFormat("0").format(boxblur.getIterations()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0);
        slider3.setMax(3);
        slider3.setValue(boxblur.getIterations());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(1);
        slider3.setBlockIncrement(1);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boxblur.setIterations((int) slider3.getValue());
            lblValue3.setText(new DecimalFormat("0").format(slider3.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);
        gridpane.add(title3, 0, 2);
        gridpane.add(slider3, 1, 2);
        gridpane.add(lblValue3, 2, 2);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text3);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createGaussianBlurPane() {
        gaussianblur = new GaussianBlur();
        gaussianblur.setRadius(15.0);

        text4 = new Text();
        text4.setEffect(gaussianblur);
        text4.setText("Gaussian Blur");
        text4.setFill(Color.BLACK);
        text4.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        // Set Radius
        Label title1 = new Label("Radius:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(gaussianblur.getRadius()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(63.0);
        slider1.setValue(gaussianblur.getRadius());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(2.0);
        slider1.setBlockIncrement(2.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            gaussianblur.setRadius(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text4);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createMotionBlurPane() {
        motionblur = new MotionBlur();
        motionblur.setAngle(180.0);
        motionblur.setRadius(20.0);

        text5 = new Text();
        text5.setEffect(motionblur);
        text5.setText("Motion Blur");
        text5.setFill(Color.BLACK);
        text5.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        // Set Angle
        Label title1 = new Label("Angle:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(motionblur.getAngle()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(-360.0);
        slider1.setMax(360.0);
        slider1.setValue(motionblur.getAngle());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(5.0);
        slider1.setBlockIncrement(5.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            motionblur.setAngle(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Radius
        Label title2 = new Label("Radius:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(motionblur.getRadius()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(63.0);
        slider2.setValue(motionblur.getRadius());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            motionblur.setRadius(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text5);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createReflectionPane() {
        reflection = new Reflection();
        reflection.setTopOffset(0.0);
        reflection.setFraction(1.0);
        reflection.setTopOpacity(0.5);
        reflection.setBottomOpacity(0.0);

        imageview1 = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/JavaFX.png")));
        imageview1.setEffect(reflection);

        // Set Top Offset
        Label title1 = new Label("Top Offset:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(reflection.getTopOffset()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(20.0);
        slider1.setValue(reflection.getTopOffset());
        slider1.setMajorTickUnit(1.0);
        slider1.setBlockIncrement(1.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setTopOffset(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Fraction
        Label title2 = new Label("Fraction:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(reflection.getFraction()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(1.0);
        slider2.setValue(reflection.getFraction());
        slider2.setMajorTickUnit(0.1);
        slider2.setBlockIncrement(0.1);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setFraction(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set Top Opacity
        Label title3 = new Label("Top Opacity:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(reflection.getTopOpacity()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(1.0);
        slider3.setValue(reflection.getTopOpacity());
        slider3.setMajorTickUnit(0.1);
        slider3.setBlockIncrement(0.1);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setTopOpacity(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Bottom Opacity
        Label title4 = new Label("Bottom Opacity:");
        title4.setPrefSize(120, 25);

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(reflection.getBottomOpacity()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(1.0);
        slider4.setValue(reflection.getBottomOpacity());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            reflection.setBottomOpacity(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);
        gridpane.add(title3, 0, 2);
        gridpane.add(slider3, 1, 2);
        gridpane.add(lblValue3, 2, 2);
        gridpane.add(title4, 0, 3);
        gridpane.add(slider4, 1, 3);
        gridpane.add(lblValue4, 2, 3);

        AnchorPane anchorpane = new AnchorPane();
        AnchorPane.setTopAnchor(imageview1, 100.0);
        AnchorPane.setLeftAnchor(imageview1, 200.0);
        anchorpane.getChildren().add(imageview1);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(anchorpane);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createGlowPane() {
        glow = new Glow();
        glow.setLevel(0.8);

        imageview2 = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/JavaFX.png")));
        imageview2.setEffect(glow);

        // Set Level
        Label title1 = new Label("Level:");
        title1.setPrefWidth(50);

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(glow.getLevel()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(1.0);
        slider1.setValue(glow.getLevel());
        slider1.setMajorTickUnit(0.1);
        slider1.setBlockIncrement(0.1);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            glow.setLevel(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(imageview2);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createBloomPane() {
        bloom = new Bloom();
        bloom.setThreshold(0.1);

        imageview3 = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/JavaFX.png")));
        imageview3.setEffect(bloom);

        // Set Threshold
        Label title1 = new Label("Threshold:");
        title1.setPrefWidth(70);

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(bloom.getThreshold()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(1.0);
        slider1.setValue(bloom.getThreshold());
        slider1.setMajorTickUnit(0.1);
        slider1.setBlockIncrement(0.1);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            bloom.setThreshold(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(imageview3);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createSepiaTonePane() {
        sepiatone = new SepiaTone();
        sepiatone.setLevel(0.0);

        imageview4 = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/scene.jpg")));
        imageview4.setEffect(sepiatone);

        // Set Level
        Label title1 = new Label("Level:");
        title1.setPrefWidth(50);

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(sepiatone.getLevel()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(1.0);
        slider1.setValue(sepiatone.getLevel());
        slider1.setMajorTickUnit(0.1);
        slider1.setBlockIncrement(0.1);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sepiatone.setLevel(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(imageview4);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    private BorderPane createPerspectiveTransformPane() {
        perspectiveTrasform = new PerspectiveTransform();
        perspectiveTrasform.setUlx(150.0);
        perspectiveTrasform.setUly(5.0);
        perspectiveTrasform.setUrx(420.0);
        perspectiveTrasform.setUry(55.0);
        perspectiveTrasform.setLrx(450.0);
        perspectiveTrasform.setLry(100.0);
        perspectiveTrasform.setLlx(25.0);
        perspectiveTrasform.setLly(185.0);

        text6 = new Text();
        text6.setText("Perspective Transform");
        text6.setFill(Color.BLACK);
        text6.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        group = new Group();
        group.setCache(true);
        group.getChildren().add(text6);

        group.setEffect(perspectiveTrasform);

        // Set X Coordinate of the Upper Left Corner
        Label title1 = new Label("Upper Left X:");

        final Label lblValue1 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUlx()));
        lblValue1.setPrefSize(100, 25);

        final Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.HORIZONTAL);
        slider1.setMin(0.0);
        slider1.setMax(500.0);
        slider1.setValue(perspectiveTrasform.getUlx());
        slider1.setMinorTickCount(1);
        slider1.setMajorTickUnit(2.0);
        slider1.setBlockIncrement(2.0);
        slider1.setPrefSize(200, 25);
        slider1.setSnapToTicks(true);

        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUlx(slider1.getValue());
            lblValue1.setText(new DecimalFormat("0.0").format(slider1.getValue()));
        });

        // Set Y Coordinate of the Upper Left Corner
        Label title2 = new Label("Upper Left Y:");

        final Label lblValue2 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUly()));
        lblValue2.setPrefSize(100, 25);

        final Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.HORIZONTAL);
        slider2.setMin(0.0);
        slider2.setMax(200.0);
        slider2.setValue(perspectiveTrasform.getUly());
        slider2.setMinorTickCount(1);
        slider2.setMajorTickUnit(2.0);
        slider2.setBlockIncrement(2.0);
        slider2.setPrefSize(200, 25);
        slider2.setSnapToTicks(true);

        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUly(slider2.getValue());
            lblValue2.setText(new DecimalFormat("0.0").format(slider2.getValue()));
        });

        // Set X Coordinate of the Upper Right Corner
        Label title3 = new Label("Upper Right X:");

        final Label lblValue3 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUrx()));
        lblValue3.setPrefSize(100, 25);

        final Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.HORIZONTAL);
        slider3.setMin(0.0);
        slider3.setMax(500.0);
        slider3.setValue(perspectiveTrasform.getUrx());
        slider3.setMinorTickCount(1);
        slider3.setMajorTickUnit(2.0);
        slider3.setBlockIncrement(2.0);
        slider3.setPrefSize(200, 25);
        slider3.setSnapToTicks(true);

        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUrx(slider3.getValue());
            lblValue3.setText(new DecimalFormat("0.0").format(slider3.getValue()));
        });

        // Set Y Coordinate of the Upper Right Corner
        Label title4 = new Label("Upper Right Y:");

        final Label lblValue4 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getUry()));
        lblValue4.setPrefSize(100, 25);

        final Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.HORIZONTAL);
        slider4.setMin(0.0);
        slider4.setMax(200.0);
        slider4.setValue(perspectiveTrasform.getUry());
        slider4.setMajorTickUnit(0.1);
        slider4.setBlockIncrement(0.1);
        slider4.setPrefSize(200, 25);
        slider4.setSnapToTicks(true);

        slider4.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setUry(slider4.getValue());
            lblValue4.setText(new DecimalFormat("0.0").format(slider4.getValue()));
        });

        // Set X Coordinate of the Lower Right Corner
        Label title5 = new Label("Lower Right X:");

        final Label lblValue5 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLrx()));
        lblValue5.setPrefSize(100, 25);

        final Slider slider5 = new Slider();
        slider5.setOrientation(Orientation.HORIZONTAL);
        slider5.setMin(0.0);
        slider5.setMax(500.0);
        slider5.setValue(perspectiveTrasform.getLrx());
        slider5.setMinorTickCount(1);
        slider5.setMajorTickUnit(2.0);
        slider5.setBlockIncrement(2.0);
        slider5.setPrefSize(200, 25);
        slider5.setSnapToTicks(true);

        slider5.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLrx(slider5.getValue());
            lblValue5.setText(new DecimalFormat("0.0").format(slider5.getValue()));
        });

        // Set Y Coordinate of the Lower Right Corner
        Label title6 = new Label("Lower Right Y:");

        final Label lblValue6 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLry()));
        lblValue6.setPrefSize(100, 25);

        final Slider slider6 = new Slider();
        slider6.setOrientation(Orientation.HORIZONTAL);
        slider6.setMin(0.0);
        slider6.setMax(200.0);
        slider6.setValue(perspectiveTrasform.getLry());
        slider6.setMajorTickUnit(0.1);
        slider6.setBlockIncrement(0.1);
        slider6.setPrefSize(200, 25);
        slider6.setSnapToTicks(true);

        slider6.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLry(slider6.getValue());
            lblValue6.setText(new DecimalFormat("0.0").format(slider6.getValue()));
        });

        // Set X Coordinate of the Lower Left Corner
        Label title7 = new Label("Lower Left X:");

        final Label lblValue7 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLlx()));
        lblValue7.setPrefSize(100, 25);

        final Slider slider7 = new Slider();
        slider7.setOrientation(Orientation.HORIZONTAL);
        slider7.setMin(0.0);
        slider7.setMax(500.0);
        slider7.setValue(perspectiveTrasform.getLlx());
        slider7.setMinorTickCount(1);
        slider7.setMajorTickUnit(2.0);
        slider7.setBlockIncrement(2.0);
        slider7.setPrefSize(200, 25);
        slider7.setSnapToTicks(true);

        slider7.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLlx(slider7.getValue());
            lblValue7.setText(new DecimalFormat("0.0").format(slider7.getValue()));
        });

        // Set Y Coordinate of the Lower Left Corner
        Label title8 = new Label("Lower Left Y:");

        final Label lblValue8 = new Label(new DecimalFormat("0.0").format(perspectiveTrasform.getLly()));
        lblValue8.setPrefSize(100, 25);

        final Slider slider8 = new Slider();
        slider8.setOrientation(Orientation.HORIZONTAL);
        slider8.setMin(0.0);
        slider8.setMax(200.0);
        slider8.setValue(perspectiveTrasform.getLly());
        slider8.setMajorTickUnit(0.1);
        slider8.setBlockIncrement(0.1);
        slider8.setPrefSize(200, 25);
        slider8.setSnapToTicks(true);

        slider8.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            perspectiveTrasform.setLly(slider8.getValue());
            lblValue8.setText(new DecimalFormat("0.0").format(slider8.getValue()));
        });

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-background-color: #d4d0c8;");
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(title1, 0, 0);
        gridpane.add(slider1, 1, 0);
        gridpane.add(lblValue1, 2, 0);
        gridpane.add(title2, 0, 1);
        gridpane.add(slider2, 1, 1);
        gridpane.add(lblValue2, 2, 1);
        gridpane.add(title3, 0, 2);
        gridpane.add(slider3, 1, 2);
        gridpane.add(lblValue3, 2, 2);
        gridpane.add(title4, 0, 3);
        gridpane.add(slider4, 1, 3);
        gridpane.add(lblValue4, 2, 3);
        gridpane.add(title5, 0, 4);
        gridpane.add(slider5, 1, 4);
        gridpane.add(lblValue5, 2, 4);
        gridpane.add(title6, 0, 5);
        gridpane.add(slider6, 1, 5);
        gridpane.add(lblValue6, 2, 5);
        gridpane.add(title7, 0, 6);
        gridpane.add(slider7, 1, 6);
        gridpane.add(lblValue7, 2, 6);
        gridpane.add(title8, 0, 7);
        gridpane.add(slider8, 1, 7);
        gridpane.add(lblValue8, 2, 7);

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(group);
        borderpane.setBottom(gridpane);

        return borderpane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
