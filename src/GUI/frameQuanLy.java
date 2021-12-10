package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Global;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class frameQuanLy extends JFrame {

	private JPanel contentPane;
	private JPanel panelMain;
	private JPanel panel_NhanVien;
	private JPanel panel_Log;
	private JPanel panel_ThongKe;
	private int maNV=0;
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
	public frameQuanLy() {
		setTitle("Quản lý");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 20, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_NhanVien=new panelNhanVien();
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1164, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(120, 35, -11, 100);
		panel.add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 695, 22);
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
		
		JMenuItem mnItemInfo = new JMenuItem("Cập nhật thông tin");
		mnItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frameThongTin fThongTin=new frameThongTin(Global.getMaNV());
					fThongTin.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		menuTaiKhoan.add(mnItemInfo);
		
		JButton btnTabNhanVien = new JButton("Nhân viên");
		btnTabNhanVien.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/people_48px.png")));
		btnTabNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePanel(panel_NhanVien);
			}
		});
		btnTabNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabNhanVien.setBounds(0, 25, 100, 80);
		panel.add(btnTabNhanVien);
		
		JButton btnTabThongKe = new JButton("Thống kê");
		btnTabThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_ThongKe);
			}
		});
		btnTabThongKe.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/statistics_48px.png")));
		btnTabThongKe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabThongKe.setBounds(100, 25, 100, 80);
		panel.add(btnTabThongKe);
		
		JButton btnTabLog = new JButton("Hoạt động");
		btnTabLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_Log);
			}
		});
		btnTabLog.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/log_48px.png")));
		btnTabLog.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabLog.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabLog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabLog.setBounds(200, 25, 100, 80);
		panel.add(btnTabLog);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(0, 255, 127));
		panelMain.setBounds(10, 110, 1164, 530);
		contentPane.add(panelMain);
		
		panel_Log=new panelLog();
		panel_NhanVien = new panelNhanVien();
		panel_ThongKe=new panelThongKe();
		panelMain.setLayout(new BorderLayout(0, 0));
		
		
		changePanel(panel_NhanVien);
		
			
	}
	
	private void changePanel(JPanel pnl) {
		panel_NhanVien.setVisible(false);
		panel_Log.setVisible(false);
		panel_ThongKe.setVisible(false);
		panelMain.removeAll();
		
		pnl.setVisible(true);
		panelMain.add(pnl,BorderLayout.CENTER);
		
	}
}
