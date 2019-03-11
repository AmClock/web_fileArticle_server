package vo;

public class Article {

	private int no;
	private String title, text, regdate;

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int no, String title, String text) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.title = title;
		this.text = text;
	}

	public Article(int no, String title, String text, String regdate) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.title = title;
		this.text = text;
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String mainDate() {
		return this.regdate.split("-")[0] + "년" + this.regdate.split("-")[1] + "월"
				+ this.regdate.split("-")[2].split(" ")[0] + "일";
	}// mainDate end

}// Article end
