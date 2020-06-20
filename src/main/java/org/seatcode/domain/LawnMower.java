package org.seatcode.domain;

import org.seatcode.Command.ICommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LawnMower {

    private Position initialPosition;
    private Position currentPosition;
    private Ground ground;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LawnMower.class);

    public LawnMower(Integer x, Integer y, Orientation orientation){
        this.initialPosition = new Position(x,y,orientation);
        this.currentPosition = new Position(x,y,orientation);
    }

    public void execute(ICommand command) throws IndexOutOfBoundsException{
        Position pos = command.execute(currentPosition);
        if(ground.lengthValidation(pos.getX(),pos.getY())){
            LOGGER.info("Mower changed position: x{} y{} Orientation {}"
                    ,pos.getX(),pos.getY(),pos.getOrientation());
            setCurrentPosition(pos);
        } else{
            LOGGER.error("A critical error has occurred, " +
                    "the program is going to stop");
            throw new IllegalArgumentException("Please check input arguments");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawnMower lawnMower = (LawnMower) o;
        return Objects.equals(initialPosition, lawnMower.initialPosition) &&
                Objects.equals(currentPosition, lawnMower.currentPosition) &&
                Objects.equals(ground, lawnMower.ground);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialPosition, currentPosition, ground);
    }
}
