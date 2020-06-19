package org.seatcode.Command;

import org.seatcode.domain.Orientation;
import org.seatcode.domain.Position;

public class RightCommandImpl implements ICommand {
    @Override
    public Position execute(Position position) {
        Position newPosition = position.clone();
        Orientation orientation;

        switch(position.getOrientation()){
            case NORTH:
                orientation = Orientation.EAST;
                break;
            case SOUTH:
                orientation = Orientation.WEST;
                break;
            case EAST:
                orientation = Orientation.SOUTH;
                break;
            default:
                orientation = Orientation.NORTH;
        }
        newPosition.setOrientation(orientation);

        return newPosition;


    }
}
