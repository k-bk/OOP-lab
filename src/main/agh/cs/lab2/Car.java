package agh.cs.lab2;

public class Car {
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2,2);

    public void move(MoveDirection direction) {
        switch(direction) {
            case Left:
                this.direction = this.direction.previous();
                break;
            case Right:
                this.direction = this.direction.next();
                break;
            case Forward:
                this.position = this.position.add(this.direction.toPosition());
                break;
            case Backward:
                this.position = this.position.add(this.direction.toPosition());
        }
    }
    @Override
    public String toString() {
        return "Samochód: " + direction + " " + position;
    }
}
