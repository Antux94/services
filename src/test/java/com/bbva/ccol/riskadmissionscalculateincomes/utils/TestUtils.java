package com.bbva.ccol.riskadmissionscreditevaluations.utils;

import com.openpojo.reflection.PojoClass;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;

import java.util.Iterator;
import java.util.List;

public class TestUtils {

    public static Validator packageValidator() {
        return ValidatorBuilder.create().with(new Tester[]{new SetterTester()}).with(new Tester[]{new GetterTester()}).build();
    }

    public static void testToString(List<PojoClass> pojoClasses) {
        Iterator var1 = pojoClasses.iterator();

        while (var1.hasNext()) {
            PojoClass pojoClass = (PojoClass) var1.next();
            ValidationHelper.getBasicInstance(pojoClass).toString();
            ValidationHelper.getMostCompleteInstance(pojoClass).toString();
        }

    }

}
