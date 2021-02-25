package bbs2Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BBSDAO;


@WebServlet("/bbs2/adoptcancel.do")
public class adoptcancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public adoptcancel() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAll(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BBSDAO dao = new BBSDAO();
		int uid = Integer.parseInt(request.getParameter("uid"));
		dao.adoptCancel(uid);
		
	response.sendRedirect("/bbs2/list2.do");
	}
}
