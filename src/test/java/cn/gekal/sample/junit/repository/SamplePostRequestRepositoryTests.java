package cn.gekal.sample.junit.repository;

import cn.gekal.sample.junit.configuration.RestTemplateConfiguration;
import cn.gekal.sample.junit.properties.HttpBinMethodProperties;
import cn.gekal.sample.junit.properties.SampleRestTemplateProperties;
import cn.gekal.sample.junit.repository.dto.HttpBinPostInput;
import cn.gekal.sample.junit.repository.dto.HttpBinPostOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * テストリポジトリのJunit
 */
@RestClientTest(value = {SamplePostRequestRepository.class, RestTemplateConfiguration.class, SampleRestTemplateProperties.class, HttpBinMethodProperties.class}, properties = {"http-bin.method.post=https://httpbin.org/post", "logging.level.cn.gekal.sample.junit.repository.SamplePostRequestRepository=DEBUG"})
class SamplePostRequestRepositoryTests {

    /** テストのPOST先 */
    private static final String POST = "https://httpbin.org/post";

    /** テストリポジトリ */
    @Autowired
    private SamplePostRequestRepository samplePostRequestRepository;

    /** モックサーバー */
    @Autowired
    private MockRestServiceServer server;

    /** JSONマッパー */
    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("テストメソッド")
    @Test
    void httpBinPost() throws JsonProcessingException {

        // モック
        HttpBinPostInput httpBinPostInput = new HttpBinPostInput();
        httpBinPostInput.setValue1("Value1");
        httpBinPostInput.setValue2("Value2");

        HttpBinPostOutput httpBinPostOutputMock = new HttpBinPostOutput();
        httpBinPostOutputMock.setArgs(Maps.newHashMap("key1", "value1"));
        httpBinPostOutputMock.setData("Data");
        httpBinPostOutputMock.setFiles("Files");
        httpBinPostOutputMock.setForm("Form");
        httpBinPostOutputMock.setHeaders("Headers");
        httpBinPostOutputMock.setJson("Json");
        httpBinPostOutputMock.setOrigin("Origin");
        httpBinPostOutputMock.setUrl("Url");

        this.server.expect(once(), requestTo(POST))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(httpBinPostInput)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(httpBinPostOutputMock),
                        MediaType.APPLICATION_JSON));

        // テスト実施
        HttpBinPostOutput result = samplePostRequestRepository.httpBinPost(httpBinPostInput);

        // 結果検証
        assertThat(result).usingRecursiveComparison().isEqualTo(httpBinPostOutputMock);
    }

}