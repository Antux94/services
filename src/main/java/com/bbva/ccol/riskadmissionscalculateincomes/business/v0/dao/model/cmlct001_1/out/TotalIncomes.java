package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>totalIncomes</code>, utilizado por la clase <code>Data</code></p>
 * 
 * @see Data
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class TotalIncomes {
	
	/**
	 * <p>Campo <code>amount</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "amount", tipo = TipoCampo.ENTERO, longitudMaxima = 15, signo = true, obligatorio = true)
	private long amount;
	
	/**
	 * <p>Campo <code>currency</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "currency", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String currency;
	

	public long getAmount() {
	    return amount;
	}

	public void setAmount(long amount) {
    	this.amount = amount;
	}

	public String getCurrency() {
	    return currency;
	}

	public void setCurrency(String currency) {
    	this.currency = currency;
	}
}