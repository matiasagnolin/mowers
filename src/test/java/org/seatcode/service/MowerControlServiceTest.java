package org.seatcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seatcode.domain.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.seatcode.utils.FileReader.parseInputFile;

public class MowerControlServiceTest {

    private Ground ground;
    private static final String PATHTOFILE="src/test/resources/input.txt";

    @Before
    public void init(){
        ground = new Ground(6,6);
    }

    private MowerControlService newControl(Integer x, Integer y){
        LawnMower mower = new LawnMower(x,y, Orientation.N);
        mower.setGround(ground);
        return new MowerControlService(mower);
    }

    @Test
    public void mowerTurnRight()  {
        MowerControlService control = newControl(0,0);
        List<Movements> list = new ArrayList<>();
        list.add(Movements.R);

        control.makeMovements(list);
        Assert.assertEquals(control.getMower().
                getCurrentPosition().getOrientation(), Orientation.E);
    }
    @Test
    public void mowerTurnLeft()  {
        MowerControlService control = newControl(0,0);
        List<Movements> list = new ArrayList<>();
        list.add(Movements.L);
        control.makeMovements(list);
        Assert.assertEquals(control.getMower()
                .getCurrentPosition().getOrientation(), Orientation.W);
    }
    @Test
    public void mowerGoAhead()  {
        MowerControlService control = newControl(0,0);
        List<Movements> list = new ArrayList<>();
        list.add(Movements.M);
        control.makeMovements(list);
        Assert.assertEquals(1, (int) control.getMower().
                getCurrentPosition().getY());
    }
    @Test
    public void goToTopRight(){
        MowerControlService control = newControl(0,0);
        List<Movements> list = new ArrayList<>();
        for(int i=0;i<=4;i++){
            list.add(Movements.M);
        }
        list.add(Movements.R);
        for(int i=0;i<=4;i++){
            list.add(Movements.M);
        }
        list.add(Movements.L);
        control.makeMovements(list);
        Assert.assertEquals(control.getMower()
                .getCurrentPosition(), new Position(5, 5, Orientation.N));

    }
    @Test(expected = IllegalArgumentException.class)
    public void mowerFailsIllegalArgumentException() {
        MowerControlService control = newControl(0,0);

        List<Movements> list = new ArrayList<>();
        for(int i = 0; i<=6 ;i++ ){
            list.add(Movements.M);
        }
        control.makeMovements(list);
    }
    @Test
    public void testingExampleGivenWithThreads() throws IOException {

        File file = new File(PATHTOFILE);
        List<MowerControlService> list;
        list = parseInputFile(file);

        for (MowerControlService con : list) {
            new Thread(() -> con.makeMovements(con.getFollowingMovements())).start();
        }
    }


}
