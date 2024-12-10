package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto;

import java.util.List;

public class IdentityDocument {
    
    private String documentType;
    private String documentNumber;
    
public IdentityDocument() {}

public String getDocumentType() {
    return documentType;
}

public void setDocumentType(String documentType) {
    this.documentType = documentType;
}

public String getDocumentNumber() {
    return documentNumber;
}

public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
}
}
