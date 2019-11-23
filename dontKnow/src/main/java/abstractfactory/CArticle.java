package abstractfactory;

/**
 * @author:whr 2019/9/10
 */
public class CArticle implements Article {
    @Override
    public void makeArticle() {
        System.out.println("C语言Article");
    }
}
