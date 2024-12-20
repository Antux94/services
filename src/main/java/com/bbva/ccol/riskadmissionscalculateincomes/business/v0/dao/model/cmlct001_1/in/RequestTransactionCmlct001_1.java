package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.*;
import java.util.List;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Transaccion;

/**
 * <p>Transacci&oacute;n <code>CMLCT001</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> RequestTransactionCmlct001_1</li>
 *    <li><b>Clase de respuesta:</b> ResponseTransactionCmlct001_1</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_apx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: CMLCT001-01-CO.xml
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;yes&quot;?&gt;
 * &lt;transaction xmlns=&quot;http://www.w3schools.com&quot; transactionName=&quot;CMLCT001&quot; application=&quot;CMLC&quot; version=&quot;01&quot; country=&quot;CO&quot; language=&quot;ES&quot;&gt;
 * &lt;paramsIn&gt;
 * &lt;dto order=&quot;1&quot; name=&quot;person&quot; mandatory=&quot;1&quot; package=&quot;com.bbva.cmlc.dto.c001.PersonDTO&quot; artifactId=&quot;CMLCC001&quot;&gt;
 * &lt;dto order=&quot;1&quot; name=&quot;identityDocument&quot; mandatory=&quot;1&quot; package=&quot;com.bbva.cmlc.dto.c001.IdentityDocumentDTO&quot; artifactId=&quot;CMLCC001&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;documentType&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;documentNumber&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;firstName&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;parameter order=&quot;3&quot; name=&quot;middleName&quot; mandatory=&quot;0&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;parameter order=&quot;4&quot; name=&quot;lastName&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;dto order=&quot;5&quot; name=&quot;laboralInformation&quot; mandatory=&quot;0&quot; package=&quot;com.bbva.cmlc.dto.c001.LaboralInformationDTO&quot; artifactId=&quot;CMLCC001&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;companyId&quot; mandatory=&quot;0&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;declaratedIncome&quot; mandatory=&quot;0&quot; type=&quot;Long&quot; size=&quot;15&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;list order=&quot;2&quot; name=&quot;informationSources&quot; mandatory=&quot;1&quot;&gt;
 * &lt;dto order=&quot;1&quot; name=&quot;Type&quot; mandatory=&quot;1&quot; package=&quot;com.bbva.cmlc.dto.c001.InformationSourcesDTO&quot; artifactId=&quot;CMLCC001&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;isConsulted&quot; mandatory=&quot;0&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/list&gt;
 * &lt;dto order=&quot;3&quot; name=&quot;product&quot; mandatory=&quot;0&quot; package=&quot;com.bbva.cmlc.dto.c001.ProductInDTO&quot; artifactId=&quot;CMLCC001&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;name&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;255&quot;/&gt;
 * &lt;/dto&gt;
 * 
 * &lt;/paramsIn&gt;
 * &lt;paramsOut&gt;
 * &lt;/paramsOut&gt;
 * &lt;description&gt;For RiskAdmission&lt;/description&gt;
 * &lt;/transaction&gt;
</pre></code>
 * 
 * @see ResponseTransactionCmlct001_1
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "CMLCT001",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_apx",
	respuesta = ResponseTransactionCmlct001_1.class,
	atributos = {@Atributo(nombre = "country", valor = "CO")}
)
public class RequestTransactionCmlct001_1 {
		
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
	 * <p>Campo <code>product</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "product", tipo = TipoCampo.DTO)
	private Product product;
	

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

	public Product getProduct() {
	    return product;
	}

	public void setProduct(Product product) {
    	this.product = product;
	}
}