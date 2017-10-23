package agh.cs.lab1;
import java.util.*;

public class CarSystem {

    private static void run(ArrayList<Direction> args) {
        for(Direction arg : args) {
            switch(arg) {
                case f:
                    System.out.println("Forward");
                    break;
                case b:
                    System.out.println("Backward");
                    break;
                case r:
                    System.out.println("Right");
                    break;
                case l:
                    System.out.println("Left");
                    break;
                default:
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Engine start.");
        ArrayList<Direction> dirArgs = new ArrayList<>();
        for(String arg : args) {
            switch(arg) {
                case "f":
                    dirArgs.add(Direction.f);
                    break;
                case "b":
                    dirArgs.add(Direction.b);
                    break;
                case "r":
                    dirArgs.add(Direction.r);
                    break;
                case "l":
                    dirArgs.add(Direction.l);
                    break;
                default:
            }
        }

        run(dirArgs);
        System.out.println("Engine off.");
    }
}
