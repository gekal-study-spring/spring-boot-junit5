package cn.gekal.sample.junit.service;

import cn.gekal.sample.junit.model.SampleInput;
import cn.gekal.sample.junit.model.SampleOutput;
import cn.gekal.sample.junit.repository.TestRepository;
import org.springframework.stereotype.Service;

/**
 * テストサービス
 */
@Service
public class TestService {

    /** テストリポジトリ */
    private final TestRepository testRepository;

    /**
     * コンストラクタ
     *
     * @param testRepository テストリポジトリ
     */
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /**
     * テストメソッド
     *
     * @param sampleInput インプット
     * @return アウトプット
     */
    public SampleOutput testService(SampleInput sampleInput) {

        return this.testRepository.testRepository(sampleInput);
    }

}
