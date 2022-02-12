package cn.gekal.sample.junit.properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * サンプルプロパティーのJunit
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(properties = {"gekal.properties.property1=test1", "gekal.properties.property2=test2"})
class TestPropertiesTests {

    /** サンプルプロパティー */
    @Autowired
    private TestProperties testProperties;

    @DisplayName("プロパティー検証")
    @Test
    public void test() {

        assertAll(() -> {
            assertEquals("test1", testProperties.getProperty1());
            assertEquals("test2", testProperties.getProperty2());
        });
    }
}