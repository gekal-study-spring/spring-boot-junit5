package cn.gekal.sample.junit.repository;

import cn.gekal.sample.junit.model.SampleInput;
import cn.gekal.sample.junit.model.SampleOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * テストリポジトリ
 */
@Repository
public class TestRepository {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRepository.class);

    /**
     * テストメソッド
     *
     * @param sampleInput インプット
     * @return アウトプット
     */
    public SampleOutput testRepository(SampleInput sampleInput) {

        LOGGER.debug("input = [{}]", sampleInput);

        SampleOutput sampleOutput = new SampleOutput();
        sampleOutput.setResult1("11111");
        sampleOutput.setResult2("22222");

        LOGGER.debug("output = [{}]", sampleOutput);

        return sampleOutput;
    }
}
