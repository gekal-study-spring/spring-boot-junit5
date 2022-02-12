package cn.gekal.sample.junit.repository;

import cn.gekal.sample.junit.model.SampleInput;
import cn.gekal.sample.junit.model.SampleOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

class TestRepositoryTests {

    /** テストサービス */
    @InjectMocks
    private TestRepository target;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("テストメソッド")
    @Test
    void testRepository() {

        // データ準備
        SampleInput sampleInput = new SampleInput();
        sampleInput.setValue1("aaaaa");
        sampleInput.setValue2("bbbbb");

        // テスト実施
        SampleOutput testRepositoryOutput = target.testRepository(sampleInput);

        // 検証: レスポンス
        assertThat(testRepositoryOutput).usingRecursiveComparison().isEqualTo(new SampleOutput() {{
            setResult1("11111");
            setResult2("22222");
        }});
    }
}