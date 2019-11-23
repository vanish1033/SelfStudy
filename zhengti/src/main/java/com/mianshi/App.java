package com.mianshi;

import lombok.Data;

import java.util.HashMap;

/**
 * Hello world!
 */
@Data
public class App {
    public static void main(String[] args) {
        method("a b c c", "f g g f r");
    }

    static String[] method(String a, String b) {
        String[] aArr = a.split(" ");
        String[] bArr = b.split(" ");
        HashMap<String, Integer> aMap = new HashMap<>();
        HashMap<String, Integer> bMap = new HashMap<>();
        for (String aa : aArr) {
            if (aMap.containsKey(aa)) {
                aMap.put(aa, aMap.get(aa) + 1);
                continue;
            }
            aMap.put(aa, 1);
        }
        for (String bb : bArr) {
            if (bMap.containsKey(bb)) {
                bMap.put(bb, bMap.get(bb) + 1);
                continue;
            }
            bMap.put(bb, 1);
        }
        System.out.println(aMap);
        System.out.println(bMap);
        return null;
    }

/*    public String[] uncommonFromSentences(String A, String B) {
        String[] stringsA = A.split(" ");
        //将所有单词记录一遍
        Set<String> stringSet = new HashSet<>();
        //记录重复的
        Set<String> replace = new HashSet<>();
        for (String a : stringsA) {
            if (!stringSet.add(a)) {
                replace.add(a);
            }
        }
        String[] stringsB = B.split(" ");
        for (String b : stringsB) {
            if (!stringSet.add(b)) {
                replace.add(b);
            }
        }
        //从一遍中删除掉重复的
        for (String rep : replace) {
            if (stringSet.contains(rep)) {
                stringSet.remove(rep);
            }
        }
        //赋值给string数组
        String[] result = new String[stringSet.size()];
        int[] index = {0};
        stringSet.forEach(s -> {
            result[index[0]] = s;
            index[0]++;
        });

        return result;
    }*/
}
