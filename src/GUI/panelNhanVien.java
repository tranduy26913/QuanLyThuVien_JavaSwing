package GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.AccountDAO;
import Model.Global;
import Model.NhanVien;
import Model.NhanVienDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class panelNhanVien extends JPanel {
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextArea txtDCNV;
	private JTextField txtSDTNV;
	private JTable tableNV;
	private Component frameMain;
	private JTextField txtLuong;
	NhanVienDAO nhanVienDAO = new NhanVienDAO();
	AccountDAO accountDAO = new AccountDAO();

	/**
	 * Create the panel.
	 */
	private int maNV = Global.getMaNV();
	public panelNhanVien() {
		setBounds(new Rectangle(0, 0, 1000, 600));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tabbedPane);

		JPanel panel_tabNV = new JPanel();
		panel_tabNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.addTab("Danh sách nhân viên", null, panel_tabNV, null);
		panel_tabNV.setLayout(null);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(955, 11, 180, 25);
		panel_tabNV.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(852, 11, 100, 25);
		panel_tabNV.add(lblNewLabel);

		JLabel lblTnNxb = new JLabel("Tên nhân viên");
		lblTnNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNxb.setBounds(852, 47, 100, 25);
		panel_tabNV.add(lblTnNxb);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(955, 47, 180, 25);
		panel_tabNV.add(txtTenNV);

		JLabel lblaChNxb = new JLabel("Địa chỉ");
		lblaChNxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaChNxb.setBounds(852, 83, 100, 25);
		panel_tabNV.add(lblaChNxb);

		JScrollPane scrollPane_DCNXB = new JScrollPane();
		scrollPane_DCNXB.setBounds(955, 83, 180, 69);
		panel_tabNV.add(scrollPane_DCNXB);

		txtDCNV = new JTextArea();
		scrollPane_DCNXB.setViewportView(txtDCNV);
		txtDCNV.setWrapStyleWord(true);
		txtDCNV.setRows(10);
		txtDCNV.setLineWrap(true);
		txtDCNV.setColumns(10);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(852, 163, 100, 25);
		panel_tabNV.add(lblSinThoi);

		txtSDTNV = new JTextField();
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(955, 163, 180, 25);
		panel_tabNV.add(txtSDTNV);

		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 11, 810, 450);
		panel_tabNV.add(scrollPaneNV);

		tableNV = new JTable();
		tableNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneNV.setViewportView(tableNV);
		InitTableNV();// Khá»Ÿi táº¡o báº£ng NXB

		JButton btnThemNV = new JButton("Thêm");
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNV();
			}
		});
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNV.setBounds(900, 250, 110, 40);
		panel_tabNV.add(btnThemNV);

		JButton btnSuaNV = new JButton("Sửa");
		btnSuaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNV();
			}
		});
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaNV.setBounds(1033, 250, 110, 40);
		panel_tabNV.add(btnSuaNV);

		JButton btnXoaNV = new JButton("Xóa");
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaNV();
			}
		});
		btnXoaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaNV.setBounds(900, 300, 110, 40);
		panel_tabNV.add(btnXoaNV);

		JButton btnTimNV = new JButton("T\u00ECm");
		btnTimNV.addActionListener(new TimNV());
		btnTimNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimNV.setBounds(1033, 300, 110, 40);
		panel_tabNV.add(btnTimNV);

		JLabel lblLng = new JLabel("Lương");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLng.setBounds(852, 198, 100, 25);
		panel_tabNV.add(lblLng);

		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(955, 198, 180, 25);
		panel_tabNV.add(txtLuong);		
	}

	private void InitTableNV() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		model.addColumn("Lương");
		tableNV.setModel(model);
		ListSelectionModel model2 = tableNV.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model2.isSelectionEmpty()) {
					int index = model2.getMinSelectionIndex();
					txtMaNV.setText(tableNV.getValueAt(index, 0).toString());
					txtTenNV.setText(tableNV.getValueAt(index, 1).toString());
					txtDCNV.setText(tableNV.getValueAt(index, 2).toString());
					txtSDTNV.setText(tableNV.getValueAt(index, 3).toString());
					txtLuong.setText(tableNV.getValueAt(index, 4).toString());
				}

			}
		});
		LoadDataTableNV(null);
	}

	private void LoadDataTableNV(ArrayList<NhanVien> list)// load dá»¯ liá»‡u cho báº£ng NXB
	{
		try {
			if (list == null) {
				NhanVienDAO nhanVienDAO = new NhanVienDAO();
				list = nhanVienDAO.GetAllNhanVien();

			}
			DefaultTableModel model = (DefaultTableModel) tableNV.getModel();
			model.setRowCount(0);

			for (NhanVien nxb : list) {
				model.addRow(new Object[] { nxb.getMa(), nxb.getHoTen(), nxb.getDiaChi(), nxb.getSoDT(),
						String.valueOf(nxb.getLuong()) });
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void ThemNV() {
		String typeString = null;
		try {
			if (txtTenNV.getText().isEmpty() || txtDCNV.getText().isEmpty() || txtSDTNV.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền đầy đủ thông tin !!", "Nhân viên");
				return;
			}
			NhanVien nhanVien = new NhanVien(txtTenNV.getText(), txtDCNV.getText(), txtSDTNV.getText(),
					Double.parseDouble(txtLuong.getText()));

			int output = JOptionPane.showConfirmDialog(frameMain, "Thêm nhân viên này làm quản lý?", "Thêm nhân viên",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (output == JOptionPane.YES_OPTION) {
				// statusLabel.setText("Yes selected.");
				typeString = "QL";

				if (nhanVienDAO.Insert(nhanVien, typeString)) {
					Alert.ShowMessageInfo(
							"Thêm quản lý thành công: Tên đăng nhập: " + txtMaNV.getText() + "Mật khẩu: 123456",
							"Nhân viên");
					LoadDataTableNV(null);

				} else {
					Alert.ShowMessageWarn("Thêm nhân viên không thành công!! Vui lòng kiểm tra lại", "Nhân viên");
				}

			} else if (output == JOptionPane.NO_OPTION) {
				// statusLabel.setText("No selected.");
				typeString = "NV";

				if (nhanVienDAO.Insert(nhanVien, typeString)) {
					Alert.ShowMessageInfo(
							"Thêm nhân viên thành công: Tên đăng nhập: " + txtMaNV.getText() + "Mật khẩu: 123456",
							"Nhân viên");
					LoadDataTableNV(null);
				} else {
					Alert.ShowMessageWarn("Thêm nhân viên không thành công!! Vui lòng kiểm tra lại", "Nhân viên");
				}
			} else if (output == JOptionPane.CANCEL_OPTION) {
				Alert.ShowMessageWarn("Thêm nhân viên không thành công!! Vui lòng kiểm tra lại", "Nhân viên");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi thêm nhân viên", "Thêm nhân viên");

		}
	}

	private void SuaNV() {
		try {
			if (txtMaNV.getText().isEmpty() || txtTenNV.getText().isEmpty() || txtDCNV.getText().isEmpty()
					|| txtSDTNV.getText().isEmpty() || txtLuong.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng nhập đầy đủ thông tin!", "Sửa nhân viên");
				return;
			}

			NhanVien nhanVien = new NhanVien(Integer.parseInt(txtMaNV.getText()), txtTenNV.getText(), txtDCNV.getText(),
					txtSDTNV.getText(), Double.parseDouble(txtLuong.getText()));
			NhanVienDAO dao = new NhanVienDAO();

			if (dao.Update(nhanVien)) {
				Alert.ShowMessageInfo("Cập nhật thông tin nhân viên thành công", "Nhân viên");
				LoadDataTableNV(null);
			}

			else {
				Alert.ShowMessageWarn("Cập nhật thông tin nhân viên không thành công!! Vui lòng kiểm tra lại",
						"Nhân viên");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi cập nhật thông tin nhân viên !!", "Nhân viên");

		}
	}

	private void XoaNV() {
		try {
			if (txtMaNV.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng chonh nhân viên cần xóa", "Xóa nhân viên");
				return;
			}
			if (nhanVienDAO.Delete(Integer.parseInt(txtMaNV.getText()))) {
				Alert.ShowMessageInfo("Xóa nhân viên thành công!", "Xóa nhân viên");
				LoadDataTableNV(null);
			} else {
				Alert.ShowMessageWarn("Xóa nhân viên không thành công! Vui lòng kiểm tra lại", "Xóa nhân viên");
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi xóa nhân viên", "Xóa nhân viên");
		}
	}

	private class TimNV implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int ma = 0;
				try {
					ma = Integer.parseInt(txtMaNV.getText());
				} catch (Exception e2) {
					Alert.ShowMessageWarn("Vui lòng nhập số vào ô mã nhân viên", "Tìm nhân viên");
				}

				LoadDataTableNV(nhanVienDAO.layThongTinNhanVien(ma));

			} catch (Exception e2) {
				Alert.ShowMessageError("Lỗi khi Tìm độc giả", "Tìm độc giả");
				e2.printStackTrace();
			}
		}
	}

	// Region Event

	private class ClickCellTableNV extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = tableNV.getSelectedRow();
			if (index != -1) {
				txtMaNV.setText(tableNV.getValueAt(index, 0).toString());
				txtTenNV.setText(tableNV.getValueAt(index, 1).toString());
				txtDCNV.setText(tableNV.getValueAt(index, 2).toString());
				txtSDTNV.setText(tableNV.getValueAt(index, 3).toString());
				txtLuong.setText(tableNV.getValueAt(index, 4).toString());
			}
		}
	}

}

