package abstractfactory;

/**
 * @author:whr 2019/9/8
 */
public class Test {
    @org.junit.Test // 测试抽象工厂模式
    public void Test1() {
        CourseFactory CourseFactory = //new JavaCourseFactory();
//                new PythonCourseFactory();
//                new GoCourseFactory();
                new CCourseFactory();
        CourseFactory.getArticle().makeArticle();
        CourseFactory.getVideo().makeVideo();
    }

}
