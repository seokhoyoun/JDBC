package test.object.method;

public class TestMember {

	public static void main(String[] args) {
		// 메소드 오버라이딩 테스트
		Member m = new Member("홍길동",27,10.5);
		System.out.println(m);
		// Member m2 = m.clone(); 후손은 부모클래스를 받을 수 없다.
		Member m2 = (Member)m.clone();
		System.out.println(m2);
		
		System.out.println("m == m2 : "+(m == m2));
		System.out.println(m.hashCode());
		System.out.println(m2.hashCode());
	
	}

}
