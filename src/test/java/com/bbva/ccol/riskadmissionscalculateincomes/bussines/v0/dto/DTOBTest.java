package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.bbva.ccol.riskadmissionscalculateincomes.utils.TestUtils;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterEnum;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;


@RunWith(MockitoJUnitRunner.class)
public class DTOBTest {

    private static final String POJO_PACKAGE = "com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto";
	
    @Test
    public void testPojos() {
        Validator validator = TestUtils.packageValidator();
        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new FilterChain(new FilterPackageInfo(),
                new FilterEnum()));
        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
        TestUtils.testToString(pojoClasses);
    }
}
