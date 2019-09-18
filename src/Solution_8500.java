import java.util.Scanner;

public class Solution_8500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int people = sc.nextInt();
			int max = 0;
			int result = 0;
			
			for (int j = 0; j < people; j++) {
				int seat = sc.nextInt();
				max = max > seat ? max : seat;
				result += seat;
			}
			result += max + people;
			System.out.println("#"+i+" "+result);
		}

	}

}
