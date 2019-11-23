package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class PythonArticle implements Article {
    @Override
    public void makeArticle() {
        System.out.println("Python手记");
    }
}
