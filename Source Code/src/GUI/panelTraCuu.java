package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Model.DauSachDAO;
import Model.DocGia;
import Model.DocGiaDAO;
import Model.NXB;
import Model.NXBDAO;
import Model.TacGiaDAO;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;

public class panelTraCuu extends JPanel {
	private JTable table;
	private JComboBox cbTG;
	private JComboBox cbNXB;
	private JCheckBox checkboxNXB;
	private JCheckBox checkboxTG;

	/**
	 * Create the panel.
	 */
	public panelTraCuu()  {

		setBounds(new Rectangle(0, 0, 1160, 510));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel);
		panel.setLayout(null);

		JLabel lblKhchHng = new JLabel("Nhà xuất bản");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhchHng.setBounds(20, 27, 92, 25);
		panel.add(lblKhchHng);

		NXBDAO nxbDAO = new NXBDAO();
		ArrayList<NXB> listNXB = nxbDAO.GetAllNXB();

		DefaultComboBoxModel model = new DefaultComboBoxModel();

		for (NXB nxb : listNXB) {
			model.addElement(nxb);
		}
		cbNXB = new JComboBox(model);
		cbNXB.setRenderer(new NXBListCellRenderer());
		cbNXB.setSelectedIndex(-1);
		cbNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbNXB.setBounds(122, 27, 150, 25);
		panel.add(cbNXB);

		JLabel lblTcGi = new JLabel("Tác giả");
		lblTcGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTcGi.setBounds(20, 67, 92, 25);
		panel.add(lblTcGi);

		DefaultComboBoxModel model2 = new DefaultComboBoxModel();
		TacGiaDAO tgDAO = new TacGiaDAO();
		ArrayList<String> listTG = tgDAO.GetAllTenTG();
		for (String tg : listTG) {
			model2.addElement(tg);
		}
		cbTG = new JComboBox(model2);
		cbTG.setSelectedIndex(-1);
		cbTG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTG.setBounds(122, 67, 150, 25);
		panel.add(cbTG);

		checkboxNXB = new JCheckBox("Theo Nhà xuất bản");
		checkboxNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkboxNXB.setBounds(291, 30, 150, 23);
		panel.add(checkboxNXB);

		checkboxTG = new JCheckBox("Theo Tác giả");
		checkboxTG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkboxTG.setBounds(291, 70, 150, 23);
		panel.add(checkboxTG);

		JButton btnTraCuu = new JButton("Tra cứu");
		btnTraCuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraCuu();
			}
		});
		btnTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTraCuu.setBounds(463, 32, 110, 40);
		panel.add(btnTraCuu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 103, 1130, 367);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		InitTable();
	}

	private void InitTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Sách");
		model.addColumn("Tựa Sách");
		model.addColumn("Tác giả");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Số lượng");
		model.addColumn("Giá sách");
		table.setModel(model);
		LoadDataDauSach(null);
	}

	private void TraCuu() {
		try {
			DauSachDAO dsDAO = new DauSachDAO();

			if (checkboxNXB.isSelected() && checkboxTG.isSelected()) {
				if (cbNXB.getSelectedItem() == null || cbTG.getSelectedItem() == null) {
					Alert.ShowMessageWarn("Vui lòng chọn NXB và tác giả", "Tra cứu");
					return;
				}
				LoadDataDauSach(
						dsDAO.TraCuu(((NXB) cbNXB.getSelectedItem()).getMaNXB(), cbTG.getSelectedItem().toString()));
			} else if (checkboxNXB.isSelected()) {
				if (cbNXB.getSelectedItem() == null) {
					Alert.ShowMessageWarn("Vui lòng chọn NXB", "Tra cứu");
					return;
				}
				LoadDataDauSach(dsDAO.TraCuuSachTheoNXB(((NXB) cbNXB.getSelectedItem()).getMaNXB()));
			} else if (checkboxTG.isSelected()) {
				if (cbTG.getSelectedItem() == null) {
					Alert.ShowMessageWarn("Vui lòng chọn Tác giả", "Tra cứu");
					return;
				}
				LoadDataDauSach(dsDAO.TraCuuSachTheoTacGia(cbTG.getSelectedItem().toString()));
			} else {
				Alert.ShowMessageWarn("Vui lòng chọn loại tra cứu", "Tra cứu");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void LoadDataDauSach(ResultSet rs) {
		try {
			if (rs != null) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);

				while (rs.next()) {
					model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5),rs.getString(6) });
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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

}
