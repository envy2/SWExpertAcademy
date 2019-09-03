import java.util.Scanner;

public class Solution_1240 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int sero = sc.nextInt();
			int garo = sc.nextInt();
			sc.nextLine();
			String password = "";
			
			for (int x = 0; x < sero; x++) {
				String str = sc.nextLine();
				if(str.contains("1")) {
					password = str;
				}
			}
			int start = 0;
			int end = 0;
			
			for (int j = password.length()-1; j >= 0; j--) {
				if(password.charAt(j) == '1') {
					end = j;
					break;
				}
			}
			for (int j = 0; j <password.length()-1; j++) {
				if(password.charAt(j) == '1') {
					start = j;
					break;
				}
			}
			String result ="";
			for (int j = end; j > start ; j-=7) {
				result = patten(password.substring(j-6, j+1)) + result;
			}

			int sum = 0;
			if(check(result)) {
				for (int j = 0; j < result.length(); j++) {
					sum += result.charAt(j)-'0';
				}
			}
			
			System.out.printf("#%d %d\n",i,sum);
			
		}
		
	}
	public static boolean check(String s) {
		boolean ch = false;
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < s.length()-1; i+=2) {
			sum1 += s.charAt(i) -'0';
			sum2 += s.charAt(i+1) - '0';
		}
		int result = sum1*3 + sum2;
		if(result % 10 == 0) {
			ch = true;
		}
		
		return ch;
	}
	public static String patten(String s) {
		switch(s) {
		case "0001101":
			return "0";
		case "0011001":
			return "1";
		case "0010011":
			return "2";
		case "0111101":
			return "3";
		case "0100011":
			return "4";
		case "0110001":
			return "5";
		case "0101111":
			return "6";
		case "0111011":
			return "7";
		case "0110111":
			return "8";
		case "0001011":
			return "9";
		}
		return null;
	}
}
