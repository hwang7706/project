package bbs2Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BBSDAO;
import model.BbsModel;


@WebServlet("/bbs2/adopt.do")
public class Adopt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Adopt() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String addr2 = request.getParameter("addr2");
		String addr3 = request.getParameter("addr3");
		String addr4 = request.getParameter("addr4");
		String content = request.getParameter("content");
		BBSDAO dao = new BBSDAO();
		BbsModel bm = new BbsModel();
		System.out.println("====="+id);
		
		bm = dao.adoptList(uid);
		
		dao.insertadopt(bm,name,tel,addr,addr2,addr3,addr4,content);
		request.setAttribute("msg", "입양신청하신 펫은 마이페이지 > 입양신청목록 에서 확인가능합니다 신청서에따라 취소될수있는점 양해부탁드립니다");
		request.setAttribute("url", "/bbs2/list2.do");
		
		RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
		dis.forward(request, response);

	}
}
