package com.synth.ui;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import com.synth.audio.Wavetable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class OscillatorUI {
    final int OSCILLATOR_WIDTH = 220;
    final int OSCILLATOR_HEIGHT = 120;
    final int PAD = 4;

    Pane pane = new Pane();
    Label oscillatorLabel;
    Label volumeLabel = new Label("Volume");
    Label pitchShiftLabel = new Label("Pitch Shift");
    Spinner<Double> volumeSpinner = new Spinner<Double>();
    Spinner<Double> pitchShiftSpinner = new Spinner<Double>();
    ChoiceBox<Wavetable> waveChoiceBox = new ChoiceBox<Wavetable>(FXCollections.observableArrayList( Wavetable.values()));

    public OscillatorUI(String label) {
        // Populate UI elements
        oscillatorLabel = new Label(label);
        waveChoiceBox.setValue(Wavetable.Sine);

        // Size elements
        pane.setPrefSize(OSCILLATOR_WIDTH, OSCILLATOR_HEIGHT);
        pane.setMaxSize(OSCILLATOR_WIDTH, OSCILLATOR_HEIGHT);
        pane.setMinSize(OSCILLATOR_WIDTH, OSCILLATOR_HEIGHT);
        volumeSpinner.setMaxWidth(120);
        volumeSpinner.setMinWidth(120);
        volumeSpinner.setPrefWidth(120);
        pitchShiftSpinner.setMaxWidth(120);
        pitchShiftSpinner.setMinWidth(120);
        pitchShiftSpinner.setPrefWidth(120);
        waveChoiceBox.setMaxWidth(120);
        waveChoiceBox.setMinWidth(120);
        waveChoiceBox.setPrefWidth(120);

        // Position elements
        oscillatorLabel.setLayoutX(PAD + 9);
        oscillatorLabel.setLayoutY(PAD + 4);

        waveChoiceBox.setLayoutX(OSCILLATOR_WIDTH - waveChoiceBox.getMaxWidth() - PAD);
        waveChoiceBox.setLayoutY(PAD);

        volumeLabel.setLayoutX(36);
        volumeLabel.setLayoutY(43 + PAD);
        volumeSpinner.setLayoutX(OSCILLATOR_WIDTH - volumeSpinner.getMaxWidth() - PAD);
        volumeSpinner.setLayoutY(40 + PAD);

        pitchShiftLabel.setLayoutX(21);
        pitchShiftLabel.setLayoutY(83 + PAD);
        pitchShiftSpinner.setLayoutX(OSCILLATOR_WIDTH - pitchShiftSpinner.getMaxWidth() - PAD);
        pitchShiftSpinner.setLayoutY(80 + PAD);

        // Border
        Line top = new Line(0,0,OSCILLATOR_WIDTH,0);
        Line right = new Line(OSCILLATOR_WIDTH,0,OSCILLATOR_WIDTH,OSCILLATOR_HEIGHT);
        Line bottom = new Line(OSCILLATOR_WIDTH,OSCILLATOR_HEIGHT,0,OSCILLATOR_HEIGHT);
        Line left = new Line(0,OSCILLATOR_HEIGHT,0,0);

        // Add all elements to pane
        pane.getChildren().addAll(oscillatorLabel, volumeLabel, pitchShiftLabel, volumeSpinner,
                pitchShiftSpinner, waveChoiceBox, top, right, bottom, left);

    }

    public Pane getUIElement() {
        return pane;
    }

}
