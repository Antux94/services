
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto;

import java.util.List;

public class BProduct {
    
    private String id;
    private String name;
    
public BProduct() {}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "BProduct{" +
    "id='" + id + '\'' +
    ", name='" + name + '\'' +
    '}';
}
}

