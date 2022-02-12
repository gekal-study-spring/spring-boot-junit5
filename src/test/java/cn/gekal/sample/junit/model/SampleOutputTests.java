package cn.gekal.sample.junit.model;

import cn.gekal.sample.junit.tools.PojoTestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * サンプルアウトプットのJunit
 */
class SampleOutputTests {

    @DisplayName("プロパティーの検証")
    @Test
    public void testProperField() {

        PojoTestUtil.validateAccessors(SampleInput.class);
    }
}