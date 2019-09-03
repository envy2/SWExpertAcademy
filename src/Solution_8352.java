import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution_8352 {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int iT = Integer.parseInt(br.readLine());
		for(int i = 1 ;i<= iT ;i++) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			Date date = df.parse(br.readLine());
			int second = Integer.parseInt(br.readLine(),2);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.SECOND, second);
			System.out.println("#"+i+" "+df.format(cal.getTime()));

		}
	}

}
