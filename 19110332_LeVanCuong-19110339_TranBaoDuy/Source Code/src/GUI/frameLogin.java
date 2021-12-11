package GUI;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Account;
import Model.AccountDAO;
import Model.Global;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class frameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPw;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public frameLogin() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(60, 105, 110, 25);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUser.setBounds(180, 105, 177, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(60, 144, 110, 25);
		contentPane.add(lblMtKhu);
		
		txtPw = new JPasswordField();
		txtPw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPw.setBounds(180, 144, 177, 25);
		contentPane.add(txtPw);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(frameLogin.class.getResource("/icon/test_account_100px.png")));
		lblNewLabel_1.setBounds(166, 11, 95, 83);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDN = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDN.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
		btnDN.addActionListener(new Login());
		btnDN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDN.setBounds(90, 225, 110, 40);
		contentPane.add(btnDN);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(230, 225, 110, 40);
		contentPane.add(btnThoat);
		ButtonGroup group = new ButtonGroup();
	}
	
	private class Login implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Login();
		}
	}
	
	private void Login() {
		try {
			@SuppressWarnings("deprecation")
			AccountDAO dao=new AccountDAO();
			Account acc=dao.Login(txtUser.getText(), txtPw.getText());
			String typeUser = acc.getTypeUser();
			//System.out.println(acc.getMaNV());
			if(acc!=null) {
				if(typeUser.equals("TT")) {
					Global.setMaNV(acc.getMaNV());
					this.setVisible(false);
					frameMain f=new frameMain();
					f.setVisible(true);
				}
				else {
					Global.setMaNV(acc.getMaNV());
					this.setVisible(false);
					frameQuanLy qLy=new frameQuanLy();
					qLy.setVisible(true);
					qLy.setMaNV(acc.getMaNV());
				}
			}
			else {
				Alert.ShowMessageInfo("Sai mật khẩu hoặc tên đăng nhập. Vui lòng nhập lại", "Đăng nhập");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
