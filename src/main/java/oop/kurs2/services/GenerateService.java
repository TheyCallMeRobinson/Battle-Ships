package oop.kurs2.services;

import oop.kurs2.units.Coordinate;
import oop.kurs2.BattleField;
import oop.kurs2.units.State;

import java.util.*;
/*
 * хранить дерево расстановки
 * узел хранит в себе поле с расставленными кораблями
 * каждая постановка корабля это отдельный узел
 * если сумели расставить корабли за линейное время, то гуд, если нет, то откатываться на узел назад и ставить в другое место
 * 
 */
public class GenerateService {
    private static List<Coordinate> generateShipsByType(int x, int y) {
        List<Coordinate> list = new LinkedList<>();
        for(int i = 0; i < x * y / 3; i++) {
            list.add(new Coordinate((int)(Math.random() * x), (int)(Math.random() * y)));
        }
        return list;
    }
    public static BattleField generateBattlefield(int x, int y, String playerName) {
        BattleField bf = new BattleField(x, y, playerName);

        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++) {
                Coordinate c = new Coordinate(i, j);
                bf.getField().put(c, State.Free);
                bf.getRemainingCells().add(c);
            }

        List<Coordinate> bs = generateShipsByType(x, y);
        for (var i : bs)
            bf.getField().replace(i, State.Battleship);
        return bf;
    }
}
