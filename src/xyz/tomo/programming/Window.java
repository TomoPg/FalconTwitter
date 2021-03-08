package xyz.tomo.programming;

import javax.swing.*;

public class Window extends JFrame{
        public Window() {
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setTitle("Falcon");
            this.setSize(800,800);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
}
