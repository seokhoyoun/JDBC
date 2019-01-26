package test.string.method;
import java.util.*;
public class TestStringTokenizer {

	public static void main(String[] args) {
		
		StringTokenizer st = new StringTokenizer("servlet jsp mybatis spring");
		System.out.println("분리된 토큰 수 : "+ st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer("eclipse,editplus staruml&exerd",",& ");
		System.out.println(st2.countTokens());
	}

}
