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


@WebServlet("/like.do")
public class like_system extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public like_system() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAll(request, response);
	}
protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		BBSDAO dao = new BBSDAO();
		
		String check = dao.alreadychecked(uid);
	
		if(check.equals(session_id)) {
			request.setAttribute("msg", "안되요!!!");
			request.setAttribute("url", "/bbs2/view2.do?uid="+uid);
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}else if(session_id == ""){
			request.setAttribute("msg", "로그인하셔야 좋아요를 하실수있습니다");
			request.setAttribute("url", "/bbs2/view2.do?uid="+uid);
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}else {
			dao.likeSystem(uid,session_id);
			request.setAttribute("msg", "좋아요!");
			request.setAttribute("url", "/bbs2/view2.do?uid="+uid);
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}
	}
}
