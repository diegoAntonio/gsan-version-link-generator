package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMobile;

/**
 *  Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o
 *  da apk do ISC.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoIscChain extends GenericEmailGenerator {

	public VersaoIscChain(GenericEmailGenerator next) {
		super(next);
		this.produtoAlvo = ProdutosConsenso.ISC;
	}
	
	//TODO: resolver problema da empresa-alvo.
	@Override
	protected Email gerarEmailVersao(HelperEnvioEmail helper) {
		EmailVersaoMobile email = new EmailVersaoMobile(helper.getNomeVersao().getText(), helper.getLinkVersaoGsan().getText(), 
				ProdutosConsenso.ISC.getNomeAppExtenso(), "", "", ProdutosConsenso.ISC.getId());
		
		return email;
	}

}
