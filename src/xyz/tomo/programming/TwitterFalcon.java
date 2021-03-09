package xyz.tomo.programming;

import java.awt.*;
import java.awt.event.KeyEvent;

import static xyz.tomo.programming.EnumFalconScoreen.GAME_OVER;

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
        long sleeps;
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
                    gra.drawString("����J�A�J�E���g���[�U�[��ID����͂��Ă�������",240 - (metrics.stringWidth("����J�A�J�E���g���[�U�[��ID����͂��Ă�������") / 2),200);
                    font = new Font("SansSerif",Font.PLAIN,20);
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("ID����͂��Ă���ENTER�L�[�������ĉ�����",270 - (metrics.stringWidth("����J�A�J�E���g���[�U�[��ID����͂��Ă�������") / 2),230);
                    if (Keyboard.isKeyPressed(KeyEvent.VK_ENTER)) {
                        scoreen = EnumFalconScoreen.GAME;
                    }
                    break;
                case GAME:
                    gra.setColor(Color.BLACK);
                    font = new Font("SansSerif",Font.PLAIN,17);
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("���͂���ID�̔���J�A�J�E���g�������悤�ɂȂ�܂���",240 - (metrics.stringWidth("���͂���ID�̔���J�A�J�E���g�������悤�ɂȂ�܂���") / 2),100);

                    gra.setColor(Color.BLACK);
                    font = new Font("SansSerif",Font.PLAIN,17 );
                    gra.setFont(font);
                    metrics = gra.getFontMetrics(font);
                    gra.drawString("�u���E�U���J���Ċm�F���Ă�������",240 - (metrics.stringWidth("�u���E�U���J���Ċm�F���Ă�������") / 2),150);

                    try {
                        gra.setColor(Color.BLACK);
                        font = new Font("SansSerif",Font.PLAIN,17 );
                        gra.setFont(font);
                        metrics = gra.getFontMetrics(font);
                        gra.drawString("��͒��E�E�E",240 - (metrics.stringWidth("��͒��E�E�E") / 2),170);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        gra.setColor(Color.BLACK);
                        font = new Font("SansSerif",Font.PLAIN,17 );
                        gra.setFont(font);
                        metrics = gra.getFontMetrics(font);
                        gra.drawString("����J�A�J�E���g�������E�E�E",240 - (metrics.stringWidth("����J�A�J�E���g�������E�E�E") / 2),170);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case GAME_OVER:
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