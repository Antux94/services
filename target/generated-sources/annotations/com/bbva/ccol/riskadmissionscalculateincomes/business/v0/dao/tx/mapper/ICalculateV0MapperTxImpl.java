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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T01:18:22-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ICalculateV0MapperTxImpl implements ICalculateV0MapperTx {

    @Override
    public RequestTransactionCmlct001_1 mapInApxData(BBody dtoInt) {
        if ( dtoInt == null ) {
            return null;
        }

        RequestTransactionCmlct001_1 requestTransactionCmlct001_1 = new RequestTransactionCmlct001_1();

        requestTransactionCmlct001_1.setPerson( bPersonToPerson( dtoInt.getPerson() ) );
        requestTransactionCmlct001_1.setInformationSources( bInformationSourcesListToInformationSourcesList( dtoInt.getInformationSources() ) );
        requestTransactionCmlct001_1.setProduct( bProductToProduct( dtoInt.getProduct() ) );

        return requestTransactionCmlct001_1;
    }

    protected IdentityDocument bIdentityDocumentToIdentityDocument(BIdentityDocument bIdentityDocument) {
        if ( bIdentityDocument == null ) {
            return null;
        }

        IdentityDocument identityDocument = new IdentityDocument();

        identityDocument.setDocumentType( bIdentityDocument.getDocumentType() );
        identityDocument.setDocumentNumber( bIdentityDocument.getDocumentNumber() );

        return identityDocument;
    }

    protected LaboralInformation bLaboralInformationToLaboralInformation(BLaboralInformation bLaboralInformation) {
        if ( bLaboralInformation == null ) {
            return null;
        }

        LaboralInformation laboralInformation = new LaboralInformation();

        laboralInformation.setCompanyId( bLaboralInformation.getCompanyId() );
        if ( bLaboralInformation.getDeclaratedIncome() != null ) {
            laboralInformation.setDeclaratedIncome( bLaboralInformation.getDeclaratedIncome().longValue() );
        }

        return laboralInformation;
    }

    protected Person bPersonToPerson(BPerson bPerson) {
        if ( bPerson == null ) {
            return null;
        }

        Person person = new Person();

        person.setIdentityDocument( bIdentityDocumentToIdentityDocument( bPerson.getIdentityDocument() ) );
        person.setFirstName( bPerson.getFirstName() );
        person.setMiddleName( bPerson.getMiddleName() );
        person.setLastName( bPerson.getLastName() );
        person.setLaboralInformation( bLaboralInformationToLaboralInformation( bPerson.getLaboralInformation() ) );

        return person;
    }

    protected InformationSources bInformationSourcesToInformationSources(BInformationSources bInformationSources) {
        if ( bInformationSources == null ) {
            return null;
        }

        InformationSources informationSources = new InformationSources();

        informationSources.setId( bInformationSources.getId() );
        if ( bInformationSources.getIsConsulted() != null ) {
            informationSources.setIsConsulted( String.valueOf( bInformationSources.getIsConsulted() ) );
        }

        return informationSources;
    }

    protected List<InformationSources> bInformationSourcesListToInformationSourcesList(List<BInformationSources> list) {
        if ( list == null ) {
            return null;
        }

        List<InformationSources> list1 = new ArrayList<InformationSources>( list.size() );
        for ( BInformationSources bInformationSources : list ) {
            list1.add( bInformationSourcesToInformationSources( bInformationSources ) );
        }

        return list1;
    }

    protected Product bProductToProduct(BProduct bProduct) {
        if ( bProduct == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( bProduct.getId() );
        product.setName( bProduct.getName() );

        return product;
    }
}
