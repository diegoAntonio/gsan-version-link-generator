package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.VersaoCasada;

/**
 *  Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o
 *  da apk de algum mobile casado com a vers&atilde;o do Gsan.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoCasadaMobile extends GenericEmailOpcaoGenerator {

	public VersaoCasadaMobile(GenericEmailGenerator next) {
		super(next);
		this.opcao = OpcoesVersao.CASADA_MOBILE;
	}

	//TODO: terminar a classe.
	@Override
	protected Email criarEmailComOpcoes(HelperEnvioEmail helper,
			Email emailConstruido) {
		EmailDecorator email = new VersaoCasada(emailConstruido, 0);
		
		return email;
	}

}
