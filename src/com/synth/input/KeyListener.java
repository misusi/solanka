package com.synth.input;

import com.synth.utils.Math;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.HashMap;

public class KeyListener {
    private static final HashMap<Character, Double> KEY_FREQUENCIES = new HashMap<>();
    private static HashMap<Character, Boolean> KEY_CURRENTLY_PRESSED = new HashMap<>();
    private static int numKeysPressed = 0;

    static {
        createKeyMappings();
    }

    private static void createKeyMappings() {
        final int STARTING_KEY = 16;
        final int KEY_FREQUENCY_INCREMENT = 2;
        final char[] KEYS = "zxcvbnm,./asdfghjkl;'qwertyuiop[]1234567890-=".toCharArray();
        for (int i = STARTING_KEY, key = 0; i < KEYS.length * KEY_FREQUENCY_INCREMENT + STARTING_KEY; i += KEY_FREQUENCY_INCREMENT, ++key) {
            KEY_FREQUENCIES.put(KEYS[key], Math.getKeyFrequency(i));
            KEY_CURRENTLY_PRESSED.put(KEYS[key], false);
        }
    }

    public static EventHandler<KeyEvent> keyHandler =
            keyEvent -> {
//                 If no char
                if (keyEvent.getText().isEmpty()) {
                    return;
                }
                char keyChar = keyEvent.getText().charAt(0);
                // If key is valid
                if (KEY_FREQUENCIES.get(keyChar) != null) {
                    // Key press
                    if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
                        // Key already set as pressed - return
                        if (KEY_CURRENTLY_PRESSED.get(keyChar) == true) {
                            return;
                        }
                        KEY_CURRENTLY_PRESSED.put(keyChar,true);
                        numKeysPressed++;
                        System.out.println("Pressed " + keyChar);
                    }
                    // Key release
                    else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
                        KEY_CURRENTLY_PRESSED.put(keyChar, false);
                        numKeysPressed--;
                        System.out.println("Released " + keyChar);
                    }
                }
                System.out.println(numKeysPressed);
            };
}