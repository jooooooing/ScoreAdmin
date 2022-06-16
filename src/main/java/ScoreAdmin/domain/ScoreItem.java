package ScoreAdmin.domain;

public class ScoreItem {
	
	//1. 무지성 private 멤버 변수
	//2. 필요하면 생성자 추가
	//3. 무지성 getter / setter 읽기 전용, 쓰기 전용 구현하기 위해 만듬
	//4. 무지성 toStirng()
	//5. 필요하면 equals / hashCode 재정의(오버라이드)
	
	private String name;
	private int studentid;
	private int kor;
	private int eng;
	private int mat;
	
	public ScoreItem(String name, int studentid, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.studentid = studentid;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	@Override
	public String toString() {
		return "ScoreItem [name=" + name + ", studentid=" + studentid + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
				+ "]";
	}
	
	
	
	
}
