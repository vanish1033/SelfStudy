package dontknow.pattern.builderpattern;

/**
 * @author vanish
 */
public class LowCarBuilder implements CarBuilder{

    /**
     * 汽车对象
     */
    private Car car = new Car();

    /**
     * 建造汽车的外壳
     */
    @Override
    public Car buildCarShell() {
        System.out.println("建造低级车的外壳");
        car.setCarShell(new CarShell("Low"));
        return car;
    }

    /**
     * 建造汽车的发动机
     */
    @Override
    public Car buildCarEngine() {
        System.out.println("建造低级车的发动机");
        car.setCarEngine(new CarEngine("High"));
        return car;
    }

    /**
     * 建造汽车的轮子
     */
    @Override
    public Car buildCarWheel() {
        System.out.println("建造低级车的轮子");
        car.setCarWheel(new CarWheel("Low"));
        return car;
    }

}
