package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import java.util.List;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * <p>Bean fila para el campo tabular <code>participantInformation</code>, utilizado por la clase <code>Employers</code></p>
 * 
 * @see Employers
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
public class ParticipantInformation {
	
	/**
	 * <p>Campo <code>seniority</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "seniority", tipo = TipoCampo.DTO)
	private Seniority seniority;
	
	/**
	 * <p>Campo <code>incomes</code>, &iacute;ndice: <code>2</code>, tipo: <code>TABULAR</code>
	 */
	@Campo(indice = 2, nombre = "incomes", tipo = TipoCampo.TABULAR)
	private List<Incomes> incomes;
	
	/**
	 * <p>Campo <code>deduction</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "deduction", tipo = TipoCampo.DTO)
	private Deduction deduction;
	
	/**
	 * <p>Campo <code>employmentSituation</code>, &iacute;ndice: <code>4</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 4, nombre = "employmentSituation", tipo = TipoCampo.DTO)
	private EmploymentSituation employmentSituation;
	
	/**
	 * <p>Campo <code>dateRelationship</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "dateRelationship", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 10, signo = true, obligatorio = true)
	private String dateRelationship;
	

	public Seniority getSeniority() {
	    return seniority;
	}

	public void setSeniority(Seniority seniority) {
    	this.seniority = seniority;
	}

	public List<Incomes> getIncomes() {
	    return incomes;
	}

	public void setIncomes(List<Incomes> incomes) {
    	this.incomes = incomes;
	}

	public Deduction getDeduction() {
	    return deduction;
	}

	public void setDeduction(Deduction deduction) {
    	this.deduction = deduction;
	}

	public EmploymentSituation getEmploymentSituation() {
	    return employmentSituation;
	}

	public void setEmploymentSituation(EmploymentSituation employmentSituation) {
    	this.employmentSituation = employmentSituation;
	}

	public String getDateRelationship() {
	    return dateRelationship;
	}

	public void setDateRelationship(String dateRelationship) {
    	this.dateRelationship = dateRelationship;
	}
}