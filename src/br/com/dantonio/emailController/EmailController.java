package br.com.dantonio.emailController;

import javafx.scene.control.RadioButton;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.validation.ValidadorRegras;

/** 
 * Classe que funciona como um controlador validando regra de
 * negocio e criando os objetos corretamente para o envio das 
 * vers&otilde;es.
 
 * @author Diego.Ferreira
 *
 */
public class EmailController {
	
	/**
	 *  M&eacute;todo central respons&aacute;vel por fazer a
	 *  cria&ccedil;&atilde;o, valida&ccedil;&atilde;o 
	 *  e envio da versao para os clientes.
	 *  
	 * @param helper - {@link HelperEnvioEmail} criado com os 
	 * parametro informados nas 3 abas.
	 */
	public static void enviarEmailVersao(HelperEnvioEmail helper) {
		Email emailVersao;
		Integer idTipoVersao = null;
		RadioButton versao = null;
		
		ValidadorRegras.verificarPreenchimentoVersao(helper.getTipoVersao());
		versao = (RadioButton) helper.getTipoVersao().getSelectedToggle();
		idTipoVersao = new Integer(versao.getId());
		
		if (ProdutosConsenso.isVersaoGsan(idTipoVersao)) {
			ValidadorRegras.validarParametrosVersaoGsan(helper);
		} else if (ProdutosConsenso.isVersaoMobile(idTipoVersao)) {
			ValidadorRegras.validarParametrosVersaoMobile(helper);
		} else {
			throw new IllegalArgumentException("Erro versao desconhecida!");
		}

		emailVersao = gerarEmailVersao(helper);
		
		//TODO: chamar o service que manda o email gerado.

	}

	private static Email gerarEmailVersao(HelperEnvioEmail helper) {
		RadioButton versao = (RadioButton) helper.getTipoVersao().getSelectedToggle();
		Email email = null;
		Integer id = Integer.parseInt(versao.getId());
		
		
		
		return email;
	}
}
