package br.com.dantonio.constantesSistema;

import java.util.Arrays;

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
	CASADA_MOBILE(2, "Versão Casada com Mobile");
	
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
	
	public static OpcoesVersao getByStringId(String codigoOpcao) {
		int id = Integer.parseInt(codigoOpcao);
		OpcoesVersao opcao = Arrays.asList(OpcoesVersao.values()).stream().filter(s-> s.getId() == id).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
		
		return opcao;
	}
}
