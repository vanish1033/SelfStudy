package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class GoVideo implements Video {
    @Override
    public void makeVideo() {
        System.out.println("Go语言视频");
    }
}
