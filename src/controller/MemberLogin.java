package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberBean;

@WebServlet("/member/login_ok.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberLogin() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAll(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		int total_record=0;
		
		MemberDAO dao = new MemberDAO();
		
		total_record= dao.loginMember(id, pass);
		MemberBean bean = new MemberBean();
		if(total_record == 1) {
			bean = dao.loginSelect(id,pass);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", bean.getId());
			session.setAttribute("level", bean.getLevel());
			session.setAttribute("name", bean.getName());
			int level = bean.getLevel();
			if(level == 0) {
				request.setAttribute("msg", "아이디 또는 패스워드가 일치 하지 않습니다.");
				request.setAttribute("url", "login.jsp");
				
				RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
				dis.forward(request, response);
			}
			
			PrintWriter out = response.getWriter(); 
			   
			   String str="";
			   str = "<script language='javascript'>";
			   str += "opener.window.location.reload();"; 
			   str += "self.close();"; 
			    str += "</script>";
			   out.print(str);
		}else {
			request.setAttribute("msg", "아이디 또는 패스워드가 일치 하지 않습니다.");
			request.setAttribute("url", "login.jsp");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}
		

	}

}
