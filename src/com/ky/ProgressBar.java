package com.ky;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar {

    private JFrame mainFrame;
    private JButton startButton;
    private JProgressBar progressBar;
    private Task task;

    public ProgressBar(){
        mainFrame = new JFrame("Progress Bar");
        mainFrame.setSize(600,400);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(3);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        startButton = new JButton("Start");
        startButton.setBounds(50,50,100,50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();

            }
        });

        progressBar = new JProgressBar(0,100);
        progressBar.setBounds(50,150,500,20);
        progressBar.setStringPainted(true);

        mainFrame.add(progressBar);
        mainFrame.add(startButton);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args){
        new ProgressBar();
    }

    private class Task extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <= 100 ; i++) {
                progressBar.setValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null,"Complete");
        }
    }
}
