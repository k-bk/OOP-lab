package agh.cs.lab2;

public class CarSystem {

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);

        car.move(MoveDirection.Right);
        car.move(MoveDirection.Forward);
        car.move(MoveDirection.Forward);
        car.move(MoveDirection.Forward);
        System.out.println(car);
    }
}
