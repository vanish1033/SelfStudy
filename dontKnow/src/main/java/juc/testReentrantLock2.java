package juc;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author:whr 2019/10/24
 */
public class testReentrantLock2 {

    private static volatile int i = 0;
    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(
            5,
            15,
            10, TimeUnit.MICROSECONDS,
            new LinkedBlockingQueue(100));
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    @Test
    public void test1() throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        if (i == 0) {
                            i++;
                            System.out.println("i++");
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        if (i == 1) {
                            i--;
                            System.out.println("i--");

                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }.start();
        Thread.sleep(10000000L);
    }

    /**
     * 不同的线程不适用锁降级
     *
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {

        new Thread() {
            @Override
            public void run() {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println("writeLock");
                try {
                    Thread.sleep(100000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                reentrantReadWriteLock.readLock().lock();
                System.out.println("get read lock");
                try {
                    Thread.sleep(10000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Thread.sleep(100000000000L);

    }

    /**
     * 锁降级
     */
    @Test
    public void test3() {
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("writeLock");

        reentrantReadWriteLock.readLock().lock();
        System.out.println("readLock");

        // 获取到读锁后在释放写锁，防止一释放写锁，写锁就被其他线程抢了，这样就拿不到读锁了
        reentrantReadWriteLock.writeLock().unlock();
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        FutureTask<Integer> command = new FutureTask<>(() -> 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 / 0);

        Future<Integer> submit = pool.submit(() -> 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13);
        Integer integer = submit.get();
        System.out.println("integer = " + integer);

// ======================实现callable的线程创建方法======================
        Callable<Integer> integerCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1 + 2;
            }
        };
        FutureTask<Integer> integerFutureTask = new FutureTask<>(integerCallable);

        Thread thread = new Thread(integerFutureTask);

        thread.start();

        System.out.println("integerFutureTask.get() = " + integerFutureTask.get());
// ======================实现callable的线程创建方法======================

//        pool.execute(command);
//        Integer reslut = command.get();
//        System.out.println("reslut = " + reslut);
    }

}
