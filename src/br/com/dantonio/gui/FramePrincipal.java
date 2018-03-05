package br.com.dantonio.gui;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.dantonio.email.EmailsClientes;

public class FramePrincipal extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnPanel0;
	private JLabel lbLabel0;
	private JTextField tfText0;
	private JButton btBut0;
	private JTextArea taArea0;
	private JLabel lbLabel4;
	private JLabel lbLabel5;
	private JTextArea taArea1;
	private JComboBox<EmailsClientes> cmbCombo0;
	private JButton btBut1;

	public FramePrincipal() throws HeadlessException {
		super();
		this.iniciarComponentes();
	}

	public FramePrincipal(GraphicsConfiguration gc) {
		super(gc);
		this.iniciarComponentes();
	}

	public FramePrincipal(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.iniciarComponentes();
	}

	public FramePrincipal(String title) throws HeadlessException {
		super(title);
		this.iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setSize(800, 600);
		
		pnPanel0 = new JPanel();
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		pnPanel0.setLayout( gbPanel0 );

		lbLabel0 = new JLabel( "Link Jenkins"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
		pnPanel0.add( lbLabel0 );

		tfText0 = new JTextField( );
		gbcPanel0.gridx = 4;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 14;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText0, gbcPanel0 );
		pnPanel0.add( tfText0 );

		btBut0 = new JButton( "Gerar Link Jenkins"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		//btBut0.addActionListener(new ActionListener);
		pnPanel0.add( btBut0 );

		taArea0 = new JTextArea(2,10);
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 16;
		gbcPanel0.gridheight = 4;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( taArea0, gbcPanel0 );
		pnPanel0.add( taArea0 );

		lbLabel4 = new JLabel( "Resultado:"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel4, gbcPanel0 );
		pnPanel0.add( lbLabel4 );

		lbLabel5 = new JLabel( "Email Clientes:"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel5, gbcPanel0 );
		pnPanel0.add( lbLabel5 );

		taArea1 = new JTextArea(2,10);
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 12;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 4;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( taArea1, gbcPanel0 );
		pnPanel0.add( taArea1 );

		String []dataCombo0 = {"CAERN", "CAERR", "CASAL" };
		cmbCombo0 = new JComboBox( dataCombo0 );
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 9;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cmbCombo0, gbcPanel0 );
		pnPanel0.add( cmbCombo0 );

		btBut1 = new JButton( "Obter Endereço Clientes"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut1, gbcPanel0 );
		pnPanel0.add( btBut1 );
		
		this.add(pnPanel0);
		this.setVisible(true);
	}

	public JPanel getPnPanel0() {
		return pnPanel0;
	}

	public void setPnPanel0(JPanel pnPanel0) {
		this.pnPanel0 = pnPanel0;
	}

	public JLabel getLbLabel0() {
		return lbLabel0;
	}

	public void setLbLabel0(JLabel lbLabel0) {
		this.lbLabel0 = lbLabel0;
	}

	public JTextField getTfText0() {
		return tfText0;
	}

	public void setTfText0(JTextField tfText0) {
		this.tfText0 = tfText0;
	}

	public JButton getBtBut0() {
		return btBut0;
	}

	public void setBtBut0(JButton btBut0) {
		this.btBut0 = btBut0;
	}

	public JTextArea getTaArea0() {
		return taArea0;
	}

	public void setTaArea0(JTextArea taArea0) {
		this.taArea0 = taArea0;
	}

	public JLabel getLbLabel4() {
		return lbLabel4;
	}

	public void setLbLabel4(JLabel lbLabel4) {
		this.lbLabel4 = lbLabel4;
	}

	public JLabel getLbLabel5() {
		return lbLabel5;
	}

	public void setLbLabel5(JLabel lbLabel5) {
		this.lbLabel5 = lbLabel5;
	}

	public JTextArea getTaArea1() {
		return taArea1;
	}

	public void setTaArea1(JTextArea taArea1) {
		this.taArea1 = taArea1;
	}

	public JComboBox getCmbCombo0() {
		return cmbCombo0;
	}

	public void setCmbCombo0(JComboBox cmbCombo0) {
		this.cmbCombo0 = cmbCombo0;
	}

	public JButton getBtBut1() {
		return btBut1;
	}

	public void setBtBut1(JButton btBut1) {
		this.btBut1 = btBut1;
	}
}
