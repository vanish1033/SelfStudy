package juc;

import java.util.concurrent.*;

/**
 * @author:whr 2019/10/23
 */
public class testCountDownLatch {

    private static final CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7,
                15,
                10L,
                TimeUnit.MICROSECONDS,
                new SynchronousQueue<>());

        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);

            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        test1();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
    }

    private static void test1() throws InterruptedException {
        Thread.sleep(1);

        System.out.println(Thread.currentThread().getName());
    }

}
