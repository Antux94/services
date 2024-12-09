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
    date = "2024-12-09T00:41:50-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ICalculateV0MapperTxImpl implements ICalculateV0MapperTx {

    @Override
    public BBody mapInApxData(RequestTransactionCmlct001_1 dtoInt) {
        if ( dtoInt == null ) {
            return null;
        }

        BBody bBody = new BBody();

        bBody.setPerson( personToBPerson( dtoInt.getPerson() ) );
        bBody.setInformationSources( informationSourcesListToBInformationSourcesList( dtoInt.getInformationSources() ) );
        bBody.setProduct( productToBProduct( dtoInt.getProduct() ) );

        return bBody;
    }

    protected BIdentityDocument identityDocumentToBIdentityDocument(IdentityDocument identityDocument) {
        if ( identityDocument == null ) {
            return null;
        }

        BIdentityDocument bIdentityDocument = new BIdentityDocument();

        bIdentityDocument.setDocumentType( identityDocument.getDocumentType() );
        bIdentityDocument.setDocumentNumber( identityDocument.getDocumentNumber() );

        return bIdentityDocument;
    }

    protected BLaboralInformation laboralInformationToBLaboralInformation(LaboralInformation laboralInformation) {
        if ( laboralInformation == null ) {
            return null;
        }

        BLaboralInformation bLaboralInformation = new BLaboralInformation();

        bLaboralInformation.setCompanyId( laboralInformation.getCompanyId() );
        if ( laboralInformation.getDeclaratedIncome() != null ) {
            bLaboralInformation.setDeclaratedIncome( laboralInformation.getDeclaratedIncome().doubleValue() );
        }

        return bLaboralInformation;
    }

    protected BPerson personToBPerson(Person person) {
        if ( person == null ) {
            return null;
        }

        BPerson bPerson = new BPerson();

        bPerson.setIdentityDocument( identityDocumentToBIdentityDocument( person.getIdentityDocument() ) );
        bPerson.setFirstName( person.getFirstName() );
        bPerson.setMiddleName( person.getMiddleName() );
        bPerson.setLastName( person.getLastName() );
        bPerson.setLaboralInformation( laboralInformationToBLaboralInformation( person.getLaboralInformation() ) );

        return bPerson;
    }

    protected BInformationSources informationSourcesToBInformationSources(InformationSources informationSources) {
        if ( informationSources == null ) {
            return null;
        }

        BInformationSources bInformationSources = new BInformationSources();

        bInformationSources.setId( informationSources.getId() );
        if ( informationSources.getIsConsulted() != null ) {
            bInformationSources.setIsConsulted( Boolean.parseBoolean( informationSources.getIsConsulted() ) );
        }

        return bInformationSources;
    }

    protected List<BInformationSources> informationSourcesListToBInformationSourcesList(List<InformationSources> list) {
        if ( list == null ) {
            return null;
        }

        List<BInformationSources> list1 = new ArrayList<BInformationSources>( list.size() );
        for ( InformationSources informationSources : list ) {
            list1.add( informationSourcesToBInformationSources( informationSources ) );
        }

        return list1;
    }

    protected BProduct productToBProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        BProduct bProduct = new BProduct();

        bProduct.setId( product.getId() );
        bProduct.setName( product.getName() );

        return bProduct;
    }
}
