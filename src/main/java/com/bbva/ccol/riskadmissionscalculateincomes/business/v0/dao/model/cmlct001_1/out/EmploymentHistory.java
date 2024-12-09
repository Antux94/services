package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>employmentHistory</code>, utilizado por la clase <code>Data</code></p>
 * 
 * @see Data
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class EmploymentHistory {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true)
	private String id;
	
	/**
	 * <p>Campo <code>timeContinuity</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "timeContinuity", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 15, signo = true)
	private String timeContinuity;
	
	/**
	 * <p>Campo <code>dateContinuity</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "dateContinuity", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 10, signo = true)
	private String dateContinuity;
	

	public String getId() {
	    return id;
	}

	public void setId(String id) {
    	this.id = id;
	}

	public String getTimeContinuity() {
	    return timeContinuity;
	}

	public void setTimeContinuity(String timeContinuity) {
    	this.timeContinuity = timeContinuity;
	}

	public String getDateContinuity() {
	    return dateContinuity;
	}

	public void setDateContinuity(String dateContinuity) {
    	this.dateContinuity = dateContinuity;
	}
}