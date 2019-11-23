package multithreadedreordering;

/**
 * @author:whr 2019/7/22
 */
public class Thread2 extends Thread {
    @Override
    public void run() {
        if (Test.flag) {
            System.out.println(Test.num * 4);
        }
    }
}
