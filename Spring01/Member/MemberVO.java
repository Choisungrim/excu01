package vo;

//** VO (Value Object) , DTO (Data Transfer Object)
//=> 자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용됨
//=> 대부분 Table 별로 만들며, Table 과 동일한 필드(컬럼)명을 사용한다.
//=> Table과 무관하게 자료전달용으로만 정의한 경우 DTO라 함.

public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private String lev;
	private String birthd;
	private int point;
	private double weight;
	private String lev1;
	private String Id1;
	private String password1;
	private String birthd1;
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getBirthd1() {
		return birthd1;
	}
	public void setBirthd1(String birthd1) {
		this.birthd1 = birthd1;
	}
	public String getId1() {
		return Id1;
	}
	public void setId1(String id1) {
		Id1 = id1;
	}
	public String getId() {
		return id;
	}
	public String getLev1() {
		return lev1;
	}
	public void setLev1(String lev1) {
		this.lev1 = lev1;
	}
	public String setId(String id) {
		return this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getBirthd() {
		return birthd;
	}
	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", lev=" + lev + ", birthd="
				+ birthd + ", point=" + point + ", weight=" + weight + "]";
	}
} //class
