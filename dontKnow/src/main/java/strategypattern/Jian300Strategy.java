package strategypattern;

/**
 * @author:whr 2019/11/2
 */
public class Jian300Strategy implements Strategy {
    @Override
    public void doStrategy(int i) {
        System.out.println("减300策略   参数为:" + i);
    }
}
