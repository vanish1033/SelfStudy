package strategypattern;

import org.junit.Test;

/**
 * @author:whr 2019/11/2
 */
public class TestStrategy {

    @Test
    public void test() {
        Activity activity = new Activity(2000);
        activity.do1(2_000);
    }

}
