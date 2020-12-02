package oop.kurs2.services;

import oop.kurs2.BattleField;
import oop.kurs2.units.Coordinate;
import oop.kurs2.units.State;

import java.util.*;

public class BattleService {
    private static Coordinate createShot(BattleField bf) {
        if (bf.getPreferredShots().size() > 0)
            return bf.getPreferredShots().poll();
        else
            return bf.getRemainingCells().get((int)(Math.random() * bf.getRemainingCells().size()));
    }
    private static State takeShot(BattleField bf, Coordinate coordinate) {
        State state = bf.getField().get(coordinate);
        if(state == State.Free || state == State.Miss) {
            bf.getField().put(coordinate, State.Miss);
            state = null;
        }
        else if(state != State.Damaged) {
            state = bf.getField().get(coordinate);
            bf.getField().put(coordinate, State.Damaged);
        }
        return state;
    }
    private static List<Coordinate> getUnitsByType(BattleField bf, State unitState) {
        List<Coordinate> units = new ArrayList<>();
        for(var i : bf.getField().keySet())
            if(bf.getField().get(i) == unitState)
                units.add(i);

        return units;
    }
    public static boolean checkDefeat(BattleField battleField) {return getUnitsByType(battleField, State.Battleship).size() == 0;}
    public static boolean hasNextMove(BattleField first, BattleField second) {
        return !checkDefeat(first) && !checkDefeat(second);
    }
    public static void nextMove(BattleField attacker, BattleField attacked) {
        Coordinate shot = createShot(attacker);
        State move = takeShot(attacked, shot);
        if (move != null)
            switch (move) {
                case Battleship:
                    attacker.getRemainingCells().remove(shot);
                    if (shot.getX() < attacker.getSizeX() - 1)
                        attacker.getPreferredShots().offer(new Coordinate(shot.getX() + 1, shot.getY()));
                    if(shot.getX() > 0)
                        attacker.getPreferredShots().offer(new Coordinate(shot.getX() - 1, shot.getY()));
                    if(shot.getY() < attacker.getSizeY() - 1)
                        attacker.getPreferredShots().offer(new Coordinate(shot.getX(), shot.getY() + 1));
                    if(shot.getY() > 0)
                        attacker.getPreferredShots().add(new Coordinate(shot.getX(), shot.getY() - 1));
//                    int[] newShotX = {
//                            shot.getX() == attacker.getSizeX() ? 0 : 1,
//                            0,
//                            shot.getX() == 0 ? 0 : -1,
//                            0
//                    };
//                    int[] newShotY = {
//                            0,
//                            shot.getY() == attacker.getSizeY() ? 0 : 1,
//                            0,
//                            shot.getY() == 0 ? 0 : -1
//                    };
//                    for(int i = 0; i < newShotX.length; i++)
//                        attacker.getPreferredShots().add(new Coordinate(shot.getX() + newShotX[i], shot.getY() + newShotY[i]));
                    break;
                case Sweeper:
                    attacked.getRemainingCells().remove(shot);
                    break;
                case Mine:
                    attacked.getPreferredShots().add(getUnitsByType(attacker, State.Battleship).get(0));
                    break;
            }
    }
}
