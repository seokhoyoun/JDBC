package test.string.method;

public class TestStringBuilder {

	public static void main(String[] args) {
		// mutable : 기록된 문자열값 변경 가능
		// StringBuffer : 쓰레드 safe 기능이 있다.
		// StringBuilder : 기능이 없다.
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = sb;
		System.out.println("저장용량 : " + sb.capacity());
		sb.append("java");
		sb.append(8.5);
		sb.append(' ');
		sb.append(true);
		sb.append(10);
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());
		
		System.out.println(sb.length());
		sb.delete(2, 6);
		System.out.println(sb);
		
		char[] dst = new char[5];
		sb.getChars(0, 5, dst, 0);
		for(int i = 0; i < dst.length; i++) {
			System.out.print(dst[i]+"-");
		}System.out.println();
		
		sb.insert(3, "oracle");
		System.out.println(sb);
		
		sb.setCharAt(7, 'A');
		System.out.println(sb);
		//sb ---> String
		String ss = sb.toString();
		String ss2 = new String(sb);
	}

}
