package oop.kurs2.redundant;

import oop.kurs2.units.Coordinate;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    // этот класс особо не нужен, можно сделать слияние с battlefield
    private LinkedList<Coordinate> preferredCells = new LinkedList<>();
    private ArrayList<Coordinate> prohibitedCells = new ArrayList<>();
    private ArrayList<Coordinate> moves = new ArrayList<>();

    public LinkedList<Coordinate> getPreferredCells() {
        return preferredCells;
    }
    public ArrayList<Coordinate> getProhibitedCells() {
        return prohibitedCells;
    }

    public void setPreferredCells(LinkedList<Coordinate> preferredCells) {
        this.preferredCells = preferredCells;
    }
    public void setProhibitedCells(ArrayList<Coordinate> prohibitedCells) {
        this.prohibitedCells = prohibitedCells;
    }
}
