package GUI;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Model.DocGia;
import Model.DocGiaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class panelDocGia extends JPanel {
	private JTextField txtMaDG;
	private JTextField txtTenDG;
	private JTextArea txtDC;
	private JTextField txtSDT;
	private JTable tableDG;

	/**
	 * Create the panel.
	 */
	public panelDocGia() {

		setBounds(new Rectangle(0, 0, 1160, 510));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel);
		panel.setLayout(null);

		txtMaDG = new JTextField();
		txtMaDG.setBounds(931, 22, 205, 25);
		panel.add(txtMaDG);
		txtMaDG.setColumns(10);

		JLabel lblMuSch = new JLabel("M\u00E3 \u0111\u1ED9c Gi\u1EA3");
		lblMuSch.setBounds(831, 22, 90, 25);
		panel.add(lblMuSch);
		lblMuSch.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblTaSch = new JLabel("T\u00EAn \u0111\u1ED9c gi\u1EA3");
		lblTaSch.setBounds(831, 58, 90, 25);
		panel.add(lblTaSch);
		lblTaSch.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenDG = new JTextField();
		txtTenDG.setBounds(931, 58, 205, 25);
		panel.add(txtTenDG);
		txtTenDG.setColumns(10);

		JLabel lblNhXutBn = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNhXutBn.setBounds(831, 94, 90, 25);
		panel.add(lblNhXutBn);
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnThemDG = new JButton("Th\u00EAm");
		btnThemDG.addActionListener(new ThemDG());// th??m ?????c gi???
		btnThemDG.setBounds(863, 235, 110, 40);
		panel.add(btnThemDG);
		btnThemDG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnSuaDG = new JButton("S\u1EEDa");
		btnSuaDG.addActionListener(new SuaDG());
		btnSuaDG.setBounds(983, 235, 110, 40);
		panel.add(btnSuaDG);
		btnSuaDG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnXoaDG = new JButton("Xo\u00E1");
		btnXoaDG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDG();
			}
		});
		btnXoaDG.setBounds(863, 286, 110, 40);
		panel.add(btnXoaDG);
		btnXoaDG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnTimDG = new JButton("T\u00ECm");
		btnTimDG.addActionListener(new TimDG());
		btnTimDG.setBounds(983, 286, 110, 40);
		panel.add(btnTimDG);
		btnTimDG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(931, 94, 205, 59);
		panel.add(scrollPane_1);

		txtDC = new JTextArea();
		scrollPane_1.setViewportView(txtDC);
		txtDC.setRows(5);
		txtDC.setLineWrap(true);
		txtDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDC.setColumns(10);

		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setBounds(831, 164, 90, 25);
		panel.add(lblSinThoi);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtSDT = new JTextField();
		txtSDT.setBounds(931, 164, 205, 25);
		panel.add(txtSDT);
		txtSDT.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 11, 780, 480);
		panel.add(scrollPane);

		tableDG = new JTable();
		tableDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableDG);

		JButton btnDocGiaNoSach = new JButton("?????c gi??? m?????n qu?? h???n");
		btnDocGiaNoSach.addActionListener(new DocGiaQuaHanMuon());
		btnDocGiaNoSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDocGiaNoSach.setBounds(863, 337, 230, 40);
		panel.add(btnDocGiaNoSach);

		JButton btnF5DocGia = new JButton("L??m m???i");
		btnF5DocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		btnF5DocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnF5DocGia.setBounds(863, 388, 230, 40);
		panel.add(btnF5DocGia);
		tableDG.addMouseListener(new ClickCellTableDG());
		InitTable();
	}

	private void InitTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("M?? ?????c gi???");
		model.addColumn("T??n ?????c gi???");
		model.addColumn("?????a ch???");
		model.addColumn("S??? ??i???n tho???i");
		tableDG.setModel(model);
		ListSelectionModel model2 = tableDG.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					if (!model2.isSelectionEmpty()) {
						int index = model2.getMinSelectionIndex();
						txtMaDG.setText(tableDG.getValueAt(index, 0).toString());
						txtTenDG.setText(tableDG.getValueAt(index, 1).toString());
						txtDC.setText(tableDG.getValueAt(index, 2).toString());
						txtSDT.setText(tableDG.getValueAt(index, 3).toString());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}

			}

		});

		try {
			DocGiaDAO dgDAO = new DocGiaDAO();
			ResultSet rs = dgDAO.GetAllDocGia();
			LoadDataTable(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void Refresh() {
		try {
			DocGiaDAO DAO = new DocGiaDAO();
			LoadDataTable(DAO.GetAllDocGia());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void LoadDataTable(ResultSet rs) {
		try {
			DefaultTableModel model = (DefaultTableModel) tableDG.getModel();
			model.setRowCount(0);
			if (rs == null) {
				return;
			}
			while (rs.next()) {
				model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ThemDG implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				if (txtTenDG.getText().isEmpty() || txtDC.getText().isEmpty() || txtSDT.getText().isEmpty()) {
					Alert.ShowMessageWarn("Vui l??ng ??i???n ?????y ????? th??ng tin", "Th??m ?????c gi???");
					return;
				}
				DocGia dg = new DocGia(txtTenDG.getText(), txtDC.getText(), txtSDT.getText());
				DocGiaDAO DAO = new DocGiaDAO();
				DAO.Insert(dg);
				Alert.ShowMessageInfo("Th??m ?????c gi??? th??nh c??ng", "Th??m ?????c gi???");
			} catch (Exception e2) {
				Alert.ShowMessageError("L???i khi th??m ?????c gi???", "Th??m ?????c gi???");
				e2.printStackTrace();
			}
		}
	}

	private class SuaDG implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (txtMaDG.getText().isEmpty() || txtTenDG.getText().isEmpty() || txtDC.getText().isEmpty()
						|| txtSDT.getText().isEmpty()) {
					Alert.ShowMessageWarn("Vui l??ng ??i???n ?????y ????? th??ng tin", "S???a ?????c gi???");
					return;
				}
				DocGia dg = new DocGia(Integer.parseInt(txtMaDG.getText()), txtTenDG.getText(), txtDC.getText(),
						txtSDT.getText());
				DocGiaDAO DAO = new DocGiaDAO();
				DAO.Update(dg);
				Alert.ShowMessageInfo("S???a ?????c gi??? th??nh c??ng", "S???a ?????c gi???");
			} catch (Exception e2) {
				Alert.ShowMessageError("L???i khi S???a ?????c gi???", "S???a ?????c gi???");
				e2.printStackTrace();
			}
		}
	}

	private void XoaDG() {
		try {

			if (txtMaDG.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui l??ng ??i???n m?? ?????c gi??? c???n xo??", "Xo?? ?????c gi???");
				return;
			}
			int output = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n xo?? ?????c gi??? n??y?", "Xo?? ?????c gi???",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(output==JOptionPane.NO_OPTION) {
				return;
			}
			
			DocGiaDAO DAO = new DocGiaDAO();
			if(DAO.CheckDocGiaDangMuon(txtMaDG.getText())!=0) {
				Alert.ShowMessageWarn("?????c gi??? n??y v???n c??n s??ch ch??a tr???. Kh??ng ???????c ph??p xo??!", "Xo?? ?????c gi???");
				return;
			}
			DAO.DeleteDocGiaFromMaDG(txtMaDG.getText());
			Alert.ShowMessageInfo("Xo?? ?????c gi??? th??nh c??ng", "Xo?? ?????c gi???");

		} catch (Exception e2) {
			Alert.ShowMessageError("L???i khi S???a ?????c gi???", "S???a ?????c gi???");
			e2.printStackTrace();
		}

	}

	private class TimDG implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DocGiaDAO DAO = new DocGiaDAO();
				LoadDataTable(DAO.GetDocGiaFromInfo(txtMaDG.getText(), txtTenDG.getText(), txtDC.getText(),
						txtSDT.getText()));

			} catch (Exception e2) {
				Alert.ShowMessageError("L???i khi T??m ?????c gi???", "T??m ?????c gi???");
				e2.printStackTrace();
			}
		}
	}

	private class DocGiaQuaHanMuon implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DocGiaDAO DAO = new DocGiaDAO();
				LoadDataTable(DAO.GetDocGiaMuonQuaHan());
			} catch (Exception e2) {
				Alert.ShowMessageError("L???i khi T??m ?????c gi???", "T??m ?????c gi???");
				e2.printStackTrace();
			}
		}
	}

	private class ClickCellTableDG extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = tableDG.getSelectedRow();
			if (index != -1) {
				txtMaDG.setText(tableDG.getValueAt(index, 0).toString());
				txtTenDG.setText(tableDG.getValueAt(index, 1).toString());
				txtDC.setText(tableDG.getValueAt(index, 2).toString());
				txtSDT.setText(tableDG.getValueAt(index, 3).toString());

			}
		}
	}
}
