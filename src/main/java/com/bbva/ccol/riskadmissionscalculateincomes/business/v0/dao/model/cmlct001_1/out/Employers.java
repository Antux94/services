package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>employers</code>, utilizado por la clase <code>Employers</code></p>
 * 
 * @see Employers
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class Employers {
	
	/**
	 * <p>Campo <code>employerInfo</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "employerInfo", tipo = TipoCampo.DTO)
	private EmployerInfo employerInfo;
	
	/**
	 * <p>Campo <code>participantInformation</code>, &iacute;ndice: <code>2</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 2, nombre = "participantInformation", tipo = TipoCampo.DTO)
	private ParticipantInformation participantInformation;
	

	public EmployerInfo getEmployerInfo() {
	    return employerInfo;
	}

	public void setEmployerInfo(EmployerInfo employerInfo) {
    	this.employerInfo = employerInfo;
	}

	public ParticipantInformation getParticipantInformation() {
	    return participantInformation;
	}

	public void setParticipantInformation(ParticipantInformation participantInformation) {
    	this.participantInformation = participantInformation;
	}
}