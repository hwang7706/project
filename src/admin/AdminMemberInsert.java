package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;

@WebServlet("/admin/admin_member/AdminMemberInsert.do")
public class AdminMemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminMemberInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberBean bean = new MemberBean();
		
		bean.setId(request.getParameter("id"));
		bean.setPass(request.getParameter("pass"));
		bean.setName(request.getParameter("name"));
		bean.setTel(request.getParameter("tel"));
		bean.setAddr(request.getParameter("addr"));
		bean.setGender(request.getParameter("gender"));
		bean.setBirtday(request.getParameter("birtday"));
		bean.setMail(request.getParameter("mail"));
		bean.setAddr2(request.getParameter("addr2"));
		bean.setAddr3(request.getParameter("addr3"));
		bean.setAddr4(request.getParameter("addr4"));
		bean.setLevel(Integer.parseInt(request.getParameter("c_member")));
		
		
		AdminMemberDAO dao = new AdminMemberDAO();
		dao.insertMember(bean);
		
		response.sendRedirect("/admin/admin.jsp");
		}
}
