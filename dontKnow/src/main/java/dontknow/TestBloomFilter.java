package dontknow;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * guava  BloomFilter
 *
 * @author:whr 2019/10/26
 */
public class TestBloomFilter {

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.001);

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };
        thread.start();
        thread.join();

        for (int i = 0; i < 10000000; i++) {
            bloomFilter.put(i);
        }
        int size = 0;
        for (int i = 10000000; i < 20000000; i++) {
            if (bloomFilter.mightContain(i)) {
                size++;
                System.out.println(i + "误判了");
            }
        }
        System.out.println("总共有" + size + "条数据误判了");
    }
}
