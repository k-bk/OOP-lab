package agh.cs.lab;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;

    RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return false;
    }

    @Override
    public boolean place(Car car) {
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Position position) {
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        return null;
    }
}
