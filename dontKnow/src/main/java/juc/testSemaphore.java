package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:whr 2019/10/23
 */
public class testSemaphore {

    private static final Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7,
                15,
                10L,
                TimeUnit.MICROSECONDS,
                new SynchronousQueue<>());

        for (int i = 0; i < 100; i++) {
//            Thread.sleep(10);
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        getPrintln();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }

                }
            });
        }

//        threadPoolExecutor.shutdown();
    }

    private static void getPrintln() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
    }

}
