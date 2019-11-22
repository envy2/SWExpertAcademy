import java.util.Arrays;
import java.util.Scanner;

public class Solution_8825 {
	static int[] first_floor;
	
	public static void init(Scanner sc) {
			int N = sc.nextInt();
			first_floor = new int[N * 2 - 1];
			
			for (int n = 0; n < first_floor.length; n++) {
				first_floor[n] = sc.nextInt();
			}
			
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT; i++) {
			init(sc);
			System.out.println(Arrays.toString(first_floor));
		}

	}

}
