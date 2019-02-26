package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMunicipal;

/**
 *  Constr&oacute;i um {@link Email} destinado &agrave;s empresas da vers&atilde;o 
 *  Municipal do Gsan.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoMunicipalChain extends GenericEmailGenerator {

	public VersaoMunicipalChain(GenericEmailGenerator next) {
		super(next);
		this.produtoAlvo = ProdutosConsenso.GSAN_MUNICIPAL;
	}

	@Override
	protected Email gerarEmailVersao(HelperEnvioEmail helper) {
		EmailVersaoMunicipal email = new EmailVersaoMunicipal(
				helper.getNomeVersao().getText(), helper.getLinkVersaoGsan().getText(),
				ProdutosConsenso.GSAN_MUNICIPAL.getNomeAppAbreviado(), "");
		
		return email;
	}
}
