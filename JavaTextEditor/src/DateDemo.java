import java.util.*;
import java.text.*;

public class DateDemo {
	public static void main(String args[]) {

		Date dNow = new Date();// Instantiate a Date object
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'Time:' hh:mm:ss a zzz");// display time and date using toString()

		System.out.println("Current Date: " + ft.format(dNow));
	}
	public void setVisible(boolean b) {
		
	}

}
			
	


