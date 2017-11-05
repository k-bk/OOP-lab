package agh.cs.lab;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private Position limitMax;
    private Position limitMin;
    private List<Car> cars = new ArrayList<>();

    RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.limitMax = new Position(width - 1, height - 1);
        this.limitMin = new Position(0,0);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.larger(limitMin)
                && position.smaller(limitMax)
                && !(isOccupied(position));
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
        for(int i = 0; i < directions.length; i++) {
            Car tmp = cars.get(i % cars.size());
            tmp.move(directions[i]);
        }
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
        for(Car c : cars) {
            if(position.equals(c.getPosition()))
                return c;
        }
        return null;
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer();
        return mapVisualizer.dump(this, limitMin, limitMax);
    }
}
