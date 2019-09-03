import java.util.Scanner;

public class Solution_5688 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tcase = sc.nextInt();
		
		for (int i = 0; i < tcase; i++) {
			long number = sc.nextLong();
			
			if(Math.cbrt(number) == (int)Math.cbrt(number)) {
				System.out.printf("#%d "+(int)(Math.cbrt(number)),i+1);
				System.out.println();
			}
			else {
				System.out.printf("#%d %d\n",i+1,-1);
			}
		}

	}

}
