import java.util.Scanner;

public class Solution_9658 {
	static String result;
	static int length;
	
	public static void init(Scanner sc) {
		String N = sc.next();
		result = "";
		length = 0;
		
		Round(N);
	}
	
	public static void Round(String number) {
		length = number.length() - 1;

		int first_number = number.charAt(0) - '0';
		int second_number = number.charAt(1) - '0';
		int third_number = number.charAt(2) - '0';
		
		int res = first_number * 10 + second_number;
		
		if(third_number > 4) {
			res += 1;
		}
		
		if(res > 99) {
			length += 1;
			res = 10;
		}
		
		result = "" + (res/10) + "." + (res%10);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			System.out.println("#" + t + " " + result + "*" + "10^" + length);
		}

	}

}
