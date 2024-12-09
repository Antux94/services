
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
        Assert.assertEquals(Long.valueOf(body.getPerson().getLaboralInformation().getDeclaratedIncome().longValue()), bBody.getPerson().getLaboralInformation().getDeclaratedIncome());

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
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome(), Long.valueOf(body.getPerson().getLaboralInformation().getDeclaratedIncome().longValue()));

        for (int i = 0; i < bBody.getInformationSources().size(); i++) {
            Assert.assertEquals(bBody.getInformationSources().get(i).getId(), body.getInformationSources().get(i).getId());
            Assert.assertEquals(bBody.getInformationSources().get(i).getIsConsulted(), body.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(bBody.getProduct().getId(), body.getProduct().getId());
        Assert.assertEquals(bBody.getProduct().getName(), body.getProduct().getName());
    }


    public class DummyMock {
        private Body body;
        private BBody bBody;

        public void init() {
            body = new Body();
            bBody = new BBody();

            // Body Data
            Person person = new Person();
            person.setFirstName("John");
            person.setMiddleName("Doe");
            person.setLastName("Smith");

            IdentityDocument identityDocument = new IdentityDocument();
            identityDocument.setDocumentType("Passport");
            identityDocument.setDocumentNumber("123456789");
            person.setIdentityDocument(identityDocument);

            LaboralInformation laboralInformation = new LaboralInformation();
            laboralInformation.setCompanyId("ACME Corp");
            laboralInformation.setDeclaratedIncome(Double.valueOf("50000"));
            person.setLaboralInformation(laboralInformation);
            body.setPerson(person);


            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("source1");
            informationSources.setIsConsulted(Boolean.TRUE);
            informationSourcesList.add(informationSources);
            body.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("product1");
            product.setName("Loan");
            body.setProduct(product);

            //BBody Data - Mirroring Body data with necessary type conversions
            BPerson bPerson = new BPerson();
            bPerson.setFirstName("John");
            bPerson.setMiddleName("Doe");
            bPerson.setLastName("Smith");

            BIdentityDocument bIdentityDocument = new BIdentityDocument();
            bIdentityDocument.setDocumentType("Passport");
            bIdentityDocument.setDocumentNumber("123456789");
            bPerson.setIdentityDocument(bIdentityDocument);

            BLaboralInformation bLaboralInformation = new BLaboralInformation();
            bLaboralInformation.setCompanyId("ACME Corp");
            bLaboralInformation.setDeclaratedIncome(50000L);
            bPerson.setLaboralInformation(bLaboralInformation);
            bBody.setPerson(bPerson);

            List<BInformationSources> bInformationSourcesList = new ArrayList<>();
            BInformationSources bInformationSources = new BInformationSources();
            bInformationSources.setId("source1");
            bInformationSources.setIsConsulted(Boolean.TRUE);
            bInformationSourcesList.add(bInformationSources);
            bBody.setInformationSources(bInformationSourcesList);

            BProduct bProduct = new BProduct();
            bProduct.setId("product1");
            bProduct.setName("Loan");
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
