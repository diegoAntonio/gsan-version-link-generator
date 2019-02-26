package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.builder.chain.interfaces.EmailOpcoesGerenator;
import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 *  Superclasse que inicia a sequencia do Chain of Responsability
 *  para o caso de Cria&ccedil;&atilde;o de op&ccedil;&otilde;es.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public abstract class GenericEmailOpcaoGenerator implements
		EmailOpcoesGerenator {
	protected GenericEmailGenerator next;
	protected OpcoesVersao opcao;

	public GenericEmailOpcaoGenerator(GenericEmailGenerator next) {
		super();
		this.next = next;
	}

	@Override
	public Email avaliarGeracaoEmail(HelperEnvioEmail helper,
			Email emailConstruido) {
		Email emailGerado = null;

		if (this.verificarAplicacaoOpcao(helper)) {
			emailGerado = this.criarEmailComOpcoes(helper, emailConstruido);
		} else if (this.next != null) {
			emailGerado = this.next.avaliarGeracaoEmail(helper);
		} else {
			throw new IllegalArgumentException(
					"Erro, Opcao Informada ao filtro nao existe!");
		}

		return emailGerado;
	}

	protected abstract Email criarEmailComOpcoes(HelperEnvioEmail helper,
			Email emailConstruido);

	protected boolean verificarAplicacaoOpcao(HelperEnvioEmail helper) {
		boolean aplicarOpcao = false;
		
		return aplicarOpcao;
	}
}
