package xyz.tomo.programming;

import java.awt.*;

public class TwitterFalcon {

    public static Window window;
    public static boolean loop;

    public static void main(String[] args) {
        window = new Window();
        loop = true;

        Graphics gra = window.panel.image.createGraphics();

        //fps
        long startTime;
        long fpsTime = 0;
        int fps = 30;
        int FPS = 0;
        while (loop) {
            if ((System.currentTimeMillis() - fpsTime) >= 1000) {
                fpsTime = System.currentTimeMillis();
            }
            startTime = System.currentTimeMillis();

            gra.setColor(Color.WHITE);
            gra.fillRect(0,0,500,500);

            gra.setColor(Color.BLACK);
            gra.fillRect(100,100,100,100);

            window.panel.draw();

            try {
            Thread.sleep((1000 / fps) - (System.currentTimeMillis() - startTime));

        } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(System.currentTimeMillis() - startTime);
        }
    }
}
