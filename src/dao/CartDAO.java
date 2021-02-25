package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import model.CartModel;

public class CartDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO dao = new DAO();
	
	public int cartinsert(CartModel cart) {
		dao.getCon();
		int result=-1;
		try {
			String sql = "insert into cart (userid,name,product_id,product_name,price,amount,money) values(?,?,?,?,?,?,?)";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setString(1, cart.getUserid());
			pstmt.setString(2, cart.getName());
			pstmt.setInt(3, cart.getProduct_id());
			pstmt.setString(4, cart.getProduct_name());
			pstmt.setInt(5, cart.getPrice());
			pstmt.setInt(6, cart.getAmount());
			pstmt.setInt(7, cart.getMoney());
			
			pstmt.executeLargeUpdate();
			result=1;
			
			pstmt.close();
			dao.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void dou(int product, int money, int amount) {
		dao.getCon();
		
		
		try {
			
			String sql = "update cart set amount = amount+? ,money = money+? where product_id=?";
			
			pstmt=dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, amount);
			pstmt.setInt(2, money);
			pstmt.setInt(3, product);
			
			pstmt.executeLargeUpdate();
			
			pstmt.close();
			dao.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CartModel> getCartList(String id) {
		dao.getCon();
		ArrayList<CartModel> cart = new ArrayList<CartModel>(); 
		
		try {
			
			String sql = "select * from cart where userid=?";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CartModel car = new CartModel();
				
				car.setProduct_id(rs.getInt("product_id"));
				car.setProduct_name(rs.getString("product_name"));
				car.setName(rs.getString("name"));
				car.setPrice(rs.getInt("price"));
				car.setAmount(rs.getInt("amount"));
				car.setMoney(rs.getInt("money"));
				
				cart.add(car);
			}
			rs.close();
			pstmt.close();
			dao.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public int Allsubject(int product) {
		
		dao.getCon();
		
		int productNum=0;
		try {
			
			String sql="select * from cart where product_id =?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, product);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				productNum=rs.getInt("product_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productNum;
	}
	
	public int delete(int id) {
		dao.getCon();
		
		int del=1;
		try {
			
			String sql = "delete from cart where product_id=?";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeLargeUpdate();
			
			del=0;
			
			pstmt.close();
			dao.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return del;
	}
	
	public int UpdateTo(int id, int amount) {
		dao.getCon();
		
		int up=0;
		try {
			
			String sql = "update cart set amount=?, money=*? where product_id=?";
			
			pstmt=dao.conn.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, id);
			
			
			pstmt.executeUpdate();
			
			up=1;
			
			pstmt.close();
			dao.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return up;
	}
	
	public int deleteAll(String uid) {
		
		dao.getCon();
		int da = 0;
		
		try {
			
			String sql = "delete from cart where userid=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setString(1, uid);
			
			pstmt.executeLargeUpdate();
			
			da=1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return da;
	}
	
	public CartModel checkOk(String objs) {
		dao.getCon();
		ArrayList<CartModel> ac = new ArrayList<CartModel>();
		try {
			
			String sql = "select * from cart where product_id=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setString(1, objs);
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				CartModel cm = new CartModel();
				
				cm.setProduct_name(rs.getString("product_name"));
				cm.setAmount(rs.getInt("amount"));
				cm.setPrice(rs.getInt("price"));
				cm.setMoney(rs.getInt("money"));
				cm.setProduct_id(rs.getInt("product_id"));
				
				
				return cm;
			}
			
			rs.close();
			pstmt.close();
			dao.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getmoney(String objs) {
		dao.getCon();
		int money=0;
		try {
			String sql="select money from cart where product_id=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setString(1, objs);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				money=rs.getInt("money");
				
				return money;
			}
			
			rs.close();
			pstmt.close();
			dao.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
