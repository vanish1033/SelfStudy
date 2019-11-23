import java.util.Date;

/**
 * @author:whr 2019/7/18
 */
public class Test {
    public static void main(String[] args) {
        //创建乘法表优化
        long[][] table = new long[10][20];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (long) Math.pow(i, j);
            }
        }

        long num = 0;
        while (num <= Long.MAX_VALUE) {
            // 把输入的数字转为String类型
            String snum = num + "";
            // 再把String类型转为char数组
            char[] cnumArr = snum.toCharArray();
            //存储和的变量
            int sum = 0;
            // 遍历数组计算各位的位数幂次和
            for (char c : cnumArr) {
                int inum = Integer.parseInt(String.valueOf(c));
                sum += table[inum][snum.length()]; //Math.pow(inum, snum.length());
            }
            // 判断是否和原值相等
            if (sum == num)
                System.out.println(num + "是水仙花数   " + new Date());
            if (num == 912985153) {
                num = 4679307770l;
            }
            num++;
        }
    }
}
