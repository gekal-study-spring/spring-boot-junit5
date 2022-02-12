package cn.gekal.sample.junit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URI;

/**
 * HttpBinメソッドのプロパティー
 */
@Component
@Validated
@ConfigurationProperties(prefix = "http-bin.method")
public class HttpBinMethodProperties {

    /** POSTの送信先 */
    @NotNull
    private URI post;

    /**
     * POSTの送信先を取得します。
     *
     * @return POSTの送信先
     */
    public URI getPost() {
        return post;
    }

    /**
     * POSTの送信先を設定します。
     *
     * @param post POSTの送信先
     */
    public void setPost(URI post) {
        this.post = post;
    }
}
