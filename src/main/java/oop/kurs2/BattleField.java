package oop.kurs2;

import oop.kurs2.units.Coordinate;
import oop.kurs2.units.State;

import java.util.*;

/*
 * Map<Coords, Cell>, заполнить ее ячейками
 * генерить корабли: длина, направление, координаты, размер(в случае, если не вмещаются - столько, сколько поместится)
 * вынести Point в паблик, Point -> Cell
 * Cell содержит: состояние(занято, свободно, получил выстрел (подбит))
 * логика: два игрока по очереди генерируют корабли и по очереди стреляют, каждый игрок содержит хешмап его ходов, в начале игры для каждого игрока генерировать список из ключей(координаты от А1 до И10)
 * и случайным образом генерировать выстрел по полю
 * хранить подбитые ячейки для каждого игрока
 * выделить все методы в отдельный BattleService, классы преимущественно содержат только поля, геттеры и сеттеры
 * чем меньше связей, тем лучше
 * вынести Cell в отдельный класс
 * */
// когда строю поле, заполняю лист и проставляю их координаты, заношу в поле field, расставляю корабли
// когда стреляю, то из поле cells удаляю ячейку, она попадает в prohibitedShots
//    private Map<ShipType, List<Ship>> ships = new HashMap<>();
//    private List<Coordinate> prohibitedShots = new ArrayList<>();//достаточно хранить сами cell, Set вместо Array

public class BattleField {
    private int sizeX, sizeY;
    private String playerName = "";
    private Map<Coordinate, State> field = new HashMap<>();
    private Queue<Coordinate> preferredShots = new LinkedList<>();
    private List<Coordinate> remainingCells = new ArrayList<>();

    public BattleField(int sizeX, int sizeY, String playerName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.playerName = playerName;
    }
    public BattleField() {}

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public String getPlayerName() {
        return playerName;
    }
    public Map<Coordinate, State> getField() {
        return field;
    }
    public Queue<Coordinate> getPreferredShots() {
        return preferredShots;
    }
    public List<Coordinate> getRemainingCells() {
        return remainingCells;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setField(Map<Coordinate, State> field) {
        this.field = field;
    }
    public void setPreferredShots(Queue<Coordinate> preferredShots) {
        this.preferredShots = preferredShots;
    }
    public void setRemainingCells(List<Coordinate> remainingCells) {
        this.remainingCells = remainingCells;
    }
}
