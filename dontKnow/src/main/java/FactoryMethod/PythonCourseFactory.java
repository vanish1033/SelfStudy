package FactoryMethod;

/**
 * @author:whr 2019/11/2
 */
public class PythonCourseFactory extends CourseFactory {

    @Override
    Course getCourse() {
        return new PythonCourse();
    }
}
