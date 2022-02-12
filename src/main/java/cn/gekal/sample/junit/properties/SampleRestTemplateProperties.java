package cn.gekal.sample.junit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * サンプルプロパティー
 */
@Component
@ConfigurationProperties(prefix = "gekal.rest-template.sample")
public class SampleRestTemplateProperties {

    /** リードタイムアウト */
    private Duration readTimeout;

    /** 接続タイムアウト */
    private Duration connectTimeout;

    /**
     * リードタイムアウトを取得します。
     *
     * @return リードタイムアウト
     */
    public Duration getReadTimeout() {
        return readTimeout;
    }

    /**
     * リードタイムアウトを設定します。
     *
     * @param readTimeout リードタイムアウト
     */
    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    /**
     * 接続タイムアウトを取得します。
     *
     * @return 接続タイムアウト
     */
    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * 接続タイムアウトを設定します。
     *
     * @param connectTimeout 接続タイムアウト
     */
    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
}
