package br.com.dantonio.email;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dantonio.constantesSistema.Constantes;

public enum EmailsClientes {
	
	EMPRESAS_3_0(Constantes.TODAS_EMPRESAS ,"TODAS_EMPRESAS_3_0", ""), 
	CAERN(Constantes.CAERN,"CAERN", "aalcides@caern.com.br, jcardoso@caern.com.br, rodolfo@caern.com.br, rodrigoaraujo@caern.com.br, marciogomes@caern.com.br, suportecaern@gmail.com, suportegsi@caern.com.br, joaomaynard@hotmail.com, suportegti@caern.com.br, tiagocorcelli@gmail.com, usco@caern.com.br"), 
	CASAL(Constantes.CASAL,"CASAL", "deborah.tayse@procenge.com.br, mercia.macario@casal.al.gov.br, pedro.bezerra@casal.al.gov.br, inaldo.lourenco@casal.al.gov.br"), 
	CAERR(Constantes.CAERR,"CAERR", "laurencelamare@gmail.com, tony@caer.com.br, wagmedrado@gmail.com, gsansuporte@caer.com.br"), 
	SAAE_JUA(Constantes.SAAE_JUA, "SAAE-JUAZEIRO", "hegira.saae@gmail.com, ti@saaejuazeiro.com.br"), 
	DESO(Constantes.DESO,"DESO", "joaoas@deso-se.com.br, gsanhelp@deso-se.com.br, brunomenezes@deso-se.com.br, ronaldojunior@deso-se.com.br"), 
	DAAE(Constantes.DAAE,"DAAE-ARARAQUARA", "gti@daaeararaquara.com.br"), 
	CAERD(Constantes.CAERD,"CAERD","jander@caerd-ro.com.br, erovay@caerd-ro.com.br"), 
	SOROCABA(Constantes.SOROCABA,"SOROCABA", "joaomarcos@saaesorocaba.sp.gov.br, fabiocacace@saaesorocaba.sp.gov.br, guilherme.oliveira@procenge.com.br, sandrieligaloni@saaesorocaba.sp.gov.br"), 
	CAGEPA(Constantes.CAGEPA,"CAGEPA", "eduardo@cagepa.pb.gov.br,cpinto@cagepa.pb.gov.br, Erick@cagepa.pb.gov.br, ILKASOUSA@cagepa.pb.gov.br, isaias@cagepa.pb.gov.br, ricardo@cagepa.pb.gov.br"),
	OPERACAO_PROCENGE(Constantes.OPERACAO_PROCENGE,"OP. PROCENGE","operacaoal@procenge.com.br"),
	DAERP(Constantes.DAERP, "DAERP", "scarparo@coderp.com.br, barreto@coderp.com.br, orsi@coderp.com.br, lnogueira@coderp.com.br"),
	CLIENTES_FTP(Constantes.CLIENTES_FTP, "Clientes da estadual que recebem o arquivo .rar",""),
	CLIENTES_JENKINS(Constantes.CLIENTES_JENKINS, "Clientes da estadual que recebem o arquivo .ear",""),
	CLIENTES_MUNICIPAL_FTP(Constantes.CLIENTES_MUNICIPAL_FTP, "Clientes da municipal que recebem o arquivo .rar", ""),
	CLIENTES_MUNICIPAL_JENKINS(Constantes.CLIENTES_MUNICIPAL_JENKINS, "Clientes da municipal que recebem o arquivo .ear", "");

	private int idCliente;
	private String nomeEmpresa;
	private String listaEmails;

	private EmailsClientes(int idCliente,String nomeEmpresa, String listaEmails) {
		this.idCliente = idCliente;
		this.listaEmails = listaEmails;
		this.nomeEmpresa = nomeEmpresa;
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
		
		if (idEmpresa == Constantes.SOROCABA || idEmpresa == Constantes.CAERD || idEmpresa == Constantes.CASAL
				|| idEmpresa == Constantes.DAAE) {
			listaEmails.append(", " + EmailsClientes.OPERACAO_PROCENGE.getListaEmails());
		}
		
		if(idEmpresa != Constantes.OPERACAO_PROCENGE) {
			listaEmails.append(", " +  Constantes.EMAIL_GRUPO_GSAN);
		}

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
				.filter(s -> s.getIdCliente() != Constantes.MANAM && s.getIdCliente() != Constantes.SOROCABA
				&& s.getIdCliente() != Constantes.TODAS_EMPRESAS
				&& s.getIdCliente() != Constantes.CLIENTES_FTP
				&& s.getIdCliente() != Constantes.CLIENTES_JENKINS
				&& s.getIdCliente() != Constantes.CLIENTES_MUNICIPAL_FTP
				&& s.getIdCliente() != Constantes.CLIENTES_MUNICIPAL_JENKINS
				&& s.getIdCliente() != Constantes.OPERACAO_PROCENGE)
				.collect(Collectors.toList());

		for (EmailsClientes emailsClientes : clientesGsan) {
			listaEmails.append(emailsClientes.getListaEmails());
			listaEmails.append(", \n");
		}
		
		listaEmails.append(Constantes.EMAIL_GRUPO_GSAN);

		return listaEmails.toString();

	}
	
	/** Retorna a lista de emails de todos os clientes da versao 3.0 que recebem
	 *  a versao pelo FTP.
	 *  
	 * @return {@link String} contendo todos os emails.
	 */
	public static String getEmailsClientesFTP() {
		StringBuilder listaEmails = new StringBuilder();
		
		List<EmailsClientes> clientesGsan = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getIdCliente() != Constantes.MANAM 
				&& s.getIdCliente() != Constantes.SOROCABA
				&& s.getIdCliente() != Constantes.TODAS_EMPRESAS 
				&& s.getIdCliente() != Constantes.CASAL
				&& s.getIdCliente() != Constantes.CAERD 
				&& s.getIdCliente() != Constantes.CAGEPA 
				&& s.getIdCliente() != Constantes.OPERACAO_PROCENGE
				&& s.getIdCliente() != Constantes.CLIENTES_FTP
				&& s.getIdCliente() != Constantes.CLIENTES_JENKINS
				&& s.getIdCliente() != Constantes.SAAE_JUA
				&& s.getIdCliente() != Constantes.DAERP
				&& s.getIdCliente() != Constantes.DAAE
				&& s.getIdCliente() != Constantes.CLIENTES_MUNICIPAL_FTP
				&& s.getIdCliente() != Constantes.CLIENTES_MUNICIPAL_JENKINS)
				.collect(Collectors.toList());
		
		for (EmailsClientes emailsClientes : clientesGsan) {
			listaEmails.append(emailsClientes.getListaEmails());
			listaEmails.append(", \n");
		}
		
		listaEmails.append(Constantes.EMAIL_GRUPO_GSAN);
		
		return listaEmails.toString();
	}
	
	/** Retorna a lista de emails de todos os clientes da versao 3.0 que recebem
	 *  a versao pelo JENKINS.
	 *  
	 * @return {@link String} contendo todos os emails.
	 */
	public static String getEmailsClientesJenkins() {
		StringBuilder listaEmails = new StringBuilder();
		
		List<EmailsClientes> clientesGsan = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getIdCliente() != Constantes.MANAM 
				&& s.getIdCliente() != Constantes.SOROCABA
				&& s.getIdCliente() != Constantes.TODAS_EMPRESAS 
				&& s.getIdCliente() != Constantes.CAERN
				&& s.getIdCliente() != Constantes.DESO 
				&& s.getIdCliente() != Constantes.SAAE_JUA 
				&& s.getIdCliente() != Constantes.CAERR
				&& s.getIdCliente() != Constantes.CLIENTES_FTP
				&& s.getIdCliente() != Constantes.CLIENTES_JENKINS
				&& s.getIdCliente() != Constantes.DAERP
				&& s.getIdCliente() != Constantes.DAAE
				&& s.getIdCliente() != Constantes.CLIENTES_MUNICIPAL_FTP
				&& s.getIdCliente() != Constantes.CLIENTES_MUNICIPAL_JENKINS)
				.collect(Collectors.toList());
		
		for (EmailsClientes emailsClientes : clientesGsan) {
			listaEmails.append(emailsClientes.getListaEmails());
			listaEmails.append(",\n");
		}
		
		return listaEmails.toString();
	}
	
	
	/** Retorna a lista de emails de todos os clientes da versao 3.0 que recebem
	 *  a versao pelo JENKINS.
	 *  
	 * @return {@link String} contendo todos os emails.
	 */
	public static String getEmailsClientesMunicipalJenkins() {
		StringBuilder listaEmails = new StringBuilder();
		
		List<EmailsClientes> clientesGsan = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getIdCliente() == Constantes.SOROCABA 
				|| s.getIdCliente() == Constantes.DAAE
				|| s.getIdCliente() == Constantes.DAERP)
				.collect(Collectors.toList());
		
		for (EmailsClientes emailsClientes : clientesGsan) {
			listaEmails.append(emailsClientes.getListaEmails());
			listaEmails.append(", \n");
		}
		
		listaEmails.append(EmailsClientes.OPERACAO_PROCENGE.getListaEmails());
		
		return listaEmails.toString();
	}
	
	/** Retorna a lista de emails de todos os clientes da versao 3.0 que recebem
	 *  a versao pelo JENKINS.
	 *  
	 * @return {@link String} contendo todos os emails.
	 */
	public static String getEmailsClientesMunicipalFTP() {
		StringBuilder listaEmails = new StringBuilder();
		
		listaEmails.append(getEmailClientes(EmailsClientes.SAAE_JUA.getIdCliente()));
		
		return listaEmails.toString();
	}
	
	
	/** Retorna a lista de emails de todos os clientes da versao 3.0 que recebem
	 *  a versao pelo JENKINS.
	 *  
	 * @return {@link String} contendo todos os emails.
	 */
	public static EmailsClientes getEmpresaPorListaClientes(String listaEmails) {		
		EmailsClientes cliente = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getListaEmails().equalsIgnoreCase(listaEmails)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
		
		return cliente;
	}
	
	public static EmailsClientes getEmpresaById(Integer id) {
		EmailsClientes empresa = Arrays.asList(EmailsClientes.values()).stream()
				.filter(s -> s.getIdCliente() == id.intValue()).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
		
		return empresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
}