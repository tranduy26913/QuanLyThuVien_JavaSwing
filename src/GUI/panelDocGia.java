package GUI;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class panelDocGia extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public panelDocGia() {

		setBounds(new Rectangle(0, 0, 1000, 600));
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(885, 11, 205, 25);
		add(textField);
		
		JLabel lblMuSch = new JLabel("M\u00E3 \u0110\u1EA7u S\u00E1ch");
		lblMuSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMuSch.setBounds(785, 11, 117, 25);
		add(lblMuSch);
		
		JLabel lblTaSch = new JLabel("T\u1EF1a s\u00E1ch");
		lblTaSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch.setBounds(785, 47, 117, 25);
		add(lblTaSch);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(885, 47, 205, 25);
		add(textField_1);
		
		JLabel lblNhXutBn = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n");
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn.setBounds(785, 83, 117, 25);
		add(lblNhXutBn);
		
		JButton btnThemNXB_1 = new JButton("Th\u00EAm");
		btnThemNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNXB_1.setBounds(835, 246, 110, 40);
		add(btnThemNXB_1);
		
		JButton btnSuaNXB_1 = new JButton("S\u1EEDa");
		btnSuaNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaNXB_1.setBounds(955, 246, 110, 40);
		add(btnSuaNXB_1);
		
		JButton btnXoaNXB_1 = new JButton("Xo\u00E1");
		btnXoaNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaNXB_1.setBounds(835, 297, 110, 40);
		add(btnXoaNXB_1);
		
		JButton btnTimNXB_1 = new JButton("T\u00ECm");
		btnTimNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimNXB_1.setBounds(955, 297, 110, 40);
		add(btnTimNXB_1);
		
		JComboBox cBNXB = new JComboBox();
		cBNXB.setBounds(885, 83, 205, 25);
		add(cBNXB);
	}
}
