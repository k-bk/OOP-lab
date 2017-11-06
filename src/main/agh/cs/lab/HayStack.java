package agh.cs.lab;

public class HayStack implements IMapElement {
    private Position position;

    public HayStack (Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String toString() {
        return "#";
    }
}
