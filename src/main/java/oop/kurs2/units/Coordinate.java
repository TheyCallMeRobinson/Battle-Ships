package oop.kurs2.units;

public class Coordinate {
    private int x, y;

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass())
            return false;
        Coordinate coordinate = (Coordinate)obj;
        return coordinate.getX() == this.x && coordinate.getY() == this.y;
    }
    @Override
    public int hashCode() {
        final int prime = 1000;
        return prime * x + y;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Character x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
