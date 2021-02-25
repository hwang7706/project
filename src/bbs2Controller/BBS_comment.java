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
import dao.CommentDAO;
import model.CommentBean;

@WebServlet("/bbs2/comment2.do")
public class BBS_comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BBS_comment() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAll(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String uid = request.getParameter("uid");
		String id = (String)session.getAttribute("id");
		System.out.println(uid);
		if(id == null) {
			request.setAttribute("url", "/");
			request.setAttribute("msg", "로그인하고 답글달아라");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}else {
			CommentBean bean = new CommentBean();
			CommentDAO cdao = new CommentDAO();
			BBSDAO dao = new BBSDAO();
			int fid = cdao.showfid();
			
			fid++;
			
			bean.setBrdno(uid);
			bean.setRewriter(id);
			bean.setRememo(request.getParameter("rememo"));
			bean.setReparent(fid);
			
			dao.CommentWrite(bean);
			
			request.setAttribute("url", "/bbs2/view2.do?uid="+uid);
			request.setAttribute("msg", "댓글달았음");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
			
		}
	}

}
