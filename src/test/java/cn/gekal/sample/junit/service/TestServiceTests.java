package cn.gekal.sample.junit.service;

import cn.gekal.sample.junit.model.SampleInput;
import cn.gekal.sample.junit.model.SampleOutput;
import cn.gekal.sample.junit.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * テストサービスのJunit
 */
class TestServiceTests {

    /** サンプルインプット */
    @Captor
    private ArgumentCaptor<SampleInput> testRepositoryInput;

    /** テストサービス */
    @InjectMocks
    private TestService target;

    /** テストリポジトリ */
    @Mock
    private TestRepository testRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("テストメソッド")
    @Test
    void testService() {

        // モック
        SampleOutput sampleOutput = new SampleOutput();
        sampleOutput.setResult1("aaaaa");
        sampleOutput.setResult2("bbbbb");
        when(testRepository.testRepository(any())).thenReturn(sampleOutput);

        // データ準備
        SampleInput sampleInput = new SampleInput();
        sampleInput.setValue1("11111");
        sampleInput.setValue2("22222");

        // テスト実施
        SampleOutput testRepositoryOutput = target.testService(sampleInput);

        // 検証: レスポンス
        assertThat(testRepositoryOutput).usingRecursiveComparison().isEqualTo(sampleOutput);

        // 検証：モックパラメータ
        assertAll(() -> {
            verify(testRepository, times(1)).testRepository(testRepositoryInput.capture());
            assertThat(testRepositoryInput.getValue()).usingRecursiveComparison().isEqualTo(sampleInput);
        });
    }
}