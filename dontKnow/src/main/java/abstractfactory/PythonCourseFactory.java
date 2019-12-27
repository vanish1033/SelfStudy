package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class PythonCourseFactory extends CourseFactory {

    @Override
    Video getVideo() {
        return new PythonVideo();
    }

    @Override
    Article getArticle() {
        return new PythonArticle();
    }
}
