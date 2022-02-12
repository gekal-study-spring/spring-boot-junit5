package cn.gekal.sample.junit.controller;

import cn.gekal.sample.junit.controller.dto.HttpBinPostRequest;
import cn.gekal.sample.junit.controller.dto.HttpBinPostResponse;
import cn.gekal.sample.junit.repository.dto.HttpBinPostInput;
import cn.gekal.sample.junit.repository.dto.HttpBinPostOutput;
import cn.gekal.sample.junit.service.SamplePostRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HttpBinのテストAPI
 */
@RestController
@RequestMapping("/httpbin/method")
public class HttpBinMethodController {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpBinMethodController.class);

    /** テストサービス */
    private final SamplePostRequestService samplePostRequestService;

    /**
     * コンストラクタ
     *
     * @param samplePostRequestService テストサービス
     */
    public HttpBinMethodController(SamplePostRequestService samplePostRequestService) {
        this.samplePostRequestService = samplePostRequestService;
    }

    /**
     * POSTのサンプルAPI
     *
     * @param httpBinPostRequest サンプルリクエスト
     * @return サンプルレスポンス
     */
    @PostMapping("/post")
    public HttpBinPostResponse samplePostApi(@RequestBody HttpBinPostRequest httpBinPostRequest) {

        LOGGER.debug("request = [{}]", httpBinPostRequest);

        HttpBinPostInput httpBinPostInput = new HttpBinPostInput();
        httpBinPostInput.setValue1(httpBinPostRequest.getValue1());
        httpBinPostInput.setValue2(httpBinPostRequest.getValue2());

        HttpBinPostOutput httpBinPostOutput = this.samplePostRequestService.httpBinPost(httpBinPostInput);

        HttpBinPostResponse httpBinPostResponse = new HttpBinPostResponse();
        httpBinPostResponse.setArgs(httpBinPostOutput.getArgs());
        httpBinPostResponse.setData(httpBinPostOutput.getData());
        httpBinPostResponse.setFiles(httpBinPostOutput.getFiles());
        httpBinPostResponse.setForm(httpBinPostOutput.getForm());
        httpBinPostResponse.setHeaders(httpBinPostOutput.getHeaders());
        httpBinPostResponse.setJson(httpBinPostOutput.getJson());
        httpBinPostResponse.setOrigin(httpBinPostOutput.getOrigin());
        httpBinPostResponse.setUrl(httpBinPostOutput.getUrl());

        LOGGER.debug("response = [{}]", httpBinPostResponse);

        return httpBinPostResponse;
    }

}
