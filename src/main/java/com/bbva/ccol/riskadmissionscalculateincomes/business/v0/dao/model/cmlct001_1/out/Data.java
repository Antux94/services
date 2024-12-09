package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import java.util.List;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>data</code>, utilizado por la clase <code>ResponseTransactionCmlct001_1</code></p>
 * 
 * @see ResponseTransactionCmlct001_1
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class Data {
	
	/**
	 * <p>Campo <code>person</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "person", tipo = TipoCampo.DTO)
	private Person person;
	
	/**
	 * <p>Campo <code>informationSources</code>, &iacute;ndice: <code>2</code>, tipo: <code>TABULAR</code>
	 */
	@Campo(indice = 2, nombre = "informationSources", tipo = TipoCampo.TABULAR)
	private List<InformationSources> informationSources;
	
	/**
	 * <p>Campo <code>totalIncomes</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "totalIncomes", tipo = TipoCampo.DTO)
	private TotalIncomes totalIncomes;
	
	/**
	 * <p>Campo <code>totalDeductions</code>, &iacute;ndice: <code>4</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 4, nombre = "totalDeductions", tipo = TipoCampo.DTO)
	private TotalDeductions totalDeductions;
	
	/**
	 * <p>Campo <code>employers</code>, &iacute;ndice: <code>5</code>, tipo: <code>TABULAR</code>
	 */
	@Campo(indice = 5, nombre = "employers", tipo = TipoCampo.TABULAR)
	private List<Employers> employers;
	
	/**
	 * <p>Campo <code>employmentHistory</code>, &iacute;ndice: <code>6</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 6, nombre = "employmentHistory", tipo = TipoCampo.DTO)
	private EmploymentHistory employmentHistory;
	
	/**
	 * <p>Campo <code>status</code>, &iacute;ndice: <code>7</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 7, nombre = "status", tipo = TipoCampo.DTO)
	private Status status;
	

	public Person getPerson() {
	    return person;
	}

	public void setPerson(Person person) {
    	this.person = person;
	}

	public List<InformationSources> getInformationSources() {
	    return informationSources;
	}

	public void setInformationSources(List<InformationSources> informationSources) {
    	this.informationSources = informationSources;
	}

	public TotalIncomes getTotalIncomes() {
	    return totalIncomes;
	}

	public void setTotalIncomes(TotalIncomes totalIncomes) {
    	this.totalIncomes = totalIncomes;
	}

	public TotalDeductions getTotalDeductions() {
	    return totalDeductions;
	}

	public void setTotalDeductions(TotalDeductions totalDeductions) {
    	this.totalDeductions = totalDeductions;
	}

	public List<Employers> getEmployers() {
	    return employers;
	}

	public void setEmployers(List<Employers> employers) {
    	this.employers = employers;
	}

	public EmploymentHistory getEmploymentHistory() {
	    return employmentHistory;
	}

	public void setEmploymentHistory(EmploymentHistory employmentHistory) {
    	this.employmentHistory = employmentHistory;
	}

	public Status getStatus() {
	    return status;
	}

	public void setStatus(Status status) {
    	this.status = status;
	}
}