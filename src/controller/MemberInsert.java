
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberBean;


@WebServlet("/member/member_insert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberInsert() {
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
		MemberBean bean = new MemberBean();
		String id2 = request.getParameter("id2");
		String id = request.getParameter("id");
		if(!id.equals(id2)) {
			
			request.setAttribute("msg", "아이디를 다시 확인해주세요");
			request.setAttribute("url", "/member/join.jsp");
			
			RequestDispatcher dis = request.getRequestDispatcher("/error.jsp");
			dis.forward(request, response);
		}else {
		
		
		
		bean.setId(id);
		bean.setPass(request.getParameter("pass"));
		bean.setName(request.getParameter("name"));
		bean.setTel(request.getParameter("tel"));
		bean.setAddr(request.getParameter("addr"));
		bean.setGender(request.getParameter("gender"));
		bean.setBirtday(request.getParameter("birtday"));
		bean.setMail(request.getParameter("mail"));
		bean.setAddr2(request.getParameter("addr2"));
		bean.setAddr3(request.getParameter("addr3"));
		bean.setAddr4(request.getParameter("addr4"));
		bean.setLevel(Integer.parseInt(request.getParameter("c_member")));
		
		MemberDAO dao = new MemberDAO();

		dao.insertMember(bean);
		
		response.sendRedirect("/");	
		}
	}

}
