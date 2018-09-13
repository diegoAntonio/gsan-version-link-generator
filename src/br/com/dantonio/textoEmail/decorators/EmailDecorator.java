package br.com.dantonio.textoEmail.decorators;

import br.com.dantonio.textoEmail.baseClasses.Email;

public abstract class EmailDecorator extends Email{
	protected Email email;

	public EmailDecorator(Email email) {
		super();
		this.email = email;
	}
	
	@Override
	public abstract String[] gerarEmailVersao();

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

}
