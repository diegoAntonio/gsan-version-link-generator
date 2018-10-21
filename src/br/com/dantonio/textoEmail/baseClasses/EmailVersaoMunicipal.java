package br.com.dantonio.textoEmail.baseClasses;

import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

/**
 * Classe que representa um {@link Email} de Vers&atilde;o
 * disponibilizado para as empresas municipais.
 * 
 * @author Diego.Ferreira
 *
 */
public class EmailVersaoMunicipal extends Email {

	public EmailVersaoMunicipal() {
		super();
	}

	public EmailVersaoMunicipal(String versao, String linkVersao,
			String produto, String linkScripts) {
		super(versao, linkVersao, produto, linkScripts);
	}

	@Override
	public String[] gerarEmailVersao() {
		String email[] = new String[Constantes.TAM_VETOR_EMAIL];
		int index = 0;
		
		email[index++] = this.gerarAssunto();
		email[index++] = this.alterarConstantesTexto(ConstantesTexto.CORPO_EMAIL_VERSAO_MUNICIPAL);
		email[index++] = "";
		email[index++] = ConstantesTexto.RODAPE_EMAIL;
		
 		return email;
	}

}
