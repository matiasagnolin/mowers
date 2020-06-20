package org.seatcode.domain;

import java.util.concurrent.Semaphore;

public class Ground {
    private final int [][] ground;
    private final Semaphore _semaphore = new Semaphore(1);


    public Ground(int x, int y) {
        ground = new int [x][y];
    }
    public boolean cellValidation(int x, int y){
        return (x >= 0 && y >= 0);
    }

    public boolean lengthValidation(int x, int y){
        return (x >= 0 && x < ground.length) && (y >= 0 && y < ground[0].length);
    }

    /**
     * Try to acquire a permit to execute on this {@link Ground}, blocking until it is available, or the threas is interrupted.
     * Acquires a permit, if there isn't another object running on this ground and returns immediately, reducing the number of available permits by one.
     *
     * @return the same instance
     * @throws InterruptedException
     */
    public Ground acquire() throws InterruptedException
    {
        _semaphore.acquire();
        return this;
    }

    /**
     * Releases a permit, allowing other lawn mower to move on the ground.
     * @return the same instance.
     */
    public Ground release()
    {
        _semaphore.release();
        return this;
    }
}
