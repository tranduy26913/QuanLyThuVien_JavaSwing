package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.KhachHang;
import Model.KhachHangDAO;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frameDonHang extends JFrame {
	private JPanel contentPane;
	private JTextField txtSoDH;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JLabel lblNgy;
	private JTextField txtNgay;
	private JTable table;
	private JComboBox cbKH;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public frameDonHang() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSnHng = new JLabel("S\u1ED1 \u0111\u01A1n h\u00E0ng");
		lblSnHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSnHng.setBounds(25, 11, 92, 25);
		contentPane.add(lblSnHng);
		
		txtSoDH = new JTextField();
		txtSoDH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoDH.setColumns(10);
		txtSoDH.setBounds(127, 11, 149, 25);
		contentPane.add(txtSoDH);
		
		txtTen = new JTextField();
		txtTen.setEnabled(false);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setColumns(10);
		txtTen.setBounds(317, 47, 390, 25);
		contentPane.add(txtTen);
		
		JLabel lblKhchHng = new JLabel("Kh\u00E1ch h\u00E0ng");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhchHng.setBounds(25, 47, 92, 25);
		contentPane.add(lblKhchHng);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(127, 83, 580, 25);
		contentPane.add(txtDiaChi);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(25, 83, 76, 25);
		contentPane.add(lblaCh);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(127, 119, 149, 25);
		contentPane.add(txtSDT);
		
		JLabel lblinThoi = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblinThoi.setBounds(25, 119, 76, 25);
		contentPane.add(lblinThoi);
		
		lblNgy = new JLabel("Ng\u00E0y");
		lblNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgy.setBounds(456, 11, 92, 25);
		contentPane.add(lblNgy);
		
		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgay.setColumns(10);
		txtNgay.setBounds(558, 11, 149, 25);
		contentPane.add(txtNgay);
		
		KhachHangDAO khDAO=new KhachHangDAO();
		ArrayList<KhachHang> listKH=khDAO.GetAllKhachHang();
		ArrayList<String> maKH= new ArrayList<String>();
		
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		
		for (KhachHang kh : listKH) {
			model.addElement(kh);
		}
		JComboBox cbKH = new JComboBox(model);
		cbKH.setSelectedIndex(-1);
		cbKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang s = (KhachHang) cbKH.getSelectedItem();
				txtTen.setText(s.getName());
			}
		});
		cbKH.setBounds(127, 47, 150, 25);
		contentPane.add(cbKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 170, 717, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "H\u00E0ng Ho\u00E1", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(136, 382, 110, 30);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(256, 382, 110, 30);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(376, 382, 110, 30);
		contentPane.add(btnSua);
		
		JButton btnIn = new JButton("In");
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIn.setBounds(496, 382, 110, 30);
		contentPane.add(btnIn);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(616, 382, 110, 30);
		contentPane.add(btnThoat);
		
		JButton btnTim = new JButton("T\u00ECm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(16, 382, 110, 30);
		contentPane.add(btnTim);
		setVisible(true);
		LoadData();
	}
	
	public  void LoadData() {
		
		
		
		
	}
}
