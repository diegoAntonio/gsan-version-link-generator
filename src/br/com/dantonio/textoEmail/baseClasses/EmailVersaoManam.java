package br.com.dantonio.textoEmail.baseClasses;

import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

/**
 *  Classe que representa o {@link Email} que &eacute; disponibilizado
 *  para a empresa MANAM.
 *  
 * @author Diego.Ferreira.
 *
 */
public class EmailVersaoManam extends Email {
	public EmailVersaoManam() {
		super();
	}

	public EmailVersaoManam(String versao, String linkVersao, String produto, String linkScripts) {
		super(versao, linkVersao, produto, linkScripts);
	}

	@Override
	public String[] gerarEmailVersao() {
		int index = 0;
		String[] email = new String[Constantes.TAM_VETOR_EMAIL];
		
		email[index++] = this.gerarAssunto();
		email[index++] = this.alterarConstantesTexto(ConstantesTexto.CORPO_EMAIL_VERSAO_MANAM);
		email[index++] = "";
		email[index++] = ConstantesTexto.RODAPE_EMAIL;
		
		return email;
	}
}
