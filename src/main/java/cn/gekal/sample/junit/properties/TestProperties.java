package cn.gekal.sample.junit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * サンプルプロパティー
 */
@Component
@ConfigurationProperties(prefix = "gekal.properties")
public class TestProperties {

    /** プロパティー１ */
    private String property1;

    /** プロパティー２ */
    private String property2;

    /**
     * プロパティー１を取得します。
     *
     * @return プロパティー１
     */
    public String getProperty1() {
        return property1;
    }

    /**
     * プロパティー１を設定します。
     *
     * @param property1 プロパティー１
     */
    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    /**
     * プロパティー２を取得します。
     *
     * @return プロパティー２
     */
    public String getProperty2() {
        return property2;
    }

    /**
     * プロパティー２を設定します。
     *
     * @param property2 プロパティー２
     */
    public void setProperty2(String property2) {
        this.property2 = property2;
    }
}
