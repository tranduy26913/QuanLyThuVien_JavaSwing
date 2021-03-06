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
//Panel ?????u s??ch
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
		btnThemDauSach.setBounds(884, 242, 110, 40);
		panel_tabDauSach.add(btnThemDauSach);

		JButton btnSuaDauSach = new JButton("S\u1EEDa");
		btnSuaDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaDauSach();
			}
		});
		btnSuaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaDauSach.setBounds(1004, 242, 110, 40);
		panel_tabDauSach.add(btnSuaDauSach);

		JButton btnXoaDauSach = new JButton("Xo\u00E1");
		btnXoaDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDauSach();
			}
		});
		btnXoaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaDauSach.setBounds(884, 293, 110, 40);
		panel_tabDauSach.add(btnXoaDauSach);

		JButton btnTimDauSach = new JButton("T\u00ECm");
		btnTimDauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimDauSach();
			}
		});
		btnTimDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimDauSach.setBounds(1004, 293, 110, 40);
		panel_tabDauSach.add(btnTimDauSach);

		cBNXB = new JComboBox();
		cBNXB.setBounds(930, 83, 205, 25);
		panel_tabDauSach.add(cBNXB);
		InitCBNXB();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 810, 477);
		panel_tabDauSach.add(scrollPane);

		tableDauSach = new JTable();
		tableDauSach.setFillsViewportHeight(true);
		tableDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// tableDauSach.addMouseListener(new ClickCellTableDauSach());// s??? ki???n click
		// ch???n row
		scrollPane.setViewportView(tableDauSach);
		InitTableDauSach();

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(819, 391, 326, 10);
		panel_tabDauSach.add(separator);

		txtSoCuonSach = new JTextField();
		txtSoCuonSach.setColumns(10);
		txtSoCuonSach.setBounds(930, 412, 128, 25);
		panel_tabDauSach.add(txtSoCuonSach);

		JLabel lblTaSch_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblTaSch_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch_2.setBounds(830, 410, 97, 25);
		panel_tabDauSach.add(lblTaSch_2);

		JButton btnThemSach = new JButton("Th\u00EAm S\u00E1ch");
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemCuonSach();
			}
		});
		btnThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemSach.setBounds(930, 448, 110, 40);
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
		
		JLabel lblGiSch = new JLabel("Gi?? s??ch");
		lblGiSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiSch.setBounds(830, 190, 97, 25);
		panel_tabDauSach.add(lblGiSch);
		
		txtGiaDauSach = new JTextField();
		txtGiaDauSach.setColumns(10);
		txtGiaDauSach.setBounds(930, 190, 205, 25);
		panel_tabDauSach.add(txtGiaDauSach);
		
		JButton btnF5DauSach = new JButton("L??m m???i");
		btnF5DauSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshDauSach();
			}
		});
		btnF5DauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnF5DauSach.setBounds(884, 344, 230, 40);
		panel_tabDauSach.add(btnF5DauSach);

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
		InitTableNXB();// Kh???i t???o b???ng NXB

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
		btnTimNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimNXB();
			}
		});
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
		btnTimSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			///
			}
		});
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

		JButton btnSuaCuonSach = new JButton("S???a V??? tr??");
		btnSuaCuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaCuonSach();
			}
		});
		btnSuaCuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaCuonSach.setBounds(852, 181, 110, 40);
		panel_tabSach.add(btnSuaCuonSach);
		
		JLabel lblNhXutBn_1_1 = new JLabel("V??? tr??");
		lblNhXutBn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhXutBn_1_1.setBounds(830, 120, 92, 25);
		panel_tabSach.add(lblNhXutBn_1_1);
		
		txtViTriCuonSach = new JTextField();
		txtViTriCuonSach.setColumns(10);
		txtViTriCuonSach.setBounds(930, 120, 205, 25);
		panel_tabSach.add(txtViTriCuonSach);
		
		JButton btnXoaCuonSach = new JButton("Xo?? s??ch");
		btnXoaCuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaCuonSach();
			}
		});
		btnXoaCuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaCuonSach.setBounds(984, 181, 110, 40);
		panel_tabSach.add(btnXoaCuonSach);
		
		JButton btnCuonSachChuaMuon = new JButton("Ch??a m?????n");
		btnCuonSachChuaMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuonSachChuaMuon();
			}
		});
		btnCuonSachChuaMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCuonSachChuaMuon.setBounds(852, 232, 110, 40);
		panel_tabSach.add(btnCuonSachChuaMuon);
		
		JButton btnCuonSachDaMuon = new JButton("???? m?????n");
		btnCuonSachDaMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuonSachDaMuon();
			}
		});
		btnCuonSachDaMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCuonSachDaMuon.setBounds(984, 232, 110, 40);
		panel_tabSach.add(btnCuonSachDaMuon);
		
		JButton btnTatCaCuonSach = new JButton("T???t c???");
		btnTatCaCuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshCuonSach();
			}
		});
		btnTatCaCuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTatCaCuonSach.setBounds(852, 283, 242, 40);
		panel_tabSach.add(btnTatCaCuonSach);

		InitTableCuonSach();

	}
	
	private void InitCBNXB() {
		try {
			cBNXB.setModel(customComboBoxModel());// t???o combobox nxb
			cBNXB.setRenderer(new NXBListCellRenderer());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void RefreshDauSach() {
		try {
			InitCBNXB();
			LoadDataDauSach(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void RefreshCuonSach() {
		try {
			LoadDataCuonSach(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void CuonSachChuaMuon() {
		try {
			CuonSachDAO csDAO=new CuonSachDAO();
			LoadDataCuonSach(csDAO.GetAllCuonSachChuaMuon());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void CuonSachDaMuon() {
		try {
			CuonSachDAO csDAO=new CuonSachDAO();
			LoadDataCuonSach(csDAO.GetAllCuonSachDaMuon());
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		model.addColumn("M?? S??ch");
		model.addColumn("T???a S??ch");
		model.addColumn("T??c gi???");
		model.addColumn("Nh?? xu???t b???n");
		model.addColumn("S??? l?????ng");
		model.addColumn("Gi?? s??ch");
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
				Alert.ShowMessageWarn("Vui l??ng nh???p m?? s??ch", "T??m ?????u S??ch");
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

	private void InitTableNXB()// Kh???i t???o b???ng NXB
	{
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("M?? NXB");
		model.addColumn("T??n NXB");
		model.addColumn("?????a ch???");
		model.addColumn("S??? ??i???n tho???i");
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

	private void LoadDataTableNXB(ArrayList<NXB> list)// load d??? li???u cho b???ng NXB
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
		model.addColumn("M?? cu???n");
		model.addColumn("T???a S??ch");
		model.addColumn("T??c gi???");
		model.addColumn("Nh?? xu???t b???n");
		model.addColumn("Tr???ng th??i");
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
			if (txtTenNXB.getText().isEmpty() || txtDCNXB.getText().isEmpty()
					|| txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n d???y ????? th??ng tin", "Nh?? xu???t b???n");
				return;
			}
			NXB nxb = new NXB( txtTenNXB.getText(), txtDCNXB.getText(), txtSDTNXB.getText());
			NXBDAO dao = new NXBDAO();
			if (dao.Insert(nxb)) {
				Alert.ShowMessageInfo("Th??m nh?? xu???t b???n th??nh c??ng", "Nh?? xu???t b???n");
				LoadDataTableNXB(null);
			} else {
				Alert.ShowMessageWarn("Th??m nh?? xu???t b???n kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i", "Nh?? xu???t b???n");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("L???i th??m nh?? xu???t b???n", "Nh?? xu???t b???n");

		}
	}

	private void SuaNXB() {
		try {
			if (txtMaNXB.getText().isEmpty() || txtTenNXB.getText().isEmpty() || txtDCNXB.getText().isEmpty()
					|| txtSDTNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n d???y ????? th??ng tin", "Nh?? xu???t b???n");
				return;
			}
			NXB nxb = new NXB(txtMaNXB.getText(), txtTenNXB.getText(), txtDCNXB.getText(), txtSDTNXB.getText());
			NXBDAO dao = new NXBDAO();
			if (dao.Update(nxb)) {
				Alert.ShowMessageInfo("C???p nh???t nh?? xu???t b???n th??nh c??ng", "Nh?? xu???t b???n");
				LoadDataTableNXB(null);
			}

			else {
				Alert.ShowMessageWarn("C???p nh???t nh?? xu???t b???n kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i", "Nh?? xu???t b???n");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("L???i c???p nh???t nh?? xu???t b???n", "Nh?? xu???t b???n");

		}
	}

	private void XoaNXB() {
		try {
			if (txtMaNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n m?? nh?? xu???t b???n c???n xo??", "Nh?? xu???t b???n");
				return;
			}
			int output = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n xo?? nh?? xu???t b???n n??y?", "Xo?? nh?? xu???t b???n",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			NXBDAO dao = new NXBDAO();
			if (dao.Delete(txtMaNXB.getText())) {
				Alert.ShowMessageInfo("Xo?? nh?? xu???t b???n th??nh c??ng", "Nh?? xu???t b???n");
				LoadDataTableNXB(null);
			} else {
				Alert.ShowMessageWarn("Xo?? nh?? xu???t b???n kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i", "Nh?? xu???t b???n");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("L???i xo?? nh?? xu???t b???n", "Nh?? xu???t b???n");
		}
	}
	
	private void TimNXB() {
		try {
			if (txtMaNXB.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n m?? nh?? xu???t b???n c???n t??m", "T??m Nh?? xu???t b???n");
				return;
			}
			
			NXBDAO dao = new NXBDAO();
			NXB nxb=dao.GetNXBFromMaNXB(txtMaNXB.getText());
			if(nxb==null) {
				Alert.ShowMessageInfo("Kh??ng t??m th???y nh?? xu???t b???n", "Nh?? xu???t b???n");
				return;
			}
			txtTenNXB.setText(nxb.getTenNXB());
			txtDCNXB.setText(nxb.getDiaChi());
			txtSDTNXB.setText(nxb.getSoDT());
			ArrayList<NXB> list=new ArrayList<NXB>();
			list.add(nxb);
			LoadDataTableNXB(list);

		} catch (Exception e) {
			Alert.ShowMessageError("L???i xo?? nh?? xu???t b???n", "Nh?? xu???t b???n");
		}
	}

	private void ThemDauSach() {
		try {
			String maNXB = ((NXB) cBNXB.getSelectedItem()).getMaNXB();
			int giaSach=0;
			try {
				giaSach=Integer.parseInt(txtGiaDauSach.getText());
			} catch (Exception e) {
				Alert.ShowMessageWarn("Vui l??ng nh???p s??? v??o gi?? s??ch", "?????u s??ch");
				return;
			}
			if (txtMaDauSach.getText().isEmpty() || txtTuaSach.getText().isEmpty() || maNXB.isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n d???y ????? th??ng tin", "?????u s??ch");
				return;
			}
			DauSach ds = new DauSach(txtMaDauSach.getText(), txtTuaSach.getText(), maNXB, txtTacGia.getText(),giaSach);
			DauSachDAO dsDAO = new DauSachDAO();
			if (dsDAO.Insert(ds)) {
				Alert.ShowMessageInfo("Th??m ?????u s??ch th??nh c??ng", "?????u S??ch");
				LoadDataDauSach(null);
			} else {
				Alert.ShowMessageWarn("Th??m ?????u s??ch kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i", "?????u s??ch");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("L???i th??m ?????u s??ch", "?????u s??ch");
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
				Alert.ShowMessageWarn("Vui l??ng nh???p s??? v??o gi?? s??ch", "?????u s??ch");
				return;
			}
			if (txtMaDauSach.getText().isEmpty() || txtTuaSach.getText().isEmpty() || maNXB.isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n d???y ????? th??ng tin", "?????u s??ch");
				return;
			}
			DauSach ds = new DauSach(txtMaDauSach.getText(), txtTuaSach.getText(), maNXB, txtTacGia.getText(),giaSach);
			DauSachDAO dsDAO = new DauSachDAO();
			if (dsDAO.Update(ds)) {
				Alert.ShowMessageInfo("S???a ?????u s??ch th??nh c??ng", "?????u S??ch");
				LoadDataDauSach(null);
			} else {
				Alert.ShowMessageWarn("S???a ?????u s??ch kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i", "?????u s??ch");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("L???i s???a ?????u s??ch", "?????u s??ch");
			e.printStackTrace();
		}
	}

	private void XoaDauSach() {
		try {

			if (txtMaDauSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n ??i???n m?? s??ch", "?????u s??ch");
				return;
			}

			int output = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n xo?? ?????u s??ch n??y?", "Xo?? ?????u s??ch",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			DauSachDAO dsDAO = new DauSachDAO();
			if (dsDAO.Delete(txtMaDauSach.getText())) {
				Alert.ShowMessageInfo("Xo?? ?????u s??ch th??nh c??ng", "?????u S??ch");
				LoadDataDauSach(null);
			} else {
				Alert.ShowMessageWarn("Xo?? ?????u s??ch kh??ng th??nh c??ng. Vui l??ng ki???m tra l???i", "?????u s??ch");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("L???i xo?? ?????u s??ch", "?????u s??ch");
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
			if (sl == 0 || sl<1) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n s??? l?????ng cu???n s??ch c???n th??m ph?? h???p", "Th??m s??ch");
				return;
			}

			CuonSachDAO csDAO = new CuonSachDAO();
			for (int i = 0; i < sl; i++) {
				CuonSach cs = new CuonSach(txtMaDauSach.getText(),"","Ch??a m?????n");
				csDAO.Insert(cs);
			}
			Alert.ShowMessageInfo("Th??m s??ch th??nh c??ng", "Th??m cu???n s??ch");

		} catch (Exception e) {
			Alert.ShowMessageError("L???i xo?? ?????u s??ch", "Th??m cu???n s??ch");
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
				Alert.ShowMessageWarn("Vui l??ng ??i???n m?? cu???n s??ch c???n s???a", "S???a s??ch");
				return;
			}

			CuonSachDAO csDAO = new CuonSachDAO();
			CuonSach cs=new CuonSach(macuon, txtViTriCuonSach.getText());
			if(csDAO.Update(cs)) {
				Alert.ShowMessageInfo("S???a cu???n s??ch th??nh c??ng", "S???a cu???n s??ch");
			}
			else {
				Alert.ShowMessageInfo("S???a cu???n s??ch kh??ng th??nh c??ng", "S???a cu???n s??ch");
			}
			

		} catch (Exception e) {
			Alert.ShowMessageError("L???i xo?? ?????u s??ch", "Th??m cu???n s??ch");
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
				Alert.ShowMessageWarn("Vui l??ng ??i???n m?? s??? cu???n s??ch c???n xo??", "Xo?? s??ch");
				return;
			}
			int output = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n xo?? cu???n s??ch n??y?", "Xo?? cu???n s??ch",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			MuonDAO muonDAO=new MuonDAO();
			if(muonDAO.CheckCuonSachDaMuon(sl)) {
				Alert.ShowMessageWarn("Cu???n s??ch n??y ??ang ???????c m?????n. Kh??ng th??? xo??","Xo?? cu???n s??ch");
				return;
			}
			CuonSachDAO csDAO = new CuonSachDAO();
			if(csDAO.Delete(sl)) {
				Alert.ShowMessageInfo("Xo?? cu???n s??ch th??nh c??ng", "Xo?? cu???n s??ch");
			}
			else {
				Alert.ShowMessageWarn("Xo?? cu???n s??ch kh??ng th??nh c??ng", "Xo?? cu???n s??ch");
			}
			

		} catch (Exception e) {
			Alert.ShowMessageError("L???i xo?? ?????u s??ch", "Th??m cu???n s??ch");
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
