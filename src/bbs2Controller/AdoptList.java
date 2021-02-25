package bbs2Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BBSDAO;
import model.AdoptModel;

@WebServlet("/bbs2/adoptlist.do")
public class AdoptList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdoptList() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
		
			request.setAttribute("msg", "로그인하셔야 사용가능합니다.");
			request.setAttribute("url", "/");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}else {
			BBSDAO dao = new BBSDAO();
			ArrayList<AdoptModel> h = new ArrayList<AdoptModel>();
			h = dao.aretheseExist2(id);
			
			request.setAttribute("h", h);
			
			RequestDispatcher dis = request.getRequestDispatcher("/bbs2/adoptlist.jsp");
			dis.forward(request, response);
		}
		
	}
}
