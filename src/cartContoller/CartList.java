package cartContoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BBSDAO;
import dao.CartDAO;
import model.CartModel;

@WebServlet("/cart/cartList.do")
public class CartList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartList() {
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
		String id = request.getParameter("id");
		String file1="";
		
		ArrayList<CartModel> cart = new ArrayList<CartModel>();

		CartDAO car = new CartDAO();
		
		BBSDAO bbs = new BBSDAO();
		
		/* file1= bbs.getfile1_thum(); */
		
		cart = car.getCartList(id);
		
		request.setAttribute("cart", cart);
		request.setAttribute("uid", id);
		
		RequestDispatcher dis = request.getRequestDispatcher("/cart/cartList.jsp");
		dis.forward(request, response);
		
	}
}
