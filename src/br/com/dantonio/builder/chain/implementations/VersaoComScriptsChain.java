package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.Scripts;

/**
 *  Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o
 *  com os scritps da vers&atilde;o.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoComScriptsChain extends GenericEmailOpcaoGenerator {

	public VersaoComScriptsChain(GenericEmailOpcaoGenerator next) {
		super(next);
		this.opcao = OpcoesVersao.SCRIPTS;
	}

	@Override
	protected Email criarEmailComOpcoes(HelperEnvioEmail helper,
			Email emailConstruido) {
		EmailDecorator email = new Scripts(emailConstruido);
		email.setLinkScripts(helper.getLinkScripts().getText());
		
		return email;
	}

}
