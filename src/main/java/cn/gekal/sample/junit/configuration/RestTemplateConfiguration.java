package cn.gekal.sample.junit.configuration;

import cn.gekal.sample.junit.properties.SampleRestTemplateProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/***
 * レストテンプレートのコンフィグレーション
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * サンプルレストテンプレートBeanを作成する
     *
     * @param restTemplateBuilder          レストテンプレートビルダー
     * @param sampleRestTemplateProperties サンプルプロパティー
     * @return サンプルレストテンプレートBean
     */
    @Bean
    public RestTemplate sampleRestTemplate(RestTemplateBuilder restTemplateBuilder, SampleRestTemplateProperties sampleRestTemplateProperties) {

        return restTemplateBuilder.setReadTimeout(sampleRestTemplateProperties.getReadTimeout())
                .setConnectTimeout(sampleRestTemplateProperties.getConnectTimeout())
                .build();
    }
}
