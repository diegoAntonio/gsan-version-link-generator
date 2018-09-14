package br.com.dantonio.textoEmail.decorators;

import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 *  Classe que representa a modifica&ccedil;&atilde;o
 *  gerada por uma vers&atilde;o Emergencial.
 *  
 * @author Diego.Ferreira
 *
 */
public class Emergencial extends EmailDecorator {

	public Emergencial(Email email) {
		super(email);
	}
	
	public String[] gerarEmailVersao() {
		final int posicaoAssunto = 0;
		String[] email = this.email.gerarEmailVersao();
		StringBuilder assunto = new StringBuilder("EMERGENCIAL: ");
		assunto.append(email[posicaoAssunto]);
	
		email[posicaoAssunto] = assunto.toString();
	
		return email;
	}

}
