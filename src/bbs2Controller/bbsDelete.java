package bbs2Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BBSDAO;


@WebServlet("/bbs2/bbsDelete.do")
public class bbsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public bbsDelete() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAll(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAll(request, response);
	}
protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		BBSDAO bbsdao = new BBSDAO();
	
		bbsdao.DeleteBbs(uid);
		
		RequestDispatcher dis = request.getRequestDispatcher("/bbs2/list2.do");
		dis.forward(request, response);
	}

}
