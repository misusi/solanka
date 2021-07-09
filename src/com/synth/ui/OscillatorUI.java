package com.synth.ui;

import com.synth.Oscillator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import com.synth.audio.Wavetable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class OscillatorUI extends Oscillator {
    final int OSCILLATOR_WIDTH = 220;
    final int OSCILLATOR_HEIGHT = 120;
    final int PAD = 4;

    Pane pane = new Pane();
    Label oscillatorLabel;

    // Volume Controls
    Label volumeLabel = new Label("Volume");
    SpinnerValueFactory.IntegerSpinnerValueFactory volumeSpinnerValueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 100);
    Spinner<Integer> volumeSpinner = new Spinner<Integer>(volumeSpinnerValueFactory);

    // Pitch Controls
    Label pitchShiftLabel = new Label("Pitch Shift");
    SpinnerValueFactory.DoubleSpinnerValueFactory pitchShiftSpinnerValueFactory =
            new SpinnerValueFactory.DoubleSpinnerValueFactory(-2.000d, 2.000d, 0.000d);
    Spinner<Double> pitchShiftSpinner = new Spinner<Double>(pitchShiftSpinnerValueFactory);

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

        connectUIToValues();

        // Add all elements to pane
        pane.getChildren().addAll(oscillatorLabel, volumeLabel, pitchShiftLabel, volumeSpinner,
                pitchShiftSpinner, waveChoiceBox, top, right, bottom, left);

    }

    private void connectUIToValues() {
        volumeSpinner.setEditable(true);
        volumeSpinnerValueFactory.setAmountToStepBy(5);
        pitchShiftSpinner.setEditable(true);
        pitchShiftSpinnerValueFactory.setAmountToStepBy(0.05);
//        pitchShiftSpinner.promptTextProperty().
    }

    public Pane getUIElement() {
        return pane;
    }

}
