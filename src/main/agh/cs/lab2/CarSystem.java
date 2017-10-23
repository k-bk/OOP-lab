package agh.cs.lab2;

public class CarSystem {

    public static void main(String[] args) {
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(position1.smaller(position2));
        System.out.println(position1.larger(position2));
        System.out.println(position1.equals(position2));

        MapDirection a = MapDirection.East;
        System.out.println(a.next());
        System.out.println(a.previous());

    }
}
