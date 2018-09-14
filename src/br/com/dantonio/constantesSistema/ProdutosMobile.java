package br.com.dantonio.constantesSistema;

import java.util.Arrays;

/**
 *  Classe que representa um produto Mobile
 *  da Consenso.
 *  
 * @author Diego.Ferreira
 *
 */
public enum ProdutosMobile {
	ISC(0, "ISC", "Impressão Simultânea de Contas (ISC)"),
	GSANAS(1, "GSANAS", "Acompanhamento de Ordens de Serviço"),
	GSANEOS(2,"GSANEOS", "Execução de Ordem de Serviço"),
	GSANAC(3,"GSANAC", "Atualização Cadastral");
	
	private Integer id;
	private String nomeAppAbreviado;
	private String nomeAppExtenso;

	private ProdutosMobile(Integer id, String nomeAppAbreviado, String nomeAppExtenso) {
		this.id = id;
		this.nomeAppAbreviado = nomeAppAbreviado;
		this.nomeAppExtenso = nomeAppExtenso;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAppAbreviado() {
		return nomeAppAbreviado;
	}

	public void setNomeAppAbreviado(String nomeAppAbreviado) {
		this.nomeAppAbreviado = nomeAppAbreviado;
	}

	public String getNomeAppExtenso() {
		return nomeAppExtenso;
	}

	public void setNomeAppExtenso(String nomeAppExtenso) {
		this.nomeAppExtenso = nomeAppExtenso;
	}
	
	/**
	 *  Recupera o nome extenso de um {@link ProdutosMobile} atraves de um
	 *  codigo passado por parametro.
	 *  
	 * @param codigoProduto - Codigo do {@link ProdutosMobile} a ser encontrado.
	 * @return {@link String} contendo o nome por Extenso.
	 * @throws IllegalArgumentException - Caso o codigo do produto informado nao exista.
	 */
	public static String getNomeProdutoExtenso(int codigoProduto) {
		ProdutosMobile produto = getById(new Integer(codigoProduto));
		
		return produto.getNomeAppExtenso();
	}
	
	/**
	 *  Recupera o nome abreviado de um {@link ProdutosMobile} atraves de um
	 *  codigo passado por parametro.
	 *  
	 * @param codigoProduto - Codigo do {@link ProdutosMobile} a ser encontrado.
	 * @return {@link String} contendo o nome por Extenso.
	 * @throws IllegalArgumentException - Caso o codigo do produto informado nao exista.
	 */
	public static String getNomeProdutoAbreviado(int codigoProduto) {
		ProdutosMobile produto = getById(new Integer(codigoProduto));
		
		return produto.getNomeAppAbreviado();
	}
	
	/**
	 *  Recupera o nome extenso de um {@link ProdutosMobile} atraves de um
	 *  id passado por parametro.
	 *  
	 * @param id - Id do {@link ProdutosMobile} a ser encontrado.
	 * @return {@link ProdutosMobile}.
	 * @throws IllegalArgumentException - Caso o codigo do produto informado nao exista.
	 */
	private static ProdutosMobile getById(Integer id) {
		ProdutosMobile temp = Arrays.asList(ProdutosMobile.values()).stream()
				.filter(p -> p.getId().intValue() == id.intValue()).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
		
		return temp;
	}
}
