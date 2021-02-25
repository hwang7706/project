package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberBean;

@WebServlet("/admin/admin_member/adminMemberModify.do")
public class AdminMemberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminMemberModify() {
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
		
		
		String id123= request.getParameter("id");
		
		MemberBean bean = new MemberBean();		
		AdminMemberDAO dao = new AdminMemberDAO();
		
  		bean = dao.viewMember(id123);
  		
		request.setAttribute("bean", bean);
		RequestDispatcher dis = request.getRequestDispatcher("/admin/admin_member/adminMemberModify.jsp");
		dis.forward(request, response);	 
	}
}

