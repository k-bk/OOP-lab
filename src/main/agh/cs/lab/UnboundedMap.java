package agh.cs.lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnboundedMap extends AbstractWorldMap {

    protected Map<Position, HayStack> hayStacks = new HashMap<>();

    public UnboundedMap(List<HayStack> hayStackList) {
        for(HayStack h : hayStackList) {
            place(h);
        }
    }

    public boolean place(HayStack hayStack) {
        if(!isOccupied(hayStack.getPosition())) {
            hayStacks.put(hayStack.getPosition(), hayStack);
            return true;
        } else {
            throw new IllegalArgumentException(hayStack.getPosition() + " is already occupied");
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !(isOccupied(position));
    }

    @Override
    public boolean isOccupied(Position position) {
        return hayStacks.containsKey(position) || super.isOccupied(position);
    }

    @Override
    public Object objectAt(Position position) {
        if(hayStacks.containsKey(position))
            return hayStacks.get(position);
        return super.objectAt(position);
    }

    @Override
    public String toString() {

        if(cars.size() > 0) {
            Position min = null;
            Position max = null;
            for(Car c : cars.values()) {
                if(max == null || c.getPosition().larger(max))
                    max = c.getPosition();
                if(min == null || c.getPosition().smaller(min))
                    min = c.getPosition();
            }
            lowerLeft = min;
            upperRight = max;
            return super.toString();
        }
        return "";
    }

}
