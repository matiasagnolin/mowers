package org.seatcode.Command;

import org.seatcode.domain.Position;

public class MoveCommandImpl implements ICommand {

    @Override
    public Position execute(Position position) {
        Position newPosition = position.clone();
        int x, y = x = 0;

        switch(position.getOrientation())
        {
            case N:
                y = 1;
                break;
            case S:
                y = -1;
                break;
            case E:
                x = 1;
                break;
            case W:
                x = -1;
                break;
        }

        newPosition.setX(position.getX() + x);
        newPosition.setY(position.getY() + y);

        return newPosition;

    }
}
