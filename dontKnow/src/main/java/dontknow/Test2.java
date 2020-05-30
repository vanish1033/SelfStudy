package dontknow;

/**
 * @author:whr 2019/11/14
 */
public class Test2 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    System.out.println(System.currentTimeMillis());
                }
            }
        };
        // 设置为守护线程
        thread.setDaemon(true);
        thread.start();
        System.out.println("main线程退出");
    }

}
