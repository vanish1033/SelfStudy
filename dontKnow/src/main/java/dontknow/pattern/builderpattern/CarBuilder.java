package dontknow.pattern.builderpattern;

/**
 * @author vanish
 */
public interface CarBuilder {

    /**
     * 建造汽车的外壳
     *
     * @return Car
     */
    Car buildCarShell();

    /**
     * 建造汽车的发动机
     *
     * @return Car
     */
    Car buildCarEngine();

    /**
     * 建造汽车的轮子
     *
     * @return Car
     */
    Car buildCarWheel();

}
