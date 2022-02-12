package cn.gekal.sample.junit.repository;

import cn.gekal.sample.junit.properties.HttpBinMethodProperties;
import cn.gekal.sample.junit.repository.dto.HttpBinPostInput;
import cn.gekal.sample.junit.repository.dto.HttpBinPostOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * テストリポジトリ
 */
@Repository
public class SamplePostRequestRepository {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(SamplePostRequestRepository.class);

    /** サンプルレストテンプレート */
    private final RestTemplate sampleRestTemplate;

    /** HttpBinメソッドのプロパティー */
    private final HttpBinMethodProperties httpBinMethodProperties;

    /**
     * コンストラクタ
     *
     * @param sampleRestTemplate      サンプルレストテンプレート
     * @param httpBinMethodProperties HttpBinメソッドのプロパティー
     */
    public SamplePostRequestRepository(RestTemplate sampleRestTemplate, HttpBinMethodProperties httpBinMethodProperties) {
        this.sampleRestTemplate = sampleRestTemplate;
        this.httpBinMethodProperties = httpBinMethodProperties;
    }

    /**
     * テストメソッド
     *
     * @param httpBinPostInput インプット
     * @return アウトプット
     */
    public HttpBinPostOutput httpBinPost(HttpBinPostInput httpBinPostInput) {

        LOGGER.debug("HttpBinPostInput = [{}]", httpBinPostInput);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<HttpBinPostInput> httpEntity = new HttpEntity<>(httpBinPostInput, headers);

        ResponseEntity<HttpBinPostOutput>
                responseEntity =
                this.sampleRestTemplate.exchange(httpBinMethodProperties.getPost(),
                        HttpMethod.POST,
                        httpEntity,
                        HttpBinPostOutput.class);

        HttpBinPostOutput httpBinPostOutput = responseEntity.getBody();

        LOGGER.debug("StatusCode = [{}]", responseEntity.getStatusCode());
        LOGGER.debug("HttpBinPostOutput = [{}]", httpBinPostOutput);

        return httpBinPostOutput;
    }
}
