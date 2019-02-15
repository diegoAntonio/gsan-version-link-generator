package br.com.dantonio.util;

/**
 * Classe de apoio que contem metodos uteis sem muita conexao direta com as
 * regras de negocio do programa.
 * 
 * @author Diego.Ferreira
 * @since 15-02-2019
 *
 */
public class Util {

	/**
	 * Verifica se um campo informado est&aacute; nulo ou &eacute; uma string vazia.
	 * 
	 * @param texto
	 *            - Texto a ser avaliado
	 * @return <code>true</code> se o texto for nulo ou uma string vazia. Caso
	 *         contr&aacute;rio, retorna <code>false</code>.
	 */
	public static boolean isTextoNuloOuBranco(String texto) {
		boolean isTextoNuloOuBranco = false;

		if (texto == null || (texto != null && texto.trim().isEmpty())) {
			isTextoNuloOuBranco = true;
		}

		return isTextoNuloOuBranco;
	}

	/**
	 * Verifica se um objeto informado est&aacute; nulo.
	 * 
	 * @param objeto
	 *            - Objeto a ser avaliado
	 * @return <code>true</code> se o objeto for nulo. Caso contr&aacute;rio, retorna
	 *         <code>false</code>.
	 */
	public static boolean isObjetoNulo(Object objeto) {
		boolean isObjetoNulo = (objeto == null) ? true : false;

		return isObjetoNulo;
	}

}
