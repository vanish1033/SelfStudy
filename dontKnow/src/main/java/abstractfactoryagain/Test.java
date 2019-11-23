package abstractfactoryagain;

/**
 * @author:whr 2019/9/10
 */
public class Test {
    @org.junit.Test
    public void test1() {
        CourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.makeAtricle().getAtricle();
        courseFactory.makeVideo().getVideo();

        System.out.println("---------------------------");

        CourseFactory courseFactory1 = new PythonCourseFactory();
        courseFactory1.makeVideo().getVideo();
        courseFactory1.makeVideo().getVideo();
    }
}
