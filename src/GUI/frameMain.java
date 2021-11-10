package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frameMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameMain frame = new frameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frameMain() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLaptop = new JButton("Laptop");
		btnLaptop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new frameLaptop();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLaptop.setBounds(10, 44, 110, 30);
		contentPane.add(btnLaptop);
		
		JButton btnKhachHng = new JButton("Kh\u00E1ch h\u00E0ng");
		btnKhachHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKhachHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new frameKhachHang();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnKhachHng.setBounds(138, 44, 110, 30);
		contentPane.add(btnKhachHng);
		
		JButton btnDonHang = new JButton("\u0110\u01A1n h\u00E0ng");
		btnDonHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDonHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new frameDonHang();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnDonHang.setBounds(258, 44, 110, 30);
		contentPane.add(btnDonHang);
	}

}
