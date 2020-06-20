package org.seatcode.Command;

import org.seatcode.domain.Orientation;
import org.seatcode.domain.Position;

public class LeftCommandImpl implements ICommand {
    @Override
    public Position execute(Position position) {
        Position newPosition = position.clone();
        Orientation orientation;

        switch(position.getOrientation()){
            case N:
                orientation = Orientation.W;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case W:
                orientation = Orientation.S;
                break;
            default:
                orientation = Orientation.N;
        }
        newPosition.setOrientation(orientation);

        return newPosition;

    }
}
