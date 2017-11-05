package agh.cs.lab;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap implements IWorldMap {

    private List<Car> cars = new ArrayList<>();
    private List<HayStack> hayStacks;

    public UnboundedMap(List<HayStack> hayStacks) {
        this.hayStacks = hayStacks;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return isOccupied(position);
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
        if(cars.size() > 0)
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
        for(HayStack h : hayStacks) {
            if(position.equals(h.getPosition()))
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
        for(HayStack h : hayStacks) {
            if(position.equals(h.getPosition()))
                return h;
        }
        return null;
    }

    public String toString() {
        if(cars.size() > 0) {
            Position tmp = cars.get(1).getPosition();
            Position lowerLeft = new Position(tmp.x, tmp.y);
            Position upperRight = new Position(tmp.x, tmp.y);
            for(Car c : cars) {
                int xmin = Math.min(lowerLeft.x, c.getPosition().x);
                int ymin = Math.min(lowerLeft.y, c.getPosition().y);
                lowerLeft = new Position(xmin, ymin);
                int xmax = Math.max(lowerLeft.x, c.getPosition().x);
                int ymax = Math.max(lowerLeft.y, c.getPosition().y);
                upperRight = new Position(xmax, ymax);
            }
            MapVisualizer mapVisualizer = new MapVisualizer();
            return mapVisualizer.dump(this, lowerLeft, upperRight);
        }
        return "";
    }

}
