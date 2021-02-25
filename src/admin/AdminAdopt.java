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


@WebServlet("/AdminAdopt.do")
public class AdminAdopt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminAdopt() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doAll(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		
	
			BBSDAO dao = new BBSDAO();
			ArrayList<AdoptModel> h = new ArrayList<AdoptModel>();
			h = dao.getAlladoptList1();
			
			request.setAttribute("h", h);
			
			RequestDispatcher dis = request.getRequestDispatcher("admin/admin_member/adminAdopt.jsp");
			dis.forward(request, response);
	}

}
