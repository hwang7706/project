package bbs2Controller;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/bbs2/wirteAction2.do")
@MultipartConfig(fileSizeThreshold = 0, location = "C:\\jsp\\Gproject\\WebContent\\upload")
public class WriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAll(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAll(request, response);
	}

	protected void doAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date time = new Date();

		String time1 = format1.format(time);

		request.setCharacterEncoding("utf-8");
		int result;
		String uploadFileName = "";
		String thum_file1 = "";

		Part part = request.getPart("file1");

		if (part.getSize() > 0) {
			String contentDisposition = part.getHeader("content-disposition");
			uploadFileName = time1 + getUploadFileName(contentDisposition);

			part.write(uploadFileName);// 경로에 파일저장 처리부분

			if (uploadFileName != "") {
				String filePath = "C:\\jsp\\Gproject\\WebContent\\upload\\";

				String orgImg = filePath + uploadFileName;// 원본 파일
				thum_file1 = "thumb_" + time1 + uploadFileName;// 썸네일 파일명
				String thumbImg = filePath + thum_file1;// 파일경로 + 파일명

				int thumbWidth = 256;// 가로
				int thumbHeight = 230;// 세로

				try {
					Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
					Jimi.putImage(thumbnail, thumbImg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				BBSDAO bbs = new BBSDAO();

				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				String city = request.getParameter("city");
				String id = request.getParameter("id");
				String subject = request.getParameter("subject");
				String content = request.getParameter("content");
				
				result = bbs.write(subject, id, content, uploadFileName, thum_file1, city);

				if (result == -1) {
					out.print("<script> alert('글을 다시 작성해 주세요'); location.href='/bbs2/write2.jsp?'</script>");
				} else {
					out.print("<script> alert('글이 작성되었습니다.'); location.href='/bbs2/list2.do'</script>");
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
