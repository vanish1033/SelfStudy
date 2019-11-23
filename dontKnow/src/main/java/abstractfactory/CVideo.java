package abstractfactory;

/**
 * @author:whr 2019/9/10
 */
public class CVideo implements Video {

    @Override
    public void makeVideo() {
        System.out.println("C语言Video");
    }
}
