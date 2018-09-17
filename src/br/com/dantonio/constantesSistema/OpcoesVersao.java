package br.com.dantonio.constantesSistema;

/**
 *  Classe que modela as op&ccedil;&otilde;es de envio de email
 *  que ser&atilde;o disponibilizadas pelo programa.
 *  
 * @author Diego.Ferreira
 *
 */
public enum OpcoesVersao {
	EMERGENCIAL(0,"Emergencial"),
	SCRIPTS(1,"Versão Possui Scripts"),
	CASADA_ISC(2, "Versão Casada com ISC");
	
	private Integer id;
	private String descricao;
	
	private OpcoesVersao(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
