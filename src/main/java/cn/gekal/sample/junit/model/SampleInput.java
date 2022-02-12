package cn.gekal.sample.junit.model;

/**
 * サンプルインプット
 */
public class SampleInput {

    /** バリュー１ */
    private String value1;

    /** バリュー２ */
    private String value2;

    /**
     * バリュー１を取得します。
     *
     * @return バリュー１
     */
    public String getValue1() {
        return value1;
    }

    /**
     * バリュー１を設定します。
     *
     * @param value1 バリュー１
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    /**
     * バリュー２を取得します。
     *
     * @return バリュー２
     */
    public String getValue2() {
        return value2;
    }

    /**
     * バリュー２を設定します。
     *
     * @param value2 バリュー２
     */
    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "SampleInput{" + "value1='" + value1 + '\'' + ", value2='" + value2 + '\'' + '}';
    }
}
