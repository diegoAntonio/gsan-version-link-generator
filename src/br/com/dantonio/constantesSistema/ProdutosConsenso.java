package br.com.dantonio.constantesSistema;

import java.util.Arrays;

/**
 *  Classe que representa um produto Mobile
 *  da Consenso.
 *  
 * @author Diego.Ferreira
 *
 */
public enum ProdutosConsenso {
	ISC(0, "ISC", "Impressão Simultânea de Contas (ISC)"),
	GSANAS(1, "GSANAS", "Acompanhamento de Ordens de Serviço"),
	GSANEOS(2,"GSANEOS", "Execução de Ordem de Serviço"),
	GSANAC(3,"GSANAC", "Atualização Cadastral"),
	GSAN(4,"GSAN", "Gestão de Saneamento Básico"),
	MANAM(5,"MANAM", "MANAM"),
	GSAN_MUNICIPAL(6,"GSAN - MUNICIPAL", "Gestão de Saneamento Básico - Municipal");
	
	private Integer id;
	private String nomeAppAbreviado;
	private String nomeAppExtenso;

	private ProdutosConsenso(Integer id, String nomeAppAbreviado, String nomeAppExtenso) {
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
	 *  Recupera o nome extenso de um {@link ProdutosConsenso} atraves de um
	 *  codigo passado por parametro.
	 *  
	 * @param codigoProduto - Codigo do {@link ProdutosConsenso} a ser encontrado.
	 * @return {@link String} contendo o nome por Extenso.
	 * @throws IllegalArgumentException - Caso o codigo do produto informado nao exista.
	 */
	public static String getNomeProdutoExtenso(int codigoProduto) {
		ProdutosConsenso produto = getById(new Integer(codigoProduto));
		
		return produto.getNomeAppExtenso();
	}
	
	/**
	 *  Recupera o nome abreviado de um {@link ProdutosConsenso} atraves de um
	 *  codigo passado por parametro.
	 *  
	 * @param codigoProduto - Codigo do {@link ProdutosConsenso} a ser encontrado.
	 * @return {@link String} contendo o nome por Extenso.
	 * @throws IllegalArgumentException - Caso o codigo do produto informado nao exista.
	 */
	public static String getNomeProdutoAbreviado(int codigoProduto) {
		ProdutosConsenso produto = getById(new Integer(codigoProduto));
		
		return produto.getNomeAppAbreviado();
	}
	
	/**
	 *  Recupera o nome extenso de um {@link ProdutosConsenso} atraves de um
	 *  id passado por parametro.
	 *  
	 * @param id - Id do {@link ProdutosConsenso} a ser encontrado.
	 * @return {@link ProdutosConsenso}.
	 * @throws IllegalArgumentException - Caso o codigo do produto informado nao exista.
	 */
	private static ProdutosConsenso getById(Integer id) {
		ProdutosConsenso temp = Arrays.asList(ProdutosConsenso.values()).stream()
				.filter(p -> p.getId().intValue() == id.intValue()).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
		
		return temp;
	}

	/**
	 * Verifica se o id informado pertence a uma versao de um produto mobile.
	 * 
	 * @param id - id informado.
	 * @return true se for um produto mobile, false caso contrario.
	 */
	public static boolean isVersaoMobile(Integer id) {
		boolean isVersaoMobile = false;

		if (id.equals(GSANAC.getId()) || id.equals(GSANAS.getId()) || id.equals(GSANAS.getId())
				|| id.equals(GSANEOS.getId())) {
			isVersaoMobile = true;
		}

		return isVersaoMobile;
	}

	/**
	 * Verifica se o id informado pertence a uma versao de um produto Gsan.
	 * 
	 * @param id - id informado.
	 * @return true se for um produto Gsan, false caso contrario.
	 */
	public static boolean isVersaoGsan(Integer id) {
		boolean isVersaoGsan = false;

		if (id.equals(GSAN.getId()) || id.equals(GSAN_MUNICIPAL.getId()) || id.equals(MANAM.getId())) {
			isVersaoGsan = true;
		}

		return isVersaoGsan;
	}
}
