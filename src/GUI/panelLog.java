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

public class panelLog extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTable tableLog;
	private JCheckBox cbThoiGian;
	private JDatePickerImpl datePickerTo;
	private JDatePickerImpl datePickerFrom;

	private int maNV = 0;
	private int chucNang = 0;

	public int getChucNang() {
		return chucNang;
	}

	public void setChucNang(int chucNang) {
		this.chucNang = chucNang;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	/**
	 * Create the panel.
	 */
	public panelLog() {
		Init();
	}
	
	public panelLog(int maNv,int chucNang) {
		this.maNV=maNv;
		this.chucNang=chucNang;
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

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNV.setBounds(110, 24, 126, 25);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblMuSch = new JLabel("Mã  Nhân Viên");
		lblMuSch.setBounds(10, 24, 90, 25);
		panel.add(lblMuSch);
		lblMuSch.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnTimNV = new JButton("T\u00ECm");
		btnTimNV.addActionListener(new TimLog());
		btnTimNV.setBounds(246, 16, 73, 40);
		panel.add(btnTimNV);
		btnTimNV.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 75, 1132, 416);
		panel.add(scrollPane);

		tableLog = new JTable();
		tableLog.setFillsViewportHeight(true);
		tableLog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableLog);

		JButton btnF5 = new JButton("Làm mới");
		btnF5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		btnF5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnF5.setBounds(1028, 16, 110, 40);
		panel.add(btnF5);

		if (chucNang == 0) {
			JButton btnTatCa = new JButton("Tất cả");
			btnTatCa.addActionListener(new TimTatCaLog());
			btnTatCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnTatCa.setBounds(769, 16, 110, 40);
			panel.add(btnTatCa);
		}else {
			txtMaNV.setText(String.valueOf(this.maNV));
			txtMaNV.setEnabled(false);
			//btnTimNV.setEnabled(false);
		}
		
		UtilDateModel model = new UtilDateModel();
		java.util.Date date=new java.util.Date();
		model.setDate(date.getYear()+1900, date.getMonth(), date.getDay());
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
		model2.setDate(date.getYear()+1900, date.getMonth(), date.getDay());
		model2.setSelected(true);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		datePickerFrom = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePickerFrom.setLocation(642, 24);
		datePickerFrom.setSize(140, 30);
		 
		panel.add(datePickerFrom);
		
		cbThoiGian = new JCheckBox("Theo thời gian");
		cbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbThoiGian.setBounds(457, 25, 126, 23);
		panel.add(cbThoiGian);
		
		JLabel lblNewLabel = new JLabel("Từ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(598, 29, 34, 14);
		panel.add(lblNewLabel);
		
		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(804, 29, 46, 14);
		panel.add(lbln);
		
		
		
		
		InitTable();
	}

	private void InitTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID Log");
		model.addColumn("Tên nhân viên");
		model.addColumn("Ghi chú");
		model.addColumn("Thời gian");
		tableLog.setModel(model);
		try {
			LogDAO dgDAO = new LogDAO();
			ResultSet rs;
			if (maNV == 0) {
				rs = dgDAO.GetAllLog();
			} else {
				rs = dgDAO.GetLogFromMaNV(maNV);
			}
			LoadDataTable(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void Refresh() {
		try {
			int ma = 0;
			try {
				ma = Integer.parseInt(txtMaNV.getText());
			} catch (Exception e2) {
				// TODO: handle exception
			}
			if (ma == 0) {
				Alert.ShowMessageWarn("Vui lòng nhập số vào mã nhân viên", "Log Event");
				return;
			}
			LogDAO DAO = new LogDAO();
			LoadDataTable(DAO.GetLogFromMaNV(ma));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void LoadDataTable(ResultSet rs) {
		try {
			DefaultTableModel model = (DefaultTableModel) tableLog.getModel();
			model.setRowCount(0);
			if (rs == null) {
				return;
			}
			while (rs.next()) {
				model.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4) });

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private class TimTatCaLog implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				LogDAO DAO = new LogDAO();
				if(cbThoiGian.isSelected()) {
					java.util.Date from = (java.util.Date) datePickerFrom.getModel().getValue(); 
					java.util.Date to = (java.util.Date) datePickerTo.getModel().getValue();
					if(from.compareTo(to)>0) {
						Alert.ShowMessageWarn("Vui lòng chọn ngày phù hợp", "Tìm theo ngày");
						return;
					}
					
					Date d1=new Date(from.getTime());
					Date d2=new Date(to.getTime());
					
					LoadDataTable(DAO.GetAllLogDate(d1,d2));
				}
				else {
					
				LoadDataTable(DAO.GetAllLog());
				}
				

			} catch (Exception e2) {
				Alert.ShowMessageError("Lỗi khi tìm Log Event", "Log event");
				e2.printStackTrace();
			}
		}
	}

	private class TimLog implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int ma = 0;
				try {
					ma = Integer.parseInt(txtMaNV.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if (ma == 0) {
					Alert.ShowMessageWarn("Vui lòng nhập số vào mã nhân viên", "Tìm Log Event");
					return;
				}LogDAO DAO = new LogDAO();
				if(cbThoiGian.isSelected()) {
					java.util.Date from = (java.util.Date) datePickerFrom.getModel().getValue(); 
					java.util.Date to = (java.util.Date) datePickerTo.getModel().getValue();
					if(from.compareTo(to)>0) {
						Alert.ShowMessageWarn("Vui lòng chọn ngày phù hợp", "Tìm theo ngày");
						return;
					}
					
					Date d1=new Date(from.getTime());
					Date d2=new Date(to.getTime());
					
					LoadDataTable(DAO.GetLogFromMaNVandDate(ma,d1,d2));
				}
				else {
					
				LoadDataTable(DAO.GetLogFromMaNV(ma));
				}
				

			} catch (Exception e2) {
				Alert.ShowMessageError("Lỗi khi tìm Log Event", "Log event");
				e2.printStackTrace();
			}
		}
	}
	
	
}
