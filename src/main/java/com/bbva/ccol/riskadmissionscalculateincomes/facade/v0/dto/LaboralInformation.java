
package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto;

import java.util.List;

public class LaboralInformation {
    
    private String companyId;
    private Double declaratedIncome;
    
public LaboralInformation() {}

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
}

