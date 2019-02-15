package br.com.dantonio.validation;

import java.awt.TextArea;
import java.io.File;

import br.com.dantonio.util.Util;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Classe que far&aacute; as valida&ccedil;&otilde;es de regra de negocio para
 * envio das vers&otilde;es
 * 
 * @author Diego.Ferreira
 *
 */
public class ValidadorRegras {

	public static void validarEmailsClientes(TextArea area) {
		if (Util.isObjetoNulo(area) || Util.isTextoNuloOuBranco(area.getText())) {
			throw new IllegalArgumentException(
					"Selecione o(s) Cliente(s) que recebera(ao) a versao!");
		}
	}

	public static void validarLinkDaVersao(TextField link) {
		if (Util.isObjetoNulo(link) || Util.isTextoNuloOuBranco(link.getText())) {
			throw new IllegalArgumentException(
					"Informe o link para download da versao!");
		}
	}

	public static void validarParametrosVersaoGsan() {

	}

	public static void validarParametrosVersaoMobile() {

	}

	public static void validarReleaseNotes(File release) {
		if (Util.isObjetoNulo(release)) {
			throw new IllegalArgumentException(
					"Adicione o Release Notes da Versao!");
		}

	}

	public static void verificarPreenchimentoVersao(ToggleGroup toggleGroup) {
		if (Util.isObjetoNulo(toggleGroup.getSelectedToggle())) {
			throw new IllegalArgumentException(
					"Informe o tipo da versão na primeira Aba!");
		}
	}

	public static void verificarLoginSenhaEmail(TextField login, TextField senha) {
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

	}

	// TODO:Fazer as seguintes validacoes
	/*
	 * Link da versao (x)
	 * 
	 * Lista de Emails (X)
	 * 
	 * Parametros Versao Gsan
	 * 
	 * Parametros Versao Mobile
	 * 
	 * Numero da versao (x)
	 * 
	 * Email/Senha (x)
	 * 
	 * ReleaseNotes (x)
	 */
}
