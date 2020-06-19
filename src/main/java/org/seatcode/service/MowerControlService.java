package org.seatcode.service;

import org.seatcode.Command.ICommand;
import org.seatcode.Command.LeftCommandImpl;
import org.seatcode.Command.MoveCommandImpl;
import org.seatcode.Command.RightCommandImpl;
import org.seatcode.domain.LawnMower;
import org.seatcode.domain.Movements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MowerControlService {
    LawnMower mower;

    public MowerControlService(LawnMower mower){
        this.mower = mower;
    }

    private void addExecutions(List<ICommand> executions,Movements command){

        switch (command)
            {
                case L:
                    executions.add(new LeftCommandImpl());
                    break;
                case R:
                    executions.add(new RightCommandImpl());
                    break;
                case M:
                    executions.add(new MoveCommandImpl());
                    break;
                default:
                    throw new IllegalStateException();
            }
    }

    public void makeMovements(Movements ... movements){
        List<ICommand> executions = new ArrayList<>();

        Arrays.asList(movements).forEach(mv -> {
            addExecutions(executions, mv);
        });

        executions.forEach(e -> mower.execute(e));
    }

    public LawnMower getMower() {
        return mower;
    }

    public void setMower(LawnMower mower) {
        this.mower = mower;
    }



}
