package bbs2Controller;

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



@WebServlet("/bbs2/adoptview2.do")
public class AdoptView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdoptView() {
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
		
		int uid= Integer.parseInt(request.getParameter("uid"));
		
		BBSDAO dao = new BBSDAO();
		ArrayList<AdoptModel> v = new ArrayList<AdoptModel>();
		
		
		v= dao.adoptView(uid);
		
		request.setAttribute("v", v);
		
		RequestDispatcher dis = request.getRequestDispatcher("/bbs2/adoptview.jsp");
		dis.forward(request, response);
	}
}
