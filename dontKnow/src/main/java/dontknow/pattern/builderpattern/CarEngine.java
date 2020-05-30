package dontknow.pattern.builderpattern;

import lombok.Data;

/**
 * @author vanish
 */
@Data
public class CarEngine {
    /**
     * 等级
     */
    private String level;

    public CarEngine(String level) {

        this.level = level;
    }

    public CarEngine() {
    }
}
