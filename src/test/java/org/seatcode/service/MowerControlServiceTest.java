package org.seatcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seatcode.domain.*;

public class MowerControlServiceTest {

    private Ground ground;

    @Before
    public void init(){
        ground = new Ground(5,5);
    }

    private MowerControlService newControl(){
        LawnMower mower = new LawnMower(0,0,Orientation.NORTH);
        mower.setGround(ground);
        MowerControlService control = new MowerControlService(mower);
        return control;
    }


    @Test
    public void mowerTurnRight(){
        MowerControlService control = newControl();

        control.makeMovements(Movements.R);
        Assert.assertTrue(control.getMower().
                getCurrentPosition().getOrientation().equals(Orientation.EAST));
    }
    @Test
    public void mowerTurnLeft(){
        MowerControlService control = newControl();

        control.makeMovements(Movements.L);
        Assert.assertTrue(control.getMower()
                .getCurrentPosition().getOrientation().equals(Orientation.WEST));
    }
    @Test
    public void mowerGoAhead(){
        MowerControlService control = newControl();

        control.makeMovements(Movements.M);
        Assert.assertTrue(control.getMower().
                getCurrentPosition().getY().equals(1));
    }

}
