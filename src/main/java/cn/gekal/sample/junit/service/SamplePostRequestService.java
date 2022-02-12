package cn.gekal.sample.junit.service;

import cn.gekal.sample.junit.repository.SamplePostRequestRepository;
import cn.gekal.sample.junit.repository.dto.HttpBinPostInput;
import cn.gekal.sample.junit.repository.dto.HttpBinPostOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * テストサービス
 */
@Repository
public class SamplePostRequestService {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(SamplePostRequestService.class);

    /** サンプルレストテンプレート */
    private final SamplePostRequestRepository samplePostRequestRepository;

    /**
     * コンストラクタ
     *
     * @param samplePostRequestRepository サンプルレストテンプレート
     */
    public SamplePostRequestService(SamplePostRequestRepository samplePostRequestRepository) {
        this.samplePostRequestRepository = samplePostRequestRepository;
    }

    /**
     * テストメソッド
     *
     * @param httpBinPostInput インプット
     * @return アウトプット
     */
    public HttpBinPostOutput httpBinPost(HttpBinPostInput httpBinPostInput) {

        LOGGER.debug("テストログ");

        return samplePostRequestRepository.httpBinPost(httpBinPostInput);
    }
}
