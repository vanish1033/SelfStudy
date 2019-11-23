package multithreadedreordering;

/**
 * @author:whr 2019/7/22
 */
public class Thread1 extends Thread {
    @Override
    public void run() {
        Test.flag = true;
        Test.num = 2;
    }
}
