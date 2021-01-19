package onlinelibrary.business;

import java.io.Serializable;

public class Issue implements Serializable {

	private int issueid;
	private String bookid;
	private String studentid;

	public Issue() {

	}

	public Issue(String bookid, String studentid) {
		this.setIssueid(issueid);
		this.setBookid(bookid);
		this.setStudentid(studentid);
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;

	}

	public int getIssueid() {
		return issueid;
	}

	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}

	@Override
	public String toString() {
		return "Issue [issueid=" + issueid + ", bookid=" + bookid + ", studentid=" + studentid + "]";
	}



}