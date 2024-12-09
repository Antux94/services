
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.tx.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.IdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.InformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.LaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.Person;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.Product;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.RequestTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BBody;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BIdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BInformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BLaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BPerson;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BProduct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ICalculateV0MapperTxTest {

    private ICalculateV0MapperTx mapper = Mappers.getMapper(ICalculateV0MapperTx.class);

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void testMapInApxData() {
        RequestTransactionCmlct001_1 source = dummyMock.getRequestTransactionCmlct001_1();
        BBody destination = mapper.mapInApxData(source);

        Assert.assertNotNull(destination);

        BPerson destinationPerson = destination.getPerson();
        Person sourcePerson = source.getPerson();
        Assert.assertNotNull(destinationPerson);
        Assert.assertEquals(sourcePerson.getFirstName(), destinationPerson.getFirstName());
        Assert.assertEquals(sourcePerson.getMiddleName(), destinationPerson.getMiddleName());
        Assert.assertEquals(sourcePerson.getLastName(), destinationPerson.getLastName());

        BIdentityDocument destinationIdentityDocument = destinationPerson.getIdentityDocument();
        IdentityDocument sourceIdentityDocument = sourcePerson.getIdentityDocument();
        Assert.assertNotNull(destinationIdentityDocument);
        Assert.assertEquals(sourceIdentityDocument.getDocumentType(), destinationIdentityDocument.getDocumentType());
        Assert.assertEquals(sourceIdentityDocument.getDocumentNumber(), destinationIdentityDocument.getDocumentNumber());

        BLaboralInformation destinationLaboralInformation = destinationPerson.getLaboralInformation();
        LaboralInformation sourceLaboralInformation = sourcePerson.getLaboralInformation();
        Assert.assertNotNull(destinationLaboralInformation);
        Assert.assertEquals(sourceLaboralInformation.getCompanyId(), destinationLaboralInformation.getCompanyId());
        Assert.assertEquals(sourceLaboralInformation.getDeclaratedIncome(), (Long)Math.round(destinationLaboralInformation.getDeclaratedIncome()));


        List<BInformationSources> destinationInformationSources = destination.getInformationSources();
        List<InformationSources> sourceInformationSources = source.getInformationSources();
        Assert.assertNotNull(destinationInformationSources);
        Assert.assertEquals(sourceInformationSources.size(), destinationInformationSources.size());
        for (int i = 0; i < sourceInformationSources.size(); i++) {
            Assert.assertEquals(sourceInformationSources.get(i).getId(), destinationInformationSources.get(i).getId());
            Assert.assertEquals(Boolean.valueOf(sourceInformationSources.get(i).getIsConsulted()), destinationInformationSources.get(i).getIsConsulted());
        }

        BProduct destinationProduct = destination.getProduct();
        Product sourceProduct = source.getProduct();
        Assert.assertNotNull(destinationProduct);
        Assert.assertEquals(sourceProduct.getId(), destinationProduct.getId());
        Assert.assertEquals(sourceProduct.getName(), destinationProduct.getName());
    }


    private class DummyMock {

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
            RequestTransactionCmlct001_1 request = new RequestTransactionCmlct001_1();

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
            laboralInformation.setDeclaratedIncome(5000000L);
            person.setLaboralInformation(laboralInformation);
            request.setPerson(person);


            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("SOI");
            informationSources.setIsConsulted("false");
            informationSourcesList.add(informationSources);
            request.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("12");
            product.setName("hipotecas");
            request.setProduct(product);

            return request;
        }
    }
}
