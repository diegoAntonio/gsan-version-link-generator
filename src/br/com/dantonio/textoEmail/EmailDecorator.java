package br.com.dantonio.textoEmail;

public class EmailDecorator extends Email{
	private Email email;

	public EmailDecorator(Email email) {
		super();
		this.email = email;
	}
	
	@Override
	public String[] gerarEmailVersao() {
		return null;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

}
