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
import dao.CommentDAO;
import model.AdoptModel;
import model.BbsModel;
import model.CommentBean;


@WebServlet("/bbs2/view2.do")
public class view2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public view2Servlet() {
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
		
		CommentDAO dao = new CommentDAO();
		BBSDAO dao1 = new BBSDAO();
		
		ArrayList<CommentBean> v2 = new ArrayList<>();
		ArrayList<AdoptModel> v3 = new ArrayList<AdoptModel>();
		
		
		
		ArrayList<BbsModel> v = new ArrayList<BbsModel>();
		v= dao1.viewInsert(uid);
		request.setAttribute("v", v);
		
		v2 = dao.viewComment(uid);
		request.setAttribute("v2", v2);
		
		v3 = dao1.aretheseExist3(uid);
		request.setAttribute("v3", v3);
		
		ArrayList<BbsModel> v4 = new ArrayList<BbsModel>();
		v4 = dao1.getAllmember(uid);
		request.setAttribute("v4", v4);
		
		
		
		
		int likes = dao1.howmanylikes(uid);
		request.setAttribute("likes", likes);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/bbs2/view2.jsp");
		dis.forward(request, response);
	}

}
