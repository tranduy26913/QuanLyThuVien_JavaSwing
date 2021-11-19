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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JSeparator;

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
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1164, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnTabSach = new JButton("S\u00E1ch");
		btnTabSach.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabSach.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabSach.setBounds(10, 35, 100, 100);
		panel.add(btnTabSach);
		btnTabSach.setIcon(new ImageIcon(frameMain.class.getResource("/icon/Actions-document-edit-icon-48.png")));
		btnTabSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTabDocGia = new JButton("\u0110\u1ED9c gi\u1EA3");
		btnTabDocGia.setIcon(new ImageIcon(frameMain.class.getResource("/icon/10207-man-student-light-skin-tone-icon-64.png")));
		btnTabDocGia.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTabDocGia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTabDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTabDocGia.setBounds(120, 35, 100, 100);
		panel.add(btnTabDocGia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(120, 35, -11, 100);
		panel.add(separator);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(0, 255, 127));
		panelMain.setBounds(10, 140, 1164, 501);
		contentPane.add(panelMain);
		
		panelSach panel_Sach=new panelSach();
		panel_Sach.setVisible(true);
		panelMain.setLayout(new BorderLayout(0, 0));
		panelMain.add(panel_Sach);
		
		
	}
}
