package test.string.method;

public class TestSplit {

	public static void main(String[] args) {
		// 하나의 문자열을 토큰문자를 기준으로 여러개의 문자열로 분리하는 것
		
		String s = "red yellow green blue purple";
		String[] sar = s.split(" ");
		// 객체배열과 컬렉션은 for each문 사용할 수 있다.
		// for(클래스명 래퍼런스 변수 : 배열명){}
		/*for(String e : sar) {
			System.out.println(e);
		}
		
		String s2 = "java,oracle,jdbc";
		String[] sar2 = s2.split(",");
		for(String e2 : sar2) {
			System.out.println(e2);
		}*/
		
		String s3 = "html5 css3,javascript&jquery#web";
		String[] sar3 = s3.split(" |,|&|#");
		for(String e3 : sar3) {
			System.out.println(e3);
		}
	}

}
