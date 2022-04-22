package GUI;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Model.DocGia;
import Model.DocGiaDAO;
import Model.LogDAO;

import javax.swing.JLabel;
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
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;

public class panelThongKe extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox cbThoiGian;
	private JDatePickerImpl datePickerTo;
	private JDatePickerImpl datePickerFrom;
	private JLabel lbSoDauSach;
	private JLabel lbSoCuonSach1;
	private JLabel lbSoCuonSach2;
	private JLabel lbDocGia;
	private JLabel lbTacGia;
	private JLabel lbNV;
	private JLabel lbNXB;

	private int maNV = 0;
	private JLabel lbSoLanMuonSach;
	private JLabel lbSoSachDuocMuonNhieuNhat;
	private JLabel lbSoLanTraSach;

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	/**
	 * Create the panel.
	 */
	public panelThongKe() {
		Init();
	}

	public panelThongKe(int maNv) {
		this.maNV = maNv;
		Init();
	}

	@SuppressWarnings("deprecation")
	public void Init() {
		setBounds(new Rectangle(0, 0, 1160, 510));
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel);
		panel.setLayout(null);

		JButton btnF5 = new JButton("Xem");
		btnF5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		btnF5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnF5.setBounds(1028, 16, 110, 40);
		panel.add(btnF5);

		UtilDateModel model = new UtilDateModel();
		java.util.Date date = new java.util.Date();
		model.setDate(date.getYear() + 1900, date.getMonth(), date.getDay());
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePickerTo = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerTo.setLocation(861, 24);
		datePickerTo.setSize(140, 30);
		panel.add(datePickerTo);

		UtilDateModel model2 = new UtilDateModel();
		model2.setDate(date.getYear() + 1900, date.getMonth(), date.getDay());
		model2.setSelected(true);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		datePickerFrom = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePickerFrom.setLocation(642, 24);
		datePickerFrom.setSize(140, 30);

		panel.add(datePickerFrom);

		cbThoiGian = new JCheckBox("Theo thời gian");
		cbThoiGian.setBackground(SystemColor.control);
		cbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbThoiGian.setBounds(468, 25, 124, 23);
		panel.add(cbThoiGian);

		JLabel lblNewLabel = new JLabel("Từ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(598, 29, 34, 14);
		panel.add(lblNewLabel);

		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(804, 29, 46, 14);
		panel.add(lbln);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(457, 0, 9, 510);
		panel.add(separator);

		lbSoDauSach = new JLabel("Số đầu sách: ");
		lbSoDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoDauSach.setBounds(35, 120, 367, 30);
		panel.add(lbSoDauSach);

		lbSoCuonSach1 = new JLabel("Số cuốn đang sách: ");
		lbSoCuonSach1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoCuonSach1.setBounds(35, 325, 367, 30);
		panel.add(lbSoCuonSach1);

		lbSoCuonSach2 = new JLabel("Số cuốn sách chưa mượn: ");
		lbSoCuonSach2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoCuonSach2.setBounds(35, 366, 367, 30);
		panel.add(lbSoCuonSach2);

		lbDocGia = new JLabel("Số độc giả: ");
		lbDocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDocGia.setBounds(35, 161, 367, 30);
		panel.add(lbDocGia);

		lbTacGia = new JLabel("Số tác giả: ");
		lbTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTacGia.setBounds(35, 202, 367, 30);
		panel.add(lbTacGia);

		lbNXB = new JLabel("Số nhà xuất bản: ");
		lbNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNXB.setBounds(35, 243, 367, 30);
		panel.add(lbNXB);

		lbNV = new JLabel("Số nhân viên: ");
		lbNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNV.setBounds(35, 284, 367, 30);
		panel.add(lbNV);
		
		lbSoLanMuonSach = new JLabel("Số cuốn sách được mượn: ");
		lbSoLanMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoLanMuonSach.setBounds(541, 120, 367, 30);
		panel.add(lbSoLanMuonSach);
		
		lbSoSachDuocMuonNhieuNhat = new JLabel("Số đầu sách được mượn nhiều nhất: ");
		lbSoSachDuocMuonNhieuNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoSachDuocMuonNhieuNhat.setBounds(541, 202, 367, 30);
		panel.add(lbSoSachDuocMuonNhieuNhat);
		
		lbSoLanTraSach = new JLabel("Số cuốn sách trả sách: ");
		lbSoLanTraSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoLanTraSach.setBounds(541, 161, 367, 30);
		panel.add(lbSoLanTraSach);
		LoadData();

	}

	private void LoadData() {
		try {
			LogDAO logDAO = new LogDAO();
			ResultSet rs = logDAO.GetThongKeChung();
			if (rs != null) {
				if (rs.next()) {
					lbSoDauSach.setText("Số đầu sách: " + rs.getString(1));
					lbSoCuonSach1.setText("Số sách đang mượn: " + rs.getString(2));
					lbSoCuonSach2.setText("Số sách chưa mượn: " + rs.getString(3));
					lbDocGia.setText("Số độc giả: " + rs.getString(4));
					lbTacGia.setText("Số tác giả: " + rs.getString(5));
					lbNXB.setText("Số nhà xuất bản: " + rs.getString(6));
					lbNV.setText("Số nhân viên: " + rs.getString(7));
				}
			}
			Refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void Refresh() {
		try {
			LogDAO DAO = new LogDAO();
			if (cbThoiGian.isSelected()) {
				java.util.Date from = (java.util.Date) datePickerFrom.getModel().getValue();
				java.util.Date to = (java.util.Date) datePickerTo.getModel().getValue();
				if (from.compareTo(to) > 0) {
					Alert.ShowMessageWarn("Vui lòng chọn ngày phù hợp", "Tìm theo ngày");
					return;
				}

				Date d1 = new Date(from.getTime());
				Date d2 = new Date(to.getTime());
				ResultSet rs= DAO.GetThongKeMuonTheoNgay(d1,d2);
				if(rs!=null) {
					if(rs.next()) {
						lbSoLanMuonSach.setText("Số lần mượn sách: "+rs.getString(1));
						lbSoLanTraSach.setText("Số lần trả sách: "+rs.getString(2));
						lbSoSachDuocMuonNhieuNhat.setText("Sách được mượn nhiều nhất: "+rs.getString(3));
					}
					
				}
			} else {
				ResultSet rs= DAO.GetThongKeMuon();
				if(rs!=null) {
					if(rs.next()) {
						lbSoLanMuonSach.setText("Số lần mượn sách: "+rs.getString(1));
						lbSoLanTraSach.setText("Số lần trả sách: "+rs.getString(2));
						lbSoSachDuocMuonNhieuNhat.setText("Sách được mượn nhiều nhất: "+rs.getString(3));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
