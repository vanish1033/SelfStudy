package Thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author:whr 2019/8/22
 */
public class test {

    public static AtomicBoolean isHappend = new AtomicBoolean(false);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                new Thread() {
                    @Override
                    public void run() {
                        if (isHappend.compareAndSet(false, true)) { //其中代码只会执行一次
                            System.out.println(Thread.currentThread().getName() + "修改成功" + isHappend.get());
                        }
                    }
                }.start();
            }

            while (Thread.activeCount() > 2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (isHappend.compareAndSet(true, false)) {
                System.out.println(Thread.currentThread().getName() + "修改成功" + isHappend.get());
            }
        }
//        for (int i = 0; i < 1000; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    if (isHappend.compareAndSet(false, true)) {
//                        System.out.println(Thread.currentThread().getName() + "修改成功");
//                    }
//                }
//            }.start();
//        }
//        while (Thread.activeCount() > 2) {
//
//        }
//        System.out.println(a);
    }


}
