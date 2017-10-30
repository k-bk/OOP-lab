package agh.cs.lab;

import java.util.ArrayList;

public class OptionParser {

    public ArrayList<MoveDirection> parser (String[] options) {
        ArrayList<MoveDirection> moves = new ArrayList<MoveDirection>();
        for(String s : options) {
            switch(s) {
                case "f":
                case "forward":
                   moves.add(MoveDirection.Forward);
                   break;
                case "b":
                case "backward":
                    moves.add(MoveDirection.Backward);
                    break;
                case "l":
                case "left":
                    moves.add(MoveDirection.Left);
                    break;
                case "r":
                case "right":
                    moves.add(MoveDirection.Right);
            }
        }
        return moves;
    }

}
