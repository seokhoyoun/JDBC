package test.object.method;

public class Member {
	// Field
	private String name;
	private int age;
	private double point;
	// Constructor
	public Member() {
		
	}
	public Member(String name, int age, double point) {
		super(); //Object() call...
		this.name = name;
		this.age = age;
		this.point = point;
	}
	// Getter and Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public String toString() {
		// return "클래스명 @ 16진수코드";
		return this.name+" "+ this.age+" "+ this.point;
	}
	
	@Override
	public boolean equals(Object obj) {
		// return this == (Member)obj;
		Member other = (Member)obj;
		return (this.name.equals(other.name) && this.age == other.age && this.point == other.point);
		
	}
	@Override
	public Object clone() {// 접근수준제어자를 넓히거나 throw 예외개수를 줄일 수 있다.
//		return this; // 주소복사 : shalow copy : 얕은 복사
						// deep copy : 깊은 복사로 오버라이딩
		return new Member(this.name, this.age, this.point);
	}
	
}
