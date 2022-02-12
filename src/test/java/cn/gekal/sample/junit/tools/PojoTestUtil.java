package cn.gekal.sample.junit.tools;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;

/**
 * POJOテストUtil
 */
public class PojoTestUtil {

    /** POJOテストルール */
    private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create()
            .with(new GetterMustExistRule())
            .with(new SetterMustExistRule())
            .build();

    /**
     * ゲッター・セッターを検証する
     *
     * @param clazz 対象クラス
     */
    public static void validateAccessors(final Class<?> clazz) {

        ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }
}
