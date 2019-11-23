package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class PythonVideo implements Video {
    @Override
    public void makeVideo() {
        System.out.println("Python视频");
    }
}
