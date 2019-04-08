package br.com.dantonio.emailController;

import br.com.dantonio.builder.ConstrutorEmail;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.emailService.EmailService;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.util.ProgressoEnvioEmail;
import br.com.dantonio.validation.ValidadorRegras;
import javafx.scene.control.RadioButton;

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
		EmailService service;
		ConstrutorEmail builder = new ConstrutorEmail();
		
		ValidadorRegras.verificarPreenchimentoVersao(helper.getTipoVersao());
		versao = (RadioButton) helper.getTipoVersao().getSelectedToggle();
		idTipoVersao = new Integer(versao.getId());
		ProgressoEnvioEmail.getInstance().getBarraProgresso().setProgress(50);
		if (ProdutosConsenso.isVersaoGsan(idTipoVersao)) {
			ValidadorRegras.validarParametrosVersaoGsan(helper);
		} else if (ProdutosConsenso.isVersaoMobile(idTipoVersao)) {
			ValidadorRegras.validarParametrosVersaoMobile(helper);
		} else {
			throw new IllegalArgumentException("Erro versao desconhecida!");
		}

		emailVersao = builder.criarEmailVersao(helper);
		ProgressoEnvioEmail.getInstance().getBarraProgresso().setProgress(70);
		service = new EmailService(helper.getLoginEmail().getText(), helper.getSenhaEmail().getText());
		service.enviarEmailVersao(helper.getResultadoEmails().getText(), emailVersao.gerarEmailVersao(),
				helper.getReleaseNotes());
	}
}
