package br.com.dantonio.converter;

import br.com.dantonio.constantesSistema.Constantes;

public class LinkConverter {
	
	public static String formatarLinkExternoJenkins(String linkInternoJenkins) {
		StringBuilder linkExterno = new StringBuilder();
		
		linkExterno.append(Constantes.LINK_EXTERNO_JENKINS);
		 
		if(linkInternoJenkins != null && !linkInternoJenkins.trim().isEmpty()) {
			int posicao1 = linkInternoJenkins.indexOf("job");
			int tamanhoTotal = linkInternoJenkins.length();

			if(posicao1 > -1) {
				linkExterno.append(linkInternoJenkins.substring(posicao1, tamanhoTotal));
			} else {
				linkExterno.append("Link Incorreto ou formatado errado!");
			}
		}
		
		return linkExterno.toString();
	}
	
	
	public static String formatarLinkExternoFTP(String linkInternoFTP) {
		StringBuilder linkExterno = new StringBuilder();
		
		linkExterno.append(Constantes.LINK_EXTERNO_FTP);
		
		if(linkInternoFTP != null && !linkInternoFTP.trim().isEmpty()) {
			int posicao1 = linkInternoFTP.indexOf("ear");
			int tamanhoTotal = linkInternoFTP.length();
			
			linkInternoFTP = linkInternoFTP.replace("\\", "//");
			
			linkExterno.append(linkInternoFTP.substring(posicao1, tamanhoTotal));
		}
		
		
		return linkExterno.toString();
	}

}
