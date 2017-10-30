package agh.cs.lab;

import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private Position limitMax;
    private Position limitMin;
    private List<Car> cars;

    RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.limitMax = new Position(width - 1, height - 1);
        this.limitMin = new Position(0,0);
    }

    @Override
    public boolean canMoveTo(Position position) {
        if(position.larger(limitMin)
                && position.smaller(limitMax)
                && !(isOccupied(position)))
            return true;
        return false;
    }

    @Override
    public boolean place(Car car) {
        if(canMoveTo(car.getPosition())) {
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Position position) {
        for(Car c : cars) {
            if(position.equals(c.getPosition()))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        return null;
    }
}