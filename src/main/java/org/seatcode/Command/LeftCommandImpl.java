package org.seatcode.Command;

import org.seatcode.domain.Orientation;
import org.seatcode.domain.Position;

public class LeftCommandImpl implements ICommand {
    @Override
    public void execute(Position position) {
        Orientation orientation;

        switch(position.getOrientation()){
            case NORTH:
                orientation = Orientation.WEST;
                break;
            case SOUTH:
                orientation = Orientation.EAST;
                break;
            case WEST:
                orientation = Orientation.SOUTH;
                break;
            default:
                orientation = Orientation.NORTH;
        }
        position.setOrientation(orientation);

    }
}
