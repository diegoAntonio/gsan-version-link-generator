package br.com.dantonio.validation;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.util.Util;

/**
 * Classe que far&aacute; as valida&ccedil;&otilde;es de regra de negocio para
 * envio das vers&otilde;es
 * 
 * @author Diego.Ferreira
 *
 */
public class ValidadorRegras {

	public static void verificarPreenchimentoVersao(ToggleGroup toggleGroup) {
		if (Util.isObjetoNulo(toggleGroup.getSelectedToggle())) {
			throw new IllegalArgumentException(
					"Informe o tipo da versão na primeira Aba!");
		}
	}

	public static void validarParametrosVersaoGsan(HelperEnvioEmail helper) {
		CheckBox[] opcoesVersao = helper.getOpcoesVersao();
		validarNumeroVersao(helper);
		validarEmailsClientes(helper.getResultadoEmails());
		validarLinkDaVersao(helper.getLinkVersaoGsan());
		verificarLoginSenhaEmail(helper.getLoginEmail(), helper.getSenhaEmail());
		
		if(!Util.isObjetoNulo(opcoesVersao) && opcoesVersao[1].isSelected()){
			verificarLinkScriptsVersao(helper);
		}
		
		if(!Util.isObjetoNulo(opcoesVersao) && opcoesVersao[2].isSelected()){
			verificarVersaoCasadaMobile(helper);
		}

	}

	public static void validarParametrosVersaoMobile(HelperEnvioEmail helper) {
		validarNumeroVersao(helper);
		validarEmailsClientes(helper.getResultadoEmails());
		validarLinkDaVersao(helper.getLinkVersaoGsan());
		verificarLoginSenhaEmail(helper.getLoginEmail(), helper.getSenhaEmail());
	}

	private static void validarEmailsClientes(TextArea area) {
		if (Util.isObjetoNulo(area) || Util.isTextoNuloOuBranco(area.getText())) {
			throw new IllegalArgumentException(
					"Selecione o(s) Cliente(s) que recebera(ao) a versao!");
		}
	}

	private static void validarLinkDaVersao(TextField link) {
		if (Util.isObjetoNulo(link) || Util.isTextoNuloOuBranco(link.getText())) {
			throw new IllegalArgumentException(
					"Informe o link para download da versao!");
		}
	}
	
	//TODO:Release Notes
	// private static void validarReleaseNotes(TextField caminhoRelease) {
	// File release = null;
	//
	// if (Util.isObjetoNulo(release)) {
	// throw new IllegalArgumentException(
	// "Adicione o Release Notes da Versao!");
	// }
	//
	// }

	private static void verificarLoginSenhaEmail(TextField login,
			TextField senha) {
		boolean isLoginSenhaValidos = true;
		StringBuilder mensagemErro = new StringBuilder();

		if (Util.isObjetoNulo(login) || Util.isObjetoNulo(senha)) {
			isLoginSenhaValidos = false;
			mensagemErro.append("Erro na obtencao do login/senha!");
		}

		if (isLoginSenhaValidos
				&& (Util.isTextoNuloOuBranco(login.getText()) || Util
						.isTextoNuloOuBranco(senha.getText()))) {
			isLoginSenhaValidos = false;
			mensagemErro
					.append(" Informe email/senha para poder enviar a versao!");
		}

		if (!isLoginSenhaValidos) {
			throw new IllegalArgumentException(mensagemErro.toString());
		}

	}

	private static void validarNumeroVersao(HelperEnvioEmail helper) {
		if (Util.isObjetoNulo(helper.getNomeVersao())
				|| Util.isTextoNuloOuBranco(helper.getNomeVersao().getText())) {
			throw new IllegalArgumentException("Informe o numero da versao!");
		}
	}

	private static void verificarLinkScriptsVersao(HelperEnvioEmail helper) {
		if (Util.isObjetoNulo(helper.getLinkScripts())
				|| Util.isTextoNuloOuBranco(helper.getLinkScripts().getText())) {
			throw new IllegalArgumentException("Informe o link dos Scripts!");
		}
	}

	private static void verificarVersaoCasadaMobile(HelperEnvioEmail helper) {
		boolean linkIscEmBanco = false;
		boolean linkGsanasEmBranco = false;
		boolean linkGsaneosEmBranco = false;
		boolean linkGsanacEmBranco = false;
		TextField[] links = helper.getLinkVersoesMobileCasada();

		if (Util.isObjetoNulo(links) || Util.isObjetoNulo(links[0])
				|| Util.isTextoNuloOuBranco(links[0].getText())) {
			linkIscEmBanco = true;
		}

		if (Util.isObjetoNulo(links) || Util.isObjetoNulo(links[1])
				|| Util.isTextoNuloOuBranco(links[1].getText())) {
			linkGsanasEmBranco = true;
		}

		if (Util.isObjetoNulo(links) || Util.isObjetoNulo(links[2])
				|| Util.isTextoNuloOuBranco(links[2].getText())) {
			linkGsaneosEmBranco = true;
		}

		if (Util.isObjetoNulo(links) || Util.isObjetoNulo(links[3])
				|| Util.isTextoNuloOuBranco(links[3].getText())) {
			linkGsanacEmBranco = true;
		}

		if (linkIscEmBanco && linkGsaneosEmBranco && linkGsanasEmBranco
				&& linkGsanacEmBranco) {
			throw new IllegalArgumentException(
					"Informe o link para download da apk desejada!");
		}
	}
}
