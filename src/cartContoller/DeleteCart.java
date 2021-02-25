package cartContoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;

@WebServlet("/cart/cartdelete.do")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCart() {
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
		String uid = request.getParameter("uid");
		
		int del =1;
		
		CartDAO cart = new CartDAO();
		
		del=cart.delete(id);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(del==0) {
			out.print("<script> alert('장바구니에서 삭제되었습니다.'); location.href='/cart/cartList.do?id="+uid+"'</script>");
		}else {
			out.print("<script> alert('장바구니에서 삭제되지 않았습니다. 다시 시도해 주세요.'); location.href='/cart/cartList.do?id="+uid+"'</script>");
		}
		
	}
}
