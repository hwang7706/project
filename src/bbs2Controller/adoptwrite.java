package bbs2Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/bbs2/adoptwrite.do")
public class adoptwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public adoptwrite() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		if(id == null) {
			request.setAttribute("msg", "로그인하셔야 입양신청이 가능합니다");
			request.setAttribute("url", "/bbs2/view2.do?uid="+uid+"");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}else {
			response.sendRedirect("/bbs2/adoptwrite.jsp?uid="+uid+"");
		}
		
	
	}

}
