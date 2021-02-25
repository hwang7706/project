package cartContoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.OrderPay;
import model.OrderModel;

@WebServlet("/cart/paySuccess.do")
public class CartPay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartPay() {
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
		
		OrderModel om = new OrderModel();
		OrderPay od = new OrderPay();
		String[] objs = request.getParameter("product_id").split("-");
		
		HttpSession session = request.getSession();
		
		String session_id = (String)session.getAttribute("id");
		String name="";
		
		MemberDAO dao = new MemberDAO();
		
		name=dao.getName(session_id);
		
		int result=0;
		
		
		om.setUid(session_id);
		om.setName(name);
		om.setTotal_price(Integer.parseInt(request.getParameter("totalPrice")));
		om.setEmail(request.getParameter("email"));
		om.setName(request.getParameter("name"));
		om.setTel(request.getParameter("tel"));
		om.setAddress(request.getParameter("address"));
		
		for(int i = 0 ; i<objs.length; i++) {
			om.setProduct_id(objs[i]);
			result=od.PayInsert(om);
		}
		
	
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
			
		if(result==0) {
			out.print("<script> alert('결제가 되지 않았습니다.'); location.href='/product/productView.do'</script>");
		}else {
			out.print("<script> alert('결제 되었습니다'); location.href='/cart/cartList.do'</script>");
		}
	}
}
