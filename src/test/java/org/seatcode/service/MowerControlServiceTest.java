package org.seatcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seatcode.domain.*;
import org.seatcode.utils.FileReader;

import java.io.File;
import java.io.IOException;

import static org.seatcode.domain.Movements.M;
import static org.seatcode.utils.FileReader.parseInputFile;

public class MowerControlServiceTest {

    private Ground ground;
    private static final String PATHTOFILE="src/test/resources/input.txt";
    @Before
    public void init(){
        ground = new Ground(5,5);
    }

    private MowerControlService newControl(Integer x, Integer y,Orientation orientation){
        LawnMower mower = new LawnMower(x,y,orientation);
        mower.setGround(ground);
        MowerControlService control = new MowerControlService(mower);
        return control;
    }

    @Test
    public void mowerTurnRight(){
        MowerControlService control = newControl(0,0,Orientation.NORTH);

        control.makeMovements(Movements.R);
        Assert.assertTrue(control.getMower().
                getCurrentPosition().getOrientation().equals(Orientation.EAST));
    }
    @Test
    public void mowerTurnLeft(){
        MowerControlService control = newControl(0,0,Orientation.NORTH);

        control.makeMovements(Movements.L);
        Assert.assertTrue(control.getMower()
                .getCurrentPosition().getOrientation().equals(Orientation.WEST));
    }
    @Test
    public void mowerGoAhead(){
        MowerControlService control = newControl(0,0,Orientation.NORTH);

        control.makeMovements(M);
        Assert.assertTrue(control.getMower().
                getCurrentPosition().getY().equals(1));
    }
    @Test
    public void mowerKeepRightPosition(){
        MowerControlService control = newControl(5,5,Orientation.NORTH);
        control.makeMovements(M);
        Assert.assertTrue(control.getMower()
                .getCurrentPosition().equals(new Position(5,5,Orientation.NORTH)));

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void mowerFailIndexOutOfBound(){
        MowerControlService control = newControl(0,0,Orientation.NORTH);

        control.makeMovements(M,M,M,M,M,M);
    }
    @Test
    public void testingExampleGiven() throws IOException {

        File file = new File(PATHTOFILE);
        MowerControlService control;
        control = parseInputFile(file);
        control.getFollowingMovements().forEach(e->control.makeMovements(e));
    }


}
