package org.seatcode.domain;

public class Position {
    Orientation orientation;
    Integer x;
    Integer y;

    public Position(Integer x, Integer y, Orientation orientation){
        this.orientation = orientation;
        this.x=x;
        this.y=y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
