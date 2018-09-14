package br.com.dantonio.textoEmail.decorators;

import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

/**
 * Classe que representa uma modifica&ccedil;&atilde;o
 * gerada por uma vers&atilde;o que contenha Scripts.
 * 
 * @author Diego.Ferreira
 *
 */
public class Scripts extends EmailDecorator {

	public Scripts(Email email) {
		super(email);
		this.linkScripts = email.getLinkScripts();
		this.linkVersao = email.getLinkVersao();
		this.versao = email.getVersao();
	}

	@Override
	public String[] gerarEmailVersao() {
		final int posicaoObservacoes = 2;
		String[] email = this.email.gerarEmailVersao();
		StringBuilder observacoesScripts = new StringBuilder(email[posicaoObservacoes]);
		
		observacoesScripts.append(this.alterarConstantesTexto(ConstantesTexto.AVISO_SCRIPTS));
		email[posicaoObservacoes] = observacoesScripts.toString();
		
		return email;
	}	
}
