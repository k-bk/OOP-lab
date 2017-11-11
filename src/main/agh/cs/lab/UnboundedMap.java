package agh.cs.lab;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<HayStack> hayStackList) {
        for(HayStack h : hayStackList) {
            place(h);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !(isOccupied(position));
    }

    @Override
    public String toString() {
        if(cars.size() > 0) {
            Position tmp = cars.get(1).getPosition();
            int xmin = tmp.x;
            int ymin = tmp.y;
            int xmax = tmp.x;
            int ymax = tmp.y;
            for(Car c : cars.values()) {
                xmin = Math.min(xmin, c.getPosition().x);
                ymin = Math.min(ymin, c.getPosition().y);
                xmax = Math.max(xmax, c.getPosition().x);
                ymax = Math.max(ymax, c.getPosition().y);
            }
            lowerLeft = new Position(xmin, ymin);
            upperRight = new Position(xmax, ymax);
            return super.toString();
        }
        return "";
    }

}
