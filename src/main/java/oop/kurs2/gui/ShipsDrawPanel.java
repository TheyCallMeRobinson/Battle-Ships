package oop.kurs2.gui;

import oop.kurs2.BattleField;
import oop.kurs2.Game;
import oop.kurs2.services.BattleService;
import oop.kurs2.services.DrawService;
import oop.kurs2.services.GenerateService;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ShipsDrawPanel extends JPanel {
    private int sizeX, sizeY;
    private Game game = new Game(
            GenerateService.generateBattlefield(10, 10, "Vasya"),
            GenerateService.generateBattlefield(10, 10, "Petya")
    );
    private String firstPlayerName, secondPlayerName;

    public ShipsDrawPanel(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics bi_g = bi.getGraphics();
        bi_g.setColor(new Color(255, 255, 255));
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        if(game.getAttacker().getPlayerName().equals(firstPlayerName))
            DrawService.drawField(bi_g, game.getAttacker(), game.getAttacked(), sizeX, sizeY);
        else
            DrawService.drawField(bi_g, game.getAttacked(), game.getAttacker(), sizeX, sizeY);
        bi_g.dispose();
        g.drawImage(bi, 0, 0, null);
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public String getFirstPlayerName() {
        return firstPlayerName;
    }
    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }
    public String getSecondPlayerName() {
        return secondPlayerName;
    }
    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
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
}
