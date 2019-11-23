package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class JavaArticle implements Article {
    @Override
    public void makeArticle() {
        System.out.println("Java手记");
    }
}
