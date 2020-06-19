package org.seatcode.Command;

import org.seatcode.domain.Position;

public class MoveCommandImpl implements ICommand {

    @Override
    public void execute(Position position) {

        int x, y = x = 0;

        switch(position.getOrientation())
        {
            case NORTH:
                y = 1;
                break;
            case SOUTH:
                y = -1;
                break;
            case EAST:
                x = 1;
                break;
            case WEST:
                x = -1;
                break;
        }

        position.setX(position.getX() + x);
        position.setY(position.getY() + y);

    }
}
