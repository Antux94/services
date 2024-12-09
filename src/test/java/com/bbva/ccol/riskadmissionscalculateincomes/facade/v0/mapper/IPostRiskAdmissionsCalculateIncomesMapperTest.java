
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

        Assert.assertEquals(body.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(body.getProduct().getName(), bBody.getProduct().getName());

        for (int i = 0; i < body.getInformationSources().size(); i++) {
            Assert.assertEquals(body.getInformationSources().get(i).getId(), bBody.getInformationSources().get(i).getId());
            Assert.assertEquals(body.getInformationSources().get(i).getIsConsulted(), bBody.getInformationSources().get(i).getIsConsulted());
        }
    }
    
    @Test
    public void testMapInDataWithNulls() {
        Body body = null;
        BBody bBody = mapper.mapInData(body);
        Assert.assertNull(bBody);

        body = new Body();
        body.setPerson(null);
        body.setProduct(null);
        body.setInformationSources(null);

        bBody = mapper.mapInData(body);

        Assert.assertNull(bBody.getPerson());
        Assert.assertNull(bBody.getProduct());
        Assert.assertNull(bBody.getInformationSources());
    }


    @Test
    public void testMapOutData() {
        BBody bBody = dummyMock.getBBody();
        Body body = mapper.mapOutData(bBody);

        // Assertions similar to testMapInData, but in reverse
        Assert.assertEquals(bBody.getPerson().getFirstName(), body.getPerson().getFirstName());
        // ... other assertions
    }

    @Test
    public void testMapOutDataWithNulls() {
        BBody bBody = null;
        Body body = mapper.mapOutData(bBody);
        Assert.assertNull(body);

        bBody = new BBody();
        bBody.setPerson(null);
        bBody.setProduct(null);
        bBody.setInformationSources(null);

        body = mapper.mapOutData(bBody);

        Assert.assertNull(body.getPerson());
        Assert.assertNull(body.getProduct());
        Assert.assertNull(body.getInformationSources());
    }

}



class DummyMock {

    public Body getBody() {
        Body body = new Body();

        Person person = new Person();
        person.setFirstName("Christian");
        person.setMiddleName("David");
        person.setLastName("Rojas");

        IdentityDocument identityDocument = new IdentityDocument();
        identityDocument.setDocumentType("CC");
        identityDocument.setDocumentNumber("1235489345");
        person.setIdentityDocument(identityDocument);

        LaboralInformation laboralInformation = new LaboralInformation();
        laboralInformation.setCompanyId("800900231-5");
        laboralInformation.setDeclaratedIncome(Double.valueOf(5000000));
        person.setLaboralInformation(laboralInformation);

        body.setPerson(person);

        List<InformationSources> informationSourcesList = new ArrayList<>();
        InformationSources informationSources = new InformationSources();
        informationSources.setId("SOI");
        informationSources.setIsConsulted(false);
        informationSourcesList.add(informationSources);
        body.setInformationSources(informationSourcesList);


        Product product = new Product();
        product.setId("12");
        product.setName("hipotecas");
        body.setProduct(product);

        return body;
    }

    public BBody getBBody() {
        // Similar to getBody(), but creates BBody and its nested objects
        BBody bBody = new BBody();
        // ... set values for BPerson, BProduct, BInformationSources
        return bBody;
    }
}
