import java.util.Scanner;

public class Solution_10202 {

	static int result;
	public static void init(Scanner sc) {
		int n = sc.nextInt();
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		
		result = 0;
		
		Count(A,B,C);
	}
	
	public static void Count(String A, String B, String C) {
		char a,b,c;
		for (int i = 0; i < A.length(); i++) {
			a = A.charAt(i);
			b = B.charAt(i);
			c = C.charAt(i);
			
			if(a == b && b == c) {
				continue;
			}
			
			if(a == b && b != c) {
				result++;
				continue;
			}
			if(b == c && a != b) {
				result++;
				continue;
			}
			if(a == c && b != c) {
				result++;
				continue;
			}
			if(a != b && b != c) {
				result += 2;
				continue;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			System.out.println("#" + t + " " + result);
		}

	}

}
