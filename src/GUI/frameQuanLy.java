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
	
	private JPanel panel_Sach;
	private JPanel panel_DocGia;
	private JPanel panel_Muon;
	private JPanel panel_TraCuu;
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
		menuBar.setBounds(0, 0, 1164, 22);
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
		
		JButton btnTabSach = new JButton("Sách");
		btnTabSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_Sach);
			}
		});
		btnTabSach.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/books_48px.png")));
		btnTabSach.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabSach.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabSach.setBounds(300, 25, 100, 80);
		panel.add(btnTabSach);
		
		JButton btnTabDocGia = new JButton("Độc giả");
		btnTabDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_DocGia);
			}
		});
		btnTabDocGia.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/identification_documents_48px.png")));
		btnTabDocGia.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabDocGia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabDocGia.setBounds(400, 25, 100, 80);
		panel.add(btnTabDocGia);
		
		JButton btnTabMuon = new JButton("Mượn/Trả");
		btnTabMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_Muon);
			}
		});
		btnTabMuon.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/paid_bill_48px.png")));
		btnTabMuon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabMuon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabMuon.setBounds(500, 25, 100, 80);
		panel.add(btnTabMuon);
		
		JButton btnTabTraCuu = new JButton("Tra Cứu");
		btnTabTraCuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_TraCuu);
			}
		});
		btnTabTraCuu.setIcon(new ImageIcon(frameQuanLy.class.getResource("/icon/study_48px.png")));
		btnTabTraCuu.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabTraCuu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabTraCuu.setBounds(599, 25, 100, 80);
		panel.add(btnTabTraCuu);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(0, 255, 127));
		panelMain.setBounds(10, 110, 1164, 530);
		contentPane.add(panelMain);
		
		panel_Log=new panelLog();
		panel_NhanVien = new panelNhanVien();
		panel_ThongKe=new panelThongKe();
		panelMain.setLayout(new BorderLayout(0, 0));
		
		panel_Sach=new panelSach();
		panel_DocGia=new panelDocGia();
		panel_Muon=new panelMuon();
		panel_TraCuu=new panelTraCuu();
		
		changePanel(panel_NhanVien);
		
			
	}
	
	private void changePanel(JPanel pnl) {
		panel_NhanVien.setVisible(false);
		panel_Log.setVisible(false);
		panel_ThongKe.setVisible(false);
		
		panel_DocGia.setVisible(false);
		panel_Sach.setVisible(false);
		panel_Muon.setVisible(false);
		panel_TraCuu.setVisible(false);
		panelMain.removeAll();
		
		pnl.setVisible(true);
		panelMain.add(pnl,BorderLayout.CENTER);
		
	}
}
