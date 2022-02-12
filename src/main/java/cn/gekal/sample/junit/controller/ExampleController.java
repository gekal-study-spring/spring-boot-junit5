package cn.gekal.sample.junit.controller;

import cn.gekal.sample.junit.controller.dto.SampleRequest;
import cn.gekal.sample.junit.controller.dto.SampleResponse;
import cn.gekal.sample.junit.model.SampleInput;
import cn.gekal.sample.junit.model.SampleOutput;
import cn.gekal.sample.junit.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * サンプルAPI
 */
@RestController
@RequestMapping("/test")
public class ExampleController {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

    /** テストサービス */
    private final TestService testService;

    /**
     * コンストラクタ
     *
     * @param testService テストサービス
     */
    public ExampleController(TestService testService) {
        this.testService = testService;
    }

    /**
     * POSTのサンプルAPI
     *
     * @param sampleRequest サンプルリクエスト
     * @return サンプルレスポンス
     */
    @PostMapping("/")
    public SampleResponse samplePostApi(@RequestBody SampleRequest sampleRequest) {

        LOGGER.info("ExampleController start");
        LOGGER.debug("request = [{}]", sampleRequest);

        SampleInput sampleInput = new SampleInput();
        sampleInput.setValue1(sampleRequest.getValue1());
        sampleInput.setValue2(sampleRequest.getValue2());

        SampleOutput sampleOutput = this.testService.testService(sampleInput);

        SampleResponse sampleResponse = new SampleResponse();
        sampleResponse.setResult1(sampleOutput.getResult1());
        sampleResponse.setResult2(sampleOutput.getResult2());

        LOGGER.debug("response = [{}]", sampleResponse);
        LOGGER.info("ExampleController end");

        return sampleResponse;
    }

}
