package dontknow.pattern.zhuangshizhe;

/**
 * @author vanish
 */
public class Test {
    public static void main(String[] args) {

        AddEggNoodles addEggNoodles = new AddEggNoodles(new NiuRouNoodles());
        System.out.println("addEggNoodles.jiaGe() = " + addEggNoodles.jiaGe());

        AddEggNoodles addEggNoodles1 = new AddEggNoodles(addEggNoodles);
        System.out.println("addEggNoodles1.jiaGe() = " + addEggNoodles1.jiaGe());

//        Exception in thread "main" java.lang.StackOverflowError
//        addEggNoodles1.setNoodles(addEggNoodles1);
//        System.out.println("addEggNoodles1.jiaGe() = " + addEggNoodles1.jiaGe());

        AddEggNoodles addEggNoodles2 = new AddEggNoodles(addEggNoodles1);
        System.out.println("addEggNoodles2.jiaGe() = " + addEggNoodles2.jiaGe());

        AddNiuRouNoodles addNiuRouNoodles = new AddNiuRouNoodles(addEggNoodles2);

        System.out.println("addNiuRouNoodles.jiaGe() = " + addNiuRouNoodles.jiaGe());


        AddNiuRouNoodles addNiuRouNoodles1 = new AddNiuRouNoodles(addNiuRouNoodles);
        System.out.println("addNiuRouNoodles1 = " + addNiuRouNoodles1.jiaGe());
    }
}
