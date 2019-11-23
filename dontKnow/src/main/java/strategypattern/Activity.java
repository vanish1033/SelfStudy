package strategypattern;

/**
 * @author:whr 2019/11/2
 */
public class Activity {

    public Activity(int i) {
        this.strategy = StrategyFactory.getStrategy(i + "");
    }

    private Strategy strategy;

    public void do1(int i) {
        strategy.doStrategy(i);
    }

}
