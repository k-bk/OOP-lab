package agh.cs.lab;
import java.util.*;

public class ActionParser {
    public List<MoveDirection> parse(String[] actions) {
        List<MoveDirection> moves = new ArrayList<>();
        for(String s : actions) {
            if (s.equals("forward") || s.equals("f")) {
                MoveDirection newMove = MoveDirection.Forward;
            moves.add(newMove);
            } else if(s.equals("backward") || s.equals("b")) {
                MoveDirection newMove = MoveDirection.Backward;
                moves.add(newMove);
            }
        }
        return moves;
    }
}
