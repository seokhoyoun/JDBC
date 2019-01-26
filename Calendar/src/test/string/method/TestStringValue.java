package test.string.method;

public class TestStringValue {
	
	public static void stringToData() {
		// 문자열 값을 기본 자료형으로 변경(parsing)
		// Wrapper(래퍼) 클래스에서 메소드로 제공
		// * 기본 자료형에 대한 클래스 : 래퍼클래스
		String value = "12345";
		// String value = "apple"; // NumberFormatException 숫자 형식이 아닌값을 파싱하려 했기 때문.
		int num = Integer.parseInt(value);
		System.out.println("num : "+num);
		
		// int num2 = Integer.valueOf(value); // 오토 언박싱 Auto UnBoxing
		// 객체 => 값
		Integer ref = Integer.valueOf(value);
		int num2 = ref.intValue(); // 언박싱
		System.out.println(num2);
	}
	
	public static void main(String[] args) {
		// 문자열 값 <=> 기본 자료형값 변환처리
		stringToData();

	}

}
