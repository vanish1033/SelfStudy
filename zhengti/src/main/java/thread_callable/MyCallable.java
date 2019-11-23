package thread_callable;


import java.util.concurrent.Callable;

/**
 * @author:whr 2019/8/11
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
