package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/admin_member/admin_memberdelete.do")
public class AdminMemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminMemberDelete() {
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
		String id = request.getParameter("id");

		AdminMemberDAO dao = new AdminMemberDAO();

		dao.MemberDelete(id);
	
		response.sendRedirect("/admin/admin.jsp");
	}
}
