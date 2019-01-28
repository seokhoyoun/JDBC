package test.string.method;

public class TestString {

/*	public static void main(String[] args) {
		// java.lang.String 클래스가 제공하는 메소드 사용 테스트
		String s = "";
		// 초기값으로 빈따옴표 사용 가능.
		// 컴파일 오류 : 문자는 사용 불가능 char ch ='';
		char ch = ' '; // 공백 문자는 사용가능
		
		System.out.println(s.length()); // 글자개수
		
		String s1 = null;
		// NullPointerException 예외발생 //System.out.println(s1.length());
		// s1 = "apple";
		if(s1 != null && s1.length() > 0) {
			System.out.println(s1.length());
		}
		else
			System.out.println("문자열 값이 필요함.");
		
	}*/
	
	public static void main(String[] args) {
		/*String s1 = "apple";
		String s2 = new String("banana");
		byte[] bar = {74, 65, 86, 65};
		String s3 = new String(bar);
		System.out.println(s3.toString()); //자동으로 toString 생성 : 오버라이딩이 되어있다.
		
		char[] car = {'o','r','a','c','l','e'};
		String s4 = new String(car);
		int[] iar = {74, 65, 86, 65};
		String s5 = new String(iar,0,iar.length);
		
		StringBuilder sb = new StringBuilder("html5 & css3");
		String s6 = new String(sb);*/
		
		String s = new String("hello");
		System.out.println(s);
		String n = "012345";
		System.out.println(n.charAt(3));
		String s2 = s.concat(n);
		System.out.println(s2);
		System.out.println(s2.contains("o"));
		System.out.println(s2.endsWith("5"));
		String b = "HELLO";
		System.out.println(s.equals(b));
		System.out.println(s.equalsIgnoreCase(b));
		System.out.println(s.indexOf(64));
		System.out.println(s.lastIndexOf("l"));
		System.out.println(s.replace("h", "H"));
		System.out.println(s.replace('o', 'O'));
		System.out.println(s.replace('l', 'L'));
		System.out.println(s.replaceFirst("l", "L"));
		String animal = "dog,cat,pig,cow";
		String[] sar = animal.split(",",2);
		for(int i = 0; i < sar.length; i++) {
			System.out.println(sar[i]);
		}
		
		System.out.println(animal.startsWith("dog"));
		String animal2 = animal.substring(4,11);
		System.out.println(animal2);
		String tr = "          a         c        s           ";
		System.out.println(tr.trim());
		
		
	}

}
