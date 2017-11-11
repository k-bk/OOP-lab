package agh.cs.lab;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected Map<Position, IMapElement> mapElements = new HashMap<>();
    protected Map<Position, Car> cars = new HashMap<>();
    protected Position lowerLeft;
    protected Position upperRight;

    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())) {
            cars.put(car.getPosition(), car);
            mapElements.put(car.getPosition(), car);
            return true;
        } else {
            throw new IllegalArgumentException(car.getPosition() + " is already occupied");
        }
    }

    public boolean place(IMapElement element) {
        if(!isOccupied(element.getPosition())) {
            mapElements.put(element.getPosition(), element);
            return true;
        } else {
            throw new IllegalArgumentException(element.getPosition() + " is already occupied");
        }
    }

    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i += mapElements.size()) {
            for(Car c: cars.values()) {
                if(i < directions.length)
                    c.move(directions[i]);
            }
        }
    }

    public Object objectAt(Position position) {
        return mapElements.get(position);
    }

    public boolean isOccupied(Position position) {
        return mapElements.containsKey(position);
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer();
        return mapVisualizer.dump(this, lowerLeft, upperRight);
    }
}
