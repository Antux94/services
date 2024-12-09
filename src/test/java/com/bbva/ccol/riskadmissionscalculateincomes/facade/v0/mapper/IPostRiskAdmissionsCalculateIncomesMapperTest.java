
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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IPostRiskAdmissionsCalculateIncomesMapperTest {

    private IPostRiskAdmissionsCalculateIncomesMapper mapper = Mappers.getMapper(IPostRiskAdmissionsCalculateIncomesMapper.class);

    private DummyMock dummyMock = new DummyMock();

    @Before
    public void setUp() {
        dummyMock.init();
    }

    @Test
    public void testMapInData() {
        Body body = dummyMock.getBody();
        BBody bBody = mapper.mapInData(body);

        Assert.assertEquals(body.getPerson().getIdentityDocument().getDocumentType(), bBody.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(body.getPerson().getIdentityDocument().getDocumentNumber(), bBody.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(body.getPerson().getFirstName(), bBody.getPerson().getFirstName());
        Assert.assertEquals(body.getPerson().getMiddleName(), bBody.getPerson().getMiddleName());
        Assert.assertEquals(body.getPerson().getLastName(), bBody.getPerson().getLastName());
        Assert.assertEquals(body.getPerson().getLaboralInformation().getCompanyId(), bBody.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(body.getPerson().getLaboralInformation().getDeclaratedIncome(), bBody.getPerson().getLaboralInformation().getDeclaratedIncome());

        for (int i = 0; i < body.getInformationSources().size(); i++) {
            Assert.assertEquals(body.getInformationSources().get(i).getId(), bBody.getInformationSources().get(i).getId());
            Assert.assertEquals(body.getInformationSources().get(i).getIsConsulted(), bBody.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(body.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(body.getProduct().getName(), bBody.getProduct().getName());

    }

    @Test
    public void testMapOutData() {
        BBody bBody = dummyMock.getBBody();
        Body body = mapper.mapOutData(bBody);

        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentType(), body.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentNumber(), body.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(bBody.getPerson().getFirstName(), body.getPerson().getFirstName());
        Assert.assertEquals(bBody.getPerson().getMiddleName(), body.getPerson().getMiddleName());
        Assert.assertEquals(bBody.getPerson().getLastName(), body.getPerson().getLastName());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getCompanyId(), body.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome(), body.getPerson().getLaboralInformation().getDeclaratedIncome());

        for (int i = 0; i < bBody.getInformationSources().size(); i++) {
            Assert.assertEquals(bBody.getInformationSources().get(i).getId(), body.getInformationSources().get(i).getId());
            Assert.assertEquals(bBody.getInformationSources().get(i).getIsConsulted(), body.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(bBody.getProduct().getId(), body.getProduct().getId());
        Assert.assertEquals(bBody.getProduct().getName(), body.getProduct().getName());
    }


    class DummyMock {
        private Body body;
        private BBody bBody;


        public void init() {
            body = new Body();
            bBody = new BBody();

            // Body
            Person person = new Person();
            person.setIdentityDocument(new IdentityDocument());
            person.getIdentityDocument().setDocumentType("P");
            person.getIdentityDocument().setDocumentNumber("123456789");
            person.setFirstName("John");
            person.setMiddleName("M");
            person.setLastName("Doe");
            person.setLaboralInformation(new LaboralInformation());
            person.getLaboralInformation().setCompanyId("BBVA");
            person.getLaboralInformation().setDeclaratedIncome(1000.00);
            body.setPerson(person);

            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("1");
            informationSources.setIsConsulted(true);
            informationSourcesList.add(informationSources);
            body.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("prod1");
            product.setName("Product 1");
            body.setProduct(product);


            // BBody
            BPerson bPerson = new BPerson();
            bPerson.setIdentityDocument(new BIdentityDocument());
            bPerson.getIdentityDocument().setDocumentType("P");
            bPerson.getIdentityDocument().setDocumentNumber("123456789");
            bPerson.setFirstName("John");
            bPerson.setMiddleName("M");
            bPerson.setLastName("Doe");
            bPerson.setLaboralInformation(new BLaboralInformation());
            bPerson.getLaboralInformation().setCompanyId("BBVA");
            bPerson.getLaboralInformation().setDeclaratedIncome(1000L);
            bBody.setPerson(bPerson);

            List<BInformationSources> bInformationSourcesList = new ArrayList<>();
            BInformationSources bInformationSources = new BInformationSources();
            bInformationSources.setId("1");
            bInformationSources.setIsConsulted("true");
            bInformationSourcesList.add(bInformationSources);
            bBody.setInformationSources(bInformationSourcesList);

            BProduct bProduct = new BProduct();
            bProduct.setId("prod1");
            bProduct.setName("Product 1");
            bBody.setProduct(bProduct);
        }

        public Body getBody() {
            return body;
        }

        public BBody getBBody() {
            return bBody;
        }
    }
}

