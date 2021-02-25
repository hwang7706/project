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
import model.BbsModel;


@WebServlet("/bbs2/bbs_search.do")
public class bbsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public bbsSearch() {
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
		
		String search = request.getParameter("search");
		String word = request.getParameter("word");
		ArrayList<BbsModel> bbsm = new ArrayList<BbsModel>();
	
		BBSDAO dao = new BBSDAO();
		
		
		
		bbsm = dao.getboardList(search,word);
		
		
		int totalList = bbsm.size();
	
		request.setAttribute("totalList",totalList);
		request.setAttribute("bbsm",bbsm);
		request.setAttribute("word",1);
		
		RequestDispatcher dis = request.getRequestDispatcher("/bbs2/list2.do");
		dis.forward(request, response);
	
	}
}
