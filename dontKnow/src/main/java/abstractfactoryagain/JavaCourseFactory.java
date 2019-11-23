package abstractfactoryagain;

/**
 * @author:whr 2019/9/10
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video makeVideo() {
        return new JavaVideo();
    }

    @Override
    public Atricle makeAtricle() {
        return new JavaAtricle();
    }
}
