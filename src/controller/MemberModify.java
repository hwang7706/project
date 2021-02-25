package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberBean;


@WebServlet("/member/member_modify.do")
public class MemberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberModify() {
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
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("id");
		
		if(session_id == null) {
			request.setAttribute("msg", "아니다 나가라 그냥....");
			request.setAttribute("url", "login.jsp");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}
		MemberBean bean = new MemberBean();
		MemberDAO dao = new MemberDAO();
		
		bean = dao.viewMember(session_id);
		
		request.setAttribute("modify", bean);
		RequestDispatcher dis = request.getRequestDispatcher("/member/modify.jsp");
		dis.forward(request, response);
	}
}
