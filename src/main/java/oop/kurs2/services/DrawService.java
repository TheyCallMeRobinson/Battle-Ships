package oop.kurs2.services;

import oop.kurs2.BattleField;
import oop.kurs2.gui.DrawPanel;
import oop.kurs2.units.Coordinate;
import oop.kurs2.units.State;

import java.awt.*;
import java.util.Map;


public class DrawService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void printField(BattleField bf) {
        Map<Coordinate, State> map = bf.getField();
        State[][] field = new State[bf.getSizeX()][bf.getSizeY()];
        for(Coordinate i : map.keySet()) {
            try {
                field[i.getX()][i.getY()] = map.get(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for(State[] i : field) {
            for (State j : i) {
                String s = "\u001B[37m";
                switch (j) {
                    case Battleship:
                        s = "\u001B[37m██";//white
                        break;
                    case Sweeper:
                        s = "\u001B[32m██";//green
                        break;
                    case Mine:
                        s = "\u001B[34m██";//blue
                        break;
                    case Submarine:
                        s = "\u001B[33m██";//yellow
                        break;
                    case Free:
                        s = "\u001B[36m██";//cyan
                        break;
                    case Damaged:
                        s = "\u001B[31mXX";//red
                        break;
                    case Miss:
                        s = "\u001B[30m██";//black
                        break;
                }
                System.out.print(s);
            }
            System.out.println("\u001B[0m");
        }
    }

    public static void drawField(Graphics g, BattleField first, BattleField second, int sizeX, int sizeY) {
        Map<Coordinate, State> firstMap = first.getField();
        Map<Coordinate, State> secondMap = second.getField();
        int stepX = sizeX / first.getSizeX() / 3;
        int stepY = sizeY / first.getSizeY() / 3;
        int gapForSecondField = stepX * first.getSizeX() + 100;
        for(Coordinate i : firstMap.keySet()) {
            g.setColor(getColorByState(firstMap.get(i)));
            g.fillRect(i.getX() * stepX, i.getY() * stepY, stepX, stepY);
        }
        for(Coordinate i : secondMap.keySet()) {
            g.setColor(getColorByState(secondMap.get(i)));
            g.fillRect(i.getX() * stepX + gapForSecondField, i.getY() * stepY, stepX, stepY);
        }
    }
    private static Color getColorByState(State s) {
        switch(s) {
            case Battleship:
                return Color.GRAY;
            case Sweeper:
                return Color.GREEN;
            case Mine:
                return Color.BLUE;
            case Submarine:
                return Color.YELLOW;
            case Free:
                return Color.CYAN;
            case Damaged:
                return Color.RED;
            case Miss:
                return Color.WHITE;
        }
        return Color.WHITE;
    }
}
