package oop.kurs2.services;

import oop.kurs2.BattleField;
import oop.kurs2.Game;
import oop.kurs2.units.State;

public class GameService {
    public static Game nextStep(Game game) {
        State currentState = BattleService.nextMove(game.getAttacker(), game.getAttacked());
        switch(currentState) {
            case Mine:
            case Miss:
            case Free:
            case Damaged:
                swapQueue(game);
        }
        return game;
    }
    private static void swapQueue(Game game) {
        BattleField temp = game.getAttacked();
        game.setAttacked(game.getAttacker());
        game.setAttacker(temp);
    }
}
