package oop.kurs2.redundant;

public class BattleShip {
    private int x, y, size;
    private int damageTaken;
    private boolean isHorizontal;

    public BattleShip(int x, int y, int size, boolean isHorizontal) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.isHorizontal = isHorizontal;
    }

    public void actionOnHit() {}
}
