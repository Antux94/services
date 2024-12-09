package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>laboralInformation</code>, utilizado por la clase <code>Person</code></p>
 * 
 * @see Person
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class LaboralInformation {
	
	/**
	 * <p>Campo <code>companyId</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "companyId", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true)
	private String companyId;
	
	/**
	 * <p>Campo <code>declaratedIncome</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "declaratedIncome", tipo = TipoCampo.ENTERO, longitudMaxima = 15, signo = true)
	private Long declaratedIncome;
	

	public String getCompanyId() {
	    return companyId;
	}

	public void setCompanyId(String companyId) {
    	this.companyId = companyId;
	}

	public Long getDeclaratedIncome() {
	    return declaratedIncome;
	}

	public void setDeclaratedIncome(Long declaratedIncome) {
    	this.declaratedIncome = declaratedIncome;
	}
}