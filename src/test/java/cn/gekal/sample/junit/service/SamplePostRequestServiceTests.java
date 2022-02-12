package cn.gekal.sample.junit.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import cn.gekal.sample.junit.repository.SamplePostRequestRepository;
import cn.gekal.sample.junit.repository.dto.HttpBinPostInput;
import cn.gekal.sample.junit.repository.dto.HttpBinPostOutput;
import cn.gekal.sample.junit.tools.LoggerHelper;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * テストサービスのJunit
 */
class SamplePostRequestServiceTests {

    /** mockAppender */
    private Appender<ILoggingEvent> mockAppender;

    /** サンプルインプット */
    @Captor
    private ArgumentCaptor<HttpBinPostInput> testRepositoryInput;

    /** テストサービス */
    @InjectMocks
    private SamplePostRequestService samplePostRequestService;

    /** サンプルレストテンプレート */
    @Mock
    private SamplePostRequestRepository samplePostRequestRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockAppender = LoggerHelper.addAppender(SamplePostRequestService.class);
    }

    @DisplayName("テストメソッド")
    @Test
    void httpBinPost() {

        // モック
        HttpBinPostOutput httpBinPostOutputMock = new HttpBinPostOutput();
        httpBinPostOutputMock.setArgs(Maps.newHashMap("key1", "value1"));
        httpBinPostOutputMock.setData("Data");
        httpBinPostOutputMock.setFiles("Files");
        httpBinPostOutputMock.setForm("Form");
        httpBinPostOutputMock.setHeaders("Headers");
        httpBinPostOutputMock.setJson("Json");
        httpBinPostOutputMock.setOrigin("Origin");
        httpBinPostOutputMock.setUrl("Url");
        when(samplePostRequestRepository.httpBinPost(any())).thenReturn(httpBinPostOutputMock);

        // データ準備
        HttpBinPostInput httpBinPostInput = new HttpBinPostInput();
        httpBinPostInput.setValue1("11111");
        httpBinPostInput.setValue2("22222");

        // テスト実施
        HttpBinPostOutput httpBinPostOutput = samplePostRequestService.httpBinPost(httpBinPostInput);

        // 検証: レスポンス
        assertThat(httpBinPostOutput).usingRecursiveComparison().isEqualTo(httpBinPostOutputMock);

        // 検証：モックパラメータ
        assertAll(() -> {
            verify(samplePostRequestRepository, times(1)).httpBinPost(testRepositoryInput.capture());
            assertThat(testRepositoryInput.getValue()).usingRecursiveComparison().isEqualTo(httpBinPostInput);
        });

        // 検証：ログ
        LoggerHelper.verifyLog(mockAppender, List.of(Level.DEBUG), List.of("テストログ"));
    }
}