package cartContoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.CartModel;

@WebServlet("/cart/cartCheck.do")
public class CartCheckCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartCheckCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request, response);
	}
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] objs = request.getParameter("str").split("-");
		ArrayList<CartModel> ac = new ArrayList<CartModel>();
		ArrayList<CartModel> alc = new ArrayList<CartModel>();

		int aa = 0;
		int bb = 0;
		
		CartDAO cd = new CartDAO();
		CartModel cm = new CartModel();

		
		for(int i = 0 ;i<objs.length;i++) {
			
			cm=cd.checkOk(objs[i]);
			ac.add(cm);
			
		}
		for(int i = 0; i<objs.length;i++) {
			bb=cd.getmoney(objs[i]);
			
			aa+=bb;
		}
		
		response.setCharacterEncoding("utf-8");
		request.setAttribute("ac", ac);
		request.setAttribute("total", aa);
		
		RequestDispatcher dis = request.getRequestDispatcher("/cart/cartCheck.jsp");
		dis.forward(request, response);
	}
}
