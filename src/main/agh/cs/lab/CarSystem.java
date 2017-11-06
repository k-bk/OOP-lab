package agh.cs.lab;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        List<HayStack> hayStackList = new ArrayList<HayStack>();
        hayStackList.add(new HayStack(new Position(-4,-4)));
        hayStackList.add(new HayStack(new Position(7,7)));
        hayStackList.add(new HayStack(new Position(3,6)));
        hayStackList.add(new HayStack(new Position(2,0)));
        IWorldMap map = new UnboundedMap(hayStackList);
        map.place(new Car(map));
        map.place(new Car(map,0,0));
        System.out.println(map);
        map.run(directions);
        System.out.println(map);
    }
}
