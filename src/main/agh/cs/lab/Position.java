package agh.cs.lab;

public class Position {
    final int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean smaller(Position a) {
        return this.x <= a.x && this.y <= a.y;
    }

    boolean larger(Position a) {
        return this.x >= a.x && this.y >= a.y;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other)
            return true;
        if(!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return (this.x == that.x && this.y == that.y);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    Position add(Position a) {
        return new Position(this.x + a.x, this.y + a.y);
    }

    Position sub(Position a) {
        return new Position(this.x - a.x, this.y - a.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
