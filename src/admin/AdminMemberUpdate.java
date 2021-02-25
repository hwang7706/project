package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberBean;

@WebServlet("/admin/admin_member/adminMemberUpdate.do")
public class AdminMemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMemberUpdate() {
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
		AdminMemberDAO dao= new AdminMemberDAO();
		MemberBean bean = new MemberBean();
		
		bean.setId(id);
		bean.setPass(request.getParameter("pass"));
		bean.setName(request.getParameter("name"));
		bean.setTel(request.getParameter("tel"));
		bean.setAddr(request.getParameter("addr"));
		bean.setAddr2(request.getParameter("addr2"));
		bean.setAddr3(request.getParameter("addr3"));
		bean.setAddr4(request.getParameter("addr4"));
		bean.setMail(request.getParameter("mail"));
		bean.setLevel(Integer.parseInt(request.getParameter("level")));		
		
		dao.modifyMember(bean);
		
		response.sendRedirect("/admin/admin_member/adminMemberModify.do?id="+id+"");
		
	}

}