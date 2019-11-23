package serializationtest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 反序列化
 *
 * @author:whr 2019/7/14
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        //反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d://a.txt"));
        Student stu = (Student) objectInputStream.readObject();
        System.out.println(stu.getSerialVersionUID());
    }
}
