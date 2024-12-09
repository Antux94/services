
package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto;

import java.util.List;

public class InformationSources {
    
    private String id;
    private Boolean isConsulted;
    
public InformationSources() {}

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
    return "InformationSources{" +
    "id='" + id + '\'' +
    ", isConsulted=" + isConsulted +
    '}';
}
}

