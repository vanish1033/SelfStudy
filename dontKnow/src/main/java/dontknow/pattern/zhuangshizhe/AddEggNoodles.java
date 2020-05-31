package dontknow.pattern.zhuangshizhe;

import lombok.Data;

/**
 * @author vanish
 */
@Data
public class AddEggNoodles extends AbstractNoodles {

    private AbstractNoodles noodles;

    public AddEggNoodles(AbstractNoodles noodles) {
        this.noodles = noodles;
    }

    @Override
    public int jiaGe() {
        return noodles.jiaGe() + 2;
    }
}
