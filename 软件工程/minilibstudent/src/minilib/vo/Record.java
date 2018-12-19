package minilib.vo;

public class Record {
	private String id;
	private String userid;
	private String bookid;
	private String borrowdate;
	private String returndate;
	private String renewtimes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getRenewtimes() {
		return renewtimes;
	}
	public void setRenewtimes(String renewtimes) {
		this.renewtimes = renewtimes;
	}
	
}
