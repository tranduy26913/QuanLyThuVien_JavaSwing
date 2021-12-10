package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Global;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class frameMain extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Sach;
	private JPanel panel_DocGia;
	private JPanel panel_Muon;
	private JPanel panel_TraCuu;
	private JPanel panelMain;
	private JPanel panel_Log;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public frameMain() {
		setTitle("Thủ thư");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1164, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnTabSach = new JButton("S\u00E1ch");
		btnTabSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_Sach);
			}
		});
		btnTabSach.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabSach.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabSach.setBounds(0, 25, 100, 80);
		panel.add(btnTabSach);
		btnTabSach.setIcon(new ImageIcon(frameMain.class.getResource("/icon/books_48px.png")));
		btnTabSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTabDocGia = new JButton("\u0110\u1ED9c gi\u1EA3");
		btnTabDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_DocGia);
			}
		});
		btnTabDocGia.setIcon(new ImageIcon(frameMain.class.getResource("/icon/identification_documents_48px.png")));
		btnTabDocGia.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabDocGia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabDocGia.setBounds(100, 25, 100, 80);
		panel.add(btnTabDocGia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(120, 35, -11, 100);
		panel.add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1187, 22);
		panel.add(menuBar);
		
		JMenu menuTab = new JMenu("File");
		menuBar.add(menuTab);
		
		JMenuItem mnItemExit = new JMenuItem("Tho\u00E1t");
		mnItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Program.frame.setVisible(true);
				dispose();
			}
		});
		menuTab.add(mnItemExit);
		
		JMenu menuTaiKhoan = new JMenu("Tài khoản");
		menuBar.add(menuTaiKhoan);
		
		JMenuItem mnItemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mnItemDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frameDoiMK frame=new frameDoiMK();
					frame.setVisible(true);
					frame.setMaNV(Global.getMaNV());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		menuTaiKhoan.add(mnItemDoiMatKhau);
		
		JButton btnTabMuon = new JButton("M\u01B0\u1EE3n/Tr\u1EA3");
		btnTabMuon.setIcon(new ImageIcon(frameMain.class.getResource("/icon/paid_bill_48px.png")));
		btnTabMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_Muon);
			}
		});
		btnTabMuon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabMuon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabMuon.setBounds(200, 25, 100, 80);
		panel.add(btnTabMuon);
		
		JButton btnTabLog = new JButton("Hoạt động");
		btnTabLog.setIcon(new ImageIcon(frameMain.class.getResource("/icon/log_48px.png")));
		btnTabLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePanel(panel_Log);
			}
		});
		btnTabLog.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabLog.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabLog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabLog.setBounds(300, 25, 100, 80);
		panel.add(btnTabLog);
		
		JButton btnTabTraCuu = new JButton("Tra Cứu");
		btnTabTraCuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_TraCuu);
			}
		});
		btnTabTraCuu.setIcon(new ImageIcon(frameMain.class.getResource("/icon/study_48px.png")));
		btnTabTraCuu.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabTraCuu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabTraCuu.setBounds(400, 25, 100, 80);
		panel.add(btnTabTraCuu);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(0, 255, 127));
		panelMain.setBounds(10, 110, 1164, 530);
		contentPane.add(panelMain);
		
		panel_Sach=new panelSach();
		panel_DocGia=new panelDocGia();
		panel_Muon=new panelMuon();
		panel_Log = new panelLog(Global.getMaNV(),1);
		panel_TraCuu=new panelTraCuu();
		panelMain.setLayout(new BorderLayout(0, 0));
		changePanel(panel_Sach);
		
			
	}
	
	private void changePanel(JPanel pnl) {
		panel_DocGia.setVisible(false);
		panel_Sach.setVisible(false);
		panel_Log.setVisible(false);
		panel_Muon.setVisible(false);
		panel_TraCuu.setVisible(false);
		panelMain.removeAll();
		
		pnl.setVisible(true);
		panelMain.add(pnl,BorderLayout.CENTER);
		
	}
}
