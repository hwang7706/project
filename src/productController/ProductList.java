package productController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BBSDAO;
import dao.ProductDAO;
import model.BbsModel;
import model.ProductModel;

@WebServlet("/product/productList.do")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductList() {
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
		String search = request.getParameter("search");
		

		//한페이지 보여질 리스트 갯수
				int pageSize = 8;
				
				//현재 보여지는 페이지의 값 처리
				int pageNum = 1;
				if(request.getParameter("pageNum") != null) {
					pageNum = Integer.parseInt(request.getParameter("pageNum"));
				}
				//System.out.println("=========pageNum=========:"+pageNum);
				ProductDAO dao = new ProductDAO();
				//전체 게시글 총 갯수
				int count = dao.getAllcount();
				int searchCount = dao.getsearchCount(search);
				if(count==0) {
					request.setAttribute("count", count);
					RequestDispatcher dis = request.getRequestDispatcher("/product/productList.jsp");
					dis.forward(request, response);
				}
				//System.out.println("=========count=========:"+count);
				int totalPage = count / pageSize;
				 
				if (count % pageSize > 0) {
				    totalPage++;
				}
				if (totalPage < pageNum){
					pageNum = totalPage;
				}
				
				int startPage = ((pageNum - 1) / count) * count + 1;
				//현재 페이지가 pageCount와 같을 때를 유의하며 (page-1)을 하고
				// +1은 첫페이지가 0이나 10이 아니라 1이나 11로 하기 위함임
				int endPage = startPage + count - 1;
				// -1은 첫페이지가 1이나 11 등과 같을때 1~10, 11~20으로 지정하기 위함
				if (endPage > totalPage) {
				    endPage = totalPage;
				}
				
				//현재 페이지 limit 값 처리
				int startRow = (pageNum - 1) * pageSize;
				int endRow = pageSize;
				
				int pageCount =5;
				String word1 = request.getParameter("word");
				if(word1 == null) {
					word1 = "0";
				}
				int word = Integer.parseInt(word1);
				if(word == 1) {
					
					ArrayList<ProductModel> v2 = new ArrayList<>();
					v2 = dao.getsearchList(search);
					searchCount = dao.getsearchCount(search);
					request.setAttribute("v2", v2);
					request.setAttribute("searchCount", searchCount);
					request.setAttribute("word", 1);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageNum", totalPage);
					request.setAttribute("pageCount", pageCount);
					
					RequestDispatcher dis = request.getRequestDispatcher("/product/productList.jsp");
					dis.forward(request, response);
				}else {
					
					ArrayList<ProductModel> v = new ArrayList<>();
					v = dao.getProduct(startRow , endRow);
					
					request.setAttribute("v", v);
					request.setAttribute("word", 0);
					request.setAttribute("count", count);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageNum", totalPage);
					request.setAttribute("pageCount", pageCount);
					
					RequestDispatcher dis = request.getRequestDispatcher("/product/productList.jsp");
					dis.forward(request, response);
				}
				
				
	}
}
