package strategypattern;

/**
 * @author:whr 2019/11/2
 */
public class Jian200Strategy implements Strategy {

    @Override
    public void doStrategy(int i) {
        System.out.println("减200策略   参数为:" + i);
    }
}
