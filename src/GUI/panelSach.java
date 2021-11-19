package GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;

import Model.KhachHang;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class panelSach extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tableNXB;
	private JTextField txtMaDauSach;
	private JTextField txtTuaSach;
	private JTable tableDauSach;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public panelSach() {
		setBounds(new Rectangle(0, 0, 1000, 600));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tabbedPane);

		JPanel panel_tabSach = new JPanel();
		panel_tabSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.addTab("S\u00E1ch", null, panel_tabSach, null);
		panel_tabSach.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(930, 11, 205, 25);
		panel_tabSach.add(textField_4);
		
		JLabel lblMSch = new JLabel("M\u00E3 S\u00E1ch");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSch.setBounds(830, 11, 102, 25);
		panel_tabSach.add(lblMSch);
		
		JLabel lblTaSch_1 = new JLabel("T\u1EF1a s\u00E1ch");
		lblTaSch_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch_1.setBounds(830, 47, 92, 25);
		panel_tabSach.add(lblTaSch_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(930, 47, 205, 25);
		panel_tabSach.add(textField_5);
		
		JLabel lblNhXutBn_1 = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n");
		lblNhXutBn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn_1.setBounds(830, 83, 117, 25);
		panel_tabSach.add(lblNhXutBn_1);
		
		JButton btnThemNXB_1_1 = new JButton("Th\u00EAm");
		btnThemNXB_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNXB_1_1.setBounds(878, 143, 110, 40);
		panel_tabSach.add(btnThemNXB_1_1);
		
		JButton btnSuaNXB_1_1 = new JButton("S\u1EEDa");
		btnSuaNXB_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaNXB_1_1.setBounds(998, 143, 110, 40);
		panel_tabSach.add(btnSuaNXB_1_1);
		
		JButton btnXoaNXB_1_1 = new JButton("Xo\u00E1");
		btnXoaNXB_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaNXB_1_1.setBounds(878, 194, 110, 40);
		panel_tabSach.add(btnXoaNXB_1_1);
		
		JButton btnTimNXB_1_1 = new JButton("T\u00ECm");
		btnTimNXB_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimNXB_1_1.setBounds(998, 194, 110, 40);
		panel_tabSach.add(btnTimNXB_1_1);
		
		JComboBox cBNXB_1 = new JComboBox();
		cBNXB_1.setBounds(930, 83, 205, 25);
		panel_tabSach.add(cBNXB_1);
		
				JPanel panel_tabDauSach = new JPanel();
				panel_tabDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
				tabbedPane.addTab("\u0110\u1EA7u s\u00E1ch", null, panel_tabDauSach, null);
				panel_tabDauSach.setLayout(null);
				
						txtMaDauSach = new JTextField();
						txtMaDauSach.setColumns(10);
						txtMaDauSach.setBounds(930, 11, 205, 25);
						panel_tabDauSach.add(txtMaDauSach);
						
								JLabel lblMuSch = new JLabel("M\u00E3 \u0110\u1EA7u S\u00E1ch");
								lblMuSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblMuSch.setBounds(830, 11, 117, 25);
								panel_tabDauSach.add(lblMuSch);
								
										JLabel lblTaSch = new JLabel("T\u1EF1a s\u00E1ch");
										lblTaSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
										lblTaSch.setBounds(830, 47, 117, 25);
										panel_tabDauSach.add(lblTaSch);
										
												txtTuaSach = new JTextField();
												txtTuaSach.setColumns(10);
												txtTuaSach.setBounds(930, 47, 205, 25);
												panel_tabDauSach.add(txtTuaSach);
												
														JLabel lblNhXutBn = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n");
														lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
														lblNhXutBn.setBounds(830, 83, 117, 25);
														panel_tabDauSach.add(lblNhXutBn);
														
																JButton btnThemNXB_1 = new JButton("Th\u00EAm");
																btnThemNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
																btnThemNXB_1.setBounds(878, 143, 110, 40);
																panel_tabDauSach.add(btnThemNXB_1);
																
																		JButton btnSuaNXB_1 = new JButton("S\u1EEDa");
																		btnSuaNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
																		btnSuaNXB_1.setBounds(998, 143, 110, 40);
																		panel_tabDauSach.add(btnSuaNXB_1);
																		
																				JButton btnXoaNXB_1 = new JButton("Xo\u00E1");
																				btnXoaNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
																				btnXoaNXB_1.setBounds(878, 194, 110, 40);
																				panel_tabDauSach.add(btnXoaNXB_1);
																				
																						JButton btnTimNXB_1 = new JButton("T\u00ECm");
																						btnTimNXB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
																						btnTimNXB_1.setBounds(998, 194, 110, 40);
																						panel_tabDauSach.add(btnTimNXB_1);
																						
																								JComboBox cBNXB = new JComboBox();
																								cBNXB.setBounds(930, 83, 205, 25);
																								panel_tabDauSach.add(cBNXB);
																								cBNXB.setModel(customComboBoxModel());
																								
																								tableDauSach = new JTable();
																								tableDauSach.setBounds(10, 11, 810, 477);
																								panel_tabDauSach.add(tableDauSach);
		
		
		JPanel panel_tabNXB = new JPanel();
		panel_tabNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.addTab("Nh\u00E0 xu\u1EA5t b\u1EA3n", null, panel_tabNXB, null);
		panel_tabNXB.setLayout(null);

		textField = new JTextField();
		textField.setBounds(955, 11, 180, 25);
		panel_tabNXB.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("M\u00E3 NXB");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(852, 11, 100, 25);
		panel_tabNXB.add(lblNewLabel);

		JLabel lblTnNxb = new JLabel("T\u00EAn NXB");
		lblTnNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNxb.setBounds(852, 47, 100, 25);
		panel_tabNXB.add(lblTnNxb);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(955, 47, 180, 25);
		panel_tabNXB.add(textField_1);

		JLabel lblaChNxb = new JLabel("\u0110\u1ECBa ch\u1EC9 NXB");
		lblaChNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaChNxb.setBounds(852, 83, 100, 25);
		panel_tabNXB.add(lblaChNxb);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(955, 83, 180, 69);
		panel_tabNXB.add(textField_2);

		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(852, 163, 100, 25);
		panel_tabNXB.add(lblSinThoi);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(955, 163, 180, 25);
		panel_tabNXB.add(textField_3);

		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setBounds(10, 11, 810, 450);
		panel_tabNXB.add(scrollPaneNXB);

		tableNXB = new JTable();
		scrollPaneNXB.setViewportView(tableNXB);

		JButton btnThemNXB = new JButton("Th\u00EAm");
		btnThemNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNXB.setBounds(852, 227, 110, 40);
		panel_tabNXB.add(btnThemNXB);

		JButton btnSuaNXB = new JButton("S\u1EEDa");
		btnSuaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaNXB.setBounds(972, 227, 110, 40);
		panel_tabNXB.add(btnSuaNXB);

		JButton btnXoaNXB = new JButton("Xo\u00E1");
		btnXoaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaNXB.setBounds(852, 278, 110, 40);
		panel_tabNXB.add(btnXoaNXB);

		JButton btnTimNXB = new JButton("T\u00ECm");
		btnTimNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimNXB.setBounds(972, 278, 110, 40);
		panel_tabNXB.add(btnTimNXB);

	}
	
	
	DefaultComboBoxModel customComboBoxModel() {
		DefaultComboBoxModel model=new DefaultComboBoxModel();
		model.addElement("NXB 1");
		model.addElement("NXB 2");
		/*
		 * for (KhachHang kh : listKH) { model.addElement(kh); }
		 */
		
		return model;
	}
}
