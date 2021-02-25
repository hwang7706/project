package bbs2Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OncenterDAO;


@WebServlet("/bbs2/adoptapproval.do")
public class adoptapproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public adoptapproval() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
				doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		OncenterDAO on = new OncenterDAO();
		
		on.adoptapproval(uid);
	
		response.sendRedirect("/AdminAdopt.do");
	}
}
