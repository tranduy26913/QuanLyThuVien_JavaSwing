package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Account;
import Model.AccountDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPw;
	private JRadioButton rbQuanLy;
	private JRadioButton rbTT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frameLogin frame = new frameLogin();
					//frame.setVisible(true);
					frameMain frameMain=new frameMain();
					frameMain.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(86, 98, 110, 25);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(217, 98, 140, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(86, 137, 110, 25);
		contentPane.add(lblMtKhu);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(217, 137, 140, 25);
		contentPane.add(txtPw);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(frameLogin.class.getResource("/icon/Person-Male-Light-icon-48.png")));
		lblNewLabel_1.setBounds(190, 12, 90, 75);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDN = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDN.addActionListener(new Login());
		btnDN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDN.setBounds(107, 216, 110, 40);
		contentPane.add(btnDN);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(227, 216, 110, 40);
		contentPane.add(btnThoat);
		
		rbQuanLy = new JRadioButton("Qu\u1EA3n l\u00FD");
		rbQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbQuanLy.setBounds(117, 175, 95, 23);
		contentPane.add(rbQuanLy);
		
		rbTT = new JRadioButton("Th\u1EE7 th\u01B0");
		rbTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbTT.setBounds(231, 175, 95, 23);
		contentPane.add(rbTT);
	}
	
	private class Login implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Login();
		}
	}
	
	private void Login() {
		try {
			String typeUser="QL";
			if(rbTT.isSelected())
				typeUser="TT";
			@SuppressWarnings("deprecation")
			Account acc=new Account(txtUser.getText(), txtPw.getText(), typeUser);
			AccountDAO dao=new AccountDAO();
			if(dao.Login(acc)) {
				if(typeUser.equals("TT")) {
					frameMain f=new frameMain();
					f.setVisible(true);
				}
				else {
					//
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
