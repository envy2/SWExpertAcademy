import java.util.Arrays;
import java.util.Scanner;

public class Solution_5603 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tcase = sc.nextInt();
		for (int i = 0; i < tcase; i++) {
			int n = sc.nextInt();
			int result = 0;
			int[] list = new int[n];
			int sum = 0 ;
			for (int j = 0; j < n; j++) {
				list[j] = sc.nextInt();
				sum += list[j];
			}
			Arrays.sort(list);
			int avg = sum / n;
			
			for (int j = 0; j < list.length; j++) {
				if(list[j] < avg) {
					result += (avg - list[j]);
				}
			}
			System.out.printf("#%d %d\n",i+1,result);
			
		}

	}

}
