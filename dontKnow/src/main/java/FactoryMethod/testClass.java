package FactoryMethod;

/**
 * @author:whr 2019/11/2
 */
public class testClass {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Course course = courseFactory.getCourse();
        course.show();

        courseFactory = new PythonCourseFactory();
        Course course1 = courseFactory.getCourse();
        course1.show();

    }
}