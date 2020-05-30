package dontknow.pattern.builderpattern;

/**
 * @author vanish
 */
public class Test {
    public static void main(String[] args) {
        Car lowCar = new Director(new LowCarBuilder()).creat();
        System.out.println("lowCar = " + lowCar);

        Car highCar = new Director(new HighCarBuilder()).creat();
        System.out.println("highCar = " + highCar);
    }
}
