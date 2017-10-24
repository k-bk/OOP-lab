package agh.cs.lab2;

public class Car {
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2,3);
    private Position mapSize = new Position(4, 4);

    public void move(MoveDirection direction) {
        Position newPos = new Position(this.position.x, this.position.y);
        switch(direction) {
            case Right: this.direction.next();
            break;
            case Left: this.direction.previous();
            break;
            case Forward:
                newPos = newPos.add(this.direction.toPosition());
                if(newPos.smaller(mapSize) && newPos.larger(new Position(0,0)))
                    this.position = newPos;
                break;
            case Backward:
                newPos = newPos.sub(this.direction.toPosition());
                if(newPos.smaller(mapSize) && newPos.larger(new Position(0,0)))
                    this.position = newPos;
                break;
        }
    }
    public String toString() {
        return "Car{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
}
