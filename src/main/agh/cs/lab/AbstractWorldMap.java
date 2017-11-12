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
        } else {
            throw new IllegalArgumentException(car.getPosition() + " is already occupied by " + objectAt(car.getPosition()));
        }
    }


    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i += cars.size()) {
            for(Car c: cars.values()) {
                if(i < directions.length)
                    c.move(directions[i]);
            }
        }
    }

    public Object objectAt(Position position) {
        System.out.println("Check pos: " + position + " occupied" + isOccupied(position));
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
