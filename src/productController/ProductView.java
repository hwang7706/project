package productController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CommentDAO;
import dao.ProductDAO;

import model.ProductModel;
import model.Reply;

@WebServlet("/product/productView.do")
public class ProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductView() {
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
		
		int id = Integer.parseInt(request.getParameter("uid"));
		
		
		ProductDAO dao = new ProductDAO();
		
		ProductModel v = new ProductModel();
		
		v= dao.viewInsert(id);
		
		CommentDAO cdao = new CommentDAO();
		
		ArrayList<Reply> re = new ArrayList<Reply>();
		
		re=cdao.getAllcomment(id);
		
		
		request.setAttribute("list", v);
		request.setAttribute("reply", re);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/product/productView.jsp");
		dis.forward(request, response);
	}
}
