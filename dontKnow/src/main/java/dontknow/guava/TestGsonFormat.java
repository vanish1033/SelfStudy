package dontknow.guava;

/**
 * @author vanish
 */
public class TestGsonFormat {

    /**
     * apiName : gf
     * doSomeThing : {"name":"thounder","age":11,"sex":1}
     * time : 123
     */

    private String apiName;
    private DoSomeThingBean doSomeThing;
    private int time;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public DoSomeThingBean getDoSomeThing() {
        return doSomeThing;
    }

    public void setDoSomeThing(DoSomeThingBean doSomeThing) {
        this.doSomeThing = doSomeThing;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
