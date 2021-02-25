package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.OncenterModel;

public class OncenterDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	DAO dao = new DAO();
	
	public ArrayList<OncenterModel> getAllTheList(int startRow, int endRow) {
		dao.getCon();

		ArrayList<OncenterModel> v = new ArrayList<OncenterModel>();
		try {
			String sql = "select * from oncenter order by date desc limit ?,?";
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				OncenterModel bbs = new OncenterModel();

				bbs.setId(rs.getString("userid"));
				bbs.setTitle(rs.getString("title"));
				bbs.setDate(rs.getString("date"));
				bbs.setContent(rs.getString("content"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setUid(rs.getInt("uid"));

				v.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public int getAllcount() {
		dao.getCon();
		int count=0;

		try {
			String sql = "select count(*) from oncenter";
			pstmt = dao.conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public void oncenterWrite(OncenterModel ocm) {
		dao.getCon();
		try {
			String sql = "insert into oncenter (title,content,userid,date) values (?,?,?,now())";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setString(1, ocm.getTitle());
			pstmt.setString(2, ocm.getContent());
			pstmt.setString(3, ocm.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void adoptapproval(int uid) {
		dao.getCon();
		
		try {
			String sql ="update adopt set adopt='0' where uid=?";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
