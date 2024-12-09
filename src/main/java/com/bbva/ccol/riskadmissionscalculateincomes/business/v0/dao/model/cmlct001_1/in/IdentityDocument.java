package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>identityDocument</code>, utilizado por la clase <code>Person</code></p>
 * 
 * @see Person
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class IdentityDocument {
	
	/**
	 * <p>Campo <code>documentType</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "documentType", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String documentType;
	
	/**
	 * <p>Campo <code>documentNumber</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "documentNumber", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String documentNumber;
	

	public String getDocumentType() {
	    return documentType;
	}

	public void setDocumentType(String documentType) {
    	this.documentType = documentType;
	}

	public String getDocumentNumber() {
	    return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
    	this.documentNumber = documentNumber;
	}
}