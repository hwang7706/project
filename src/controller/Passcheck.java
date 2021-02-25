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



@WebServlet("/member/passCheck.do")
public class Passcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Passcheck() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAll(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAll(request, response);
	}
protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberDAO dao = new MemberDAO();
		
		String password = dao.passcheck(id);
		String passcheck = request.getParameter("passcheck");
		if(password.equals(passcheck)) {
		RequestDispatcher dis = request.getRequestDispatcher("/member/member_update.do");
		dis.forward(request, response);
		}else {
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
			request.setAttribute("url","/member/passCheck.jsp");
			
			RequestDispatcher dis= request.getRequestDispatcher("/error.jsp");
			 
			dis.forward(request, response);
		}
	}

}
