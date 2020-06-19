package org.seatcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seatcode.domain.Ground;
import org.seatcode.domain.LawnMower;
import org.seatcode.domain.Orientation;
import org.seatcode.domain.Position;

public class MowerControlServiceTest {

    private Ground ground;
    private LawnMower mower;
    private MowerControlService control;

    @Before
    public void init(){
        //ground = new Ground(5,5,N);
    }
    @Test
    public void getMowerToInitialPosition(){
        Assert.assertTrue(mower.goToInitialPosition().equals(
                                new Position(0,0,Orientation.NORTH)));
    }
    @Test
    public void mowerTurnRight(){
        mower.goToInitialPosition();
        control.turnRight();
        Assert.assertTrue(mower.getPosition().getOrtientation().equals(Orientation.EAST));
    }
    @Test
    public void mowerTurnLeft(){
        mower.goToInitialPosition();
        control.turnLeft();
        Assert.assertTrue(mower.getPosition().getOrtientation().equals(Orientation.EAST));
    }
    @Test
    public void mowerGoAhead(){
        mower.goToInitialPosition();
        control.goForward();
        Assert.assertTrue(mower.getPosition().getOrtientation().equals(Orientation.EAST));
    }
    @Test
    public void mowerInitialPosition(){

    }
    @Test
    public void mowerAtRightTopPosition(){

    }
}
