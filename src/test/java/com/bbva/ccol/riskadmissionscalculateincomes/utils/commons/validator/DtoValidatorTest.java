package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.validator;

import com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.annotations.Optional;
import com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.interfaces.IDTOInOptionalAttributes;
import com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.interfaces.IDTOOutOptionalAttributes;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collections;

public class DtoValidatorTest {

  private interface RequiredGroup {}
  @Getter
  @Setter
  private static class TestClass {
    @NotNull(groups = RequiredGroup.class)
    private String testAttribute;
  
    @Optional(groups = IDTOOutOptionalAttributes.class)
    @NotBlank(groups = RequiredGroup.class)
    private String optionalAttributeOut;
  
    @Optional(groups = IDTOInOptionalAttributes.class)
    @NotBlank(groups = RequiredGroup.class)
    private String optionalAttributeIn;
  
    @Optional(groups = RequiredGroup.class)
    private String optionalNoGroups;
  }
  @Test
  public void testValidateOk() {
    TestClass testClass = new TestClass();
    testClass.setTestAttribute("hello");
    DtoValidator.validate(Collections.singletonList(testClass),RequiredGroup.class, IDTOOutOptionalAttributes.class, IDTOInOptionalAttributes.class);
  }
  @Test(expected = BusinessServiceException.class)
  public void testValidateFail() {
    DtoValidator.validate(Collections.singletonList(new TestClass()),RequiredGroup.class, IDTOOutOptionalAttributes.class);
  }
  @Test(expected = BusinessServiceException.class)
  public void testValidateFailOnNull() {
    DtoValidator.validate((TestClass)null, RequiredGroup.class);
  }

}