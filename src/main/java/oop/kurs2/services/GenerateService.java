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

//        if(x == 10 && y == 10) {
//            State[][] field = new State[10][10];
//            Arrays.fill(field, State.Free);
//            for(int i = 4; i > 0; i--) {
//                for(int j = 1; j <= 5 - i; j++) {
//                    boolean flag = true;
//                    int _x, _y;
//                    while(flag) {
//                        flag = false;
//                        _x = (int)(Math.random() * (10 - i));
//                        _y = (int)(Math.random() * (10 - i));
//                        boolean isHorizontal = Math.random() > 0.5;
//                        if(isHorizontal) {
//                            for(int k = 0; k < i; k++) {
//                                if(field[_y][_x + k] != State.Free) flag = true;
//                                if(_y > 0)
//                                    if(field[_y - 1][_x + k] != State.Free) flag = true;
//                                if(_y < 9)
//                                    if(field[_y + 1][_x + k] != State.Free) flag = true;
//                            }
//                        } else {
//                            for(int k = 0; k < i; k++) {
//                                if(field[_y + k][_x] != State.Free) flag = true;
//                                if(_x > 0)
//                                    if(field[_y + k][_x - 1] != State.Free) flag = true;
//                                if(_y < 9)
//                                    if(field[_y + k][_x + 1] != State.Free) flag = true;
//                            }
//                        }
//                    }
//
//
//                }
//            }
//        }

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
