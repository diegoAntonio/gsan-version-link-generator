package br.com.dantonio.main;

import java.io.File;

import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.email.EmailsClientes;
import br.com.dantonio.emailService.EmailService;
import br.com.dantonio.gui.FramePrincipalJfx;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersao3_0;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoManam;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMobile;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMunicipal;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.Emergencial;
import br.com.dantonio.textoEmail.decorators.Scripts;
import br.com.dantonio.textoEmail.decorators.VersaoCasada;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainJavaFx extends Application {

	public static void main(String[] args) {
		launch(args);
//		System.out.println("Antes Envio");
//		testeEnvioEmailDeVersaoSorocaba();
//		System.out.println("Depois Envio");
//		System.exit(0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FramePrincipalJfx framePrincipalJfx = new FramePrincipalJfx(primaryStage);
		framePrincipalJfx.iniciarAplicacao();
	}

	
	private static String testeEmailVersao3_0() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		StringBuilder emailFinal = new StringBuilder();
		
		Email email = new EmailVersao3_0(nomeVersao, linkVersao, produto, "");
		
		for (String temp : email.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersao3_0ComScripts() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";;
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		Email email;
		EmailDecorator decorator;
		StringBuilder emailFinal = new StringBuilder();
		
		email = new EmailVersao3_0(nomeVersao, linkVersao, produto, linkScripts);
		decorator = new Scripts(email);
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersao3_0Emergencial() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		StringBuilder emailFinal = new StringBuilder();
		
		Email email = new EmailVersao3_0(nomeVersao, linkVersao, produto, "");
		EmailDecorator decorator = new Emergencial(email);
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	
	private static String testeEmailVersaoManam() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "2.10r87m.48";
		String produto = "MANAM";
		StringBuilder emailFinal = new StringBuilder();
		Email email;
		
		email = new EmailVersaoManam(nomeVersao,linkVersao,produto,"");
		
		
		for (String temp : email.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersaoManamComScripts() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "2.10r87m.48";
		String produto = "MANAM";
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		StringBuilder emailFinal = new StringBuilder();
		Email email;
		EmailDecorator decorator;
		
		email = new EmailVersaoManam(nomeVersao,linkVersao,produto,linkScripts);
		decorator = new Scripts(email);
		
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersaoMobile() {
		StringBuilder emailFinal = new StringBuilder();
		String linkVersao = "";
		String nomeVersao = "6.2.09.3";
		String produto = ProdutosConsenso.ISC.getNomeAppAbreviado();
		String linkScripts = "";
		String empresa = EmailsClientes.CAERN.getNomeEmpresa();
		Email email;
		
		email = new EmailVersaoMobile(nomeVersao, linkVersao, produto, linkScripts, empresa,
				ProdutosConsenso.ISC.getId());
		
		for (String temp : email.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>\n");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersaoCasada() {
		StringBuilder emailFinal = new StringBuilder();
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.34.0.0";
		Integer produtoMobile = ProdutosConsenso.ISC.getId();
		String produto = "GSAN";
		Email email;
		EmailDecorator decorator;
		
		email = new EmailVersao3_0(nomeVersao, linkVersao, produto, "");
		decorator = new VersaoCasada(email, produtoMobile);
		
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + "\n");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersaoComScriptsECasada() {
		StringBuilder emailFinal = new StringBuilder();
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.34.0.0";
		Integer produtoMobile = ProdutosConsenso.ISC.getId();
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		String produto = "GSAN";
		Email email;
		EmailDecorator decorator;
		EmailDecorator scripts;
		
		email = new EmailVersao3_0(nomeVersao, linkVersao, produto, linkScripts);
		scripts = new Scripts(email);
		decorator = new VersaoCasada(scripts, produtoMobile);
		
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + "\n");
		}
		
		return emailFinal.toString();
	}
	
	private static void testeEnvioEmailDeVersaoComAnexo(){
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		File anexo = new File("/home/dantonio/Downloads/Release_Notes_3.33.0.2.pdf");
		
		Email email = new EmailVersao3_0(nomeVersao, linkVersao, produto, "");
		
		EmailService servico = new EmailService("daf@a.recife.ifpe.edu.br", "0Blackops1");
		
		servico.enviarEmailVersao("dantonio808@gmail.com", email.gerarEmailVersao(), anexo);
	}
	
	private static void testeEnvioEmailDeVersaoMobileComAnexo() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		File releaseNotes = new File("/home/dantonio/Downloads/Release_Notes_3.33.0.2.pdf");
		File apk = new File("/home/dantonio/Downloads/isc-saae-6.2.09.2.rar");
		
		Email email = new EmailVersao3_0(nomeVersao, linkVersao, produto, linkScripts);
		EmailDecorator decorator1 = new Scripts(email);
		EmailDecorator decorador2 = new VersaoCasada(decorator1, ProdutosConsenso.ISC.getId());
		
		EmailService servico = new EmailService("daf@a.recife.ifpe.edu.br", "0Blackops1");
		
		servico.enviarEmailVersaoMobile("dantonio808@gmail.com", decorador2.gerarEmailVersao(), releaseNotes,apk);
	}
	
	private static void testeEnvioEmailDeVersaoSorocaba() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		String path = "C:\\Users\\gsan\\Downloads\\Release_Notes_3.34.1.0.pdf";
		File releaseNotes = new File(path);
		
		Email email = new EmailVersaoMunicipal(nomeVersao, linkVersao, produto, linkScripts);
		EmailService servico = new EmailService("daf@a.recife.ifpe.edu.br", "0Blackops1");
		
		servico.enviarEmailVersao("dantonio808@gmail.com", email.gerarEmailVersao(), releaseNotes);//("dantonio808@gmail.com", decorador2.gerarEmailVersao(), ;
	}
}
