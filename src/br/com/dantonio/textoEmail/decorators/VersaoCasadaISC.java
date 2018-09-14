package br.com.dantonio.textoEmail.decorators;

import br.com.dantonio.textoEmail.baseClasses.Email;

public class VersaoCasadaISC extends EmailDecorator {

	public VersaoCasadaISC(Email email) {
		super(email);
		this.linkScripts = email.getLinkScripts();
		this.linkVersao = email.getLinkVersao();
		this.versao = email.getVersao();
	}

	@Override
	public String[] gerarEmailVersao() {
		throw new UnsupportedOperationException("ERRO!");
	}

}
