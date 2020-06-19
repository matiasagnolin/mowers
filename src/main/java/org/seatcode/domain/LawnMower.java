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

    public void execute(ICommand command) throws IndexOutOfBoundsException{
        Position pos = command.execute(this.currentPosition);
        if(ground.lengthValidation(pos.getX(),pos.getY())){
            setCurrentPosition(pos);
        } else{
            throw new IndexOutOfBoundsException("Invalid Arguments");
        }
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
