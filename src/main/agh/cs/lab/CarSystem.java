package agh.cs.lab;

import java.util.ArrayList;

public class CarSystem {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);
    }
}
