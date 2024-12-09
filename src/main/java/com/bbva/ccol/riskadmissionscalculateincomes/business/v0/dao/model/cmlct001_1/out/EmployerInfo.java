package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>employerInfo</code>, utilizado por la clase <code>Employers</code></p>
 * 
 * @see Employers
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class EmployerInfo {
	
	/**
	 * <p>Campo <code>companyName</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "companyName", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String companyName;
	
	/**
	 * <p>Campo <code>identityDocument</code>, &iacute;ndice: <code>2</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 2, nombre = "identityDocument", tipo = TipoCampo.DTO)
	private IdentityDocument identityDocument;
	
	/**
	 * <p>Campo <code>economicActivity</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "economicActivity", tipo = TipoCampo.DTO)
	private EconomicActivity economicActivity;
	

	public String getCompanyName() {
	    return companyName;
	}

	public void setCompanyName(String companyName) {
    	this.companyName = companyName;
	}

	public IdentityDocument getIdentityDocument() {
	    return identityDocument;
	}

	public void setIdentityDocument(IdentityDocument identityDocument) {
    	this.identityDocument = identityDocument;
	}

	public EconomicActivity getEconomicActivity() {
	    return economicActivity;
	}

	public void setEconomicActivity(EconomicActivity economicActivity) {
    	this.economicActivity = economicActivity;
	}
}