```java
package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.*;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class IPostRiskAdmissionsCalculateIncomesMapperImplTest {

    private IPostRiskAdmissionsCalculateIncomesMapperImpl mapper;

    @BeforeEach
    public void setUp() {
        mapper = new IPostRiskAdmissionsCalculateIncomesMapperImpl();
    }

    @Test
    public void testMapInData() {
        IdentityDocument identityDocument = new IdentityDocument();
        identityDocument.setDocumentType("ID");
        identityDocument.setDocumentNumber("123456");

        LaboralInformation laboralInformation = new LaboralInformation();
        laboralInformation.setCompanyId("Company123");
        laboralInformation.setDeclaratedIncome(50000.0);

        Person person = new Person();
        person.setIdentityDocument(identityDocument);
        person.setFirstName("John");
        person.setMiddleName("A.");
        person.setLastName("Doe");
        person.setLaboralInformation(laboralInformation);

        InformationSources informationSource = new InformationSources();
        informationSource.setId("Source1");
        informationSource.setConsulted(true);

        Product product = new Product();
        product.setId("Product1");
        product.setName("Product Name");

        Body body = new Body();
        body.setPerson(person);
        body.setInformationSources(Arrays.asList(informationSource));
        body.setProduct(product);

        BBody bBody = mapper.mapInData(body);

        Assertions.assertNotNull(bBody);
        Assertions.assertEquals("John", bBody.getPerson().getFirstName());
        Assertions.assertEquals("ID", bBody.getPerson().getIdentityDocument().getDocumentType());
        Assertions.assertEquals("Source1", bBody.getInformationSources().get(0).getId());
        Assertions.assertEquals("Product1", bBody.getProduct().getId());
    }

    @Test
    public void testMapOutData() {
        BIdentityDocument bIdentityDocument = new BIdentityDocument();
        bIdentityDocument.setDocumentType("ID");
        bIdentityDocument.setDocumentNumber("123456");

        BLaboralInformation bLaboralInformation = new BLaboralInformation();
        bLaboralInformation.setCompanyId("Company123");
        bLaboralInformation.setDeclaratedIncome(50000.0);

        BPerson bPerson = new BPerson();
        bPerson.setIdentityDocument(bIdentityDocument);
        bPerson.setFirstName("John");
        bPerson.setMiddleName("A.");
        bPerson.setLastName("Doe");
        bPerson.setLaboralInformation(bLaboralInformation);

        BInformationSources bInformationSource = new BInformationSources();
        bInformationSource.setId("Source1");
        bInformationSource.setConsulted(true);

        BProduct bProduct = new BProduct();
        bProduct.setId("Product1");
        bProduct.setName("Product Name");

        BBody bBody = new BBody();
        bBody.setPerson(bPerson);
        bBody.setInformationSources(Arrays.asList(bInformationSource));
        bBody.setProduct(bProduct);

        Body body = mapper.mapOutData(bBody);

        Assertions.assertNotNull(body);
        Assertions.assertEquals("John", body.getPerson().getFirstName());
        Assertions.assertEquals("ID", body.getPerson().getIdentityDocument().getDocumentType());
        Assertions.assertEquals("Source1", body.getInformationSources().get(0).getId());
        Assertions.assertEquals("Product1", body.getProduct().getId());
    }

    @Test
    public void testMapInData_NullInput() {
        BBody bBody = mapper.mapInData(null);
        Assertions.assertNull(bBody);
    }

    @Test
    public void testMapOutData_NullInput() {
        Body body = mapper.mapOutData(null);
        Assertions.assertNull(body);
    }
}
```