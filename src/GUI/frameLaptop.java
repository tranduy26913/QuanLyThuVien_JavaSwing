package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Model.Laptop;
import Model.LaptopDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frameLaptop extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSo;
	private JTextField txtHangSX;
	private JTextField txtMoTa;
	private JTextField txtGiaBan;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 @throws SQLException 
	 @throws ClassNotFoundException 
	 */
	public frameLaptop() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LaptopDAO spDAO = new LaptopDAO();
					float giaban = 0;
					try {
						giaban = Float.parseFloat(txtGiaBan.getText());
					} catch (Exception ex) {
					}
					Laptop sp = new Laptop(txtMaSo.getText(), txtHangSX.getText(), txtMoTa.getText(), giaban);
					spDAO.Insert(sp);
					LoadData();
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(56, 410, 95, 40);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (txtMaSo.getText().isEmpty()||txtHangSX.getText().isEmpty()||txtMoTa.getText().isEmpty()||txtGiaBan.getText().isEmpty()) {
						System.out.println("Vui lòng chọn sản phẩm cần sửa");
						return;
					}
					else {
						LaptopDAO spDAO =new LaptopDAO();
						float giaban=0;
						try {
							giaban=Float.parseFloat(txtGiaBan.getText());
						}catch(Exception ex) {
							// TODO: handle exception
						}
						Laptop sp=new Laptop(txtMaSo.getText(),txtHangSX.getText(),txtMoTa.getText(),giaban);
						spDAO.Update(sp);
						LoadData();
					}
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(161, 410, 95, 40);
		contentPane.add(btnSua);
		
		
		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LaptopDAO spDAO=new LaptopDAO();
					
					if (txtMaSo.getText().isEmpty()) {
						System.out.println("Vui lòng chọn sản phẩm cần xoá");
						
					}
					else {
						spDAO.DeleteLaptopFromMaSo(txtMaSo.getText());
						
						LoadData();
					}
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(266, 410, 95, 40);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 155, 676, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] arr = table.getSelectedRows();
				
				if (arr.length != 0) {
					txtMaSo.setText(model.getValueAt(arr[0], 0).toString());
					txtHangSX.setText(model.getValueAt(arr[0], 1).toString());
					txtMoTa.setText(model.getValueAt(arr[0], 2).toString());
					txtGiaBan.setText(model.getValueAt(arr[0], 3).toString());
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u1ED1","H\u00E3ng S\u1EA3n Xu\u1EA5t",  "M\u00F4 T\u1EA3", "Gi\u00E1 b\u00E1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnTim = new JButton("Tìm theo ID");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maso=txtMaSo.getText();
				if(maso.equals("")) {
					try {
						LoadData();
						return;
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				LaptopDAO spDAO=new LaptopDAO();
				Laptop sp=new Laptop();
				try {
					sp=spDAO.GetLaptopFromMaSo(maso);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				if(sp!=null)
					model.addRow(new Object[] { sp.getMaSo(),sp.getHangSx(),sp.getMoTa(),sp.getGiaBan()});
		
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(476, 411, 120, 39);
		contentPane.add(btnTim);
		
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
		btnf5.setBounds(371, 410, 95, 40);
		contentPane.add(btnf5);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 s\u1ED1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 11, 76, 25);
		contentPane.add(lblNewLabel);
		
		txtMaSo = new JTextField();
		txtMaSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSo.setColumns(10);
		txtMaSo.setBounds(126, 11, 183, 25);
		contentPane.add(txtMaSo);
		
		txtHangSX = new JTextField();
		txtHangSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHangSX.setColumns(10);
		txtHangSX.setBounds(126, 47, 183, 25);
		contentPane.add(txtHangSX);
		
		JLabel lblHngSnXut = new JLabel("H\u00E3ng s\u1EA3n xu\u1EA5t");
		lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHngSnXut.setBounds(24, 47, 92, 25);
		contentPane.add(lblHngSnXut);
		
		txtMoTa = new JTextField();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(126, 83, 183, 25);
		contentPane.add(txtMoTa);
		
		JLabel lblMT = new JLabel("M\u00F4 t\u1EA3");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMT.setBounds(24, 83, 76, 25);
		contentPane.add(lblMT);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(126, 119, 183, 25);
		contentPane.add(txtGiaBan);
		
		JLabel lblGiBn = new JLabel("Gi\u00E1 b\u00E1n");
		lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiBn.setBounds(24, 119, 76, 25);
		contentPane.add(lblGiBn);
		
		JButton txtThoat = new JButton("Thoát");
		txtThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		txtThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThoat.setBounds(606, 410, 120, 39);
		contentPane.add(txtThoat);
		LoadData();
		setVisible(true);
	}
	
	private void LoadData() throws ClassNotFoundException, SQLException {
		
		LaptopDAO spDAO=new LaptopDAO();
		ArrayList<Laptop> list=spDAO.GetAllLaptop();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Laptop Laptop : list) {
			model.addRow(new Object[] { Laptop.getMaSo(),Laptop.getHangSx(),Laptop.getMoTa(),Laptop.getGiaBan()});
		}
	}
}
