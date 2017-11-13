package agh.cs.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected Map<Position, Car> cars = new HashMap<>();
    protected List<Car> carList = new ArrayList<>();
    protected Position lowerLeft;
    protected Position upperRight;

    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())) {
            cars.put(car.getPosition(), car);
            carList.add(car);
            return true;
        } else {
            throw new IllegalArgumentException(car.getPosition() + " is already occupied by " + objectAt(car.getPosition()));
        }
    }


    public void run(MoveDirection[] directions) {
        if(!cars.isEmpty())
            for(int i = 0; i < directions.length; ) {
                Car tmpCar = carList.get(i % cars.size());
                Position oldPos = tmpCar.getPosition();
                tmpCar.move(directions[i]);
                //cars.remove(oldPos);
                place(tmpCar);
            }
    }

    public Object objectAt(Position position) {
        return cars.getOrDefault(position, null);
    }

    public boolean isOccupied(Position position) {
        return cars.containsKey(position);
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer();
        return mapVisualizer.dump(this, lowerLeft, upperRight);
    }
}
