package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>status</code>, utilizado por la clase <code>Data</code></p>
 * 
 * @see Data
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class Status {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true)
	private String id;
	
	/**
	 * <p>Campo <code>description</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "description", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true)
	private String description;
	

	public String getId() {
	    return id;
	}

	public void setId(String id) {
    	this.id = id;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
    	this.description = description;
	}
}