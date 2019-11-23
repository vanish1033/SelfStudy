package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author:whr 2019/10/23
 */
public class testCyclicBarrier {

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            Thread.sleep(800);

            new Thread() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await(10000L, TimeUnit.MILLISECONDS);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }

}
