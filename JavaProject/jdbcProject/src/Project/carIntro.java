package Project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//			차 관리 페이지
public class carIntro extends JFrame implements ActionListener {
	
	JButton btnAdd,btnDel,btnUpdate,btnList;
	carDAO dao = new carDAO();

	public carIntro() {
			super("차 관리 페이지");

			this.setBounds(270, 100, 400, 400);
			initDesign();
			this.setVisible(true);

	}
	public void initDesign() {
		 this.setLayout(null);
		btnAdd = new JButton("차량 등록");
		btnDel = new JButton("차량 삭제");
		btnUpdate = new JButton("상품수정");
		btnList = new JButton("차량 목록");
		
		btnAdd.setBounds(10, 10, 100, 30);
	    btnDel.setBounds(120, 100, 100, 30);
	    btnUpdate.setBounds(230, 10, 100, 30);
	    btnList.setBounds(340, 10, 100, 30);
	    
	    styleButton(btnAdd);
	    styleButton(btnDel);
	    styleButton(btnUpdate);
	    styleButton(btnList);
		
		this.add(btnAdd);
		this.add(btnDel);
		this.add(btnUpdate);
		this.add(btnList);
		
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
		
	}
	private void styleButton(JButton button) {
	    button.setFont(new java.awt.Font("Avenir Next", 0, 14));
	    // You can customize more styles if needed
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	Object ob = e.getSource();
	
	if(ob == btnAdd)
	{
		carAddForm add= new carAddForm();
//		System.out.println("add");
	}else if (ob == btnDel)
	{
		String num = JOptionPane.showInputDialog("삭제할 num을 입력해 주세요.");
		dao.delete(num);
//		System.out.println("del");
	}else if (ob== btnUpdate) {
		System.out.println("update");
	}else if (ob == btnList) {
		carListForm  list = new carListForm();
//		System.out.println("List");
	}
	}
	
	create table carManage(num number(5) primary key, c_name varchar2(30),carImage varchar2(100),
			c_price number(8),c_fe number(6), c_fuel varchar2(30), c_level varchar2(20), c_ap varchar2(20),
			c_maintain varchar2(30));

			drop table carManage;

			create sequence car_info;

			commit;
			select * from sshop;
			select * from carManage;
	
	
	

	public static void main(String[] args) {
		new carIntro();
	}
	
}
