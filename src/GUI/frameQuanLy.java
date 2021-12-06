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
	private JPanel panel_Sach;
	private JPanel panel_DocGia;
	private JPanel panel_Muon;
	private JPanel panel_In;
	private JPanel panelMain;
	private JPanel panel_NhanVien;
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
		menuTab.add(mnItemExit);
		
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
		btnTabNhanVien.setBounds(10, 25, 100, 80);
		panel.add(btnTabNhanVien);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(0, 255, 127));
		panelMain.setBounds(10, 110, 1164, 530);
		contentPane.add(panelMain);
		
		panel_Sach=new panelSach();
		panel_DocGia=new panelDocGia();
		panel_Muon=new panelMuon();
		panel_NhanVien = new panelNhanVien();
		panelMain.setLayout(new BorderLayout(0, 0));
		
		
		changePanel(panel_NhanVien);
		
			
	}
	
	private void changePanel(JPanel pnl) {
		panel_NhanVien.setVisible(false);
		panelMain.removeAll();
		
		pnl.setVisible(true);
		panelMain.add(pnl,BorderLayout.CENTER);
		
	}
}
