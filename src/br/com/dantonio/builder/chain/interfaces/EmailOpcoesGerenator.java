package br.com.dantonio.builder.chain.interfaces;

import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 *  Interface que exp&otilde;e o m&eacute;todo que gera
 *  as op&ccedil;&otilde;es referentes aos emails.
 *  
 * @author Diego.Ferreira
 * @since 26-02-2019
 *
 */
public interface EmailOpcoesGerenator {
	
	/**
	 *  M&eacute;todo respons&aacute;vel por gerar 
	 *  o email.
	 *  
	 * @param helper - {@link HelperEnvioEmail} contendo as informa&ccedil;&otilde;es
	 * que vieram da tela.
	 * @param emailConstruido - {@link Email} criado anteriormente com as informa&ccedil;&otilde;es
	 * da vers&atilde;o.
	 * @return {@link Email}
	 */
	public Email avaliarGeracaoEmail(HelperEnvioEmail helper, Email emailConstruido);
}
