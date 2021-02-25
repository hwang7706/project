package bbs2Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import model.Reply;

@WebServlet("/bbs2/replyreupdate1.do")
public class Replyreupdate1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Replyreupdate1() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		Reply re =  new Reply();
		
		int result=0;
		CommentDAO cm = new CommentDAO();
		
		re.setRewriter(request.getParameter("rewriter"));
		re.setRememo(request.getParameter("rememo"));
		re.setReno(Integer.parseInt(request.getParameter("reno")));
		re.setBrdno(uid);
		
		result=cm.replyReUpdate(re);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result==-1) {
			out.print("<script> alert('댓글을 다시 작성해 주세요'); location.href='/bbs2/view2.do?uid="+uid+"'</script>");
		}else{
			out.print("<script> alert('대댓글이 작성되었습니다.'); location.href='/bbs2/view2.do?uid="+uid+"'</script>");
		}
	}
}
