package br.com.dantonio.textoEmail.baseClasses;

import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

public class EmailVersao3_0 extends Email {
	
	public EmailVersao3_0() {
		super();
	}
	
	public EmailVersao3_0(String versao, String linkVersao, String produto,
			String linkScripts) {
		super(versao, linkVersao, produto, linkScripts);
	}

	@Override
	public String[] gerarEmailVersao() {
		int index = 0;
		String[] email = new String[Constantes.TAM_VETOR_EMAIL];
		
		email[index++] = this.gerarAssunto();
		email[index++] = this.alterarConstantesTexto(ConstantesTexto.CORPO_EMAIL_VERSAO_3_0);
		email[index++] = "";
		email[index++] = ConstantesTexto.RODAPE_EMAIL;
		
		return email;
	}
}
