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

public class frameMain extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Sach;
	private JPanel panel_DocGia;
	private JPanel panel_Muon;
	private JPanel panel_In;
	private JPanel panelMain;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public frameMain() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnTabSach.setBounds(10, 25, 100, 80);
		panel.add(btnTabSach);
		btnTabSach.setIcon(new ImageIcon(frameMain.class.getResource("/icon/Actions-document-edit-icon-32.png")));
		btnTabSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTabDocGia = new JButton("\u0110\u1ED9c gi\u1EA3");
		btnTabDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_DocGia);
			}
		});
		btnTabDocGia.setIcon(new ImageIcon(frameMain.class.getResource("/icon/10207-man-student-light-skin-tone-icon-32.png")));
		btnTabDocGia.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabDocGia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabDocGia.setBounds(120, 25, 100, 80);
		panel.add(btnTabDocGia);
		
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
		
		JButton btnTabMuon = new JButton("M\u01B0\u1EE3n/Tr\u1EA3");
		btnTabMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(panel_Muon);
			}
		});
		btnTabMuon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabMuon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabMuon.setBounds(230, 25, 100, 80);
		panel.add(btnTabMuon);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(0, 255, 127));
		panelMain.setBounds(10, 110, 1164, 530);
		contentPane.add(panelMain);
		
		panel_Sach=new panelSach();
		panel_DocGia=new panelDocGia();
		panel_Muon=new panelMuon();
		panelMain.setLayout(new BorderLayout(0, 0));
		
		
		changePanel(panel_Sach);
		
			
	}
	
	private void changePanel(JPanel pnl) {
		panel_DocGia.setVisible(false);
		panel_Sach.setVisible(false);
		panelMain.removeAll();
		
		pnl.setVisible(true);
		panelMain.add(pnl,BorderLayout.CENTER);
		
	}
}
