package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.CommentBean;
import model.Reply;

public class CommentDAO {
	
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DAO dao = new DAO();
	
	//reply 저장
		public int getcomment(int uid, String rewriter, String rememo) {
			dao.getCon();
			int result =-1;
			String sql = "insert into reply(brdno,rewriter,redate,rememo) values(?,?,now(),?)";
			
			try {
				pstmt=dao.conn.prepareStatement(sql);
				
				pstmt.setInt(1,uid);
				pstmt.setString(2, rewriter);
				pstmt.setString(3, rememo);
				
				pstmt.executeUpdate();
				
				result=1;
				
				pstmt.close();
				dao.conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//reply 불러오기
		public ArrayList<Reply> getAllcomment(int uid) {
			dao.getCon();
			
			ArrayList<Reply> re = new ArrayList<Reply>();
			
			try {
				String sql="select * from reply where brdno=?";
				
				pstmt=dao.conn.prepareStatement(sql);
				pstmt.setInt(1, uid);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					
					Reply reply = new Reply();
					
					reply.setBrdno(rs.getInt("brdno"));
					reply.setReno(rs.getInt("reno"));
					reply.setRewriter(rs.getString("rewriter"));
					reply.setRedate(rs.getString("redate"));
					reply.setRememo(rs.getString("rememo"));
					
					re.add(reply);
				}
				rs.close();
				pstmt.close();
				dao.conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return re;
		}
		
	//reply 삭제
		public void deletereply(int reno) {
			dao.getCon();
			
			String sql = "delete from reply where reno = ?";
			
			try {
				pstmt=dao.conn.prepareStatement(sql);
				pstmt.setInt(1,reno);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				dao.conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public int getReplyUp(int reno) {
			dao.getCon();
			
			int update=1;
			String sql = "select * from reply rememo where reno=?";
			
			try {
				pstmt=dao.conn.prepareStatement(sql);
				pstmt.setInt(1, reno);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
				
					pstmt.setString(1, rs.getString("rememo"));
				
				}
				
				update=0;
				
				pstmt.close();
				dao.conn.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			return update;
		}
		
		public int replyUpdate(Reply re) {
			
			dao.getCon();
			String sql = "update reply set rememo = ? where reno=?";
			int result =-1;
			try {
				pstmt = dao.conn.prepareStatement(sql);
				
				pstmt.setString(1, re.getRememo());
				pstmt.setInt(2,re.getReno());
				
				
				pstmt.executeLargeUpdate();
				result=1;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public int getReplyReUp(int reno) {
			dao.getCon();
			
			int up=0;
			String sql = "select * from reply rememo where reno=?";
			
			try {
				pstmt=dao.conn.prepareStatement(sql);
				pstmt.setInt(1, reno);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
				
					pstmt.setString(1, rs.getString("rememo"));
				
				}
				
				up=1;
				
				pstmt.close();
				dao.conn.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			return up;
		}
		
		public int replyReUpdate(Reply re) {
			dao.getCon();
			
			int result=-1;
			
			String sql = "insert into reply(brdno,rewriter,redate,rememo) values(?,?,now(),?)";
			
			try {
				pstmt=dao.conn.prepareStatement(sql);
				
				pstmt.setInt(1,re.getBrdno());
				pstmt.setString(2, re.getRewriter());
				pstmt.setString(3, re.getRememo());
				
				pstmt.executeUpdate();
				
				result=1;
				
				pstmt.close();
				dao.conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		public char viewreorder(int fid) {
			dao.getCon();
			
			char reorder = 'A';
			try {
				String sql = "select * from reply where reparent=? order by reorder desc limit 0,1";
				
				pstmt = dao.conn.prepareStatement(sql);
				
				pstmt.setInt(1, fid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					reorder = rs.getString("reorder").charAt(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return reorder;
		}
		
		public int showfid() {
			dao.getCon();
			int fid = 0;
			try {
				String sql = "select reparent from reply order by reparent desc limit 0,1";
				
				pstmt= dao.conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					fid = rs.getInt("reparent");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return fid;
		}
		
		public void replywriter(CommentBean bean) {
			dao.getCon();
			char reorder = bean.getReorder();
			try {
				String sql = "insert into reply (redate,brdno,rewriter,rememo,reparent,reorder) values (now(),?,?,?,?,'"+reorder+"')";
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
		public ArrayList<CommentBean> viewComment(int uid){
			dao.getCon();
			ArrayList<CommentBean> re = new ArrayList<CommentBean>();
			try {
				String sql = "select * from reply where brdno=?";
				
				pstmt = dao.conn.prepareStatement(sql);
				pstmt.setInt(1, uid);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					CommentBean reply = new CommentBean();
					reply.setBrdno(rs.getString("brdno"));
					reply.setReno(rs.getInt("reno"));
					reply.setRewriter(rs.getString("rewriter"));
					reply.setRememo(rs.getString("rememo"));
					reply.setRedate(rs.getString("redate"));
					reply.setRedeleteflag(rs.getString("redeleteflag"));
					reply.setReparent(rs.getInt("reparent"));
					reply.setRedepth(rs.getString("redepth"));
					
					re.add(reply);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return re;
		}
}
