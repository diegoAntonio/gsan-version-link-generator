package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.email.EmailsClientes;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMobile;

/**
 * Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o da apk
 * do Gsanas.
 * 
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoGsanasChain extends GenericEmailGenerator {

	public VersaoGsanasChain(GenericEmailGenerator next) {
		super(next);
		this.produtoAlvo = ProdutosConsenso.GSANAS;
	}

	@Override
	protected Email gerarEmailVersao(HelperEnvioEmail helper) {
		EmailVersaoMobile email = new EmailVersaoMobile(
				helper.getNomeVersao().getText(),
				helper.getLinkVersaoMobile().getText(),
				ProdutosConsenso.GSANAS.getNomeAppAbreviado(),
				"",
				EmailsClientes.getEmpresaPorListaClientes(
						helper.getResultadoEmails().getText()).getNomeEmpresa(),
				ProdutosConsenso.GSANAS.getId());

		return email;
	}

}
