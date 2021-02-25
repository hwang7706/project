package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.OrderModel;

public class OrderPay {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO dao = new DAO();
	
	public int PayInsert(OrderModel om) {
		dao.getCon();
		int result=0;
		
		try {
			
			String sql = "insert into payment () values ()";
			
			pstmt=dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, om.getTotal_price());
			pstmt.setString(2, om.getEmail());
			pstmt.setString(3, om.getName());
			pstmt.setString(4, om.getTel());
			pstmt.setString(5, om.getAddress());
			
			result=1;
			pstmt.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
