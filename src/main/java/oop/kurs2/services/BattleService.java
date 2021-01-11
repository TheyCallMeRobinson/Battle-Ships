package oop.kurs2.services;

import oop.kurs2.BattleField;
import oop.kurs2.units.Coordinate;
import oop.kurs2.units.State;

import java.util.*;

public class BattleService {
    private static Coordinate createShot(BattleField attacker, BattleField attacked) {
        if (attacker.getPreferredShots().size() > 0)
            return attacker.getPreferredShots().poll();
        else
            return attacked.getRemainingCells().get((int)(Math.random() * attacked.getRemainingCells().size()));
    }
    private static State takeShot(BattleField attacked, Coordinate coordinate) {
        State state = attacked.getField().get(coordinate);

        if(state == State.Free || state == State.Miss)
            attacked.getField().put(coordinate, State.Miss);
        else if(state != State.Damaged)
            attacked.getField().put(coordinate, State.Damaged);

        attacked.getRemainingCells().remove(coordinate);
        return state;
    }
    private static List<Coordinate> getUnitsByType(BattleField bf, State unitState) {
        List<Coordinate> units = new ArrayList<>();
        for(Coordinate i : bf.getField().keySet())
            if(bf.getField().get(i) == unitState)
                units.add(i);

        return units;
    }
    public static boolean checkDefeat(BattleField battleField) {return getUnitsByType(battleField, State.Battleship).size() == 0;}
    public static boolean hasNextMove(BattleField first, BattleField second) {
        return !checkDefeat(first) && !checkDefeat(second);
    }
    public static State nextMove(BattleField attacker, BattleField attacked) {
        Coordinate shot = createShot(attacker, attacked);
        State move = takeShot(attacked, shot);
        List<Coordinate> newCoordinates;
        switch (move) {
            case Battleship:
                newCoordinates = new ArrayList<>();
                newCoordinates.add(new Coordinate(shot.getX() + 1, shot.getY()));
                newCoordinates.add(new Coordinate(shot.getX() - 1, shot.getY()));
                newCoordinates.add(new Coordinate(shot.getX(), shot.getY() + 1));
                newCoordinates.add(new Coordinate(shot.getX(), shot.getY() - 1));

                for (Coordinate i : newCoordinates)
                    if (attacked.getRemainingCells().contains(i))
                        attacker.getPreferredShots().add(i);
                break;

            case Sweeper:
                attacked.getRemainingCells().remove(shot);

                newCoordinates = new ArrayList<>();
                newCoordinates.add(new Coordinate(shot.getX() + 1, shot.getY()));
                newCoordinates.add(new Coordinate(shot.getX() - 1, shot.getY()));
                newCoordinates.add(new Coordinate(shot.getX(), shot.getY() + 1));
                newCoordinates.add(new Coordinate(shot.getX(), shot.getY() - 1));

                for (Coordinate i : newCoordinates)
                    attacked.getRemainingCells().remove(i);
                break;

            case Mine:
                attacked.getPreferredShots().add(getUnitsByType(attacker, State.Battleship).get(0));

                newCoordinates = new ArrayList<>();
                newCoordinates.add(new Coordinate(shot.getX() + 1, shot.getY()));
                newCoordinates.add(new Coordinate(shot.getX() - 1, shot.getY()));
                newCoordinates.add(new Coordinate(shot.getX(), shot.getY() + 1));
                newCoordinates.add(new Coordinate(shot.getX(), shot.getY() - 1));

                for (Coordinate i : newCoordinates)
                    attacked.getRemainingCells().remove(i);
                break;
        }
        return move;
    }
}
