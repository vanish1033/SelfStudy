package break_countine;

/**
 * @author:whr 2019/8/11
 */
public class A {
    public static void main(String[] args) {
        out:
        for (int i = 0; i < 10; i++) {
            in:
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " " + j);
                if (j == 5) {
                    break out;
                }
            }
        }
    }
}
