
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto;

import java.util.List;

public class BInformationSources {
    
    private String id;
    private Boolean isConsulted;
    
public BInformationSources() {}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public Boolean getIsConsulted() {
    return isConsulted;
}

public void setIsConsulted(Boolean isConsulted) {
    this.isConsulted = isConsulted;
}

@Override
public String toString() {
    return "BInformationSources{" +
    "id='" + id + '\'' +
    ", isConsulted=" + isConsulted +
    '}';
}
}

