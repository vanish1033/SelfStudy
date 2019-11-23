package abstractfactoryagain;

/**
 * @author:whr 2019/9/10
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video makeVideo() {
        return new PythonVideo();
    }

    @Override
    public Atricle makeAtricle() {
        return new PythonAtricle();
    }
}
