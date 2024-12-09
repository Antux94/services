package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>informationSources</code>, utilizado por la clase <code>InformationSources</code></p>
 * 
 * @see InformationSources
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class InformationSources {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String id;
	
	/**
	 * <p>Campo <code>isConsulted</code>, &iacute;ndice: <code>2</code>, tipo: <code>BOOLEAN</code>
	 */
	@Campo(indice = 2, nombre = "isConsulted", tipo = TipoCampo.BOOLEAN, signo = true, obligatorio = true)
	private Boolean isConsulted;
	

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
}