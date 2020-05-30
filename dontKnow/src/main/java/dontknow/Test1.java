package dontknow;

import java.util.Scanner;

/**
 * @author:whr 2019/11/5
 */
public class Test1 {
    public static void main(String[] args) {

        try {
            new Thread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String test = new Scanner(System.in).nextLine();
        String[] arr = test.split(" ");
        String a = arr[0];
        System.out.println(a.length());
    }
}
