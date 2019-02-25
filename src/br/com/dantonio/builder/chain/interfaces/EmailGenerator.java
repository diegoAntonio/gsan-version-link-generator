package br.com.dantonio.builder.chain.interfaces;

import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 *  Interface que exp&otilde;e o m&eacute;todo de gera&ccedil;&atilde;o do
 *  {@link Email} que ser&aacute; enviado aos Clientes.
 *  
 * @author Diego.Ferreira
 * @since 25/02/2019
 */
public interface EmailGenerator {
	
	/** M&eacute;todo que faz a criacao de um email.
	 * 
	 * @param helper
	 * @return
	 */
	public Email avaliarGeracaoEmail(HelperEnvioEmail helper);

}
