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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T00:31:32-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class IPostRiskAdmissionsCalculateIncomesMapperImpl implements IPostRiskAdmissionsCalculateIncomesMapper {

    @Override
    public BBody mapInData(Body dto) {
        if ( dto == null ) {
            return null;
        }

        BBody bBody = new BBody();

        bBody.setPerson( personToBPerson( dto.getPerson() ) );
        bBody.setInformationSources( informationSourcesListToBInformationSourcesList( dto.getInformationSources() ) );
        bBody.setProduct( productToBProduct( dto.getProduct() ) );

        return bBody;
    }

    @Override
    public Body mapOutData(BBody dtoInt) {
        if ( dtoInt == null ) {
            return null;
        }

        Body body = new Body();

        body.setPerson( bPersonToPerson( dtoInt.getPerson() ) );
        body.setInformationSources( bInformationSourcesListToInformationSourcesList( dtoInt.getInformationSources() ) );
        body.setProduct( bProductToProduct( dtoInt.getProduct() ) );

        return body;
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
        bLaboralInformation.setDeclaratedIncome( laboralInformation.getDeclaratedIncome() );

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
        bInformationSources.setIsConsulted( informationSources.getIsConsulted() );

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
        laboralInformation.setDeclaratedIncome( bLaboralInformation.getDeclaratedIncome() );

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
        informationSources.setIsConsulted( bInformationSources.getIsConsulted() );

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
