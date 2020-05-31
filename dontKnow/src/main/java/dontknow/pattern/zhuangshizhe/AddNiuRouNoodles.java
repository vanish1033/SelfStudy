package dontknow.pattern.zhuangshizhe;

import lombok.Data;

/**
 * @author vanish
 */
@Data
public class AddNiuRouNoodles extends AbstractNoodles {

    private AbstractNoodles noodles;

    public AddNiuRouNoodles(AbstractNoodles noodles) {
        this.noodles = noodles;
    }

    @Override
    public int jiaGe() {
        return noodles.jiaGe() + 5;
    }
}
