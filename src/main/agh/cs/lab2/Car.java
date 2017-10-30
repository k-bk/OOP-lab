package agh.cs.lab2;

public class Car {
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2,2);
    private Position limitA = new Position(0, 0);
    private Position limitB = new Position(4, 4);

    public void move(MoveDirection direction) {
        Position newPos = position;
        switch(direction) {
            case Left:
                this.direction = this.direction.previous();
                break;
            case Right:
                this.direction = this.direction.next();
                break;
            case Forward:
                newPos = position.add(this.direction.toPosition());
                break;
            case Backward:
                newPos = position.sub(this.direction.toPosition());
        }
        if(newPos.larger(limitA) && newPos.smaller(limitB))
            position = newPos;
    }
    @Override
    public String toString() {
        return "Samochód: " + direction + " " + position;
    }
}
