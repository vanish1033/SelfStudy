package dontKnow;

/**
 * @author:whr 2019/11/13
 */
public class Test111 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (Object.class) {
                    for (int i = 0; i < 9; i++) {
                        System.out.println(i);
                        try {
//                            Object.class.notify();
                            Object.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (Object.class) {
                    for (int i = 56; i < 66; i++) {
                        System.out.println((char) ('0' + i));
                        try {
//                            Object.class.notify();
                            Object.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };
        thread.start();
        thread1.start();

    }

}
