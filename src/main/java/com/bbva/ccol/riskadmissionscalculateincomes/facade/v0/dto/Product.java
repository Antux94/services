
package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto;

import java.util.List;

public class Product {
    
    private String id;
    private String name;
    
public Product() {}

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
    return "Product{" +
    "id='" + id + '\'' +
    ", name='" + name + '\'' +
    '}';
}
}

