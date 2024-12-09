package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>incomes</code>, utilizado por la clase <code>Incomes</code></p>
 * 
 * @see Incomes
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class Incomes {
	
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
	 * <p>Campo <code>incomeAmount</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "incomeAmount", tipo = TipoCampo.DTO)
	private IncomeAmount incomeAmount;
	
	/**
	 * <p>Campo <code>frecuency</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "frecuency", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String frecuency;
	

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

	public IncomeAmount getIncomeAmount() {
	    return incomeAmount;
	}

	public void setIncomeAmount(IncomeAmount incomeAmount) {
    	this.incomeAmount = incomeAmount;
	}

	public String getFrecuency() {
	    return frecuency;
	}

	public void setFrecuency(String frecuency) {
    	this.frecuency = frecuency;
	}
}