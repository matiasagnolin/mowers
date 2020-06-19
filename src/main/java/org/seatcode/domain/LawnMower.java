package org.seatcode.domain;

import org.seatcode.Command.ICommand;

public class LawnMower {

    private Position initialPosition;
    private Position currentPosition;
    private Ground ground;

    public LawnMower(Integer x, Integer y, Orientation orientation){
        this.initialPosition = new Position(x,y,orientation);
        this.currentPosition = new Position(x,y,orientation);
    }

    public Position goToIntialPosition(){

        return getCurrentPosition();
    }


    public void execute(ICommand command)
    {
        command.execute(this.currentPosition);
    }


    public Position getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Position initialPosition) {
        this.initialPosition = initialPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }
}
