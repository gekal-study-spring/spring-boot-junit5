package cn.gekal.sample.junit.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import cn.gekal.sample.junit.controller.dto.SampleRequest;
import cn.gekal.sample.junit.model.SampleInput;
import cn.gekal.sample.junit.model.SampleOutput;
import cn.gekal.sample.junit.service.TestService;
import cn.gekal.sample.junit.tools.LoggerHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * サンプルAPIのJunit
 */
@WebMvcTest(controllers = ExampleController.class, properties = {"logging.level.cn.gekal.sample.junit.controller.ExampleController=DEBUG"})
class ExampleControllerTests {

    /** MockMvc */
    @Autowired
    private MockMvc mockMvc;

    /** mockAppender */
    private Appender<ILoggingEvent> mockAppender;

    /** サンプルインプット */
    @Captor
    private ArgumentCaptor<SampleInput> testServiceInput;

    /** サンプルAPI */
    @Autowired
    private ExampleController target;

    /** テストサービス */
    @MockBean
    private TestService testService;

    /** ObjectMapper */
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockAppender = LoggerHelper.addAppender(ExampleController.class);
    }

    @DisplayName("POSTのサンプルAPI - 正常")
    @Test
    public void samplePostApi() throws Exception {

        // モック
        SampleOutput sampleOutput = new SampleOutput();
        sampleOutput.setResult1("11111");
        sampleOutput.setResult2("22222");
        when(testService.testService(any())).thenReturn(sampleOutput);

        // データ準備
        SampleRequest sampleRequest = new SampleRequest();
        sampleRequest.setValue1("value1");
        sampleRequest.setValue2("value2");

        String content = objectMapper.writeValueAsString(sampleRequest);

        // テスト実施
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/test/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(requestBuilder)
                .andDo(print()) // リクエスト詳細
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result1").value("11111"))
                .andExpect(jsonPath("$.result2").value("22222"));

        // 検証：モックパラメータ
        assertAll(() -> {
            verify(testService, times(1)).testService(testServiceInput.capture());
            assertThat(testServiceInput.getValue()).usingRecursiveComparison().isEqualTo(sampleRequest);
        });

        // 検証：ログ
        LoggerHelper.verifyLog(mockAppender,
                List.of(Level.INFO, Level.DEBUG, Level.DEBUG, Level.INFO),
                List.of("ExampleController start",
                        "request = [SampleRequest[value1=value1,value2=value2]]",
                        "response = [SampleResponse[result1=11111,result2=22222]]",
                        "ExampleController end"));
    }

}