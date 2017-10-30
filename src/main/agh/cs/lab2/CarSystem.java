package agh.cs.lab2;

import java.util.ArrayList;

public class CarSystem {

    public static void main(String[] args) {
        Car car = new Car();
        OptionParser optionParser = new OptionParser();
        ArrayList<MoveDirection> moves = optionParser.parser(args);

        for(MoveDirection m : moves) {
            car.move(m);
            System.out.println(car);
        }
    }
}
