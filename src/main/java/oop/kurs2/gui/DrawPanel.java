package oop.kurs2.gui;

import oop.kurs2.BattleField;
import oop.kurs2.services.DrawService;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private int sizeX, sizeY;
    private BattleField first;
    private BattleField second;

    public DrawPanel(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics bi_g = bi.getGraphics();
        bi_g.setColor(new Color(255, 255, 255));
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        DrawService.drawField(g, first, second, sizeX, sizeY);
    }

    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    public BattleField getFirst() {
        return first;
    }
    public void setFirst(BattleField first) {
        this.first = first;
    }
    public BattleField getSecond() {
        return second;
    }
    public void setSecond(BattleField second) {
        this.second = second;
    }
}
