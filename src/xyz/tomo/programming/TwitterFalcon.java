package xyz.tomo.programming;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TwitterFalcon {

    public static Window window;
    public static boolean loop;

    public static void main(String[] args) {

        window = new Window();
        loop = true;

        Graphics gra = window.panel.image.createGraphics();

        EnumFalconScoreen scoreen = EnumFalconScoreen.START;

        long startTime;
        long fpsTime = 0;
        int fps = 30;
        int FPS = 0;
        int FPSCount = 0;
        while (loop) {
            if ((System.currentTimeMillis() - fpsTime) >= 1000) {
                fpsTime = System.currentTimeMillis();
                FPS = FPSCount;
                FPSCount = 0;
                System.out.println(FPS);
            }
            FPSCount++;
            startTime = System.currentTimeMillis();

            gra.setColor(Color.WHITE);
            gra.fillRect(0,0,500,500);

            switch (scoreen) {
                case START:
                    gra.setColor(Color.BLACK);
                    Font font = new Font("SansSerif",Font.PLAIN,50);
                    gra.setFont(font);
                    FontMetrics metrics = gra.getFontMetrics(font);
                    gra.drawString("Falcon!",240 - (metrics.stringWidth("Falcon!") / 2),100);
                    font = new Font("SansSerif",Font.PLAIN,20);
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("非公開アカウントユーザーのIDを入力してください",240 - (metrics.stringWidth("非公開アカウントユーザーのIDを入力してください") / 2),200);
                    font = new Font("SansSerif",Font.PLAIN,20);
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("IDを入力してからENTERキーを押して下さい",270 - (metrics.stringWidth("非公開アカウントユーザーのIDを入力してください") / 2),230);
                    if (Keyboard.isKeyPressed(KeyEvent.VK_ENTER)) {
                        scoreen = EnumFalconScoreen.GAME;
                    }
                    break;
                case GAME:
                    gra.setColor(Color.BLACK);
                    font = new Font("SansSerif",Font.PLAIN,30 );
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("解析中・・・",240 - (metrics.stringWidth("解析中・・・") / 2),150);
                    if (Keyboard.isKeyPressed(KeyEvent.VK_E)) {
                        scoreen = EnumFalconScoreen.GAME_OVER;
                    }
                    break;
                case GAME_OVER:
                    gra.setColor(Color.BLACK);
                    font = new Font("SansSerif",Font.PLAIN,30 );
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("鍵アカウントを突破しました",240 - (metrics.stringWidth("鍵アカウントを突破しました") / 2),150);
                    if (Keyboard.isKeyPressed(KeyEvent.VK_R)) {
                        System.exit(0);
                    }
                    break;
            }

            gra.setColor(Color.BLACK);
            gra.setFont(new Font("SansSerif",Font.PLAIN,10));
            gra.drawString(FPS + "FPS",0,460);

            window.panel.draw();

            try {
                long runTime = System.currentTimeMillis() - startTime;
                if (runTime < (1000 / fps)) {
                    Thread.sleep((1000 / fps) - (runTime));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}