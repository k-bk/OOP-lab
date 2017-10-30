package agh.cs.lab;

import java.util.ArrayList;

public class OptionsParser {

    public MoveDirection[] parse (String[] options) {
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
        MoveDirection[] output = new MoveDirection[moves.size()];
        for(int i = 0; i < moves.size(); i++) {
            output[i] = moves.get(i);
        }
        return output;
    }

}
