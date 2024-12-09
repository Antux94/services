package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>seniority</code>, utilizado por la clase <code>ParticipantInformation</code></p>
 * 
 * @see ParticipantInformation
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class Seniority {
	
	/**
	 * <p>Campo <code>number</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "number", tipo = TipoCampo.ENTERO, longitudMaxima = 15, signo = true, obligatorio = true)
	private long number;
	
	/**
	 * <p>Campo <code>period</code>, &iacute;ndice: <code>2</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 2, nombre = "period", tipo = TipoCampo.DTO)
	private Period period;
	

	public long getNumber() {
	    return number;
	}

	public void setNumber(long number) {
    	this.number = number;
	}

	public Period getPeriod() {
	    return period;
	}

	public void setPeriod(Period period) {
    	this.period = period;
	}
}