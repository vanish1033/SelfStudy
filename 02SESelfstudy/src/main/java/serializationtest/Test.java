package serializationtest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author:whr 2019/7/14
 */
public class Test {
    public static void main(String[] args) {

        Student ms = new Student("苗大森", 45);
        Student gjn = new Student("高俊楠", 22);
        Student wy = new Student("王钺", 19);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d://a.txt"))){
            objectOutputStream.writeObject(ms);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
