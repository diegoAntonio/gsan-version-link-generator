package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.Emergencial;

/**
 *  Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o
 *  de uma vers&atilde;o emergencial.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoEmergencialChain extends GenericEmailOpcaoGenerator {

	public VersaoEmergencialChain(GenericEmailOpcaoGenerator next) {
		super(next);
		this.opcao = OpcoesVersao.EMERGENCIAL;
	}

	@Override
	protected Email criarEmailComOpcoes(HelperEnvioEmail helper,
			Email emailConstruido) {
		EmailDecorator email = new Emergencial(emailConstruido);
		
		return email;
	}

}
