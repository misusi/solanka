package com.synth.test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.ByteBuffer;
import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;


public class JFrame_sliderSine extends JFrame {

    private SampleThread m_thread;
    public static JSlider m_sliderPitch;


    //Launch the app
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame_sliderSine frame = new JFrame_sliderSine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public JFrame_sliderSine() {
        //UI stuff, created with WindowsBuilder
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                m_thread.exit();
                System.exit(0);
            }
        });

        setTitle("Slider Frequency Sine Wave Demo");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 793, 166);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));

        m_sliderPitch = new JSlider();
        m_sliderPitch.setName("");
        m_sliderPitch.setMinimum(100);
        m_sliderPitch.setPaintLabels(true);
        m_sliderPitch.setPaintTicks(true);
        m_sliderPitch.setMajorTickSpacing(500);
        m_sliderPitch.setMaximum(4100);
        m_sliderPitch.setValue(880);
        getContentPane().add(m_sliderPitch);

        JLabel lblAdjustPitch = new JLabel("Adjust Pitch");
        lblAdjustPitch.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdjustPitch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblAdjustPitch, BorderLayout.NORTH);


        //Non-UI stuff
        m_thread = new SampleThread();
        m_thread.start();
    }
}