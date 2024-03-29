package day0131;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;

import oracleDb.DBConnect;

public class ShopDbModel extends JFrame {
	
	DBConnect db = new DBConnect();
	
//	추가
	public void insertShop(shopDto dto)
	{
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "insert into sshop values(seq1.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setInt(3, dto.getSu());
			pstmt.setInt(4, dto.getDan());
			//없에디트
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
//	전체조회
	public Vector<shopDto> getAllSangpums() 
	{
		Vector<shopDto> list = new Vector<shopDto>();
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sshop order by sangpum";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
//				db에서 하나의 레코드를 읽어서 dto에 넣는다.
				shopDto dto = new shopDto();
				
				dto.setNum(rs.getString("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPhoto(rs.getString("photo"));
				dto.setSu(rs.getInt("su"));
				dto.setDan(rs.getInt("dan"));
				dto.setGuipday(rs.getDate("guipday"));
				
//				list에 dto추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
//	삭제
	public void deleteSangpum(String num)
	{
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "delete from sshop where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	
//	수정

}
