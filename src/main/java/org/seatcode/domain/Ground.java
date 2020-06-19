package org.seatcode.domain;

public class Ground {
    private final int [][] ground;

    public Ground(int x, int y) {
        ground = new int [x][y];
    }
    public boolean cellValidation(int x, int y){
        return (x >= 0 && y >= 0);
    }

    public boolean lengthValidation(int x, int y){
        return (x >= 0 && x < ground.length) && (y >= 0 && y < ground[0].length);
    }
}
