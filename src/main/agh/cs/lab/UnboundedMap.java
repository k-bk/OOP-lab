package agh.cs.lab;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private List<HayStack> hayStacks;

    public UnboundedMap(List<HayStack> hayStacks) {
        this.hayStacks = hayStacks;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !(isOccupied(position));
    }

    @Override
    public boolean isOccupied(Position position) {
        if(super.isOccupied(position))
            return true;
        for(HayStack h : hayStacks) {
            if(position.equals(h.getPosition()))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        Object object = super.objectAt(position);
        if(object != null)
            return object;
        for (HayStack h : hayStacks) {
            if (position.equals(h.getPosition()))
                return h;
        }
        return null;
    }

    @Override
    public String toString() {
        if(cars.size() > 0) {
            Position tmp = cars.get(1).getPosition();
            int xmin = tmp.x;
            int ymin = tmp.y;
            int xmax = tmp.x;
            int ymax = tmp.y;
            for(Car c : cars) {
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
