package xyz.tomo.programming;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FalconPanel extends JPanel {
    public BufferedImage image;

    public FalconPanel() {
        super();
        this.image = new BufferedImage(500,500,BufferedImage.TYPE_INT_BGR);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image,0,0,this);
    }

    public void draw() {
        this.repaint();
    }
}
