package xyz.tomo.programming;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame{
    public FalconPanel panel;

        public Window() {

            panel = new FalconPanel();

            this.add(panel);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    TwitterFalcon.loop = true;
                }
            });

            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setTitle("Falcon");
            this.setSize(500,500);;
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
        }
}
