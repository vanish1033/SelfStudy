package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class GoCourseFactory extends CourseFactory {
    @Override
    Video getVideo() {
        return new GoVideo();
    }

    @Override
    Article getArticle() {
        return new GoArticle();
    }
}
