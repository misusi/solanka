package com.synth;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Synthesizer extends Application {
    Pane mainPane = new Pane();
    final int SYNTH_WIDTH = 800;
    final int SYNTH_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set up root window
        Pane rootPane = new Pane();
        rootPane.setMaxSize(SYNTH_WIDTH, SYNTH_HEIGHT);
        rootPane.setMinSize(SYNTH_WIDTH, SYNTH_HEIGHT);
        rootPane.setPrefSize(SYNTH_WIDTH, SYNTH_HEIGHT);

        // Create oscillators

        // Finalize stage/scene
        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
