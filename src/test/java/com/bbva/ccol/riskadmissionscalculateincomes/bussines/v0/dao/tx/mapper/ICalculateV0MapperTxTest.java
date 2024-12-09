
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
        RequestTransactionCmlct001_1 dtoInt = dummyMock.getRequestTransactionCmlct001_1();
        BBody bBody = mapper.mapInApxData(dtoInt);

        Assert.assertEquals(dtoInt.getPerson().getFirstName(), bBody.getPerson().getFirstName());
        Assert.assertEquals(dtoInt.getPerson().getMiddleName(), bBody.getPerson().getMiddleName());
        Assert.assertEquals(dtoInt.getPerson().getLastName(), bBody.getPerson().getLastName());

        Assert.assertEquals(dtoInt.getPerson().getIdentityDocument().getDocumentType(), bBody.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(dtoInt.getPerson().getIdentityDocument().getDocumentNumber(), bBody.getPerson().getIdentityDocument().getDocumentNumber());

        Assert.assertEquals(dtoInt.getPerson().getLaboralInformation().getCompanyId(), bBody.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(Double.valueOf(dtoInt.getPerson().getLaboralInformation().getDeclaratedIncome()), bBody.getPerson().getLaboralInformation().getDeclaratedIncome());


        Assert.assertEquals(dtoInt.getInformationSources().get(0).getId(), bBody.getInformationSources().get(0).getId());
        Assert.assertEquals(Boolean.valueOf(dtoInt.getInformationSources().get(0).getIsConsulted()), bBody.getInformationSources().get(0).getIsConsulted());

        Assert.assertEquals(dtoInt.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(dtoInt.getProduct().getName(), bBody.getProduct().getName());
    }


    @Test
    public void testMapInApxDataWithNulls() {
        RequestTransactionCmlct001_1 dtoInt = new RequestTransactionCmlct001_1();
        BBody bBody = mapper.mapInApxData(dtoInt);
        Assert.assertNull(bBody);


        dtoInt = dummyMock.getRequestTransactionCmlct001_1();
        dtoInt.setPerson(null);
        bBody = mapper.mapInApxData(dtoInt);
        Assert.assertNull(bBody.getPerson());

        dtoInt = dummyMock.getRequestTransactionCmlct001_1();
        dtoInt.setInformationSources(null);
        bBody = mapper.mapInApxData(dtoInt);
        Assert.assertNull(bBody.getInformationSources());

        dtoInt = dummyMock.getRequestTransactionCmlct001_1();
        dtoInt.setProduct(null);
        bBody = mapper.mapInApxData(dtoInt);
        Assert.assertNull(bBody.getProduct());

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
