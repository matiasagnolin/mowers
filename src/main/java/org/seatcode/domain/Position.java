package org.seatcode.domain;

import java.util.Objects;

public class Position {
    private Orientation orientation;
    private Integer x;
    private Integer y;

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

    public Position clone(){
        return new Position(getX(),getY(),getOrientation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return orientation == position.orientation &&
                Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, x, y);
    }
}
