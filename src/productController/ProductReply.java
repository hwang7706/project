package productController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.ProductDAO;
import model.ProductModel;
import model.Reply;

@WebServlet("/ProductReply")
public class ProductReply extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductReply() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		Reply re =  new Reply();
		
		int result=0;
		
		ProductDAO dao = new ProductDAO();
		
		re.setRememo(request.getParameter("rememo"));
		re.setReno(Integer.parseInt(request.getParameter("reno")));
		
		result=dao.productReplyUpdate(re);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result==-1) {
			out.print("<script> alert('댓글을 다시 작성해 주세요'); location.href='/bbs2/view2.do?uid="+id+"'</script>");
		}else{
			out.print("<script> alert('댓글이 수정되었습니다.'); location.href='/bbs2/view2.do?uid="+id+"'</script>");
		}
	}
}
