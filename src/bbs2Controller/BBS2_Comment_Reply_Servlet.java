package bbs2Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDAO;
import model.CommentBean;

@WebServlet("/reply.do")
public class BBS2_Comment_Reply_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BBS2_Comment_Reply_Servlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String id = (String)session.getAttribute("id");
		int fid = Integer.parseInt(request.getParameter("fid"));
		String brdno = request.getParameter("borderuid");
		String rememo = request.getParameter("rememo");
		String redepth = request.getParameter("redepth");
		
		
		CommentDAO dao = new CommentDAO();
		
		char reorder = dao.viewreorder(fid);
		
		reorder++;
		
		CommentBean bean = new CommentBean();
		
		bean.setBrdno(brdno);
		bean.setRedepth(redepth);
		bean.setRememo(rememo);
		bean.setReorder(reorder);
		bean.setReparent(fid);
		bean.setRewriter(id);
		
		dao.replywriter(bean);
		
		request.setAttribute("url", "/bbs2/view2.do?uid="+brdno);
		request.setAttribute("msg", "답글달았음");
		
		RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
		dis.forward(request, response);

	}

}
