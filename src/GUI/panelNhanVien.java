package GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.DauSachDAO;
import Model.NXB;
import Model.NXBDAO;
import Model.*;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.CompletionHandler;

public class panelNhanVien extends JPanel {
	private JTextField txtMaNXB;
	private JTextField txtTenNXB;
	private JTextArea txtDCNXB;
	private JTextField txtSDTNXB;
	private JTable tableNXB;
	private JTextField txtMaCuonSach;
	private JTextField txtTuaCuonSach;
	private JTextField txtNXBCuonSach;
	private JTable tableCuonSach;
	private JTextField MaNhanVienTextBox;
	private JTextField HoTenNhanVienTextBox;
	private JTextField DiaChiTextBox;
	private JTextField SoDienThoaiTextBox;
	private JTextField LuongNhanVienTextBox;
	private Component frameMain;

	/**
	 * Create the panel.
	 */
	public panelNhanVien() {
		setBounds(new Rectangle(0, 0, 1000, 600));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tabbedPane);
		InitTableDauSach();
		//Panel Ä‘áº§u sÃ¡ch
				JPanel panel_tabDauSach = new JPanel();
				panel_tabDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
				tabbedPane.addTab("Thông tin cá nhân", null, panel_tabDauSach, null);
				panel_tabDauSach.setLayout(null);
				
				JLabel nhanVienLabel = new JLabel("Mã nhân viên:");
				nhanVienLabel.setMaximumSize(new Dimension(300, 30));
				nhanVienLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
				nhanVienLabel.setPreferredSize(new Dimension(100, 20));
				nhanVienLabel.setBounds(30, 50, 300, 40);
				panel_tabDauSach.add(nhanVienLabel);
				
				JLabel HoTenNhanVienLabel = new JLabel("Họ và tên:");
				HoTenNhanVienLabel.setMaximumSize(new Dimension(300, 30));
				HoTenNhanVienLabel.setPreferredSize(new Dimension(100, 20));
				HoTenNhanVienLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
				HoTenNhanVienLabel.setBounds(30, 100, 300, 40);
				panel_tabDauSach.add(HoTenNhanVienLabel);
				
				JLabel lblaCh = new JLabel("Địa chỉ:");
				lblaCh.setMaximumSize(new Dimension(300, 30));
				lblaCh.setPreferredSize(new Dimension(100, 20));
				lblaCh.setFont(new Font("Tahoma", Font.BOLD, 30));
				lblaCh.setBounds(30, 150, 300, 40);
				panel_tabDauSach.add(lblaCh);
				
				JLabel lblSinThoi_1 = new JLabel("Số điện thoại:");
				lblSinThoi_1.setMaximumSize(new Dimension(300, 30));
				lblSinThoi_1.setPreferredSize(new Dimension(100, 20));
				lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 30));
				lblSinThoi_1.setBounds(30, 200, 300, 40);
				panel_tabDauSach.add(lblSinThoi_1);
				
				JLabel lblSinThoi_1_1 = new JLabel("Lương:");
				lblSinThoi_1_1.setMaximumSize(new Dimension(300, 30));
				lblSinThoi_1_1.setPreferredSize(new Dimension(100, 20));
				lblSinThoi_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
				lblSinThoi_1_1.setBounds(30, 250, 300, 40);
				lblSinThoi_1.setFocusable(false);
				panel_tabDauSach.add(lblSinThoi_1_1);
				
				MaNhanVienTextBox = new JTextField();
				MaNhanVienTextBox.setMaximumSize(new Dimension(300, 30));
				MaNhanVienTextBox.setBounds(250, 50, 300, 40);
				panel_tabDauSach.add(MaNhanVienTextBox);
				MaNhanVienTextBox.setColumns(10);
				
				HoTenNhanVienTextBox = new JTextField();
				HoTenNhanVienTextBox.setMaximumSize(new Dimension(300, 30));
				HoTenNhanVienTextBox.setBounds(250, 100, 300, 40);
				panel_tabDauSach.add(HoTenNhanVienTextBox);
				HoTenNhanVienTextBox.setColumns(10);
				
				DiaChiTextBox = new JTextField();
				DiaChiTextBox.setMaximumSize(new Dimension(300, 30));
				DiaChiTextBox.setBounds(250, 150, 300, 40);
				panel_tabDauSach.add(DiaChiTextBox);
				DiaChiTextBox.setColumns(10);
				
				SoDienThoaiTextBox = new JTextField();
				SoDienThoaiTextBox.setMaximumSize(new Dimension(300, 30));
				SoDienThoaiTextBox.setBounds(250, 200, 300, 40);
				panel_tabDauSach.add(SoDienThoaiTextBox);
				SoDienThoaiTextBox.setColumns(10);
				
				LuongNhanVienTextBox = new JTextField();
				LuongNhanVienTextBox.setMaximumSize(new Dimension(300, 30));
				LuongNhanVienTextBox.setBounds(250, 250, 300, 40);
				panel_tabDauSach.add(LuongNhanVienTextBox);
				LuongNhanVienTextBox.setColumns(10);

		JPanel panel_tabNXB = new JPanel();
		panel_tabNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.addTab("Danh sách nhân viên", null, panel_tabNXB, null);
		panel_tabNXB.setLayout(null);

		txtMaNXB = new JTextField();
		txtMaNXB.setBounds(955, 11, 180, 25);
		panel_tabNXB.add(txtMaNXB);
		txtMaNXB.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(852, 11, 100, 25);
		panel_tabNXB.add(lblNewLabel);

		JLabel lblTnNxb = new JLabel("Tên nhân viên");
		lblTnNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNxb.setBounds(852, 47, 100, 25);
		panel_tabNXB.add(lblTnNxb);

		txtTenNXB = new JTextField();
		txtTenNXB.setColumns(10);
		txtTenNXB.setBounds(955, 47, 180, 25);
		panel_tabNXB.add(txtTenNXB);

		JLabel lblaChNxb = new JLabel("Địa chỉ");
		lblaChNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaChNxb.setBounds(852, 83, 100, 25);
		panel_tabNXB.add(lblaChNxb);

		JScrollPane scrollPane_DCNXB = new JScrollPane();
		scrollPane_DCNXB.setBounds(955, 83, 180, 69);
		panel_tabNXB.add(scrollPane_DCNXB);

		txtDCNXB = new JTextArea();
		scrollPane_DCNXB.setViewportView(txtDCNXB);
		txtDCNXB.setWrapStyleWord(true);
		txtDCNXB.setRows(10);
		txtDCNXB.setLineWrap(true);
		txtDCNXB.setColumns(10);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(852, 163, 100, 25);
		panel_tabNXB.add(lblSinThoi);

		txtSDTNXB = new JTextField();
		txtSDTNXB.setColumns(10);
		txtSDTNXB.setBounds(955, 163, 180, 25);
		panel_tabNXB.add(txtSDTNXB);

		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setBounds(10, 11, 810, 450);
		panel_tabNXB.add(scrollPaneNXB);

		tableNXB = new JTable();
		tableNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneNXB.setViewportView(tableNXB);
		InitTableNXB();// Khá»Ÿi táº¡o báº£ng NXB

		JButton btnThemNXB = new JButton("Thêm");
		btnThemNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNXB();
			}
		});
		btnThemNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNXB.setBounds(877, 227, 110, 40);
		panel_tabNXB.add(btnThemNXB);

		JButton btnSuaNXB = new JButton("Sửa");
		btnSuaNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNXB();
			}
		});
		btnSuaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaNXB.setBounds(997, 227, 110, 40);
		panel_tabNXB.add(btnSuaNXB);

		JButton btnXoaNXB = new JButton("Xóa");
		btnXoaNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaNXB();
			}
		});
		btnXoaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaNXB.setBounds(877, 278, 110, 40);
		panel_tabNXB.add(btnXoaNXB);

		JButton btnTimNXB = new JButton("T\u00ECm");
		btnTimNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimNXB.setBounds(997, 278, 110, 40);
		panel_tabNXB.add(btnTimNXB);

		JPanel panel_tabSach = new JPanel();
		panel_tabSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.addTab("S\u00E1ch", null, panel_tabSach, null);
		panel_tabSach.setLayout(null);

		txtMaCuonSach = new JTextField();
		txtMaCuonSach.setColumns(10);
		txtMaCuonSach.setBounds(930, 11, 102, 25);
		panel_tabSach.add(txtMaCuonSach);

		JLabel lblMSch = new JLabel("M\u00E3 S\u00E1ch");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSch.setBounds(830, 11, 102, 25);
		panel_tabSach.add(lblMSch);

		JLabel lblTaSch_1 = new JLabel("T\u1EF1a s\u00E1ch");
		lblTaSch_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch_1.setBounds(830, 47, 92, 25);
		panel_tabSach.add(lblTaSch_1);

		txtTuaCuonSach = new JTextField();
		txtTuaCuonSach.setColumns(10);
		txtTuaCuonSach.setBounds(930, 47, 205, 25);
		panel_tabSach.add(txtTuaCuonSach);

		JLabel lblNhXutBn_1 = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n");
		lblNhXutBn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn_1.setBounds(830, 83, 92, 25);
		panel_tabSach.add(lblNhXutBn_1);

		JButton btnTimSach = new JButton("T\u00ECm");
		btnTimSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimSach.setBounds(1042, 12, 93, 24);
		panel_tabSach.add(btnTimSach);

		txtNXBCuonSach = new JTextField();
		txtNXBCuonSach.setColumns(10);
		txtNXBCuonSach.setBounds(930, 83, 205, 25);
		panel_tabSach.add(txtNXBCuonSach);
		
		JScrollPane scrollPaneCuonSach = new JScrollPane();
		scrollPaneCuonSach.setBounds(10, 11, 800, 477);
		panel_tabSach.add(scrollPaneCuonSach);

		tableCuonSach = new JTable();
		scrollPaneCuonSach.setViewportView(tableCuonSach);
		
		JButton btnTimDauSach_1 = new JButton("TÃ¬m");
		btnTimDauSach_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimDauSach_1.setBounds(930, 146, 110, 40);
		panel_tabSach.add(btnTimDauSach_1);

	}

	DefaultComboBoxModel customComboBoxModel() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		try {
			NXBDAO nxbDAO = new NXBDAO();
			ArrayList<NXB> list = nxbDAO.GetAllNXB();
			for (NXB nxb : list) {
				model.addElement(nxb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	
	private void InitTableDauSach() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		model.addColumn("Lương");
		tableNXB
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!model2.isSelectionEmpty()) {
					int index=model2.getMinSelectionIndex();
					txtMaDauSach.setText(tableDauSach.getValueAt(index, 0).toString());
					txtTuaSach.setText(tableDauSach.getValueAt(index, 1).toString());
					String[] tgString = tableDauSach.getValueAt(index, 2).toString().split("-");
					txtTacGia.setText(String.join("\n", tgString));

					for (int i = 0; i < cBNXB.getItemCount(); i++) {
						if (((NXB) cBNXB.getItemAt(i)).getTenNXB().equals(tableDauSach.getValueAt(index, 3).toString())) {
							cBNXB.setSelectedIndex(i);
							break;
						}
					}
				}
				
			}
		});
			LoadDataDauSach(null);
	}

	private void LoadDataDauSach(ResultSet rs) {
		try {
			if (rs == null) {
				DauSachDAO dauSachDAO = new DauSachDAO();
				rs = dauSachDAO.GetAllDauSach();
			}
			model.setRowCount(0);

			while (rs.next()) {
				model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void LoadDataComboBoxNXB() {

	}

	private class NXBListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (value instanceof NXB) {
				NXB nxb = (NXB) value;
				value = nxb.getTenNXB();
			}
			// TODO Auto-generated method stub
			return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}

	}

	private void InitTableNXB()// Khá»Ÿi táº¡o báº£ng NXB
	{
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		model.addColumn("Lương");
		tableNXB.setModel(model);
		ListSelectionModel model2=tableNXB.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!model2.isSelectionEmpty()) {
					int index=model2.getMinSelectionIndex();
					txtMaNXB.setText(tableNXB.getValueAt(index, 0).toString());
					txtTenNXB.setText(tableNXB.getValueAt(index, 1).toString());
					txtDCNXB.setText(tableNXB.getValueAt(index, 2).toString());
					txtSDTNXB.setText(tableNXB.getValueAt(index, 3).toString());
					txtSDTNXB.setText(tableNXB.getValueAt(index, 4).toString());
				}
				
			}
		});
		LoadDataTableNXB(null);

	}

	private void LoadDataTableNXB(ArrayList<NhanVien> list)// load dá»¯ liá»‡u cho báº£ng NXB
	{
		try {
			if (list == null) {
				NhanVienDAO nhanVienDAO = new NhanVienDAO();
				list = nhanVienDAO.GetAllNhanVien();
				
			}
			DefaultTableModel model = (DefaultTableModel) tableNXB.getModel();
			model.setRowCount(0);

			for (NhanVien nxb : list) {
				model.addRow(new Object[] { nxb.getMa(), nxb.getTenString(), nxb.getDiaChiString(), nxb.getSDT(), nxb.getLuong()});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private void InitTableCuonSach() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MÃ£ cuá»‘n");
		model.addColumn("Tá»±a SÃ¡ch");
		model.addColumn("TÃ¡c giáº£");
		model.addColumn("NhÃ  xuáº¥t báº£n");
		model.addColumn("Tráº¡ng thÃ¡i");
		tableCuonSach.setModel(model);
		
		ListSelectionModel model2=tableCuonSach.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!model2.isSelectionEmpty()) {
					int index=model2.getMinSelectionIndex();
					txtMaDauSach.setText(tableDauSach.getValueAt(index, 0).toString());
					txtTuaSach.setText(tableDauSach.getValueAt(index, 1).toString());
					String[] tgString = tableDauSach.getValueAt(index, 2).toString().split("-");
					txtTacGia.setText(String.join("\n", tgString));

					for (int i = 0; i < cBNXB.getItemCount(); i++) {
						if (((NXB) cBNXB.getItemAt(i)).getTenNXB().equals(tableDauSach.getValueAt(index, 3).toString())) {
							cBNXB.setSelectedIndex(i);
							break;
						}
					}
				}
				
			}
		});
			LoadDataDauSach(null);
	}

	private void LoadDataCuonSach(ResultSet rs) {
		try {
			if (rs == null) {
				DauSachDAO dauSachDAO = new DauSachDAO();
				rs = dauSachDAO.GetAllDauSach();
			}
			DefaultTableModel model = (DefaultTableModel) tableDauSach.getModel();
			model.setRowCount(0);

			while (rs.next()) {
				model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	private void ThemNXB() {
		String typeString = null ;
		try {
			if (txtMaNXB.getText().isEmpty() || txtTenNXB.getText().isEmpty() || txtDCNXB.getText().isEmpty()
					|| txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền đầy đủ thông tin !!", "Nhân viên");
				return;
			}
			NhanVien nhanVien = new NhanVien(Integer.parseInt(txtMaNXB.getText()), txtTenNXB.getText(), txtDCNXB.getText(), txtSDTNXB.getText(), 0);
			
			NhanVienDAO dao = new NhanVienDAO();
			AccountDAO accountDAO = new AccountDAO();			
			int output = JOptionPane.showConfirmDialog(frameMain,
                    "Thêm nhân viên này làm quản lý?", "Thêm nhân viên",
                    JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE);
            if (output == JOptionPane.YES_OPTION) {
                //statusLabel.setText("Yes selected.");
            	typeString ="QL";
            	Account account = new Account(txtMaNXB.getText(), "12345", typeString, txtMaNXB.getText());
            	if (dao.Insert(nhanVien)) {
    				Alert.ShowMessageInfo("Thêm quản lý thành công: Tên đăng nhập: " + txtMaNXB.getText() + "Mật khẩu: 123456" , "Nhân viên");
    				LoadDataTableNXB(null);
    				accountDAO.Insert(account);
    			}
    			else {
    				Alert.ShowMessageWarn("Thêm nhân viên không thành công!! Vui lòng kiểm tra lại", "Nhân viên");
    			}
            	
            } else if (output == JOptionPane.NO_OPTION) {
                //statusLabel.setText("No selected.");
            	typeString ="NV";
            	Account account = new Account(txtMaNXB.getText(), "12345", typeString, txtMaNXB.getText());
            	if (dao.Insert(nhanVien)) {
    				Alert.ShowMessageInfo("Thêm nhân viên thành công: Tên đăng nhập: " + txtMaNXB.getText() + "Mật khẩu: 123456" , "Nhân viên");
    				LoadDataTableNXB(null);
    				accountDAO.Insert(account);
    			}
    			else {
    				Alert.ShowMessageWarn("Thêm nhân viên không thành công!! Vui lòng kiểm tra lại", "Nhân viên");
    			}
            } else if (output == JOptionPane.CANCEL_OPTION) {
            	Alert.ShowMessageWarn("Thêm nhân viên không thành công!! Vui lòng kiểm tra lại", "Nhân viên");
            }
            

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi thêm nhân viên", "Thêm nhân viên");

		}
	}

	private void SuaNXB() {
		try {
			if (txtMaNXB.getText().isEmpty() || txtTenNXB.getText().isEmpty() || txtDCNXB.getText().isEmpty()
					|| txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lÃ²ng Ä‘iá»�n dáº§y Ä‘á»§ thÃ´ng tin", "NhÃ  xuáº¥t báº£n");
				return;
			}
			NXB nxb = new NXB(txtMaNXB.getText(), txtTenNXB.getText(), txtDCNXB.getText(), txtSDTNXB.getText());
			NXBDAO dao = new NXBDAO();
			if (dao.Update(nxb)) {
				Alert.ShowMessageInfo("Cáº­p nháº­t nhÃ  xuáº¥t báº£n thÃ nh cÃ´ng", "NhÃ  xuáº¥t báº£n");
				LoadDataTableNXB(null);
			}
			
			else {
				Alert.ShowMessageWarn("Cáº­p nháº­t nhÃ  xuáº¥t báº£n khÃ´ng thÃ nh cÃ´ng. Vui lÃ²ng kiá»ƒm tra láº¡i", "NhÃ  xuáº¥t báº£n");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lá»—i cáº­p nháº­t nhÃ  xuáº¥t báº£n", "NhÃ  xuáº¥t báº£n");

		}
	}

	private void XoaNXB() {
		try {
			if (txtMaNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lÃ²ng Ä‘iá»�n mÃ£ nhÃ  xuáº¥t báº£n cáº§n xoÃ¡", "NhÃ  xuáº¥t báº£n");
				return;
			}
			NXBDAO dao = new NXBDAO();
			if (dao.Delete(txtMaNXB.getText())) {
				Alert.ShowMessageInfo("XoÃ¡ nhÃ  xuáº¥t báº£n thÃ nh cÃ´ng", "NhÃ  xuáº¥t báº£n");
				LoadDataTableNXB(null);
			}
			else {
				Alert.ShowMessageWarn("XoÃ¡ nhÃ  xuáº¥t báº£n khÃ´ng thÃ nh cÃ´ng. Vui lÃ²ng kiá»ƒm tra láº¡i", "NhÃ  xuáº¥t báº£n");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lá»—i xoÃ¡ nhÃ  xuáº¥t báº£n", "NhÃ  xuáº¥t báº£n");
		}
	}

	// Region Event
	
	
	 

	private class ClickCellTableDauSach extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = tableDauSach.getSelectedRow();
			if (index != -1) {
				txtMaDauSach.setText(tableDauSach.getValueAt(index, 0).toString());
				txtTuaSach.setText(tableDauSach.getValueAt(index, 1).toString());
				String[] tgString = tableDauSach.getValueAt(index, 2).toString().split("-");
				txtTacGia.setText(String.join("\n", tgString));

				for (int i = 0; i < cBNXB.getItemCount(); i++) {
					if (((NXB) cBNXB.getItemAt(i)).getTenNXB().equals(tableDauSach.getValueAt(index, 3).toString())) {
						cBNXB.setSelectedIndex(i);
						break;
					}
				}
			}
		}
	}

	private class ClickCellTableNXB extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = tableNXB.getSelectedRow();
			if (index != -1) {
				txtMaNXB.setText(tableNXB.getValueAt(index, 0).toString());
				txtTenNXB.setText(tableNXB.getValueAt(index, 1).toString());
				txtDCNXB.setText(tableNXB.getValueAt(index, 2).toString());
				txtSDTNXB.setText(tableNXB.getValueAt(index, 3).toString());
			}
		}
	}
}
