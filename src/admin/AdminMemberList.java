package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;

@WebServlet("/admin/admin_member/adminMember_list.do")
public class AdminMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public AdminMemberList() {
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
		
		AdminMemberDAO dao = new AdminMemberDAO();
		
		
		
		ArrayList<MemberBean> v = new ArrayList<MemberBean>();
		
		v = dao.getAllmember();
		
		request.setAttribute("v", v);
		
		RequestDispatcher dis = request.getRequestDispatcher("/admin/admin_member/adminMemberList.jsp");
		dis.forward(request, response);
	}
}
