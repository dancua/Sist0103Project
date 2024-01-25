package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizJdbcFoodOrder {
	
	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectSawon()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql ="select * from sawon order by num";
		
		try {
			conn = DriverManager.getConnection(URL, "stu", "a1234");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
//			여러줄을 가져올때는 while문으로 가져온다.
//			rs.next() : 다음데이터로 이동하면서 true반환 더이상 데이터가 없으면 false반환
			while(rs.next())
			{
//				db로부터 데이터 가져오기
			int num	= rs.getInt("num");
			String name = rs.getString("name");
			String gender =rs.getString("gender");
			String buseo = rs.getString("buseo");
			int pay = rs.getInt("pay");
			
			System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);	
			}
			
			System.out.println("오라클 드라이버 연결 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오라클 드라이버 연결 실패");
		}finally {
		
		}
			   try {
				   if(rs!=null)	rs.close();
				   if(stmt!= null) stmt.close();
				   if(conn!= null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTest ct = new ConnectTest();
		ct.connectSawon();
	}

}
