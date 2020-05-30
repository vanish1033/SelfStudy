package dontknow.pattern.builderpattern;

/**
 * @author vanish
 */
public class HighCarBuilder implements CarBuilder {

    private Car car = new Car();

    @Override
    public Car buildCarShell() {
        System.out.println("建造高级车的外壳");
        car.setCarShell(new CarShell("High"));
        return car;
    }

    @Override
    public Car buildCarEngine() {
        System.out.println("建造高级车的外壳");
        car.setCarEngine(new CarEngine("High"));
        return car;
    }

    @Override
    public Car buildCarWheel() {
        System.out.println("建造高级车的外壳");
        car.setCarWheel(new CarWheel("Low"));
        return car;
    }

}
