package br.com.dantonio.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.dantonio.converter.LinkConverter;
import br.com.dantonio.email.EmailsClientes;

public class FramePrincipal extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textLinkJenkins;
	private JTextField textLinkFTP;
	private JTextField resultadoLinkVersao;
	private JTextArea textAreaEmailClientes;
	private ButtonGroup grupoBotao;

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setTitle("GSAN Link/Email Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		createFrame();
	}

	private void createFrame() {
		textLinkJenkins = new JTextField();
		textLinkJenkins.setBounds(150, 11, 350, 20);
		contentPane.add(textLinkJenkins);
		textLinkJenkins.setColumns(10);

		textLinkFTP = new JTextField();
		textLinkFTP.setBounds(140, 60, 350, 20);
		textLinkFTP.setColumns(10);
		textLinkFTP.setEditable(Boolean.FALSE);
		contentPane.add(textLinkFTP);

		JLabel lblLinkInternoJenkins = new JLabel("Link Interno Jenkins");
		lblLinkInternoJenkins.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLinkInternoJenkins.setBounds(21, 11, 600, 14);
		contentPane.add(lblLinkInternoJenkins);

		JLabel lblLinkInternoFTP = new JLabel("Link Interno FTP:");
		lblLinkInternoFTP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLinkInternoFTP.setBounds(21, 60, 200, 14);
		lblLinkInternoFTP.setEnabled(Boolean.FALSE);
		contentPane.add(lblLinkInternoFTP);
		
		JButton lblBotaoGerarLink = new JButton();
		lblBotaoGerarLink.setAction(null);
		lblBotaoGerarLink.setBounds(20, 90, 200, 23);
		lblBotaoGerarLink.setText("Gerar Link da Versão:");
		lblBotaoGerarLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBotaoGerarLink.addActionListener(new BotaoListener());
		contentPane.add(lblBotaoGerarLink);
		
		JLabel lblresultadoLinkVersao = new JLabel("Resultado Link Versão:");
		lblresultadoLinkVersao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblresultadoLinkVersao.setBounds(20, 130, 200, 23);
		contentPane.add(lblresultadoLinkVersao);
		
		resultadoLinkVersao = new JTextField();
		resultadoLinkVersao.setBounds(20,150,450,23);
		contentPane.add(resultadoLinkVersao);
		
		JLabel lblEmailClientes = new JLabel("Escolha o(s) Cliente(s): ");
		lblEmailClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailClientes.setBounds(20,190,200,23);
		contentPane.add(lblEmailClientes);
		
		int i = 210;
		grupoBotao = new ButtonGroup();
		for (EmailsClientes emailCliente : EmailsClientes.values()) {
			JRadioButton botao = new JRadioButton();
			botao.setText(emailCliente.getNomeEmpresa());
			botao.setActionCommand(String.valueOf(emailCliente.getIdCliente()));
			botao.setBounds(21,i,150,10);
			botao.addActionListener(new RadioButtonHandler());
			contentPane.add(botao);
			grupoBotao.add(botao);
			i+=20;
		}
		
		textAreaEmailClientes = new JTextArea();
		textAreaEmailClientes.setBounds(21,i,500,80);
		textAreaEmailClientes.setLineWrap(Boolean.TRUE);
		contentPane.add(textAreaEmailClientes);
	}
	
	
	private class RadioButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Integer valorEscolhido = new Integer(e.getActionCommand());
			textAreaEmailClientes.setText("");
			String emails =  "";
			
			switch(valorEscolhido.intValue()) {
				case 0:
					emails = EmailsClientes.getEmailClientesGsan();
				break;

				default:
					emails = EmailsClientes.getEmailClientes(valorEscolhido.intValue());
				break;
			}
			
			textAreaEmailClientes.setText(emails);
		}

	}
	
	private class BotaoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resultadoLinkVersao.setText("");
			if (textLinkJenkins != null && !textLinkJenkins.getText().trim().isEmpty()) {
				resultadoLinkVersao.setText(LinkConverter.formatarLinkExternoJenkins(textLinkJenkins.getText()));
			}
		}
	}
}