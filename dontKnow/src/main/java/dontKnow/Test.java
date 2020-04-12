package dontKnow;

import com.alibaba.fastjson.JSON;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import myannotation.ProblemCode;
import org.apache.commons.lang3.StringUtils;
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
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    /**
     * 测试Integer的缓存机制
     */
    @org.junit.Test
    public void test37() {
        Integer integer = new Integer(2);
        Integer integer1 = new Integer(2);

        Integer integer2 = 3;
        Integer integer3 = 3;

        Integer integer4 = 128;
        Integer integer5 = 128;

        System.out.println(integer == integer1); // false 虽然Integer底层有缓存机制，但是手动new利用不了缓存
        System.out.println(integer2 == integer3); // true 能利用到缓存
        System.out.println("integer4==integer5 = " + (integer4 == integer5)); // false 超出缓存的范围了
    }

    /**
     * 打印九九乘法表 | 99乘法表
     */
    @org.junit.Test
    public void test38() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " x " + i + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * 反过来打印九九乘法表 | 99乘法表
     */
    @org.junit.Test
    public void test39() {
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " x " + i + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void test40() {
        String str = "";
        System.out.println("StringUtils.isEmpty(str) = " + StringUtils.isEmpty(str));
//
//        Single intance = Single.getIntance();
//        Single intance1 = Single.getIntance();
//        System.out.println("intance==intance1 = " + (intance == intance1));
    }

    @org.junit.Test
    public void test41() {
        System.out.println(new A().method1(1, 1));
    }

    /**
     * 测试 BigDecimal 和 Math 类的ceil(向上取整), floor(向下取整), round(四舍五入, 原理是 +0.5 再向下取整)
     */
    @org.junit.Test
    public void test42() {
        BigDecimal bigDecimal = new BigDecimal("4.99");
        BigDecimal add = bigDecimal.add(new BigDecimal("1.01"));
        System.out.println(add);

        System.out.println(Math.ceil(1.1));
        System.out.println(Math.floor(1.9));
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(1.4));
        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(-1.6));

    }

    @org.junit.Test
    public void test43() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusYears(1L);
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);
    }

    @org.junit.Test
    public void test44() {
        String str = "201912080940247370240001012s1,201912080926130270240001012s2,201912080928532070240001012s3,201912080928427070240001012s4,201912080909161670240001012s5,201912080828213370240001012s6,201912081106210970240001012s7,201912081109171070240001012s8,201912081104425770240001012s9,201912081113195470240001012s10,201912081103370670240001012s11,201912081114234470240001012s12,201912080912132570240001012s13,201912081104104770240001012s14,201912081108387570240001012s15,201912081111234270240001012s16,201912081109114870240001012s17,201912081112222270240001012s18,201912081109269570240001012s19,201912081105147570240001012s20,201912081108079070240001012s21,201912081053355970240001012s22,201912081111014970240001012s23,201912081110430870240001012s24,201912081109598370240001012s25,201912081105466870240001012s26,201912081113014270240001012s27,201912081105254270240001012s28,201912080910014470240001012s29,201912080903450770240001012s30,201912080937539770240001012s31,201912080852391170240001012s32,201912081113459770240001012s33,201912080941341670240001012s34,201912080857082470240001012s35,201912080925383070240001012s36,201912080904235170240001012s37,201912080904399070240001012s38,201912080926346270240001012s39,201912080930071370240001012s40,201912080833375670240001012s41,201912080905149370240001012s42,201912080904319370240001012s43,201912080836370270240001012s44,201912080855578770240001012s45,201912080835352870240001012s46,201912081116222970240001012s47,201912080925343970240001012s48,201912081119082070240001012s49,201912080941397670240001012s50,201912080930239070240001012s51,201912080904157370240001012s52,201912080853007970240001012s53,201912080941294170240001012s54,201912080940195170240001012s55,201912081118315970240001012s56,201912080936479570240001012s57,201912080936365170240001012s58,201912080927388170240001012s59,201912080937452970240001012s60,201912080848308270240001012s61,201912080929181970240001012s62,201912080853233470240001012s63,201912080940152670240001012s64,201912080940297570240001012s65,201912080940347170240001012s66,201912080913268970240001012s67,201912080927005070240001012s68,201912081116450270240001012s69,201912080938359170240001012s70,201912080942138670240001012s71,201912080854261270240001012s72,201912080910587770240001012s73,201912080836229570240001012s74,201912081117243170240001012s75,201912080924090470240001012s107,201912080853387570240001012s108,201912081005586870240001012s109,201912081025319670240001012s110,201912080909125870240001012s111,201912081044316270240001012s112,201912080843351270240001012s113,201912080807155670240001012s114,201912080842552770240001012s115,201912080846331170240001012s116,201912080844020570240001012s117,201912080840329870240001012s118,201912080845532270240001012s119,201912081007238270240001012s120,201912081041022170240001012s121,202001061306937126148001018s76,201912313521507826148013018s77,202001061836514126148001018s78,201912312820694626148013018s79,202001063630303026148001018s80,202001062271605526148001018s81,202001062578642526148001018s82,202001062347858526148001018s83,201912310963659926148013018s84,202001062750050526148001018s85,202001060056839526148001018s86,202001060709280526148001018s87,202001062334467526148001018s88,201912310107590526148013018s89,202001060296468526148001018s90,202001061842086026148001018s91,202001061676745726148001018s92,202001060029854026148001018s93,202001062717232526148001018s94,201912311165391426148013018s95,202001060518003526148001018s96,202001061501627026148001018s97,201912313315644126148013018s98,202001060486320626148001018s99,202001062052849826148001018s100,201912313350038526148013018s101,202001060239171026148001018s102,202001060967641626148001018s103,202001062097537226148001018s104,202001062445060426148001018s105,202001060298672926148001018s106,202001063548403126148001018s122,202001061777611626148001018s123,201912302697907326148012018s124,201912302109229126148012018s125,201912310170127226148013018s126,201912301523122926148012018s127,201912311010085026148013018s128,201912311042950326148013018s129,201912300741664826148012018s130,201912302160247526148012018s131,201912312719571426148013018s132,202001061049855526148001018s133,202001060236085426148001018s134,201912310176167326148013018s135,202001062838951326148001018s136,202001060959434226148001018s137,202001061741010826148001018s138,202001062045330926148001018s139,201912310098488426148013018s140,202001061707389226148001018s141,202001062189242426148001018s142,202001061664592726148001018s143,202001061099899026148001018s144,201912311365864026148013018s145,202001062017969226148001018s146,202001060300011326148001018s147,202001062587216826148001018s148,202001063687866626148001018s149,201912313399762726148013018s150,201912312827847826148013018s151,202001063873011926148001018s152,202001063772718726148001018s153,201912313398121626148013018s154,202001063098083126148001018s155,201912310023470426148013018s156";
        String newStr = "";
        String regex = ",";
        String[] split = str.split(regex);
        System.out.println(split);
        for (String s : split) {
            String[] s1 = s.split("s");
            System.out.println(s1[0]);
            newStr += s1[0] + ",";
        }
        System.out.println(newStr);
    }

    @org.junit.Test
    public void test45() {
        BigDecimal bigDecimal = new BigDecimal("12312312.23");
        String s = bigDecimal.toPlainString();
        double v = Double.parseDouble(s);
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        System.out.println(decimalFormat.format(bigDecimal));
    }

    @org.junit.Test
    public void test46() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("34");
        objects.add("141");

        ArrayList<Object> objects1 = new ArrayList<>();
        objects1.add("1");
        objects1.add("2");
        objects1.add("34");
        objects1.add("141");

        System.out.println(objects.removeAll(objects1));


        System.out.println(objects);
    }

    @org.junit.Test
    public void test47() {
        Function<String, String> f1 = i -> i + "执行f1";
        Function<String, String> f2 = i -> i + "执行f2";

        System.out.println("f1.apply(2) = " + f1.apply("2"));
        System.out.println("f1.apply(3) = " + f1.apply("3"));

        System.out.println("f1.compose(f2).apply(\"3\") = " + f1.compose(f2).apply("3"));
        System.out.println("f1.andThen(f2).apply(\"3\") = " + f1.andThen(f2).apply("3"));

        /**
         * TreeMap可以通过传入外置比较器来定义比较大小的规则
         */
        TreeMap<String, Object> objectObjectTreeMap = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 1;
            }
        });
    }


    /**
     * 练习Stream流的用法
     */
    @org.junit.Test
    public void test48() {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "wkcto", "good", "hello", "jj", "xx", "jj", "jj", "bjpowernode", "xx", "good");
        //1)通过List集合获得Stream流
        Stream<String> stream = list.stream();

        //2流的中间操作
        //2.1 流的筛选与切片
        //distinct()去掉重复的数据
        stream.distinct().forEach(System.out::println);
        System.out.println("-----------------------");

        //filter()过滤
//        stream.filter(x->x.length() > 4).forEach(System.out::println);  //java.lang.IllegalStateException: 流已关闭, 流只能使用一次
        list.stream().filter(x -> x.length() > 4).forEach(System.out::println);
        System.out.println("-----------------------");

        //sort()排序
        list.stream().sorted(String::compareTo).forEach(System.out::println);
        System.out.println("-----------------------");

        //limt()截断操作
        list.stream().limit(5).forEach(System.out::println);
        System.out.println("-----------------------");

        //skip()跳过
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("-----------------------");

        //2.2 map映射
        //map映射转换元素, map方法接受一个函数, 把这个函数应用于每个元素上,并将它映射为一个新的元素
        list.stream()
                .map(String::toUpperCase)   //为每个元素应用toUpperCase()把小写转换为大写
                .forEach(System.out::println);
        System.out.println("-----------------------");

        list.stream()
                .map(String::length)
                .map(len -> len + "  ")
                .forEach(System.out::print);
        System.out.println();
        System.out.println("-----------------------");

        //转换为数值流
        List<Integer> integerList = Arrays.asList(54, 1, 78, 90, 345);
        IntStream intStream = integerList.stream().mapToInt(x -> x);
        intStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("-----------------------");

        //2.3 匹配与查找操作
        //allMatch()判断流中所有的元素是否都匹配给定的谓词
        System.out.println(list.stream().allMatch(s -> s.length() > 3));     //false
        //anyMatch()判断流中是否有某个元素可以匹配指定的谓词
        System.out.println(list.stream().anyMatch(s -> s.equals("wkcto")));    //true
        //noneMathc()判断流中的元素是否都没有匹配指定谓词的
        System.out.println(list.stream().noneMatch(s -> s.equals("jj")));      //false

        //查找
        System.out.println(list.stream().filter(s -> s.length() > 10).findAny().get());
        System.out.println(list.stream().filter(s -> s.length() > 20).findFirst().orElse("不存在"));

        //3 Stream流的终端操作
        //3.1 forEach遍历
        list.stream().forEach(System.out::println);

        //3.2 cout统计
        System.out.println(list.stream().filter(x -> x.length() > 2).count());

        //3.3 reduce归纳合并
        Optional<String> reduce = list.stream().reduce((s1, s2) -> s1 + "--" + s2);

        /**
         * https://segmentfault.com/q/1010000004944450 reduce三个参数方法的解释
         */
        String[] reduce1 = list.stream().reduce(new String[100], (x, y) -> {
            ArrayList<String> strings1 = new ArrayList<>();
            Collections.addAll(strings1, x);
            strings1.add(y);
            return strings1.toArray(new String[100]);
        }, (x, y) -> {
            ArrayList<String> c = new ArrayList<>();
            Collections.addAll(c, x);
            Collections.addAll(c, y);
            return c.toArray(new String[100]);
        });


        System.out.println(reduce1);
        reduce.ifPresent(System.out::println);

        //数值操作
        List<Integer> list2 = Arrays.asList(6, 21, 87, 34, 1, 78, 54);
        //求和,指定初始值
        System.out.println(list2.stream().reduce(0, Integer::sum));
        //求和,没有初始值
        System.out.println(list2.stream().reduce((x, y) -> x + y).orElse(0));
        //最值
        System.out.println(list2.stream().reduce(Math::max).get());
        System.out.println(list2.stream().reduce(Math::min).get());

        //3.4 映射到数值流
        System.out.println(list2.stream().mapToInt(x -> x).sum());       //求和
        System.out.println(list2.stream().mapToInt(x -> x).max().getAsInt());    //最大值
        System.out.println(list2.stream().mapToInt(x -> x).min().orElse(0));     //最小值
        System.out.println(list2.stream().mapToDouble(x -> x).average().getAsDouble());   //平均值
        System.out.println(list2.stream().max(Integer::compareTo).get());
        list2.stream().min(Integer::compareTo).ifPresent(System.out::println);

        /**
         * 3.5 collect归约
         * https://www.jianshu.com/p/ccbb42ad9551 -> Stream类的collect方法详解
         */
        //把stream流转换为集合
        Set<String> stringSet = list.stream().collect(Collectors.toSet());
        System.out.println(stringSet);

        //把Stream流转换为数组
        Object[] objects = list.stream().toArray();
        System.out.println(Arrays.toString(objects));
        String[] toArray = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(toArray));

        //Stream流转换为字符串
        String collect = list.stream().collect(Collectors.joining(","));
        List<String> collect1 = list.stream().collect(Collectors.toList());
        System.out.println(collect);


    }

}


class DemoFunctionApply {

    public static void main(String[] args) {
        method(Integer::parseInt);
    }

    private static void method(Function<String, Integer> function) {
        int num = function.apply("10");
        System.out.println(num + 20);
    }
}