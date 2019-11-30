package dontKnow;

import com.alibaba.fastjson.JSON;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import myannotation.ProblemCode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author:whr 2019/9/8
 */
@Slf4j
public class Test {

    @org.junit.Test // 测试枚举单例
    public void test1() {

        Student student = new Student();

        Single intance1 = Single.getIntance();
        Single intance2 = Single.getIntance();
        Single intance3 = Single.getIntance();
        Single intance4 = Single.getIntance();

        System.out.println(intance1);
        System.out.println(intance2);
        System.out.println(intance3);
        System.out.println(intance4);
    }

    @org.junit.Test // 测试冒泡排序
    public void bubbleSort() {

        int[] arr = {4, 3, 6, 4, 2, 7, 5, 4, 5, 2, 6, 3, 4, 8, 3, 9, 0, 1};

        //外层循环控制趟数
        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                int arrj = arr[j];
//                int arrjj = arr[j + 1];
//                if (arrj > arrjj) {
//                    arr[j] = arrjj;
//                    arr[j + 1] = arrj;
//                }
//            }
            for (int j = arr.length - 1; j >= 1 + i; j--) {
                int arrj = arr[j];
                int arrjj = arr[j - 1];
                if (arrj > arrjj) {
                    arr[j] = arrjj;
                    arr[j - 1] = arrj;
                }
            }
        }
        Stream<Integer> boxed = Arrays.stream(arr).boxed();
        boxed.forEach(System.out::println);
//        System.out.println(arr);
//        IntStream stream = Arrays.stream(arr);
//        stream.forEach(System.out::print);
    }

    @org.junit.Test // 测试快速排序
    public void quicksort() {
        int[] arr = {4, 3, 6, 4, 2, 7, 5, 4, 5, 2, 6, 3, 4, 8, 3, 9, 0, 1};

        for (int i = 0; i < arr.length - 1; i++) {
            // 找出第n小的数
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int i1 = arr[i];
            arr[i] = arr[min];
            arr[min] = i1;

        }
        Arrays.stream(arr).forEach(System.out::print);

        //TODO
//        @ProblemCode("java.lang.ClassCastException: java.util.stream.IntPipeline$Head cannot be cast to java.util.stream.Stream")
//        Stream<String> stream = (Stream) Arrays.stream(arr);
//        List<String> collect = stream.collect(Collectors.toList());
//        Collections.reverse(collect);
//        IntStream stream1 = Arrays.stream(arr);
//        stream1.forEach(System.out::print);

    }

    /**
     * 测试冒泡排序和快速排序的时间差
     */
    @org.junit.Test
    public void test3() throws InterruptedException {

        Date date1 = new Date();
        for (int i = 0; i < 10000000; i++) {
            bubbleSort();
        }
        Date date2 = new Date();
        System.out.println("冒泡排序10000000遍" + (date2.getTime() - date1.getTime()) + "毫秒");

        date1 = new Date();
        for (int i = 0; i < 10000000; i++) {
            quicksort();
        }
        date2 = new Date();
        System.out.println("快速排序10000000遍" + (date2.getTime() - date1.getTime()) + "毫秒");

    }

    /**
     * 测试stack的OOM
     */
    @org.junit.Test
    public void test4() {

        System.out.println(123 ^ 231);
        System.out.println(231 ^ 123);
//
//        for (; ; ) {
//            Thread thread = new Thread(() -> {
//                while (true) {
//                }
//            });
//            thread.start();
//        }
    }

    /**
     * 跑了10分钟，最后：
     * java.lang.OutOfMemoryError: Java heap space
     * <p>
     * at java.lang.Integer.toString(Integer.java:403)
     * at java.lang.String.valueOf(String.java:3099)
     * at dontKnow.Test.test5
     */
    @org.junit.Test
    public void test5() {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; true; ) {
            list.add(String.valueOf(i++).intern());
        }
    }

    @org.junit.Test // 测试Unsafe使本地内存溢出
    public void test6() throws IllegalAccessException {

        Class<Unsafe> unsafeClass = Unsafe.class;
        Field unsafeField = unsafeClass.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        System.out.println(unsafe);
        while (true) {
            unsafe.allocateMemory(1024L);
        }
    }

    @org.junit.Test // 测试反射获取枚举单例
    public void test7() throws IllegalAccessException, InstantiationException {
        Class<Single> singleClass = Single.class;
        Single single1 = singleClass.newInstance();
        Single single2 = singleClass.newInstance();
        System.out.println(single1);
        System.out.println(single2);
    }

    @org.junit.Test // 测试反射获取Common类单例(构造方法私有化)
    public void test8() throws IllegalAccessException, InstantiationException {
        Class<Common> commonClass = Common.class;
        Common common = commonClass.newInstance(); // 私有构造反射不了
        System.out.println(common);
    }


    public static Common common;

    @org.junit.Test
    public void test9() {
        double y = 2.0d + 3 / 2;
        System.out.println(y);
        System.out.println(16 % 5);
        System.out.println(15 | 5);
        System.out.println(16 & 1);
        System.out.println(Byte.MAX_VALUE);
    }

    @org.junit.Test
    public void test10() throws IOException {
        File file = new File("D:\\动力节点夜校\\阶段5,6-框架和分布式");
        File[] files = file.listFiles();
        get(file);
    }

    private void get(File file) throws IOException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                get(file1);
            }
            if (file1.getName().endsWith(".xmind")) {
                fileInputStream = new FileInputStream(file1);
                String s = "H:\\新建文件夹\\" + file1.getName();
                boolean newFile = new File(s).createNewFile();
                fileOutputStream = new FileOutputStream(s);
                byte[] b = new byte[1024];
                int read = 0;
                read = fileInputStream.read(b);

                while (read != -1) {
                    fileOutputStream.write(b, 0, read);
                    read = fileInputStream.read(b);
                }
                fileOutputStream.flush();
            }
        }
    }

    @org.junit.Test
    public void test11() {
        Student student = new Student();
        student.setName("mike");
        student.setAge(15);
        System.out.println(JSON.toJSONString(student));
    }

    @org.junit.Test
    @ProblemCode("找不到路径错误，不知道怎么改，就是找不到路径")
    public void test12() {
        String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        System.out.println(classpath);

        String path = "test.properties";
//        System.out.println(path);
        ResourceBundle bundle = ResourceBundle.getBundle(classpath + path);
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String s = keys.nextElement();
            String string = bundle.getString(s);
            System.out.println(string);
            System.out.println(string);
        }
    }

    @org.junit.Test
    public void test13() {
        int[] ints = {1, 2, 3, 4};
        int[] ints1 = {1, 2, 3, 4};
        System.out.println("ints.equals(ints1) = " + ints.equals(ints1));
    }

//    @org.junit.Test
//    public void tes13() throws CloneNotSupportedException {
//
//        Student student = new Student();
//
//        Student clone = (Student) student.clone();
//
//        System.out.println(student == clone);
//
//    }

    @org.junit.Test
    public void test14() {
        System.out.println("new File(\"/testUpLoad\") = " + new File("/testUpLoad").getAbsolutePath());
    }

    @org.junit.Test
    public void testXX() throws IOException {
        File file = new File("D:\\test");
        File[] files = file.listFiles();
        get1(file);
    }

    private void get1(File file) throws IOException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                get1(file1);
            }
            if (file1.getName().endsWith(".txt")) {
                fileInputStream = new FileInputStream(file1);
                String s = "D:\\test2\\" + file1.getName();
                System.out.println(s);
                boolean newFile = new File(s).createNewFile();
                fileOutputStream = new FileOutputStream(s);
                byte[] b = new byte[1024];
                int read = 0;
                read = fileInputStream.read(b);

                while (read != -1) {
                    fileOutputStream.write(b, 0, read);
                    read = fileInputStream.read(b);
                }
                fileOutputStream.flush();
            }
        }
    }

    @org.junit.Test
    public void test15() throws DocumentException {

        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><bookstore><book><title lang=\"eng\">Harry Potter</title><price>29.99</price></book><book><title lang=\"eng\">Learning XML</title><price>39.95</price></book></bookstore>";

        Document document = DocumentHelper.parseText(xml);

        Node node = document.selectSingleNode("bookstore/book[price > 29]/price");

        System.out.println(node.getText());

    }

    @org.junit.Test
    public void test16() throws ParseException {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2008-12-26"));
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()));
    }

    /**
     * 测试二维码生成
     *
     * @throws WriterException
     * @throws IOException
     */
    @org.junit.Test
    public void test17() throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String text = "https://jingyan.baidu.com/user/npublic?uid=38b532076b0890c3008fd572092099f1a2123885";

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 300, 300);

        Path path = FileSystems.getDefault().getPath("D:\\测试二维码生成\\j.png");

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    /**
     * 有n个人围成一圈,顺序排号,从第一个人开始报数,凡报到3的人退出圈子,问最后留下的是原来第几号的那位？
     */
    @org.junit.Test
    public void test18() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 3231; i++) {
            integers.add(i);
        }
//        System.out.println(6 % 3);

        ArrayList<Integer> nums = new ArrayList<>();

        int num = 0;
        while (integers.size() >= 2) {
            for (int i = 0; i < integers.size(); i++) {
                num = num + 1;
//                System.out.println(num);
                if (num % 3 == 0) {
                    nums.add(i);
                }
            }
            for (int n : nums) {
                integers.set(n, -1);
            }
            Iterator<Integer> iterator = integers.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == -1) {
                    iterator.remove();
                }
            }
            System.out.println("integers = " + integers);
            nums.clear();
        }
        System.out.println(integers);
    }


    /**
     * 判断各种括号是否匹配
     */
    @org.junit.Test
    public void test19() {
        String str = "(){}[(){}[]]{{}(){}[]}[()[{}]{}]{}{}()";
        char[] chars = str.toCharArray();
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                characters.push(aChar);
            } else if (aChar == ')') {
                if (characters.peek() != '(') break;
                characters.pop();
            } else if (aChar == ']') {
                if (characters.peek() != '[') break;
                characters.pop();
            } else if (aChar == '}') {
                if (characters.peek() != '{') break;
                characters.pop();
            }
        }
        if (characters.isEmpty()) {
            log.info("括号匹配");
            return;
        }
        log.info("括号不匹配");

    }

    /**
     * 判断简单单词，简单单词就是在两个String中总共就出现一次的单词
     */
    @org.junit.Test
    public void test20() {
        String a = "a b c s d m";
        String b = "a d t q m";
        String c = a + " " + b;
        String[] s = c.split(" ");


        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], 1);
                continue;
            }
            map.put(s[i], map.get(s[i]) + 1);
        }
        System.out.println(map);

    }

    /**
     * 输出给定的非负整数n以内的质数数量
     */
    @org.junit.Test
    public void test21() {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("我爱你");
//        System.out.print("请输入一个非负整数：");
//        int n = new Scanner(System.in).nextInt();

        // 非负整数n
        int n = 1000;
        int num = 0;

        for (int i = 0; i <= n; i++) {
            if (test22(i)) {
                System.out.print(i + "  ");
                num++;
            }
        }
        System.out.println(num);

    }

    /**
     * 判断一个数是不是质数
     */
    public boolean test22(int x) {

        if (x == 0 || x == 1) {
            return false;
        }

        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    @org.junit.Test
    public void test23() {
//        n%a == n & (a-1)  前提是a为2幂次方如: 4 , 8 , 16 , 32 , 64 。。。。。。。
        System.out.println(124431 % 32);
        System.out.println(124431 & (32 - 1));
    }

    @org.junit.Test
    public void test24() {
        int[] arr = {1, 2, 3, 34, 4, 2, 4, 7, 5, 6, 7, 2, 9, 0, 1, 6, 19};
        if (arr.length < 3) {
            System.out.println("数组的长度不能小于3");
        }
        int sum = 0;
        int num = 0;

        for (int i = 0; i < 3; i++) {
            int max = arr[0];

            for (int j = 0; j < arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    num = j;
                }
            }
            arr[num] = 0;
            sum += max;

        }
        System.out.println(sum);
    }

    @org.junit.Test
    public void test25() {
        String s1 = "12";
        String s2 = s1;
        System.out.println(s1 == s2);
        System.out.println("s1==s2 = " + (s1 == s2));
    }

    @org.junit.Test
    public void test26() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect = stream.collect(Collectors.toList());

        Iterator<Integer> iterator = collect.iterator();

        if (iterator.hasNext()) {
            collect.set(1, 3);
        }
        System.out.println(collect);
    }

    /**
     * LocalDataTime
     */
    @org.junit.Test
    public void test27() {
        LocalDateTime parse = LocalDateTime.parse("1997-12-26 12:12:34", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);
        String yyyyMMdd = parse.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(yyyyMMdd);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse1 = LocalDateTime.parse("1997-12-26 12:12:34", formatter);
        System.out.println("parse1.format(formatter) = " + parse1.format(formatter));
    }

    /**
     * Stream测试
     */
    @org.junit.Test
    public void test28() {

        // 数值流转对象流
        Stream<Integer> boxed = Arrays.stream(new int[]{1, 2, 3, 4, 5}).boxed();
        List<Integer> collect = boxed.collect(Collectors.toList());
        System.out.println("collect = " + collect);

        // 对象流转数值流
//        IntStream intStream = boxed.mapToInt(x -> x.intValue());

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        stream.filter((x) -> x > 4).forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).limit(4).forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).skip(4).forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .sorted((o1, o2) -> o2 - o1)
                .limit(4)
                .map(x -> x + 6)
                .collect(Collectors.toList())
                .forEach(System.out::print);

    }


    @org.junit.Test
    public void test29() {
        Random ra = new Random();
        HashSet<Integer> objects = new HashSet<>();

        while (true) {
            int i = ra.nextInt(100);
            objects.add(i);
            if (objects.size() == 20) {
                break;
            }
        }
        Stream<Integer> stream = objects.stream();
        List<Integer> collect = stream.sorted(Integer::compareTo).collect(Collectors.toList());
    }

    @org.junit.Test
    public void test30() {
        HashMap<Object, Object> map = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }

    @org.junit.Test
    public void test31() {

        HashMap<Object, Object> map = new HashMap<>();

        Set<Object> objects = map.keySet();
        for (Object o : objects) {
            System.out.println(o);
            System.out.println(map.get(o));
        }
    }

    @org.junit.Test
    public void test32() {
        System.out.println("hello" instanceof Object);
    }

    @org.junit.Test
    public void test33() {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        List<Student> collect = students.stream()
                .filter(s -> "浙江".equals(s.getAddress()))
                .collect(Collectors.toList());

        System.out.println(collect);

//        BiFunction<Long, String, Student> studentSupplier = Student::new;
//        Student student = studentSupplier.apply(1L, "汪弘睿");
//        System.out.println(student);

        List<String> collect1 = students.stream().map(s -> "地址：" + s.getAddress()).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }

    @org.junit.Test
    public void test34() {
//        log.info("我{}", "21");

        Integer[] ints = new Integer[10];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = 1;
        }

        Stream<Integer> intStream = Arrays.stream(ints);
        intStream.distinct().map(x -> x + 4).forEach(System.out::print);

        List<Integer> ints1 = Arrays.asList(ints);

    }

    @org.junit.Test
    public void test35() {
        // 指定随机数种子
        Random random = new Random(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100));
        }

        // 默认以当前时间作为随机数种子
        Random random1 = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random1.nextInt(100));
        }
    }

    /**
     * 判断各种括号是否匹配
     */
    @org.junit.Test
    public void test36() {

        String str = "(){}[(){}[]]{{}(){}[]}[()[{}]{}]{}{}()";
        char[] chars = str.toCharArray();
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                characters.push(aChar);
            } else if (aChar == ')') {
                if (characters.peek() != '(') break;
                characters.pop();
            } else if (aChar == ']') {
                if (characters.peek() != '[') break;
                characters.pop();
            } else if (aChar == '}') {
                if (characters.peek() != '{') break;
                characters.pop();
            }
        }
        if (characters.isEmpty()) {
            log.info("括号匹配");
            return;
        }
        log.info("括号不匹配");

    }

}
