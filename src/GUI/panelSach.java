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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
	private JTextField txtSoCuonSach;
	private JTextArea txtTacGia;
	private JTable tableCuonSach;
	private JTextField txtViTriCuonSach;
	private JTextField txtGiaDauSach;

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
		btnThemDauSach.setIcon(null);
		btnThemDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemDauSach();
			}
		});

		btnThemDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemDauSach.setBounds(884, 262, 110, 40);
		panel_tabDauSach.add(btnThemDauSach);

		JButton btnSuaDauSach = new JButton("S\u1EEDa");
		btnSuaDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaDauSach();
			}
		});
		btnSuaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaDauSach.setBounds(1004, 262, 110, 40);
		panel_tabDauSach.add(btnSuaDauSach);

		JButton btnXoaDauSach = new JButton("Xo\u00E1");
		btnXoaDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDauSach();
			}
		});
		btnXoaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaDauSach.setBounds(884, 313, 110, 40);
		panel_tabDauSach.add(btnXoaDauSach);

		JButton btnTimDauSach = new JButton("T\u00ECm");
		btnTimDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimDauSach();
			}
		});
		btnTimDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimDauSach.setBounds(1004, 313, 110, 40);
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
		// tableDauSach.addMouseListener(new ClickCellTableDauSach());// sự kiện click
		// chọn row
		scrollPane.setViewportView(tableDauSach);
		InitTableDauSach();

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(819, 364, 326, 10);
		panel_tabDauSach.add(separator);

		txtSoCuonSach = new JTextField();
		txtSoCuonSach.setColumns(10);
		txtSoCuonSach.setBounds(930, 385, 128, 25);
		panel_tabDauSach.add(txtSoCuonSach);

		JLabel lblTaSch_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblTaSch_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch_2.setBounds(830, 385, 97, 25);
		panel_tabDauSach.add(lblTaSch_2);

		JButton btnThemSach = new JButton("Th\u00EAm S\u00E1ch");
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemCuonSach();
			}
		});
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
		
		JLabel lblGiSch = new JLabel("Giá sách");
		lblGiSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiSch.setBounds(830, 190, 97, 25);
		panel_tabDauSach.add(lblGiSch);
		
		txtGiaDauSach = new JTextField();
		txtGiaDauSach.setColumns(10);
		txtGiaDauSach.setBounds(930, 190, 205, 25);
		panel_tabDauSach.add(txtGiaDauSach);

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
		tableNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		tableCuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneCuonSach.setViewportView(tableCuonSach);

		JButton btnSuaCuonSach = new JButton("Sửa Vị trí");
		btnSuaCuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SuaCuonSach();

			}
		});
		btnSuaCuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaCuonSach.setBounds(856, 181, 110, 40);
		panel_tabSach.add(btnSuaCuonSach);
		
		JLabel lblNhXutBn_1_1 = new JLabel("Vị trí");
		lblNhXutBn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn_1_1.setBounds(830, 120, 92, 25);
		panel_tabSach.add(lblNhXutBn_1_1);
		
		txtViTriCuonSach = new JTextField();
		txtViTriCuonSach.setColumns(10);
		txtViTriCuonSach.setBounds(930, 120, 205, 25);
		panel_tabSach.add(txtViTriCuonSach);
		
		JButton btnXoaCuonSach = new JButton("Xoá sách");
		btnXoaCuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaCuonSach();
			}
		});
		btnXoaCuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaCuonSach.setBounds(984, 181, 110, 40);
		panel_tabSach.add(btnXoaCuonSach);

		InitTableCuonSach();

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
		model.addColumn("Số lượng");
		model.addColumn("Giá sách");
		tableDauSach.setModel(model);

		ListSelectionModel model2 = tableDauSach.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model2.isSelectionEmpty()) {
					int index = model2.getMinSelectionIndex();
					txtMaDauSach.setText(tableDauSach.getValueAt(index, 0).toString());
					txtTuaSach.setText(tableDauSach.getValueAt(index, 1).toString());
					if (tableDauSach.getValueAt(index, 2) != null) {
						String[] tgString = tableDauSach.getValueAt(index, 2).toString().split("-");
						txtTacGia.setText(String.join("\n", tgString));

						for (int i = 0; i < cBNXB.getItemCount(); i++) {
							if (((NXB) cBNXB.getItemAt(i)).getTenNXB()
									.equals(tableDauSach.getValueAt(index, 3).toString())) {
								cBNXB.setSelectedIndex(i);
								break;
							}
						}
					}
					try {
						txtGiaDauSach.setText(tableDauSach.getValueAt(index, 5).toString());
					}
					catch (Exception e2) {
						txtGiaDauSach.setText("");
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
			DefaultTableModel model = (DefaultTableModel) tableDauSach.getModel();
			model.setRowCount(0);

			while (rs.next()) {
				model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getString(6) });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void TimDauSach() {
		try {
			if (txtMaDauSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng nhập mã sách", "Tìm Đầu Sách");
				return;
			}
			DauSachDAO dao = new DauSachDAO();
			LoadDataDauSach(dao.GetDauSachFromMaSach(txtMaDauSach.getText()));
		} catch (Exception e) {
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
		ListSelectionModel model2 = tableNXB.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model2.isSelectionEmpty()) {
					int index = model2.getMinSelectionIndex();
					txtMaNXB.setText(tableNXB.getValueAt(index, 0).toString());
					txtTenNXB.setText(tableNXB.getValueAt(index, 1).toString());
					txtDCNXB.setText(tableNXB.getValueAt(index, 2).toString());
					txtSDTNXB.setText(tableNXB.getValueAt(index, 3).toString());
				}

			}
		});
		LoadDataTableNXB(null);

	}

	private void LoadDataTableNXB(ArrayList<NXB> list)// load dữ liệu cho bảng NXB
	{
		try {
			if (list == null) {
				NXBDAO nxbDAO = new NXBDAO();
				list = nxbDAO.GetAllNXB();
			}
			DefaultTableModel model = (DefaultTableModel) tableNXB.getModel();
			model.setRowCount(0);

			for (NXB nxb : list) {
				model.addRow(new String[] { nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSoDT() });
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void InitTableCuonSach() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã cuốn");
		model.addColumn("Tựa Sách");
		model.addColumn("Tác giả");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Trạng thái");
		tableCuonSach.setModel(model);

		ListSelectionModel model2 = tableCuonSach.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model2.isSelectionEmpty()) {
					int index = model2.getMinSelectionIndex();
					txtMaCuonSach.setText(tableCuonSach.getValueAt(index, 0).toString());
					txtTuaCuonSach.setText(tableCuonSach.getValueAt(index, 1).toString());
					txtNXBCuonSach.setText(tableCuonSach.getValueAt(index, 3).toString());
				}

			}
		});
		LoadDataCuonSach(null);

	}

	private void LoadDataCuonSach(ResultSet rs) {
		try {
			if (rs == null) {
				CuonSachDAO cuonSachDAO = new CuonSachDAO();
				rs = cuonSachDAO.GetAllCuonSach();
			}
			DefaultTableModel model = (DefaultTableModel) tableCuonSach.getModel();
			model.setRowCount(0);

			while (rs.next()) {
				model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5) });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void ThemNXB() {
		try {
			if (txtMaNXB.getText().isEmpty() || txtTenNXB.getText().isEmpty() || txtDCNXB.getText().isEmpty()
					|| txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Nhà xuất bản");
				return;
			}
			NXB nxb = new NXB(txtMaNXB.getText(), txtTenNXB.getText(), txtDCNXB.getText(), txtSDTNXB.getText());
			NXBDAO dao = new NXBDAO();
			if (dao.Insert(nxb)) {
				Alert.ShowMessageInfo("Thêm nhà xuất bản thành công", "Nhà xuất bản");
				LoadDataTableNXB(null);
			} else {
				Alert.ShowMessageWarn("Thêm nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi thêm nhà xuất bản", "Nhà xuất bản");

		}
	}

	private void SuaNXB() {
		try {
			if (txtMaNXB.getText().isEmpty() || txtTenNXB.getText().isEmpty() || txtDCNXB.getText().isEmpty()
					|| txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Nhà xuất bản");
				return;
			}
			NXB nxb = new NXB(txtMaNXB.getText(), txtTenNXB.getText(), txtDCNXB.getText(), txtSDTNXB.getText());
			NXBDAO dao = new NXBDAO();
			if (dao.Update(nxb)) {
				Alert.ShowMessageInfo("Cập nhật nhà xuất bản thành công", "Nhà xuất bản");
				LoadDataTableNXB(null);
			}

			else {
				Alert.ShowMessageWarn("Cập nhật nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi cập nhật nhà xuất bản", "Nhà xuất bản");

		}
	}

	private void XoaNXB() {
		try {
			if (txtMaNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền mã nhà xuất bản cần xoá", "Nhà xuất bản");
				return;
			}
			int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá nhà xuất bản này?", "Xoá nhà xuất bản",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			NXBDAO dao = new NXBDAO();
			if (dao.Delete(txtMaNXB.getText())) {
				Alert.ShowMessageInfo("Xoá nhà xuất bản thành công", "Nhà xuất bản");
				LoadDataTableNXB(null);
			} else {
				Alert.ShowMessageWarn("Xoá nhà xuất bản không thành công. Vui lòng kiểm tra lại", "Nhà xuất bản");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xoá nhà xuất bản", "Nhà xuất bản");
		}
	}

	private void ThemDauSach() {
		try {
			String maNXB = ((NXB) cBNXB.getSelectedItem()).getMaNXB();
			int giaSach=0;
			try {
				giaSach=Integer.parseInt(txtGiaDauSach.getText());
			} catch (Exception e) {
				Alert.ShowMessageWarn("Vui lòng nhập số vào giá sách", "Đầu sách");
				return;
			}
			if (txtMaDauSach.getText().isEmpty() || txtTuaSach.getText().isEmpty() || maNXB.isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Đầu sách");
				return;
			}
			DauSach ds = new DauSach(txtMaDauSach.getText(), txtTuaSach.getText(), maNXB, txtTacGia.getText(),giaSach);
			DauSachDAO dsDAO = new DauSachDAO();
			if (dsDAO.Insert(ds)) {
				Alert.ShowMessageInfo("Thêm đầu sách thành công", "Đầu Sách");
				LoadDataDauSach(null);
			} else {
				Alert.ShowMessageWarn("Thêm đầu sách không thành công. Vui lòng kiểm tra lại", "Đầu sách");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi thêm đầu sách", "Đầu sách");
			e.printStackTrace();
		}
	}

	private void SuaDauSach() {
		try {
			String maNXB = ((NXB) cBNXB.getSelectedItem()).getMaNXB();
			int giaSach=0;
			try {
				giaSach=Integer.parseInt(txtGiaDauSach.getText());
			} catch (Exception e) {
				Alert.ShowMessageWarn("Vui lòng nhập số vào giá sách", "Đầu sách");
				return;
			}
			if (txtMaDauSach.getText().isEmpty() || txtTuaSach.getText().isEmpty() || maNXB.isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền dầy đủ thông tin", "Đầu sách");
				return;
			}
			DauSach ds = new DauSach(txtMaDauSach.getText(), txtTuaSach.getText(), maNXB, txtTacGia.getText(),giaSach);
			DauSachDAO dsDAO = new DauSachDAO();
			if (dsDAO.Update(ds)) {
				Alert.ShowMessageInfo("Sửa đầu sách thành công", "Đầu Sách");
				LoadDataDauSach(null);
			} else {
				Alert.ShowMessageWarn("Sửa đầu sách không thành công. Vui lòng kiểm tra lại", "Đầu sách");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi sửa đầu sách", "Đầu sách");
			e.printStackTrace();
		}
	}

	private void XoaDauSach() {
		try {

			if (txtMaDauSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền điền mã sách", "Đầu sách");
				return;
			}

			int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá đầu sách này?", "Xoá đầu sách",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			DauSachDAO dsDAO = new DauSachDAO();
			if (dsDAO.Delete(txtMaDauSach.getText())) {
				Alert.ShowMessageInfo("Xoá đầu sách thành công", "Đầu Sách");
				LoadDataDauSach(null);
			} else {
				Alert.ShowMessageWarn("Xoá đầu sách không thành công. Vui lòng kiểm tra lại", "Đầu sách");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xoá đầu sách", "Đầu sách");
			e.printStackTrace();
		}
	}

	private void ThemCuonSach() {
		try {
			int sl = 0;
			try {
				sl = Integer.parseInt(txtSoCuonSach.getText());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (sl == 0) {
				Alert.ShowMessageWarn("Vui lòng điền số lượng cuốn sách cần thêm", "Thêm sách");
				return;
			}

			CuonSachDAO csDAO = new CuonSachDAO();
			for (int i = 0; i < sl; i++) {
				CuonSach cs = new CuonSach(txtMaDauSach.getText(),"","Chưa mượn");
				csDAO.Insert(cs);
			}
			Alert.ShowMessageInfo("Thêm sách thành công", "Thêm cuốn sách");

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xoá đầu sách", "Thêm cuốn sách");
			e.printStackTrace();
		}
	}
	
	private void SuaCuonSach() {
		try {
			int macuon = 0;
			try {
				macuon = Integer.parseInt(txtSoCuonSach.getText());
			} catch (Exception e) {
			}
			if (macuon == 0) {
				Alert.ShowMessageWarn("Vui lòng điền mã cuốn sách cần sửa", "Sửa sách");
				return;
			}

			CuonSachDAO csDAO = new CuonSachDAO();
			CuonSach cs=new CuonSach(macuon, txtViTriCuonSach.getText());
			if(csDAO.Update(cs)) {
				Alert.ShowMessageInfo("Sửa cuốn sách thành công", "Sửa cuốn sách");
			}
			else {
				Alert.ShowMessageInfo("Sửa cuốn sách không thành công", "Sửa cuốn sách");
			}
			

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xoá đầu sách", "Thêm cuốn sách");
			e.printStackTrace();
		}
	}
	
	private void XoaCuonSach() {
		try {
			int sl = 0;
			try {
				sl = Integer.parseInt(txtMaCuonSach.getText());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (sl == 0) {
				Alert.ShowMessageWarn("Vui lòng điền mã số cuốn sách cần xoá", "Xoá sách");
				return;
			}
			int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá cuốn sách này?", "Xoá cuốn sách",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			CuonSachDAO csDAO = new CuonSachDAO();
			if(csDAO.Delete(sl)) {
				Alert.ShowMessageInfo("Xoá cuốn sách thành công", "Xoá cuốn sách");
			}
			else {
				Alert.ShowMessageWarn("Xoá cuốn sách không thành công", "Xoá cuốn sách");
			}
			

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xoá đầu sách", "Thêm cuốn sách");
			e.printStackTrace();
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
