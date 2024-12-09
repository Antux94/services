package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.*;
import com.bbva.jee.arq.spring.core.host.Cabecera;
import com.bbva.jee.arq.spring.core.host.NombreCabecera;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Bean de respuesta para la transacci&oacute;n <code>CMLCT001</code>
 * 
 * @see RequestTransactionCmlct001_1
 */
@RespuestaTransaccion
@Formato(nombre = "1")
public class ResponseTransactionCmlct001_1 {
	
	/**
	 * <p>Cabecera <code>COD-AVISO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_AVISO)
	private String codigoAviso;
	
	/**
	 * <p>Cabecera <code>DES-AVISO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.DESCRIPCION_AVISO)
	private String descripcionAviso;
	
	/**
	 * <p>Cabecera <code>COD-UUAA-AVISO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.APLICACION_AVISO)
	private String aplicacionAviso;
	
	/**
	 * <p>Cabecera <code>COD-RETORNO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_RETORNO)
	private String codigoRetorno;
	
	/**
	 * <p>Campo <code>data</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "data", tipo = TipoCampo.DTO)
	private Data data;
	
	/**
	 * <p>Campo <code>appId</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "appId", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 255, signo = true, obligatorio = true)
	private String appId;
	

    public String getCodigoAviso() {
        return codigoAviso;
    }

    public void setCodigoAviso(String codigoAviso) {
        this.codigoAviso = codigoAviso;
    }

    public String getDescripcionAviso() {
        return descripcionAviso;
    }

    public void setDescripcionAviso(String descripcionAviso) {
        this.descripcionAviso = descripcionAviso;
    }

    public String getAplicacionAviso() {
        return aplicacionAviso;
    }

    public void setAplicacionAviso(String aplicacionAviso) {
        this.aplicacionAviso = aplicacionAviso;
    }

    public String getCodigoRetorno(){
        return codigoRetorno;
    }

    public void setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

	public Data getData() {
	    return data;
	}

	public void setData(Data data) {
    	this.data = data;
	}

	public String getAppId() {
	    return appId;
	}

	public void setAppId(String appId) {
    	this.appId = appId;
	}
}