package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oracleDb.DBConnect;

public class SwingJdbcScore_01 extends JFrame implements ActionListener {
	
	DBConnect db = new DBConnect();
	Container cp;
	
	DefaultTableModel model;
	JTable table;
	JButton btnAdd,btnDel,btnUpdate;
	
	AddStuInfo addForm = new AddStuInfo("성적추가");
	
//	 생성자
	public SwingJdbcScore_01(String title) {
		
		super(title);
		cp = this.getContentPane();
		this.setBounds(270,100,400,300);
		cp.setBackground(new Color(255,255,200));
		initDesing();
		this.setVisible(true);
	}
	public void tableWrite() {
//		테이블초기화
		model.setRowCount(0);
		
//		db연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from stuinfo order by num ";
		
		conn = db.getOracle();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("ban"));
				data.add(rs.getString("java"));
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));
				
//				테이블에 추가
				model.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
	}
	public void insertData() 
	{
	String name 	= addForm.tfName.getText();
	String java = addForm.tfJava.getText();
	String jsp = addForm.tfJsp.getText();
	String spring = addForm.tfSpring.getText();
	String ban =(String)addForm.cbBan.getSelectedItem();
	
	int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
	double avg =tot/3.0;
	
	String sql = "insert into stuinfo values (seq1.nextval,?,?,?,?,?,?,?";
	
//	db연결.sql문 전송
	}
	
	
public void initDesing()
{
	String [] title  = {"번호","이름","반","Java","Jsp","Spring","총점","평균"};
	
	model = new DefaultTableModel(title,0);
	table = new JTable(model);
	this.add("Center",new JScrollPane(table));
	
//	테이블에 db데이터 출력
	tableWrite();
	
//	 버튼 3개 올릴 패널
	JPanel pTop = new JPanel();
	this.add("North",pTop);
	
//	추가버튼
	btnAdd = new JButton("추가");
	btnAdd.addActionListener(this);
	pTop.add(btnAdd);
	
//	추가폼에 있는 추가버튼에 액션 추가
	addForm.btnAdd.addActionListener(this);
	
	btnDel = new JButton("삭제");
	btnDel.addActionListener(this);
	pTop.add(btnDel);
	
	btnUpdate = new JButton("수정");
	btnUpdate.addActionListener(this);
	pTop.add(btnUpdate);
}
	
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object ob= e.getSource();
	
	if(ob==btnAdd)
	{
//		System.out.println("add");
		addForm.setVisible(true);
		
	}else if (ob==btnDel)
	{
		System.out.println("del");
	}else if(ob==btnUpdate)
	{
		System.out.println("update");
	}

}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SwingJdbcScore_01("학생성적관리DB");
	}
	

}
