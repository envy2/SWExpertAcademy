import java.util.Scanner;

public class Solution_10033 {

	static long result;
	
	public static void solution(Scanner sc) {
		String cards = sc.next();
		result = 0;
		
		int count = 0;
		for (int i = 0; i < cards.length(); i++) {
			if(cards.charAt(i) == 'W') {
				result += count;
			}
			else {
				count++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			solution(sc);
			System.out.println("#" + t + " " + result);
		}

	}

}
