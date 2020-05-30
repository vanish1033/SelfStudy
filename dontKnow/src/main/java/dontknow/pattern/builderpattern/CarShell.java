package dontknow.pattern.builderpattern;

import lombok.Data;

/**
 * @author vanish
 */
@Data
public class CarShell {
    /**
     * 等级
     */
    private String level;

    public CarShell(String level) {
        this.level = level;
    }

    public CarShell() {
    }
}
