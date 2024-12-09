
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto;

import java.util.List;

public class BLaboralInformation {
    
    private String companyId;
    private Double declaratedIncome;
    
public BLaboralInformation() {}

public String getCompanyId() {
    return companyId;
}

public void setCompanyId(String companyId) {
    this.companyId = companyId;
}

public Double getDeclaratedIncome() {
    return declaratedIncome;
}

public void setDeclaratedIncome(Double declaratedIncome) {
    this.declaratedIncome = declaratedIncome;
}

@Override
public String toString() {
    return "BLaboralInformation{" +
    "companyId='" + companyId + '\'' +
    ", declaratedIncome=" + declaratedIncome +
    '}';
}
}

