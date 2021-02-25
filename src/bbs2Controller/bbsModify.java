package bbs2Controller;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiUtils;

import dao.BBSDAO;

@WebServlet("/bbs2/bbsmodify2.do")
@MultipartConfig(
		fileSizeThreshold = 0,
		location = "C:\\jsp\\Gproject\\WebContent\\upload"
)
public class bbsModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public bbsModify() {
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
		int result = 0;
		String uploadFileName = "";
		String thum_file1 = "";
		
		Part part = request.getPart("file1");		
		
		if(part.getSize() > 0) {			
			String contentDisposition = part.getHeader("content-disposition");
			uploadFileName = getUploadFileName(contentDisposition);
			
			part.write(uploadFileName);//경로에 파일저장 처리부분			
			
			if(uploadFileName != "") {
				String filePath = "C:\\jsp\\Gproject\\WebContent\\upload\\";
				
				String orgImg = filePath+uploadFileName;//원본 파일
				thum_file1 = "thumb_"+uploadFileName;//썸네일 파일명
				String thumbImg = filePath+thum_file1;//파일경로 + 파일명
				
				int thumbWidth = 152;//가로
				int thumbHeight = 218;//세로

				try {
					Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
					Jimi.putImage(thumbnail, thumbImg);
				}catch (Exception e) {
					e.printStackTrace();
				}
		BBSDAO bbs = new BBSDAO();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		result = bbs.ModifyBbs(subject,content,uploadFileName,thum_file1,uid);
		
		if(result==1) {
			out.print("<script> alert('글이 수정되었습니다'); location.href='/bbs2/view2.do?uid="+uid+"'</script>");
		}
		}
	}
}
		private String getUploadFileName(String contentDisposition) {

		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		int firstQutosIndex = contentSplitStr[2].indexOf("\"");
		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
		uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
		return uploadFileName;
		}
	}
