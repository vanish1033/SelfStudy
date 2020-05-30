package dontknow.pattern.builderpattern;

import lombok.Data;

/**
 * @author vanish
 */
@Data
public class CarWheel {
    /**
     * 等级
     */
    private String level;

    public CarWheel(String level) {
        this.level = level;
    }

    public CarWheel() {
    }
}
