package simplefactory;

/**
 * @author:whr 2019/7/24
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory.Paly(JavaCoures.class);
        CourseFactory.Paly(PythonCourse.class);
    }
}
