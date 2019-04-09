package br.com.dantonio.emailService;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Classe que encapsula todas as regras de 
 * enviar o email da vers&atilde;o.
 * 
 * @author Diego.Ferreira.
 *
 */
public class EmailService {
	private Properties propriedadesEmail;
	private String usuario;
	private String senha;
	private final int posicaoAssunto = 0;
	private int posicaoCorpo = 1;
	private int posicaoObservacoes = 2;
	private int posicaoRodape = 3;
	
	public EmailService() {
		super();
		this.propriedadesEmail = new Properties();
		propriedadesEmail.put("mail.smtp.auth", "true");
		propriedadesEmail.put("mail.smtp.starttls.enable", "true");
		propriedadesEmail.put("mail.smtp.host", "smtp.gmail.com");
		propriedadesEmail.put("mail.smtp.port", "587");
	}

	public EmailService(String usuario, String senha) {
		this();
		this.usuario = usuario;
		this.senha = senha;
	}
	
	/**
	 * M&eacute;todo que faz o envio de email de uma vers&atilde;o mobile/casada.
	 * 
	 * @param destinatario - destinos do email.
	 * @param conteudoEmail - conte&uacute;do do email.
	 * @param releaseNotes - Release Notes da Vers&aacute;o.
	 */
	public void enviarEmailVersao(String destinatarios, String[] conteudoEmail, File releaseNotes) {
		Session sessao = this.gerarSessaoEnvioEmail();
		
		try {
			Message message = new MimeMessage(sessao);
			  message.setFrom(new InternetAddress(usuario));
			  message.setRecipients(Message.RecipientType.BCC,
		                InternetAddress.parse(destinatarios));
			  
			message.setSubject(conteudoEmail[posicaoAssunto]);
			
			if(releaseNotes != null) {
				MimeBodyPart bodyPart = new MimeBodyPart();
				MimeBodyPart bodyPart2 = new MimeBodyPart();
				FileDataSource source = new FileDataSource(releaseNotes);
				Multipart multipart = new MimeMultipart("mixed");

				bodyPart.setContent(this.gerarCorpoEmailFormatado(conteudoEmail),"text/html; charset=utf-8");
				bodyPart2.setDataHandler(new DataHandler(source));
				bodyPart2.setFileName(releaseNotes.getName());
				multipart.addBodyPart(bodyPart);
				multipart.addBodyPart(bodyPart2);
				message.setContent(multipart);
				Transport.send(message);
			} else {
				throw new UnsupportedOperationException("Nao é possível enviar versão sem Release Notes");
			}
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * M&eacute;todo que faz o envio de email de uma vers&atilde;o mobile/casada.
	 * 
	 * @param destinatario - destinos do email.
	 * @param conteudoEmail - conte&uacute;do do email.
	 * @param releaseNotes - Release Notes da Vers&aacute;o.
	 * @param apks - Apks do produto mobile.
	 */
	public void enviarEmailVersaoMobile(String destinatario, String[] conteudoEmail, File releaseNotes, File apks) {
		Session sessao = this.gerarSessaoEnvioEmail();
		
		try {
			Message message = new MimeMessage(sessao);
			  message.setFrom(new InternetAddress(usuario));
			  message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse(destinatario));
			  
			message.setSubject(conteudoEmail[posicaoAssunto]);
			
			if(releaseNotes != null && apks != null) {
				MimeBodyPart bodyPart = new MimeBodyPart();
				MimeBodyPart bodyPart2 = new MimeBodyPart();
				MimeBodyPart bodyPart3 = new MimeBodyPart();
				FileDataSource source1 = new FileDataSource(releaseNotes);
				FileDataSource source2 = new FileDataSource(apks);
				Multipart multipart = new MimeMultipart("mixed");

				bodyPart.setContent(this.gerarCorpoEmailFormatado(conteudoEmail),"text/html; charset=utf-8");
				bodyPart2.setDataHandler(new DataHandler(source1));
				bodyPart2.setFileName(releaseNotes.getName());
				bodyPart3.setDataHandler(new DataHandler(source2));
				bodyPart3.setFileName(apks.getName());
				multipart.addBodyPart(bodyPart);
				multipart.addBodyPart(bodyPart2);
				multipart.addBodyPart(bodyPart3);
				message.setContent(multipart);
				Transport.send(message);
			}
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private Session gerarSessaoEnvioEmail() {
		 Session session = Session.getDefaultInstance(this.propriedadesEmail,
                 new javax.mail.Authenticator() {
                      protected PasswordAuthentication getPasswordAuthentication() 
                      {
                            return new PasswordAuthentication(usuario, senha);
                      }
                 }); 
		
		return session;
	}
	
	private String gerarCorpoEmailFormatado(String[] email) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(email[posicaoCorpo]);
		sb.append(email[posicaoObservacoes]);
		sb.append(email[posicaoRodape]);
		
		return sb.toString();
	}
	
}
