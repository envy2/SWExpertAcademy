import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8460 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ;i <= iT ;i++) {
			String num = br.readLine();
			String live = "DIES";
			int cnt = 2;
			while(cnt > 0) {
				if(check(num)) {
					live = "LIVES";
					break;
				}
				else {
					num = future(num);
				}
				cnt--;
			}
			if(num.equals("01") || num.equals("10")) {
				live = "LIVES";
			}
			System.out.println("#"+i+" "+live);
		}

	}
	public static String future(String num) {
		num = "0" + num + "0";
		String next = "";
		for (int i = 1; i < num.length()-1; i++) {
			if(num.charAt(i-1) == num.charAt(i+1)) {
				next += "0";
			}
			else {
				next += "1";
			}
		}
		return next;
	}
	public static boolean check(String num) {
		int cnt = 0;
		boolean check = false;
		num = num + "0";
		for (int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '1') {
				cnt++;
				check = true;
			}
			else if(check && num.charAt(i) == '0'&& cnt % 2 == 0) {
				return true;
			}
			else if(check && cnt % 2 == 1) {
				cnt = 0;
				check = false;
			}
		}
		return false;
	}
}
