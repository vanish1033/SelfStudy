package strategypattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:whr 2019/11/2
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategyMap = new HashMap();

    static {
        strategyMap.put("1000", new Jian100Strategy());
        strategyMap.put("2000", new Jian200Strategy());
        strategyMap.put("3000", new Jian300Strategy());
    }

    private StrategyFactory() {
    }

    public static Strategy getStrategy(String i) {
        return strategyMap.get(i);
    }


}
