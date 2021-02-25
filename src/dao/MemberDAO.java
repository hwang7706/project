package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.MemberBean;

public class MemberDAO {
	Statement stmt;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	ResultSet rs;

	DAO dao = new DAO();

	// 회원가입
	public void insertMember(MemberBean bean) {

		dao.getCon();

		try {
			String sql = "insert into member(id,pass,name,tel,addr,addr2,addr3,addr4,gender,birtday,mail,level) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPass());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getTel());
			pstmt.setString(5, bean.getAddr());
			pstmt.setString(6, bean.getAddr2());
			pstmt.setString(7, bean.getAddr3());
			pstmt.setString(8, bean.getAddr4());
			pstmt.setString(9, bean.getGender());
			pstmt.setString(10, bean.getBirtday());
			pstmt.setString(11, bean.getMail());
			pstmt.setInt(12, bean.getLevel());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				dao.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 로그인 회원 매칭
	public int loginMember(String id, String pass) {
		dao.getCon();

		int total_record = 0;

		try {
			String sql = "select count(*) from member where id=? and pass=?";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				total_record = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total_record;
	}

	// 로그인 회원 정보 불러오기
	public MemberBean loginSelect(String id, String pass) {
		dao.getCon();

		MemberBean bean = new MemberBean();

		try {
			String sql = "select * from member where id=? and pass=?";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setLevel(rs.getInt("level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public MemberBean viewMember(String id) {
		dao.getCon();

		MemberBean bean = new MemberBean();

		try {
			String sql = "select * from member where id=?";
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setPass(rs.getString("pass"));
				bean.setName(rs.getString("name"));
				bean.setTel(rs.getString("tel"));
				bean.setAddr(rs.getString("addr"));
				bean.setAddr2(rs.getString("addr2"));
				bean.setAddr3(rs.getString("addr3"));
				bean.setAddr4(rs.getString("addr4"));
				bean.setMail(rs.getString("mail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public void modifyMember(MemberBean bean) {
		dao.getCon();

		try {
			String sql = "update member set pass=?, name=?, tel=?, addr=?, addr2=?, addr3=?, addr4=?, mail=? where id=?";
			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, bean.getPass());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getTel());
			pstmt.setString(4, bean.getAddr());
			pstmt.setString(5, bean.getAddr2());
			pstmt.setString(6, bean.getAddr3());
			pstmt.setString(7, bean.getAddr4());
			pstmt.setString(8, bean.getMail());
			pstmt.setString(9, bean.getId());

			pstmt.executeUpdate();

			pstmt.close();
			dao.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkId(String id) {
		boolean b = false;
		dao.getCon();

		try {

			String sql = "select * from member where id = ?";

			pstmt = dao.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			b = rs.next();

		} catch (Exception e) {

			System.out.println("checkId err : " + e);

		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (dao.conn != null)
					dao.conn.close();

			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
		return b;
	}

	public String idOk(String name, String mail) {
		dao.getCon();

		try {

			pstmt = dao.conn.prepareStatement("select id from member where name = ? and mail= ?");

			pstmt.setString(1, name);
			pstmt.setString(2, mail);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return (rs.getString("member.id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	public String passOk(String id, String name, String mail) {
		dao.getCon();

		try {

			pstmt = dao.conn.prepareStatement("select * from member where id =? and name = ? and mail= ?");

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, mail);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return (rs.getString("member.pass"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	public String passcheck(String id) {
		dao.getCon();
		String password = "";
		try {
			String sql = "select pass from member where id=?";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				password = rs.getString("pass");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public String getName(String id) {
		dao.getCon();

		String name = "";

		try {
			String sql = "select name from member where id=?";

			pstmt = dao.conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

}