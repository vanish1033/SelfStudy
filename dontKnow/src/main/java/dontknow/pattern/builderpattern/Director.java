package dontknow.pattern.builderpattern;

/**
 * @author vanish
 */
public class Director {

    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car creat() {
        carBuilder.buildCarShell();
        carBuilder.buildCarEngine();
        Car car = carBuilder.buildCarWheel();
        return car;
    }

}
