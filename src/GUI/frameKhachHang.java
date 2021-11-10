package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Model.KhachHang;
import Model.KhachHangDAO;
import Model.Laptop;
import Model.LaptopDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frameKhachHang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtPhone;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public frameKhachHang() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangDAO khDAO = new KhachHangDAO();
				KhachHang kh = new KhachHang(txtID.getText(), txtName.getText(), txtAddress.getText(),
						txtEmail.getText(), txtPhone.getText());
				try {
					khDAO.Insert(kh);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(171, 421, 110, 29);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (txtID.getText().isEmpty()||txtName.getText().isEmpty()||txtAddress.getText().isEmpty()||
							txtEmail.getText().isEmpty()||txtPhone.getText().isEmpty()) {
						System.out.println("Vui lòng chọn khách hàng cần sửa");
						return;
					} else {
						KhachHang sp = new KhachHang(txtID.getText(),txtName.getText(),txtAddress.getText()
								,txtEmail.getText(),txtPhone.getText());
						KhachHangDAO spDAO =new KhachHangDAO();
						spDAO.Update(sp);
						LoadData();
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(291, 421, 110, 29);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KhachHangDAO khDAO = new KhachHangDAO();
					if (txtID.getText().length() != 0) {
						khDAO.DeleteKhachHangFromID(txtID.getText());
						LoadData();
					} else {
						System.out.println("Vui lòng chọn khách hàng cần xoá");
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(411, 421, 110, 29);
		contentPane.add(btnXoa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 764, 206);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] arr = table.getSelectedRows();

				if (arr.length != 0) {
					txtID.setText(model.getValueAt(arr[0], 0).toString());
					txtName.setText(model.getValueAt(arr[0], 1).toString());
					txtAddress.setText(model.getValueAt(arr[0], 2).toString());
					txtEmail.setText(model.getValueAt(arr[0], 3).toString());
					txtPhone.setText(model.getValueAt(arr[0], 4).toString());
					try {
						LoadData();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					System.out.println("Vui lòng chọn khách hàng cần sửa");
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "T\u00EAn",
				"\u0110\u1ECBa ch\u1EC9", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i" }) {
			boolean[] columnEditables = new boolean[] { false, true, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane.setViewportView(table);

		JButton btnf5 = new JButton("Làm mới");
		btnf5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadData();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnf5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnf5.setBounds(531, 421, 110, 29);
		contentPane.add(btnf5);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(20, 19, 76, 25);
		contentPane.add(lblId);

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setColumns(10);
		txtID.setBounds(122, 19, 183, 25);
		contentPane.add(txtID);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(122, 55, 183, 25);
		contentPane.add(txtName);

		JLabel lblTn = new JLabel("T\u00EAn");
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTn.setBounds(20, 55, 92, 25);
		contentPane.add(lblTn);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(122, 91, 571, 25);
		contentPane.add(txtAddress);

		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(20, 91, 76, 25);
		contentPane.add(lblaCh);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(122, 127, 183, 25);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(20, 127, 76, 25);
		contentPane.add(lblEmail);

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(122, 163, 183, 25);
		contentPane.add(txtPhone);

		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(20, 163, 92, 25);
		contentPane.add(lblSinThoi);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(651, 421, 110, 29);
		contentPane.add(btnThoat);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenString=txtName.getText();
				KhachHangDAO khDAO=new KhachHangDAO();
				try {
					ArrayList<KhachHang> list= khDAO.GetAllKhachHangFromTen(tenString);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (KhachHang kh : list) {
						model.addRow(new Object[] { kh.getID(), kh.getName(), kh.getAddress(), kh.getEmail(), kh.getPhone() });
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(51, 421, 110, 29);
		contentPane.add(btnTim);
		setVisible(true);
		LoadData();
	}

	private void LoadData() throws ClassNotFoundException, SQLException {

		KhachHangDAO khDAO = new KhachHangDAO();
		ArrayList<KhachHang> list = khDAO.GetAllKhachHang();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (KhachHang kh : list) {
			model.addRow(new Object[] { kh.getID(), kh.getName(), kh.getAddress(), kh.getEmail(), kh.getPhone() });
		}
	}
}
