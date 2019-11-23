package foreachMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author:whr 2019/7/13
 */

/**
 * 问：Java中遍历Map的几种方式。
 */
public class test4 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("123", "456");
        map.put("234", "567");
        map.put("231", "443");
        map.put("232", "537");
        map.put(null, "537");

/*        //用映射对象去遍历Map中的映射对象集合
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //获得并射出映射对象中的 key 和 value
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/
        //方法一 在for-each循环中使用entries来遍历
        System.out.println("----------方法一 在for-each循环中使用entry来遍历---------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }


        //方法二 在for-each循环中遍历keys或values
        System.out.println("----------方法二 在for-each循环中遍历keys或values。---------");
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }


        //方法三 遍历map中的值
        System.out.println("----------方法三 遍历map中的值---------");
        for (String value : map.values()) {
            System.out.println(value);
        }


        //方法四 方法三使用Iterator遍历
        System.out.println("----------方法四 方法三使用Iterator遍历---------");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
