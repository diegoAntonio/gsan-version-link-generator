package br.com.dantonio.textoEmail.decorators;

import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 *  Classe que repsenta uma altera&ccedil;&atilde;o
 *  proveniente de uma vers&atilde;o Casada com um Produto
 *  Mobile.
 *  
 * @author Diego.Ferreira
 *
 */
public class VersaoCasada extends EmailDecorator {

	public VersaoCasada(Email email) {
		super(email);
		this.linkScripts = email.getLinkScripts();
		this.linkVersao = email.getLinkVersao();
		this.versao = email.getVersao();
	}

	@Override
	public String[] gerarEmailVersao() {
		throw new UnsupportedOperationException("ERRO!");
	}

}
