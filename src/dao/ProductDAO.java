package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.AdoptModel;
import model.BbsModel;
import model.ProductModel;
import model.Reply;

public class ProductDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	DAO dao = new DAO();

	public int write(ProductModel pm) {
		dao.getCon();

		String sql = "insert into product (product_name,description,price,file1,file1_thum,date,category,discount) values (?,?,?,?,?,now(),?,?)";

		int result = -1;

		try {
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, pm.getProduct_name());
			pstmt.setString(2, pm.getDescription());
			pstmt.setInt(3, pm.getPrice());
			pstmt.setString(4, pm.getFile1());
			pstmt.setString(5, pm.getFile1_thum());
			pstmt.setString(6, pm.getCategory());
			pstmt.setString(7, pm.getDiscount());

			pstmt.executeLargeUpdate();

			result = 1;

			pstmt.close();
			dao.conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getAllcount() {
		dao.getCon();

		String sql = "select count(*) from product";

		int count = 0;
		try {

			pstmt = dao.conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			pstmt.close();
			dao.conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<ProductModel> getProduct(int startRow, int endRow) {
		dao.getCon();
		ArrayList<ProductModel> v = new ArrayList<>();

		try {
			String sql = "select * from product order by date desc limit ?,?";
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductModel pro = new ProductModel();

				pro.setProduct_id(rs.getInt("product_id"));
				pro.setProduct_name(rs.getString("product_name"));
				pro.setPrice(rs.getInt("price"));
				pro.setFile1(rs.getString("file1"));
				pro.setFile1_thum(rs.getString("file1_thum"));
				pro.setDate(rs.getString("date"));
				pro.setCategory(rs.getString("category"));
				pro.setDiscount(rs.getString("discount"));

				v.add(pro);
			}
			pstmt.close();
			dao.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public ProductModel viewInsert(int id) {
		dao.getCon();

		ProductModel pro = new ProductModel();

		try {
			String sql = "select * from product where product_id=?";

			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pro.setProduct_name(rs.getString("product_name"));
				pro.setProduct_id(rs.getInt("product_id"));
				pro.setDescription(rs.getString("description"));
				pro.setFile1(rs.getString("file1"));
				pro.setPrice(rs.getInt("price"));
				pro.setDate(rs.getString("date"));
				pro.setCategory(rs.getString("category"));
			}
			rs.close();
			pstmt.close();
			dao.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}

	public int productReplyUpdate(Reply re) {
		dao.getCon();
		int result = -1;
		try {
			String sql = "update reply set rememo = ? where reno=? ";
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, re.getRememo());
			pstmt.setInt(2, re.getReno());

			pstmt.executeLargeUpdate();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public String getproductId(int product) {
		dao.getCon();
		String product_name = "";
		try {

			String sql = "select product_name from product where product_id=?";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setInt(1, product);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return (rs.getString("product_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product_name;
	}
	public ArrayList<ProductModel> getsearchList(String search) {
		dao.getCon();
		ArrayList<ProductModel> product = new ArrayList<ProductModel>();
		
		try {
			String sql;
			
			if(search.equals("toy")) {
				sql = "select * from product where category LIKE ? order by date desc";
				pstmt = dao.conn.prepareStatement(sql.toString());
				pstmt.setString(1,"%"+search+"%");
			
			}else if(search.equals("food")){
				sql = "select * from product where category LIKE ? order by date desc";
				pstmt = dao.conn.prepareStatement(sql.toString());
				pstmt.setString(1,"%"+search+"%");
			}else if(search.equals("goods")){
				sql = "select * from product where category LIKE ? order by date desc";
				pstmt = dao.conn.prepareStatement(sql.toString());
				pstmt.setString(1,"%"+search+"%");
			}
			else if(search.equals("toilet")){
				sql = "select * from product where category LIKE ? order by date desc";
				pstmt = dao.conn.prepareStatement(sql.toString());
				pstmt.setString(1,"%"+search+"%");
			}
			else {
				 sql = "select * from product where category LIKE ? order by date desc";
				 pstmt = dao.conn.prepareStatement(sql.toString());
				 pstmt.setString(1,"%"+search+"%");
			}
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				ProductModel pm = new ProductModel();
				pm.setProduct_id(rs.getInt("product_id"));
				pm.setProduct_name(rs.getString("product_name"));
				pm.setPrice(rs.getInt("price"));
				pm.setDescription(rs.getString("description"));
				pm.setFile1(rs.getString("file1"));
				pm.setFile1_thum(rs.getString("file1_thum"));
				pm.setDate(rs.getString("date"));
				pm.setCategory(rs.getString("category"));
				pm.setDiscount(rs.getString("discount"));
				
				product.add(pm);
			}
		
				rs.close();
				pstmt.close();
				dao.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public int getsearchCount(String search) {
		dao.getCon();
		
		int searchCount = 0;
		try {
			String sql = "select count(*) from product where category=?";
			
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				searchCount = rs.getInt(1);
			}
			pstmt.close();
			dao.conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchCount;
	}
	
}
