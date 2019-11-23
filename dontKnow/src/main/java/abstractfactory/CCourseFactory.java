package abstractfactory;

/**
 * @author:whr 2019/9/10
 */
public class CCourseFactory extends CourseFactory {
    @Override
    Video getVideo() {
        return new CVideo();
    }

    @Override
    Article getArticle() {
        return new CArticle();
    }

}
