package model;

public class CommentBean {
	private String brdno;	//게시판 UID
	private int reno;	//댓글 UID
	private String rewriter;  //작성자
	private String redeleteflag;	//안씀
	private String rememo;	//메모
	private String redate;	//시간
	private int reparent;	//FID  댓글 uid+1
	private String redepth;	//padding-left							A						B
	private char reorder;	//쓰레드 A B C D E F  reorder == null {'65'} reorder !=null 65+1  66
	
	public String getBrdno() {
		return brdno;
	}
	public void setBrdno(String brdno) {
		this.brdno = brdno;
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRedeleteflag() {
		return redeleteflag;
	}
	public void setRedeleteflag(String redeleteflag) {
		this.redeleteflag = redeleteflag;
	}
	public String getRememo() {
		return rememo;
	}
	public void setRememo(String rememo) {
		this.rememo = rememo;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getRedepth() {
		return redepth;
	}
	public void setRedepth(String redepth) {
		this.redepth = redepth;
	}
	public char getReorder() {
		return reorder;
	}
	public void setReorder(char reorder) {
		this.reorder = reorder;
	}
	public int getReparent() {
		return reparent;
	}
	public void setReparent(int reparent) {
		this.reparent = reparent;
	}
	
}
