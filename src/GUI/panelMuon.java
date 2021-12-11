package GUI;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import Model.CuonSachDAO;
import Model.DocGia;
import Model.DocGiaDAO;
import Model.Muon;
import Model.MuonDAO;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class panelMuon extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaDG;
	private JTextField txtTenDG;
	private JTextArea txtDC;
	private JTextField txtSDT;
	private JTable tableDG;
	private JTable tableSach;
	private JTextField txtMaCuonSach;
	private JTextField txtTuaSach;
	private JRadioButton rbMuon;
	private JRadioButton rbTatCa;

	/**
	 * Create the panel.
	 */
	public panelMuon() {

		setBounds(new Rectangle(0, 0, 1160, 510));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel);
		panel.setLayout(null);
		
		txtMaDG = new JTextField();
		txtMaDG.setBounds(931, 11, 205, 25);
		panel.add(txtMaDG);
		txtMaDG.setColumns(10);
		
		JLabel lblMuSch = new JLabel("Mã độc giả");
		lblMuSch.setBounds(831, 11, 90, 25);
		panel.add(lblMuSch);
		lblMuSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTaSch = new JLabel("T\u00EAn \u0111\u1ED9c gi\u1EA3");
		lblTaSch.setBounds(831, 47, 90, 25);
		panel.add(lblTaSch);
		lblTaSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTenDG = new JTextField();
		txtTenDG.setBounds(931, 47, 205, 25);
		panel.add(txtTenDG);
		txtTenDG.setColumns(10);
		
		JLabel lblNhXutBn = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNhXutBn.setBounds(831, 83, 90, 25);
		panel.add(lblNhXutBn);
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnXoaDG = new JButton("Xo\u00E1");
		btnXoaDG.setBounds(857, 221, 110, 40);
		btnXoaDG.addActionListener(new XoaDG());
		panel.add(btnXoaDG);
		btnXoaDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTimDG = new JButton("T\u00ECm");
		btnTimDG.addActionListener(new TimDG());
		btnTimDG.setBounds(999, 221, 110, 40);
		panel.add(btnTimDG);
		btnTimDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(931, 83, 205, 59);
		panel.add(scrollPane_1);
		
		txtDC = new JTextArea();
		scrollPane_1.setViewportView(txtDC);
		txtDC.setRows(5);
		txtDC.setLineWrap(true);
		txtDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDC.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setBounds(831, 153, 90, 25);
		panel.add(lblSinThoi);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(931, 153, 205, 25);
		panel.add(txtSDT);
		txtSDT.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, 790, 260);
		panel.add(scrollPane);
		
		tableDG = new JTable();
		tableDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableDG);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(6, 290, 790, 250);
		panel.add(scrollPane2);
		
		tableSach = new JTable();
		tableSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane2.setViewportView(tableSach);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 280, 1160, 2);
		panel.add(separator);
		
		JLabel lblMSch = new JLabel("Mã sách");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSch.setBounds(831, 295, 90, 25);
		panel.add(lblMSch);
		
		txtMaCuonSach = new JTextField();
		txtMaCuonSach.setColumns(10);
		txtMaCuonSach.setBounds(931, 295, 205, 25);
		panel.add(txtMaCuonSach);
		
		JLabel lblTaSch_2 = new JLabel("Tựa sách");
		lblTaSch_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaSch_2.setBounds(831, 331, 90, 25);
		panel.add(lblTaSch_2);
		
		txtTuaSach = new JTextField();
		txtTuaSach.setColumns(10);
		txtTuaSach.setBounds(931, 331, 205, 25);
		panel.add(txtTuaSach);
		
		JButton btnMuon = new JButton("Mượn");
		btnMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MuonSach();
			}
		});
		btnMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMuon.setBounds(879, 378, 110, 40);
		panel.add(btnMuon);
		
		JButton btnTra = new JButton("Trả");
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraSach();
			}
		});
		btnTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTra.setBounds(999, 378, 110, 40);
		panel.add(btnTra);
		
		rbTatCa = new JRadioButton("Tất cả");
		rbTatCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbTatCa.setBounds(997, 185, 90, 23);
		panel.add(rbTatCa);
		rbTatCa.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!txtMaDG.getText().isEmpty()) {
					MuonDAO dao=new MuonDAO();
					LoadDataTableDG(dao.GetDanhSachMuonFromMaDG(txtMaDG.getText()));
				}
				
			}
		});
		
		rbMuon = new JRadioButton("Đang mượn");
		rbMuon.setSelected(true);
		rbMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbMuon.setBounds(864, 185, 103, 23);
		panel.add(rbMuon);
		rbMuon.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!txtMaDG.getText().isEmpty()) {
					MuonDAO muonDAO=new MuonDAO();
					LoadDataTableDG(muonDAO.GetDanhSachDangMuonFromMaDG(txtMaDG.getText()));
				}
			}
		});
		tableDG.addMouseListener(new ClickCellTableDG());
		
		ButtonGroup group=new ButtonGroup();
		group.add(rbMuon);
		group.add(rbTatCa);
		
		JButton btnGiaHan = new JButton("Gia hạn");
		btnGiaHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaHanSach();
			}
		});
		btnGiaHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGiaHan.setBounds(879, 429, 110, 40);
		panel.add(btnGiaHan);
		
		JButton btnMatSach = new JButton("Mất sách");
		btnMatSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatSach();
			}
		});
		btnMatSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMatSach.setBounds(999, 429, 110, 40);
		panel.add(btnMatSach);
		
		JButton btnF5CuonSachChuaMuon = new JButton("Làm mới");
		btnF5CuonSachChuaMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refresh();
			}
		});
		btnF5CuonSachChuaMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnF5CuonSachChuaMuon.setBounds(879, 480, 230, 40);
		panel.add(btnF5CuonSachChuaMuon);
		
		InitTableDG();
		InitTableSach();
	}
	
	private void InitTableDG() {
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Mã cuốn");
		model.addColumn("Tựa sách");
		model.addColumn("Ngày mượn");
		model.addColumn("Ngày trả");
		tableDG.setModel(model);
		ListSelectionModel model2 = tableDG.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					if (!model2.isSelectionEmpty()) {
						int index = model2.getMinSelectionIndex();
						txtMaCuonSach.setText(tableDG.getValueAt(index, 0).toString());
						txtTuaSach.setText(tableDG.getValueAt(index, 1).toString());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
	}
	
	private void InitTableSach() {
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Mã cuốn");
		model.addColumn("Tựa sách");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Tác giả");
		tableSach.setModel(model);
		ListSelectionModel model2 = tableSach.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					if (!model2.isSelectionEmpty()) {
						int index = model2.getMinSelectionIndex();
						txtMaCuonSach.setText(tableSach.getValueAt(index, 0).toString());
						txtTuaSach.setText(tableSach.getValueAt(index, 1).toString());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		try {
			CuonSachDAO csDAO=new CuonSachDAO();
			LoadDataTableSach(csDAO.GetAllCuonSachChuaMuon());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void Refresh() {
		try {
			CuonSachDAO csDAO=new CuonSachDAO();
			LoadDataTableSach(csDAO.GetAllCuonSachChuaMuon());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void LoadDataTableSach(ResultSet rs) {
		try {
			DefaultTableModel model=(DefaultTableModel)tableSach.getModel();
			model.setRowCount(0);
			if(rs==null) {
				return;
			}
			while (rs.next()) {
				model.addRow(new String[] {
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				});
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void LoadDataTableDG(ResultSet rs) {
		try {
			DefaultTableModel model=(DefaultTableModel)tableDG.getModel();
			model.setRowCount(0);
			if(rs==null) {
				return;
			}
			while (rs.next()) {
				model.addRow(new String[] {
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				});
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class XoaDG implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(txtMaDG.getText().isEmpty()) {
					Alert.ShowMessageWarn("Vui lòng điền mã độc giả cần xoá", 
							 "Xoá độc giả");
					return;
				}
				
				DocGiaDAO DAO=new DocGiaDAO();
				if(DAO.CheckDocGiaDangMuon(txtMaDG.getText())!=0) {
					Alert.ShowMessageWarn("Độc giả này vẫn còn sách chưa trả. Không được phép xoá!", "Xoá độc giả");
					return;
				}
				DAO.DeleteDocGiaFromMaDG(txtMaDG.getText());
				Alert.ShowMessageInfo("Xoá độc giả thành công", 
						 "Xoá độc giả");
				
			} catch (Exception e2) {
				Alert.ShowMessageError("Lỗi khi Sửa độc giả", 
						 "Sửa độc giả");
				e2.printStackTrace();
			}		
		}
	}
	
	private class TimDG implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(txtMaDG.getText().isEmpty()) {
					Alert.ShowMessageWarn("Vui lòng nhập mã độc giả", "Thông tin độc giả");
					return;
				}
				DocGiaDAO dgDAO=new DocGiaDAO();
				DocGia dg= dgDAO.GetDocGiaFromMaDG(txtMaDG.getText());
				if(dg!=null) {
					txtTenDG.setText(dg.getHoTen());
				txtDC.setText(dg.getDiaChi());
				txtSDT.setText(dg.getSoDT());
				MuonDAO DAO=new MuonDAO();
				if(rbMuon.isSelected())
					LoadDataTableDG(DAO.GetDanhSachDangMuonFromMaDG(txtMaDG.getText()));
				else
					LoadDataTableDG(DAO.GetDanhSachMuonFromMaDG(txtMaDG.getText()));
				}
				else {
					Alert.ShowMessageWarn("Không tìm thấy độc giả", "Tìm độc giả");
				}
				
				
			} catch (Exception e2) {
				Alert.ShowMessageError("Lỗi khi tìm độc giả","Tìm độc giả");
				e2.printStackTrace();
			}		
		}
	}
	
	private void MuonSach() {
		try {
			if(txtMaDG.getText().isEmpty()||txtMaCuonSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền đầy đủ thông tin", "Mượn sách");
				return;
			}
			
			int macuon = 0,madocgia=0;
			try {
				macuon = Integer.parseInt(txtMaCuonSach.getText());
				madocgia = Integer.parseInt(txtMaDG.getText());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (macuon <= 0 || madocgia <=0) {
				Alert.ShowMessageWarn("Vui lòng điền mã số cuốn sách, mã độc giả", "Mượn sách");
				return;
			}
			
			java.util.Date d=new java.util.Date();
			Date date=new Date(d.getTime());
			Muon muon=new Muon(macuon,madocgia, date);
			MuonDAO muonDAO=new MuonDAO();
			if(muonDAO.CheckDaMuonDauSach(txtMaCuonSach.getText(), txtMaDG.getText())) {
				Alert.ShowMessageInfo("Đầu sách này đã mượn. Vui lòng chọn sách khác", "Mượn sách");
				return;
			}
			
			if(muonDAO.CheckCuonSachDaMuon(macuon)) {
				Alert.ShowMessageInfo("Cuốn sách này đã được mượn. Vui lòng chọn sách khác", "Mượn sách");
				return;
			}
			
			if(muonDAO.Insert(muon)) {
				Alert.ShowMessageInfo("Mượn thành công", "Mượn sách");
				Refresh();
			}
			else {
				Alert.ShowMessageInfo("Mượn không thành công", "Mượn sách");
			}
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi mượn sách", "Mượn sách");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	private void TraSach() {
		try {
			if(txtMaDG.getText().isEmpty()||txtMaCuonSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền đầy đủ thông tin", "Trả sách");
				return;
			}
			int macuon = 0,madocgia=0;
			try {
				macuon = Integer.parseInt(txtMaCuonSach.getText());
				madocgia = Integer.parseInt(txtMaDG.getText());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (macuon <= 0 || madocgia <=0) {
				Alert.ShowMessageWarn("Vui lòng điền mã số cuốn sách, mã độc giả", "Mượn sách");
				return;
			}
			
			MuonDAO muonDAO=new MuonDAO();
			ResultSet rs=muonDAO.GetDangMuon(madocgia, macuon);
			if(rs.next()) {
				Date ngayMuon=rs.getDate(3);
				java.util.Date d=new java.util.Date();
				Date ngayTra=new Date(d.getTime());
				
				long diff=ngayTra.getTime()-ngayMuon.getTime();
				TimeUnit time = TimeUnit.DAYS; 
		        long days = time.convert(diff, TimeUnit.MILLISECONDS);
		        
				Muon muon=new Muon(macuon, madocgia, ngayMuon,ngayTra);
				
				if(muonDAO.TraSach(muon)){
					if(days>30) //Hạn trả sách là 30 ngày
					{
						int a=(int)days-30;
						Alert.ShowMessageInfo("Trả thành công. Bạn trễ hạn "+String.valueOf(a)+" ngày"
								+ ". Phạt "+String.valueOf(a*500)+" VNĐ", "Trả sách");
					}
					else {
						Alert.ShowMessageInfo("Trả thành công", "Trả sách");
					}
					Refresh();
				}
				else {
					Alert.ShowMessageInfo("Trả không thành công", "Trả sách");
				}
			}
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi mượn sách", "Mượn sách");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	private void GiaHanSach() {
		try {
			if(txtMaDG.getText().isEmpty()||txtMaCuonSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền đầy đủ thông tin", "Gia hạn sách");
				return;
			}
			
			int macuon = 0,madocgia=0;
			try {
				macuon = Integer.parseInt(txtMaCuonSach.getText());
				madocgia = Integer.parseInt(txtMaDG.getText());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (macuon <= 0 || madocgia <=0) {
				Alert.ShowMessageWarn("Vui lòng điền mã số cuốn sách, mã độc giả", "Mượn sách");
				return;
			}
			
			MuonDAO muonDAO=new MuonDAO();
			ResultSet rs=muonDAO.GetDangMuon(madocgia, macuon);
			if(rs.next()) {
				Date ngayMuon=rs.getDate(3);
				java.util.Date d=new java.util.Date();
				Date ngayGiaHan=new Date(d.getTime());
				
				long diff=ngayGiaHan.getTime()-ngayMuon.getTime();
				TimeUnit time = TimeUnit.DAYS; 
		        long days = time.convert(diff, TimeUnit.MILLISECONDS);
				Muon muon=new Muon(macuon, madocgia, ngayGiaHan);
				
				if(muonDAO.GiaHanSach(muon)){
					if(days>30) {
						int a=(int)days-30;
						Alert.ShowMessageInfo("Gia hạn thành công. Bạn trễ hạn "+String.valueOf(a)+" ngày"
								+ ". Phạt "+String.valueOf(a*500)+" VNĐ", "Gia hạn sách");
					}
					else {
						Alert.ShowMessageInfo("Gia hạn thành công", "Gia hạn sách");
					}
					
				}
				else {
					Alert.ShowMessageInfo("Gia hạn không thành công", "Gia hạn sách");
				}
			}
			else {
				Alert.ShowMessageInfo("Bạn chưa mượn sách này", "Gia hạn sách");
			}
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi mượn sách", "Mượn sách");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	private void MatSach() {
		try {
			if(txtMaDG.getText().isEmpty()||txtMaCuonSach.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng điền đầy đủ thông tin", "Báo mất sách");
				return;
			}
			int maCuon=Integer.parseInt(txtMaCuonSach.getText());
			MuonDAO muonDAO=new MuonDAO();
			int giaSach=muonDAO.GetGiaSach(Integer.parseInt(txtMaCuonSach.getText()));
			CuonSachDAO csDAO=new CuonSachDAO();
			if(csDAO.Delete(maCuon)) {
				Alert.ShowMessageInfo("Báo mất thành công. Phạt:"+giaSach+" vnd", "Báo mất sách");
				Refresh();
			}
			else {
				Alert.ShowMessageInfo("Báo mất không thành công", "Báo mất sách");
			}
			
			
		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi báo mất sách", "Báo mất sách");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
	private class ClickCellTableDG extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index= tableDG.getSelectedRow();
			if(index!=-1) {
				txtMaCuonSach.setText(tableDG.getValueAt(index, 0).toString());
				txtTuaSach.setText(tableDG.getValueAt(index, 1).toString());
				
				
			}
		}
	}
}
