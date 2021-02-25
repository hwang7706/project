package bbs2Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BBSDAO;
import dao.OncenterDAO;
import model.OncenterModel;


@WebServlet("/bbs/oncenterWrite.do")
public class oncenterWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public oncenterWrite() {
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
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("id");
		OncenterModel ocm = new OncenterModel();
		OncenterDAO dao = new OncenterDAO();
		ocm.setTitle(request.getParameter("title"));
		ocm.setContent(request.getParameter("content"));
		ocm.setId(session_id);
		
		dao.oncenterWrite(ocm);
		
		response.sendRedirect("/");	
	}
}
