package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.NhanVien;
import Model.NhanVienDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frameThongTin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private int maNV = 0;

	public frameThongTin() {
		Init();
	}

	public frameThongTin(int manv) {
		this.maNV = manv;
		Init();
	}
	private void Init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel nhanVienLabel = new JLabel("Mã nhân viên:");
		nhanVienLabel.setPreferredSize(new Dimension(100, 20));
		nhanVienLabel.setMaximumSize(new Dimension(300, 30));
		nhanVienLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhanVienLabel.setBounds(10, 53, 399, 40);
		contentPane.add(nhanVienLabel);
		JLabel HoTenNhanVienLabel = new JLabel("Họ và tên:");
		HoTenNhanVienLabel.setPreferredSize(new Dimension(100, 20));
		HoTenNhanVienLabel.setMaximumSize(new Dimension(300, 30));
		HoTenNhanVienLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		HoTenNhanVienLabel.setBounds(10, 103, 399, 40);
		contentPane.add(HoTenNhanVienLabel);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setPreferredSize(new Dimension(100, 20));
		lblaCh.setMaximumSize(new Dimension(300, 30));
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(10, 153, 399, 40);
		contentPane.add(lblaCh);

		JLabel lblSinThoi_1 = new JLabel("Số điện thoại:");
		lblSinThoi_1.setPreferredSize(new Dimension(100, 20));
		lblSinThoi_1.setMaximumSize(new Dimension(300, 30));
		lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSinThoi_1.setFocusable(false);
		lblSinThoi_1.setBounds(10, 203, 399, 40);
		contentPane.add(lblSinThoi_1);

		JLabel lblSinThoi_1_1 = new JLabel("Lương:");
		lblSinThoi_1_1.setEnabled(false);
		lblSinThoi_1_1.setPreferredSize(new Dimension(100, 20));
		lblSinThoi_1_1.setMaximumSize(new Dimension(300, 30));
		lblSinThoi_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSinThoi_1_1.setBounds(10, 253, 399, 40);
		contentPane.add(lblSinThoi_1_1);

		textField = new JTextField();
		textField.setMaximumSize(new Dimension(300, 30));
		textField.setColumns(10);
		textField.setBounds(146, 53, 263, 40);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setMaximumSize(new Dimension(300, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(146, 103, 263, 40);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setMaximumSize(new Dimension(300, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(146, 153, 263, 40);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setMaximumSize(new Dimension(300, 30));
		textField_3.setColumns(10);
		textField_3.setBounds(146, 203, 263, 40);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setMaximumSize(new Dimension(300, 30));
		textField_4.setColumns(10);
		textField_4.setBounds(146, 253, 263, 40);
		contentPane.add(textField_4);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(243, 340, 110, 40);
		contentPane.add(btnThoat);
		JButton btnCapNhatThongTin = new JButton("Cập nhật");
		btnCapNhatThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNV();
			}
			
		});
		btnCapNhatThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhatThongTin.setBounds(92, 340, 110, 40);
		contentPane.add(btnCapNhatThongTin);
		LoadData();
	}
	
	private void LoadData() {
		try {
			NhanVienDAO nhanVienDAO = new NhanVienDAO();
			if (this.maNV == 0) {
				return;
			}
			ArrayList<NhanVien> list = nhanVienDAO.layThongTinNhanVien(maNV);
			if (list.size() != 0) {
				textField.setText(String.valueOf(list.get(0).getMa()));
				textField.setEditable(false);
				textField_1.setText(list.get(0).getHoTen());
				textField_2.setText(list.get(0).getDiaChi());
				textField_3.setText(list.get(0).getSoDT());
				textField_4.setText(String.valueOf(list.get(0).getLuong()));
				textField_4.setEditable(false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void SuaNV() {
		try {
			if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
					|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()) {
				Alert.ShowMessageWarn("Vui lòng nhập đầy đủ thông tin!", "Cập nhật thông tin");
				return;
			}

			NhanVien nhanVien = new NhanVien(Integer.parseInt(textField.getText()), textField_1.getText(), textField_2.getText(),
					textField_3.getText(), Double.parseDouble(textField_4.getText()));
			NhanVienDAO dao = new NhanVienDAO();

			if (dao.Update(nhanVien)) {
				Alert.ShowMessageInfo("Cập nhật thông tin cá nhân thành công", "Cập nhật thông tin");
			}

			else {
				Alert.ShowMessageWarn("Cập nhật thông tin cá nhân không thành công!! Vui lòng kiểm tra lại",
						"Cập nhật thông tin");
				LoadData();
			}

		} catch (Exception e) {
			Alert.ShowMessageError("Lỗi cập nhật thông tin cá nhân !!", "Cập nhật thông tin");

		}
	}
	private void Exit() {
		dispose();
	}
	
}
