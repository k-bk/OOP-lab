package agh.cs.lab;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected Map<Position, Car> cars = new HashMap<>();
    protected Position lowerLeft;
    protected Position upperRight;

    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())) {
            cars.put(car.getPosition(), car);
            return true;
        }
        //throw new IllegalArgumentException(car.getPosition() + " is already occupied");
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
        return cars.get(position);
    }

    public boolean isOccupied(Position position) {
        return cars.containsKey(position);
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer();
        return mapVisualizer.dump(this, lowerLeft, upperRight);
    }
}
