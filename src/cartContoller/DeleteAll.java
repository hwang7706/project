package cartContoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import model.CartModel;

@WebServlet("/cart/cartdeleteAll.do")
public class DeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteAll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		
		int da = 0;
		
		CartDAO cd = new CartDAO();
		
		da=cd.deleteAll(uid);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
			
		if(da==0) {
			out.print("<script>alert('전체 삭제를 다시 시도해 주세요.'); location.href='/cart/cartList.do?id="+uid+"'</script>");
		}else {
			out.print("<script> alert('전체 삭제 되었습니다.'); location.href='/'</script>");
		}
	}
}
