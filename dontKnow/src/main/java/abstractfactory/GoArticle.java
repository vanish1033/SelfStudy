package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class GoArticle implements Article {
    @Override
    public void makeArticle() {
        System.out.println("Go语言手记");
    }
}
