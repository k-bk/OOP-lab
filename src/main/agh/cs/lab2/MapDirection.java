package agh.cs.lab2;

public enum MapDirection {
    North, South, West, East;

    public MapDirection next() {
        switch(this) {
            case North: return East;
            case South: return West;
            case East:  return South;
            case West:  return North;
        }
        return North;
    }

    public MapDirection previous() {
        switch(this) {
            case North: return West;
            case South: return East;
            case East:  return North;
            case West:  return South;
        }
        return North;
    }

    public String toString() {
        switch(this) {
            case North: return "Północ";
            case South: return "Południe";
            case East:  return "Wschód";
            case West:  return "Zachód";
        }
        return "";
    }
}