package test.datetime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.*;
public class TestGregorianC {

	public static void main(String[] args) {
//		GregorianCalendar today = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		System.out.println(today);
		
		GregorianCalendar christmas = new GregorianCalendar(1970,11,5);
		
		System.out.println(christmas.get(Calendar.DAY_OF_WEEK));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
		System.out.println(sdf.format(christmas.getGregorianChange())); // 날짜오류
		
		System.out.println(sdf.format(today.getTime()));
		
	}
}
