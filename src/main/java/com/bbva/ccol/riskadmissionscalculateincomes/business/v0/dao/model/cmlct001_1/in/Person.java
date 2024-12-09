package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>person</code>, utilizado por la clase <code>RequestTransactionCmlct001_1</code></p>
 * 
 * @see RequestTransactionCmlct001_1
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class Person {
	
	/**
	 * <p>Campo <code>identityDocument</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "identityDocument", tipo = TipoCampo.DTO)
	private IdentityDocument identityDocument;
	
	/**
	 * <p>Campo <code>firstName</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "firstName", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String firstName;
	
	/**
	 * <p>Campo <code>middleName</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "middleName", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true)
	private String middleName;
	
	/**
	 * <p>Campo <code>lastName</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "lastName", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String lastName;
	
	/**
	 * <p>Campo <code>laboralInformation</code>, &iacute;ndice: <code>5</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 5, nombre = "laboralInformation", tipo = TipoCampo.DTO)
	private LaboralInformation laboralInformation;
	

	public IdentityDocument getIdentityDocument() {
	    return identityDocument;
	}

	public void setIdentityDocument(IdentityDocument identityDocument) {
    	this.identityDocument = identityDocument;
	}

	public String getFirstName() {
	    return firstName;
	}

	public void setFirstName(String firstName) {
    	this.firstName = firstName;
	}

	public String getMiddleName() {
	    return middleName;
	}

	public void setMiddleName(String middleName) {
    	this.middleName = middleName;
	}

	public String getLastName() {
	    return lastName;
	}

	public void setLastName(String lastName) {
    	this.lastName = lastName;
	}

	public LaboralInformation getLaboralInformation() {
	    return laboralInformation;
	}

	public void setLaboralInformation(LaboralInformation laboralInformation) {
    	this.laboralInformation = laboralInformation;
	}
}