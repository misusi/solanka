package com.synth;

import com.synth.input.KeyListener;
import com.synth.ui.MenuBarUI;
import com.synth.ui.OscillatorUI;
import javafx.application.Application;
import javafx.scene.control.MenuBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Synthesizer extends Application {
    public static class AudioInfo {
        public static final int SYNTH_WIDTH = 800;
        public static final int SYNTH_HEIGHT = 542;
        public static final int SAMPLE_RATE = 44100;
    }
    private final KeyListener keyListener = new KeyListener();
    private Oscillator oscillator = new Oscillator();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set up root window
        Pane rootPane = new Pane();
        rootPane.setMaxSize(AudioInfo.SYNTH_WIDTH, AudioInfo.SYNTH_HEIGHT);
        rootPane.setMinSize(AudioInfo.SYNTH_WIDTH, AudioInfo.SYNTH_HEIGHT);
        rootPane.setPrefSize(AudioInfo.SYNTH_WIDTH, AudioInfo.SYNTH_HEIGHT);

        // Menu Bar
        rootPane.getChildren().add(new MenuBarUI().getUIElement());

        // Oscillators
        OscillatorUI oscillator1 = new OscillatorUI("Oscillator 1");
        oscillator1.getUIElement().setLayoutX(4);
        oscillator1.getUIElement().setLayoutY(34);
        OscillatorUI oscillator2 = new OscillatorUI("Oscillator 2");
        oscillator2.getUIElement().setLayoutX(4);
        oscillator2.getUIElement().setLayoutY(162);
        OscillatorUI oscillator3 = new OscillatorUI("Oscillator 3");
        oscillator3.getUIElement().setLayoutX(4);
        oscillator3.getUIElement().setLayoutY(290);
        OscillatorUI oscillator4 = new OscillatorUI("Oscillator 4");
        oscillator4.getUIElement().setLayoutX(4);
        oscillator4.getUIElement().setLayoutY(418);

        rootPane.getChildren().addAll(oscillator1.getUIElement(), oscillator2.getUIElement(), oscillator3.getUIElement(),
                oscillator4.getUIElement());


        // Finalize stage/scene
        Scene scene = new Scene(rootPane);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyListener.keyHandler);
        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyListener.keyHandler);
        primaryStage.setTitle("HidoiSoun");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Synthesizer.launch(args);
    }

}
