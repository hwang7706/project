package dao;

import java.sql.*;
import java.util.ArrayList;

import model.AdoptModel;
import model.AdoptReviewModel;
import model.BbsModel;
import model.CommentBean;

public class BBSDAO {
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	DAO dao = new DAO();

	// 실제로 글을 작성하는 함수
	public int write(String subject, String id, String content, String file1, String thum_file1,String city) {

		dao.getCon();
		String sql = "insert into bbs(subject,id,date,content,file1,file1_thum,city) values(?,?,now(),?,?,?,?)";

		int result = -1;
		try {

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, subject);
			pstmt.setString(2, id);
			pstmt.setString(3, content);
			pstmt.setString(4, file1);
			pstmt.setString(5, thum_file1);
			pstmt.setString(6, city);
			

			pstmt.executeLargeUpdate();

			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getAllcount() {
		dao.getCon();
		int count = 0;

		try {
			String sql = "select count(*) from bbs";
			pstmt = dao.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<BbsModel> getAllmember(int startRow, int endRow) {
		dao.getCon();

		ArrayList<BbsModel> v = new ArrayList<BbsModel>();
		try {
			String sql = "select * from bbs order by date desc limit ?,?";
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsModel bbs = new BbsModel();

				bbs.setId(rs.getString("id"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setDate(rs.getString("date"));
				bbs.setContent(rs.getString("content"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setCity(rs.getString("city"));
				bbs.setUid(rs.getInt("uid"));

				v.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public ArrayList<BbsModel> viewInsert(int uid) {
		dao.getCon();

		ArrayList<BbsModel> v = new ArrayList<BbsModel>();

		try {
			String sql = "select * from  bbs where uid=?";

			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				BbsModel bbs = new BbsModel();

				bbs.setId(rs.getNString("id"));
				bbs.setSubject(rs.getString("subject"));
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

	public int ModifyBbs(String subject,String content, String file1, String thum_file1, int uid) {
		dao.getCon();
		
		int result = -1;
		try {
			String sql = "update bbs set subject=?,content=?,file1=?,file1_thum=? where uid=?";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, file1);
			pstmt.setString(4, thum_file1);
			pstmt.setInt(5, uid);

			pstmt.executeLargeUpdate();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void DeleteBbs(int uid) {
		dao.getCon();

		try {
			String sql = "delete from bbs where uid=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<BbsModel> getboardList(String search, String word) {
		dao.getCon();
		ArrayList<BbsModel> bbsm = new ArrayList<BbsModel>();
		
		try {
			String sql;
			
			if(search.equals("subject")) {
				sql = "select * from bbs where subject LIKE ? order by date desc";
				pstmt = dao.conn.prepareStatement(sql.toString());
				pstmt.setString(1,"%"+word+"%");
			
			}else if(search.equals("all")){
				sql = "select * from bbs where subject LIKE ? or content LIKE ? order by date desc";
				pstmt = dao.conn.prepareStatement(sql.toString());
				pstmt.setString(1,"%"+word+"%");
				pstmt.setString(2,"%"+word+"%");
			}else {
				 sql = "select * from bbs where content LIKE ? order by date desc";
				 pstmt = dao.conn.prepareStatement(sql.toString());
				 pstmt.setString(1,"%"+word+"%");
			}
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				BbsModel bbs = new BbsModel();
				bbs.setCity(rs.getString("city"));
				bbs.setDate(rs.getString("date"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setContent(rs.getString("content"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				
				bbsm.add(bbs);
			}
		
				rs.close();
				pstmt.close();
				dao.conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bbsm;
	}
	public void CommentWrite(CommentBean bean) {
		dao.getCon();
	
		
		try {
			String sql = "insert into reply (redate,brdno,rewriter,rememo,reparent) values (now(),?,?,?,?)";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBrdno());
			pstmt.setString(2, bean.getRewriter());
			pstmt.setString(3, bean.getRememo());
			pstmt.setInt(4, bean.getReparent());
			
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				dao.conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public BbsModel adoptList(int uid) {
		dao.getCon();
		BbsModel bm = new BbsModel();
		try {
			String sql = "select * from bbs where uid=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bm.setUid(rs.getInt("uid"));
				bm.setId(rs.getString("id"));
				bm.setSubject(rs.getString("subject"));
				bm.setContent(rs.getString("content"));
				bm.setFile1(rs.getString("file1"));
				bm.setFile1_thum(rs.getString("file1_thum"));
				bm.setCity(rs.getString("city"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm;
	}
	public void insertadopt(BbsModel bm,String name,String tel,String addr,String addr2,String addr3,String addr4,String content) {
		dao.getCon();
		try {
			
			String sql = "insert into adopt (uid,subject,content,id,date,file1,file1_thum,city,name,tel,addr,addr2,addr3,addr4) values (?,?,?,?,now(),?,?,?,?,?,?,?,?,?)";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, bm.getUid());
			pstmt.setString(2, bm.getSubject());
			pstmt.setString(3, content);
			pstmt.setString(4, bm.getId());
			pstmt.setString(5, bm.getFile1());
			pstmt.setString(6, bm.getFile1_thum());
			pstmt.setString(7, bm.getCity());
			pstmt.setString(8, name);
			pstmt.setString(9, tel);
			pstmt.setString(10, addr);
			pstmt.setString(11, addr2);
			pstmt.setString(12, addr3);
			pstmt.setString(13, addr4);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getAlladoptCount(){
		dao.getCon();
		int count=0;
		try {
			String sql = "select count(*) from adopt";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<AdoptModel> getAlladoptList(int startRow,int endRow) {
		dao.getCon();
		ArrayList<AdoptModel> v = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt order by date desc limit ?,?";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdoptModel adoptM = new AdoptModel();
				
				adoptM.setUid(rs.getInt("uid"));
				adoptM.setId(rs.getString("id"));
				
				adoptM.setSubject(rs.getString("subject"));
				adoptM.setContent(rs.getString("content"));
				adoptM.setDate(rs.getString("date"));
				adoptM.setFile1(rs.getString("file1"));
				adoptM.setFile1_thum(rs.getString("file1_thum"));
				
				
				v.add(adoptM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public void deleteFromAdopt(int uid) {
		dao.getCon();
		
		try {
			String sql = "delete from bbs where uid=?";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<AdoptModel> adoptView(int uid) {
		dao.getCon();
		ArrayList<AdoptModel> v = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt where uid=?";
			pstmt= dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AdoptModel adoptM = new AdoptModel();
				adoptM.setUid(rs.getInt("uid"));
				adoptM.setSubject(rs.getString("subject"));
				adoptM.setContent(rs.getString("content"));
				adoptM.setDate(rs.getString("date"));
				adoptM.setFile1(rs.getString("file1"));
				adoptM.setFile1_thum(rs.getString("file1_thum"));
				
				v.add(adoptM);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public ArrayList<BbsModel> aretheseExist() {
		dao.getCon();
		ArrayList<BbsModel> m = new ArrayList<BbsModel>();
		try {
			String sql = "select * from bbs where subject not in (select subject from adopt)";
			pstmt = dao.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BbsModel bbs = new BbsModel();

				bbs.setUid(rs.getInt("uid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setContent(rs.getString("content"));
				bbs.setDate(rs.getString("date"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setCity(rs.getString("city"));

				m.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	public ArrayList<AdoptModel> aretheseExist3(int uid) {
		dao.getCon();
		ArrayList<AdoptModel> v3 = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt where uid=?";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AdoptModel bbs = new AdoptModel();

				bbs.setUid(rs.getInt("uid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setContent(rs.getString("content"));
				bbs.setDate(rs.getString("date"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setCity(rs.getString("city"));

				v3.add(bbs);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return v3;
	}
	public ArrayList<AdoptModel> aretheseExist1() {
		dao.getCon();
		ArrayList<AdoptModel> g = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt";
			pstmt = dao.conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AdoptModel bbs = new AdoptModel();

				bbs.setUid(rs.getInt("uid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setContent(rs.getString("content"));
				bbs.setDate(rs.getString("date"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setCity(rs.getString("city"));

				g.add(bbs);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return g;
	}
	public ArrayList<AdoptModel> aretheseExist2(String id) {
		dao.getCon();
		ArrayList<AdoptModel> g = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt where id=?";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AdoptModel bbs = new AdoptModel();

				bbs.setUid(rs.getInt("uid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setContent(rs.getString("content"));
				bbs.setDate(rs.getString("date"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setCity(rs.getString("city"));

				g.add(bbs);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return g;
	}
	public void likeSystem(int uid,String session_id) {
		dao.getCon();
		try {
			String sql = "insert into likedb(shopuid,user,date) values(?,?,now())";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			pstmt.setString(2, session_id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int howmanylikes(int uid) {
		dao.getCon();
		int likecount=0;
		try {
			String sql = "select count(*) from likedb where shopuid=?";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				likecount = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return likecount;
	}
	public String alreadychecked(int uid) {
		dao.getCon();
		String check="";
		try {
			String sql = "select * from likedb user where shopuid=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				check = rs.getString("user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public void adoptCancel(int uid) {
		dao.getCon();
		try {
			String sql = "delete from adopt where uid=?";
			
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<BbsModel> getAllmember(int uid) {
		dao.getCon();

		ArrayList<BbsModel> v4 = new ArrayList<BbsModel>();
		try {
			String sql = "select * from bbs where uid=?";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsModel bbs = new BbsModel();

				bbs.setUid(rs.getInt("uid"));
				bbs.setSubject(rs.getString("subject"));
				bbs.setContent(rs.getString("content"));
				bbs.setDate(rs.getString("date"));
				bbs.setFile1(rs.getString("file1"));
				bbs.setFile1_thum(rs.getString("file1_thum"));
				bbs.setCity(rs.getString("city"));

				v4.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v4;
	}
	public ArrayList<AdoptReviewModel> getAdoptReviewList(int startRow,int endRow) {
		dao.getCon();
		ArrayList<AdoptReviewModel> v = new ArrayList<AdoptReviewModel>();
				
		try {
			String sql = "select * from adoptreview order by date desc limit ?,?";
			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AdoptReviewModel arm = new AdoptReviewModel();
				arm.setUid(rs.getInt("uid"));
				arm.setSubject(rs.getString("subject"));
				arm.setContent(rs.getString("content"));
				arm.setDate(rs.getString("date"));
				arm.setFile1(rs.getString("file1"));
				arm.setFile1_thum(rs.getString("file1_thum"));
				arm.setCity(rs.getString("city"));
				arm.setId(rs.getString("id"));
				
				v.add(arm);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public int getAllcountFromAdoptReview() {
		dao.getCon();
		int count = 0;

		try {
			String sql = "select count(*) from adoptreview";
			pstmt = dao.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<AdoptModel> getAlladoptList1() {
		dao.getCon();
		ArrayList<AdoptModel> h  = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt where adopt='1'";
			pstmt = dao.conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdoptModel adoptM = new AdoptModel();
				
				adoptM.setUid(rs.getInt("uid"));
				adoptM.setId(rs.getString("id"));
				adoptM.setSubject(rs.getString("subject"));
				adoptM.setContent(rs.getString("content"));
				adoptM.setDate(rs.getString("date"));
				adoptM.setFile1(rs.getString("file1"));
				adoptM.setFile1_thum(rs.getString("file1_thum"));
				
				
				h.add(adoptM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	public ArrayList<AdoptModel> adminAdoptview(int uid) {
		dao.getCon();
		ArrayList<AdoptModel> v = new ArrayList<AdoptModel>();
		try {
			String sql = "select * from adopt where uid=?";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdoptModel am = new AdoptModel();
				am.setUid(rs.getInt("uid"));
				am.setSubject(rs.getString("subject"));
				am.setContent(rs.getString("content"));
				am.setId(rs.getString("id"));
				am.setName(rs.getString("name"));
				am.setFile1(rs.getString("file1"));
				am.setCity(rs.getString("city"));
				am.setTel(rs.getString("tel"));
				am.setAddr(rs.getString("addr"));
				am.setAddr2(rs.getString("addr2"));
				am.setAddr3(rs.getString("addr3"));
				am.setAddr4(rs.getString("addr4"));
				
				v.add(am);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public void adminlistdelete(int uid) {
		dao.getCon();
		try {
			String sql = "delete from bbs where uid="+uid+"";
			pstmt = dao.conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
