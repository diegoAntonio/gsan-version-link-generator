package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersao3_0;

/**
 * Classe respons&aacute;vel por construir um {@link EmailVersao3_0}.
 * 
 * @author Diego.Ferreira
 * @since 25/02/2019
 *
 */
public class VersaoGsanChain extends GenericEmailGenerator {

	public VersaoGsanChain(GenericEmailGenerator next) {
		super(next);
		this.produtoAlvo = ProdutosConsenso.GSAN;
	}

	@Override
	protected Email gerarEmailVersao(HelperEnvioEmail helper) {
		EmailVersao3_0 email = new EmailVersao3_0(helper.getNomeVersao()
				.getText(), helper.getLinkVersaoGsan().getText(),
				ProdutosConsenso.GSAN.getNomeAppAbreviado(), "");

		return email;
	}
}
