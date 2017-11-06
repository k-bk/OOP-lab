package agh.cs.lab;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Car> cars = new ArrayList<>();
    protected Position lowerLeft;
    protected Position upperRight;

    public boolean place(Car car) {
        if(canMoveTo(car.getPosition())) {
            cars.add(car);
            return true;
        }
        return false;
    }

    public void run(MoveDirection[] directions) {
        if(cars.size() > 0)
            for(int i = 0; i < directions.length; i++) {
                Car tmp = cars.get(i % cars.size());
                tmp.move(directions[i]);
            }
    }

    public Object objectAt(Position position) {
        for(Car c : cars) {
            if(position.equals(c.getPosition()))
                return c;
        }
        return null;
    }

    public boolean isOccupied(Position position) {
        for(Car c : cars) {
            if(position.equals(c.getPosition()))
                return true;
        }
        return false;
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer();
        return mapVisualizer.dump(this, lowerLeft, upperRight);
    }
}
