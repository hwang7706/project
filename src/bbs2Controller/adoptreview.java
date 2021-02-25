package bbs2Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BBSDAO;
import model.AdoptReviewModel;

@WebServlet("/adoptreview.do")
public class adoptreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public adoptreview() {
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
		//한페이지 보여질 리스트 갯수
		int pageSize = 20;
		
		//현재 보여지는 페이지의 값 처리
		int pageNum = 1;
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		//System.out.println("=========pageNum=========:"+pageNum);
		BBSDAO dao = new BBSDAO();
		//전체 게시글 총 갯수
		int count = dao.getAllcountFromAdoptReview();
		if(count == 0) {
			request.setAttribute("count",count);
			RequestDispatcher dis = request.getRequestDispatcher("/bbs2/adoptreview.jsp");
			dis.forward(request, response);
		}else {
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

		ArrayList<AdoptReviewModel> v = new ArrayList<AdoptReviewModel>();
		v = dao.getAdoptReviewList(startRow,endRow);
		 
		request.setAttribute("v", v);
		request.setAttribute("count", count);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", totalPage);
		request.setAttribute("pageCount", pageCount);
		
		RequestDispatcher dis = request.getRequestDispatcher("/bbs2/adoptreview.jsp");
		dis.forward(request, response);
		}
	}

}
