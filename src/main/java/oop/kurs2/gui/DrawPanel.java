package oop.kurs2.gui;

import oop.kurs2.BattleField;
import oop.kurs2.services.BattleService;
import oop.kurs2.services.DrawService;
import oop.kurs2.services.GenerateService;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private int sizeX, sizeY;
    private BattleField first = GenerateService.generateBattlefield(5, 5, "Vasya");
    private BattleField second = GenerateService.generateBattlefield(5, 5, "Vasily");

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
        DrawService.drawField(bi_g, first, second, sizeX, sizeY);
        bi_g.dispose();
        g.drawImage(bi, 0, 0, null);
    }
    public void nextStep(boolean b) {
        if(BattleService.hasNextMove(first, second))
            if(b)
                BattleService.nextMove(first, second);
            else
                BattleService.nextMove(second, first);
    }
    public BattleField getFirstField() {
        return first;
    }
    public BattleField getSecondField() {
        return second;
    }
    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    public void setFirstField(BattleField first) {
        this.first = first;
    }
    public void setSecondField(BattleField second) {
        this.second = second;
    }
}
