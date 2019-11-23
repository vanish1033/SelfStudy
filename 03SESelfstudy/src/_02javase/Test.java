package _02javase;

/**
 * @author:whr 2019/7/25
 */
public class Test {
    public static volatile int inc = 0;

    public synchronized static void add() {

        Test.inc++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 128; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        add();
                    }
                }
            }.start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(inc);
    }
}

