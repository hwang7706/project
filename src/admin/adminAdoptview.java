package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BBSDAO;
import model.AdoptModel;

/**
 * Servlet implementation class adminAdoptview
 */
@WebServlet("/adminAdoptview.do")
public class adminAdoptview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public adminAdoptview() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAll(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		
		BBSDAO dao = new BBSDAO();
		ArrayList<AdoptModel> v = new ArrayList<AdoptModel>();
		v = dao.adminAdoptview(uid);
		
		request.setAttribute("v", v);
		
		RequestDispatcher dis = request.getRequestDispatcher("/admin/admin_member/adminAdoptview.jsp");
		dis.forward(request, response);
	}

}
