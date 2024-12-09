package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>economicActivity</code>, utilizado por la clase <code>EmployerInfo</code></p>
 * 
 * @see EmployerInfo
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class EconomicActivity {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String id;
	
	/**
	 * <p>Campo <code>name</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "name", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String name;
	
	/**
	 * <p>Campo <code>internationalClassification</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "internationalClassification", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String internationalClassification;
	

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

	public String getInternationalClassification() {
	    return internationalClassification;
	}

	public void setInternationalClassification(String internationalClassification) {
    	this.internationalClassification = internationalClassification;
	}
}