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
import javax.swing.table.DefaultTableModel;

import Model.DauSachDAO;
import Model.NXB;
import Model.NXBDAO;
import Model.*;

import javax.swing.JLabel;
import javax.swing.JList;
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

public class panelSach extends JPanel {
	private JTextField txtMaNXB;
	private JTextField txtTenNXB;
	private JTextArea txtDCNXB;
	private JTextField txtSDTNXB;
	private JTable tableNXB;
	private JTextField txtMaDauSach;
	private JTextField txtTuaSach;
	private JTable tableDauSach;
	private JComboBox cBNXB;
	private JTextField txtMaCuonSach;
	private JTextField txtTuaCuonSach;
	private JTextField txtNXBCuonSach;
	private JTextField textField_7;
	private JTextArea txtTacGia;
	private JTable tableCuonSach;

	/**
	 * Create the panel.
	 */
	public panelSach() {
		setBounds(new Rectangle(0, 0, 1000, 600));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tabbedPane);
//Panel đầu sách
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
		lblTaSch.setBounds(830, 47, 97, 25);
		panel_tabDauSach.add(lblTaSch);

		txtTuaSach = new JTextField();
		txtTuaSach.setColumns(10);
		txtTuaSach.setBounds(930, 47, 205, 25);
		panel_tabDauSach.add(txtTuaSach);

		JLabel lblNhXutBn = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n");
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn.setBounds(830, 83, 117, 25);
		panel_tabDauSach.add(lblNhXutBn);

		JButton btnThemDauSach = new JButton("Th\u00EAm");
		btnThemDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemDauSach.setBounds(881, 210, 110, 40);
		panel_tabDauSach.add(btnThemDauSach);

		JButton btnSuaDauSach = new JButton("S\u1EEDa");
		btnSuaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaDauSach.setBounds(1001, 210, 110, 40);
		panel_tabDauSach.add(btnSuaDauSach);

		JButton btnXoaDauSach = new JButton("Xo\u00E1");
		btnXoaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaDauSach.setBounds(881, 261, 110, 40);
		panel_tabDauSach.add(btnXoaDauSach);

		JButton btnTimDauSach = new JButton("T\u00ECm");
		btnTimDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimDauSach.setBounds(1001, 261, 110, 40);
		panel_tabDauSach.add(btnTimDauSach);

		cBNXB = new JComboBox();
		cBNXB.setBounds(930, 83, 205, 25);
		panel_tabDauSach.add(cBNXB);
		cBNXB.setModel(customComboBoxModel());// tạo combobox nxb
		cBNXB.setRenderer(new NXBListCellRenderer());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 810, 477);
		panel_tabDauSach.add(scrollPane);

		tableDauSach = new JTable();
		tableDauSach.setFillsViewportHeight(true);
		tableDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableDauSach.addMouseListener(new ClickCellTableDauSach());//sự kiện click chọn row
		scrollPane.setViewportView(tableDauSach);
		InitTableDauSach();

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(819, 329, 326, 10);
		panel_tabDauSach.add(separator);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(930, 385, 128, 25);
		panel_tabDauSach.add(textField_7);

		JLabel lblTaSch_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblTaSch_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch_2.setBounds(830, 385, 97, 25);
		panel_tabDauSach.add(lblTaSch_2);

		JButton btnThemSach = new JButton("Th\u00EAm S\u00E1ch");
		btnThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemSach.setBounds(940, 415, 110, 40);
		panel_tabDauSach.add(btnThemSach);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(930, 119, 205, 60);
		panel_tabDauSach.add(scrollPane_1);

		txtTacGia = new JTextArea();
		scrollPane_1.setViewportView(txtTacGia);
		txtTacGia.setWrapStyleWord(true);
		txtTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTacGia.setLineWrap(true);
		txtTacGia.setRows(10);
		txtTacGia.setColumns(10);

		JLabel lblTcGi = new JLabel("T\u00E1c gi\u1EA3");
		lblTcGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTcGi.setBounds(830, 119, 97, 25);
		panel_tabDauSach.add(lblTcGi);

		JPanel panel_tabNXB = new JPanel();
		panel_tabNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.addTab("Nh\u00E0 xu\u1EA5t b\u1EA3n", null, panel_tabNXB, null);
		panel_tabNXB.setLayout(null);

		txtMaNXB = new JTextField();
		txtMaNXB.setBounds(955, 11, 180, 25);
		panel_tabNXB.add(txtMaNXB);
		txtMaNXB.setColumns(10);

		JLabel lblNewLabel = new JLabel("M\u00E3 NXB");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(852, 11, 100, 25);
		panel_tabNXB.add(lblNewLabel);

		JLabel lblTnNxb = new JLabel("T\u00EAn NXB");
		lblTnNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNxb.setBounds(852, 47, 100, 25);
		panel_tabNXB.add(lblTnNxb);

		txtTenNXB = new JTextField();
		txtTenNXB.setColumns(10);
		txtTenNXB.setBounds(955, 47, 180, 25);
		panel_tabNXB.add(txtTenNXB);

		JLabel lblaChNxb = new JLabel("\u0110\u1ECBa ch\u1EC9 NXB");
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

		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
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
		tableNXB.addMouseListener(new ClickCellTableNXB());
		scrollPaneNXB.setViewportView(tableNXB);
		InitTableNXB();// Khởi tạo bảng NXB

		JButton btnThemNXB = new JButton("Th\u00EAm");
		btnThemNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNXB();
			}
		});
		btnThemNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNXB.setBounds(877, 227, 110, 40);
		panel_tabNXB.add(btnThemNXB);

		JButton btnSuaNXB = new JButton("S\u1EEDa");
		btnSuaNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNXB();
			}
		});
		btnSuaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaNXB.setBounds(997, 227, 110, 40);
		panel_tabNXB.add(btnSuaNXB);

		JButton btnXoaNXB = new JButton("Xo\u00E1");
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
		lblNhXutBn_1.setBounds(830, 83, 117, 25);
		panel_tabSach.add(lblNhXutBn_1);

		JButton btnTimSach = new JButton("T\u00ECm");
		btnTimSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimSach.setBounds(1042, 12, 93, 24);
		panel_tabSach.add(btnTimSach);

		txtNXBCuonSach = new JTextField();
		txtNXBCuonSach.setColumns(10);
		txtNXBCuonSach.setBounds(930, 83, 205, 62);
		panel_tabSach.add(txtNXBCuonSach);
		
		tableCuonSach = new JTable();
		tableCuonSach.setBounds(10, 11, 800, 477);
		panel_tabSach.add(tableCuonSach);

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
		model.addColumn("Mã Sách");
		model.addColumn("Tựa Sách");
		model.addColumn("Tác giả");
		model.addColumn("Nhà xuất bản");
		tableDauSach.setModel(model);
		try {
			DauSachDAO dauSachDAO = new DauSachDAO();
			ResultSet rs = dauSachDAO.GetAllDauSach();
			LoadDataDauSach(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void LoadDataDauSach(ResultSet rs) {
		try {
			
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

	private void InitTableNXB()// Khởi tạo bảng NXB
	{
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã NXB");
		model.addColumn("Tên NXB");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		tableNXB.setModel(model);
		try {
			NXBDAO nxbDAO = new NXBDAO();
			ArrayList<NXB> rs = nxbDAO.GetAllNXB();
			LoadDataTableNXB(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void LoadDataTableNXB(ArrayList<NXB> list)// load dữ liệu cho bảng NXB
	{
		DefaultTableModel model = (DefaultTableModel) tableNXB.getModel();
		model.setRowCount(0);
		for (NXB nxb : list) {
			model.addRow(new String[] { nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSoDT() });
		}

	}
	
	private void ThemNXB() {
		try {
			if(txtMaNXB.getText().isEmpty()||txtTenNXB.getText().isEmpty()||txtDCNXB.getText().isEmpty()||txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Nhà xuất bản");
				return;
			}
			NXB nxb=new NXB(txtMaNXB.getText(),txtTenNXB.getText(),txtDCNXB.getText(),txtSDTNXB.getText());
			NXBDAO dao=new NXBDAO();
			if(dao.Insert(nxb))
				Alert.ShowMessageInfo("Thêm nhà xuất bản thành công", "Nhà xuất bản");
			else {
				Alert.ShowMessageWarn("Thêm nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi thêm nhà xuất bản", "Nhà xuất bản");
			
		}
	}
	
	private void SuaNXB() {
		try {
			if(txtMaNXB.getText().isEmpty()||txtTenNXB.getText().isEmpty()||txtDCNXB.getText().isEmpty()||txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Nhà xuất bản");
				return;
			}
			NXB nxb=new NXB(txtMaNXB.getText(),txtTenNXB.getText(),txtDCNXB.getText(),txtSDTNXB.getText());
			NXBDAO dao=new NXBDAO();
			if(dao.Update(nxb))
				Alert.ShowMessageInfo("Cập nhật nhà xuất bản thành công", "Nhà xuất bản");
			else {
				Alert.ShowMessageWarn("Cập nhật nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi cập nhật nhà xuất bản", "Nhà xuất bản");
			
		}
	}
	
	private void XoaNXB() {
		try {
			if(txtMaNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền mã nhà xuất bản cần xoá", "Nhà xuất bản");
				return;
			}
			NXB nxb=new NXB(txtMaNXB.getText(),txtTenNXB.getText(),txtDCNXB.getText(),txtSDTNXB.getText());
			NXBDAO dao=new NXBDAO();
			if(dao.Update(nxb))
				Alert.ShowMessageInfo("Xoá nhà xuất bản thành công", "Nhà xuất bản");
			else {
				Alert.ShowMessageWarn("Xoá nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xoá nhà xuất bản", "Nhà xuất bản");
		}
	}
	
	private void ThemDauSach() {
		try {
			String maNXB=((DauSach)cBNXB.getSelectedItem()).getMaNXB();
			if(txtMaDauSach.getText().isEmpty()||txtTuaSach.getText().isEmpty()||maNXB.isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Nhà xuất bản");
				return;
			}
			NXB nxb=new NXB(txtMaNXB.getText(),txtTenNXB.getText(),txtDCNXB.getText(),txtSDTNXB.getText());
			NXBDAO dao=new NXBDAO();
			if(dao.Insert(nxb))
				Alert.ShowMessageInfo("Thêm nhà xuất bản thành công", "Nhà xuất bản");
			else {
				Alert.ShowMessageWarn("Thêm nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi thêm nhà xuất bản", "Nhà xuất bản");
			
		}
	}
	
	//Region Event
	
	private class ClickCellTableDauSach extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index= tableDauSach.getSelectedRow();
			if(index!=-1) {
				txtMaDauSach.setText(tableDauSach.getValueAt(index, 0).toString());
				txtTuaSach.setText(tableDauSach.getValueAt(index, 1).toString());
				String[] tgString=tableDauSach.getValueAt(index, 2).toString().split("-");
				txtTacGia.setText(String.join("\n", tgString));
				
				for (int i=0;i<cBNXB.getItemCount();i++) {
					if(((NXB)cBNXB.getItemAt(i)).getTenNXB().equals(tableDauSach.getValueAt(index, 3).toString())) {
						cBNXB.setSelectedIndex(index);
						break;
					}
				}
			}
		}	
	}
	private class ClickCellTableNXB extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index= tableNXB.getSelectedRow();
			if(index!=-1) {
				txtMaNXB.setText(tableNXB.getValueAt(index, 0).toString());
				txtTenNXB.setText(tableNXB.getValueAt(index, 1).toString());
				txtDCNXB.setText(tableNXB.getValueAt(index, 2).toString());
				txtSDTNXB.setText(tableNXB.getValueAt(index, 3).toString());
				
			}
		}
	}
	
	
}
