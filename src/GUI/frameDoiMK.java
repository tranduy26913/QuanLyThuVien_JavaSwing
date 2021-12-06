package GUI;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Account;
import Model.AccountDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frameDoiMK extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPwNew;
	private JPasswordField txtPwOld;
	private int maNV=-1;

	/**
	 * Launch the application.
	 */
	
	

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	/**
	 * Create the frame.
	 */
	public frameDoiMK() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu cũ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(88, 66, 110, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu mới");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(88, 105, 110, 25);
		contentPane.add(lblMtKhu);
		
		txtPwNew = new JPasswordField();
		txtPwNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPwNew.setBounds(192, 105, 167, 25);
		contentPane.add(txtPwNew);
		
		JButton btnDN = new JButton("Đổi mật khẩu");
		btnDN.addActionListener(new Login());
		btnDN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDN.setBounds(117, 171, 110, 40);
		contentPane.add(btnDN);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(237, 171, 110, 40);
		contentPane.add(btnThoat);
		
		txtPwOld = new JPasswordField();
		txtPwOld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPwOld.setBounds(192, 66, 167, 25);
		contentPane.add(txtPwOld);
		ButtonGroup group = new ButtonGroup();
	}
	
	private class Login implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			DoiMK();
		}
	}
	
	private void DoiMK() {
		try {
			if(maNV==-1) {
				Alert.ShowMessageError("Lỗi không tìm thấy mã nhân viên", "Đổi mật khẩu");
				return;
			}
			System.out.print(maNV);
			@SuppressWarnings("deprecation")
			
			AccountDAO dao=new AccountDAO();
			if(dao.DoiMatKhau(maNV, txtPwOld.getText(),txtPwNew.getText())) {
				Alert.ShowMessageInfo("Đổi mật khẩu thành công", "Đổi mật khẩu");
			}else {
				Alert.ShowMessageInfo("Đổi mật khẩu không thành công", "Đổi mật khẩu");
			}
			
		} catch (Exception e2) {
			Alert.ShowMessageInfo("Lỗi"+e2.getMessage(), "Đổi mật khẩu");
			e2.printStackTrace();
		}
	}
}
