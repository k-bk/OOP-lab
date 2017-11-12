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
        //try {
            IWorldMap map = new UnboundedMap(hayStackList);
            //IWorldMap map = new RectangularMap(5, 7);
            map.place(new Car(map, 10, 10));
            map.place(new Car(map,5,0));
            System.out.println(map);
            map.run(directions);
            System.out.println(map);
        //} catch(IllegalArgumentException e) {
        //}
    }
}
