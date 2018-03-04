package br.com.dantonio.email;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dantonio.constantesSistema.Constantes;

public enum EmailsClientes {

	CAERN(Constantes.CAERN, "aalcides@caern.com.br,jcardoso@caern.com.br,rodolfo@caern.com.br,rodrigoaraujo@caern.com.br,ricardodias@caern.com.br,marciogomes@caern.com.br,suportecaern@gmail.com,suportegsi@caern.com.br,joaomaynard@hotmail.com,ricardo.rochadias@gmail.com,carloscamara@caern.com.br,suportegti@caern.com.br,tiagocorcelli@gmail.com,ceac13@gmail.com,saskya@caern.com.br"), 
	CASAL(Constantes.CASAL, "diogo.fonseca@casal.al.gov.br, cleiton.hardy@casal.al.gov.br, suporte.getin@casal.al.gov.br,guilherme.oliveira@procenge.com.br"), 
	CAERR(Constantes.CAERR, "laurencelamare@gmail.com,tony@caer.com.br,wagmedrado@gmail.com"), 
	SAAE_JUA(Constantes.SAAE_JUA,"hegira.saae@gmail.com,ti@saaejuazeiro.com.br"), 
	CAEMA(Constantes.CAEMA, "manoelpaulo@caema.ma.gov.br,tadeusal@gmail.com"), 
	DESO(Constantes.DESO, "joaoas@deso-se.com.br,gsanhelp@deso-se.com.br,brunomenezes@deso-se.com.br"), 
	CAERD(Constantes.CAERD,"jander@caerd-ro.com.br"), 
	MANAM(Constantes.MANAM, "estevao.carvalho@manausambiental.com.br, luana.magalhaes@procenge.com.br,luis.camara@procenge.com.br"), 
	SOROCABA(Constantes.SOROCABA, "Alexandre.Venturine@procenge.com.br,Adelmo.Cabral@procenge.com.br,joaomarcos@saaesorocaba.sp.gov.br,fabiocacace@saaesorocaba.sp.gov.br"), 
	CAGEPA(Constantes.CAGEPA, "eduardo@cagepa.pb.gov.br,cpinto@cagepa.pb.gov.br,Erick@cagepa.pb.gov.br,ILKASOUSA@cagepa.pb.gov.br,isaias@cagepa.pb.gov.br"),
	OperacaoProcenge(Constantes.OPERACAO_PROCENGE,"operacaoal@procenge.com.br");

	private int idCliente;
	private String listaEmails;

	private EmailsClientes(int idCliente, String listaEmails) {
		this.idCliente = idCliente;
		this.listaEmails = listaEmails;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getListaEmails() {
		return listaEmails;
	}

	public void setListaEmails(String listaEmails) {
		this.listaEmails = listaEmails;
	}

	/**
	 * Retorna a lista de emails para um cliente especifico
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public static String getEmailClientes(int idEmpresa) {
		StringBuilder listaEmails = new StringBuilder();
		EmailsClientes cliente = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getIdCliente() == idEmpresa).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());

		listaEmails.append(cliente.getListaEmails());

		return listaEmails.toString();

	}

	/**
	 * Retorna a lista de emails de todos os clientes da versao 3.0
	 * 
	 * @return {@link String} contendo todos os emails.
	 */
	public static String getEmailClientesGsan() {
		StringBuilder listaEmails = new StringBuilder();
		List<EmailsClientes> clientesGsan = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getIdCliente() != Constantes.MANAM && s.getIdCliente() != Constantes.SOROCABA)
				.collect(Collectors.toList());

		for (EmailsClientes emailsClientes : clientesGsan) {
			listaEmails.append(emailsClientes.getListaEmails());
			listaEmails.append(",");
		}

		return listaEmails.toString();

	}
}