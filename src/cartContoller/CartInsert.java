package cartContoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import dao.MemberDAO;
import dao.ProductDAO;
import model.CartModel;

@WebServlet("/cart/cartin.do")
public class CartInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartInsert() {
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
		
		int price = Integer.parseInt(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int money = price * amount;
		int product = Integer.parseInt(request.getParameter("product_id"));
		
		String id = request.getParameter("session_id");
		
		int result=0;
		CartModel cart = new CartModel();
		CartDAO car = new CartDAO();
		MemberDAO dao = new MemberDAO();
		ProductDAO pro = new ProductDAO();
		
		String product_name = pro.getproductId(product);
		String name = dao.getName(id);
		int productNum= car.Allsubject(product);
		
		if(product==productNum) {
			car.dou(product,money,amount);
			
			result = 1;
			
		}else {
		
			cart.setUserid(id);
			cart.setProduct_id(product);
			cart.setProduct_name(product_name);
			cart.setName(name);
			cart.setPrice(price);
			cart.setAmount(amount);
			cart.setMoney(money);
		
			result=car.cartinsert(cart);
		
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
			
		if(result==0) {
			out.print("<script> alert('로그인이 되어 있지 않아 장바구니에 담기지 않았습니다. 로그인 후 다시시도해주세요'); location.href='/product/productView.do?product_id="+product+"'</script>");
		}else {
			out.print("<script> alert('장바구니에 담겼습니다.'); location.href='/cart/cartList.do?id="+id+"'</script>");
		}
	}
}
