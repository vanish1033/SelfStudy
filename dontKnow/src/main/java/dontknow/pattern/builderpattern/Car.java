package dontknow.pattern.builderpattern;

import lombok.Data;

/**
 * @author vanish
 */
@Data
public class Car {
    /**
     * 汽车的外壳
     */
    private CarShell carShell;

    /**
     * 汽车的发动机
     */
    private CarEngine carEngine;

    /**
     * 汽车的轮子
     */
    private CarWheel carWheel;
}
