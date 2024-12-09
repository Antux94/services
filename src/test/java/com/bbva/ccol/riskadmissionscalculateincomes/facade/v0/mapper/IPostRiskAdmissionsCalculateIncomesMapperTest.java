
package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BBody;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BIdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BInformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BLaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BPerson;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BProduct;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Body;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.IdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.InformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.LaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Person;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Product;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IPostRiskAdmissionsCalculateIncomesMapperTest {

    private IPostRiskAdmissionsCalculateIncomesMapper mapper = Mappers.getMapper(IPostRiskAdmissionsCalculateIncomesMapper.class);

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void testMapInData() {
        Body body = dummyMock.getBody();
        BBody bBody = mapper.mapInData(body);

        Assert.assertEquals(body.getPerson().getFirstName(), bBody.getPerson().getFirstName());
        Assert.assertEquals(body.getPerson().getMiddleName(), bBody.getPerson().getMiddleName());
        Assert.assertEquals(body.getPerson().getLastName(), bBody.getPerson().getLastName());
        Assert.assertEquals(body.getPerson().getIdentityDocument().getDocumentType(), bBody.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(body.getPerson().getIdentityDocument().getDocumentNumber(), bBody.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(body.getPerson().getLaboralInformation().getCompanyId(), bBody.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(body.getPerson().getLaboralInformation().getDeclaratedIncome(), bBody.getPerson().getLaboralInformation().getDeclaratedIncome());

        Assert.assertEquals(body.getInformationSources().get(0).getId(), bBody.getInformationSources().get(0).getId());
        Assert.assertEquals(body.getInformationSources().get(0).getIsConsulted(), bBody.getInformationSources().get(0).getIsConsulted());

        Assert.assertEquals(body.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(body.getProduct().getName(), bBody.getProduct().getName());
    }
    
    @Test
    public void testMapInDataWithNulls() {
        Body bodyNull = null;
        BBody bBodyNullResult = mapper.mapInData(bodyNull);
        Assert.assertNull(bBodyNullResult);

        Body body = new Body();
        BBody bBody = mapper.mapInData(body);

        Assert.assertNotNull(bBody); // Check that the main object is created even with null inner objects
    }


    @Test
    public void testMapOutData() {
        BBody bBody = dummyMock.getBBody();
        Body body = mapper.mapOutData(bBody);

        Assert.assertEquals(bBody.getPerson().getFirstName(), body.getPerson().getFirstName());
        // ... similar asserts for other fields
    }

    @Test
    public void testMapOutDataWithNulls() {
        BBody bBodyNull = null;
        Body bodyNullResult = mapper.mapOutData(bBodyNull);
        Assert.assertNull(bodyNullResult);

        BBody bBody = new BBody();
        Body body = mapper.mapOutData(bBody);

        Assert.assertNotNull(body); // Check that the main object is created even with null inner objects
    }


    private class DummyMock {

        public Body getBody() {
            Body body = new Body();
            Person person = new Person();
            IdentityDocument identityDocument = new IdentityDocument();
            LaboralInformation laboralInformation = new LaboralInformation();
            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            Product product = new Product();

            identityDocument.setDocumentType("CC");
            identityDocument.setDocumentNumber("1235489345");
            person.setIdentityDocument(identityDocument);
            person.setFirstName("Christian");
            person.setMiddleName("David");
            person.setLastName("Rojas");

            laboralInformation.setCompanyId("800900231-5");
            laboralInformation.setDeclaratedIncome(Double.valueOf(5000000));
            person.setLaboralInformation(laboralInformation);
            body.setPerson(person);


            informationSources.setId("SOI");
            informationSources.setIsConsulted(false);
            informationSourcesList.add(informationSources);
            body.setInformationSources(informationSourcesList);

            product.setId("12");
            product.setName("hipotecas");
            body.setProduct(product);

            return body;
        }

        public BBody getBBody() {
            // Similar to getBody(), but creates BBody and its inner objects
            // ...
            return null; // Replace with actual implementation
        }
    }
}
