package cn.gekal.sample.junit.model;

/**
 * サンプルアウトプット
 */
public class SampleOutput {

    /** 結果１ */
    private String result1;

    /** 結果２ */
    private String result2;

    /**
     * 結果１を取得します。
     *
     * @return 結果１
     */
    public String getResult1() {
        return result1;
    }

    /**
     * 結果１を設定します。
     *
     * @param result1 結果１
     */
    public void setResult1(String result1) {
        this.result1 = result1;
    }

    /**
     * 結果２を取得します。
     *
     * @return 結果２
     */
    public String getResult2() {
        return result2;
    }

    /**
     * 結果２を設定します。
     *
     * @param result2 結果２
     */
    public void setResult2(String result2) {
        this.result2 = result2;
    }

    @Override
    public String toString() {
        return "SampleOutput{" + "result1='" + result1 + '\'' + ", result2='" + result2 + '\'' + '}';
    }
}
