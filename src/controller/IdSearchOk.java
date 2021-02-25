package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/member/id_search_ok.do")
public class IdSearchOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdSearchOk() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
			
		MemberDAO dao = new MemberDAO();
		
		String id=dao.idOk(name, mail);
		
		if(id.equals(null)&&id == "") {
			
			request.setAttribute("msg", "이름 또는 이메일이 일치하지않습니다.");
			request.setAttribute("url","/member/idPass.jsp");
			
			RequestDispatcher dis= request.getRequestDispatcher("/error.jsp");
			 
			dis.forward(request, response);
			
		}else {

			request.setAttribute("id", id);
			RequestDispatcher dis = request.getRequestDispatcher("/member/idfind.jsp");
			dis.forward(request, response);
		}
	}
}

