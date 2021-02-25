package cartContoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.CartModel;

@WebServlet("/cart/cartupdate.do")
public class CartUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartUpdate() {
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
		String Pid = request.getParameter("uid");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		CartDAO cart = new CartDAO();

		int up=0;
		
		up = cart.UpdateTo(id,amount);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
			
		if(up==0) {
			out.print("<script>alert('수량추가가 되지 않았습니다. 다시 시도해주세요.'); location.href='/cart/cartList.do?id="+Pid+"'</script>");
		}else {
			out.print("<script> alert('수량이 추가 되었습니다.'); location.href='/cart/cartList.do?id="+Pid+"'</script>");
		}
	}
}
