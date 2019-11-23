package simplefactory;

/**
 * @author:whr 2019/7/24
 */
public class CourseFactory {
    public static void Paly(Class<? extends PlayCourse> PalyCourse) {
        try {
            PalyCourse.newInstance().play();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
