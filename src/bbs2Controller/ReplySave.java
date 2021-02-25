package bbs2Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;


@WebServlet("/bbs2/replySave.do")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReplySave() {
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
		
		String uid = request.getParameter("uid");
		int update=1;
		int reno = Integer.parseInt(request.getParameter("reno"));
		CommentDAO dao = new CommentDAO();
		
		update = dao.getReplyUp(reno);
		
		
		request.setAttribute("update", update);
		request.setAttribute("reno", reno);
		
		RequestDispatcher dis = request.getRequestDispatcher("/bbs2/view2.do?uid="+uid+"");
		dis.forward(request, response);

	}

}
