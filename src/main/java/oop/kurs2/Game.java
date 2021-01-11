package oop.kurs2;

public class Game {
    private BattleField attacker, attacked;

    public Game(BattleField attacker, BattleField attacked) {
        this.attacker = attacker;
        this.attacked = attacked;
    }

    public Game() {}

    public BattleField getAttacker() {
        return attacker;
    }
    public BattleField getAttacked() {
        return attacked;
    }
    public void setAttacker(BattleField attacker) {
        this.attacker = attacker;
    }
    public void setAttacked(BattleField attacked) {
        this.attacked = attacked;
    }
}
