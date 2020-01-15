package br.com.dantonio.builder.chain.implementations;

import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.email.EmailsClientes;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMobile;
import javafx.scene.control.RadioButton;

/**
 * Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o da apk
 * do Gsaneos.
 * 
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoGsaneosChain extends GenericEmailGenerator {

	public VersaoGsaneosChain(GenericEmailGenerator next) {
		super(next);
		this.produtoAlvo = ProdutosConsenso.GSANEOS;
	}

	@Override
	protected Email gerarEmailVersao(HelperEnvioEmail helper) {
		EmailVersaoMobile email = new EmailVersaoMobile(
				helper.getNomeVersao().getText(), //Nome Versao
				helper.getLinkVersaoMobile().getText(), //Link Versao
				this.produtoAlvo.getNomeAppExtenso(), //Nome do Aplicativo
				"", //Link dos Scripts
				EmailsClientes.getEmpresaById(Integer.parseInt(((RadioButton) helper.getEmpresa().getSelectedToggle()).getId())).getNomeEmpresa(),//Nome Empresa - WTF
				this.produtoAlvo.getId());//Codigo do Produto

		return email;
	}

}
