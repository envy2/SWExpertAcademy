import java.util.Scanner;

public class Solution_1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();
		int[] arr = new int[10];
		
		for(int i = 0 ; i< tcase ; i++) {
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			int max = 0;
			int min = 10000;
			int sum = 0 ;
			for (int j = 0; j < 10; j++) {
				sum += arr[j];
				max = max > arr[j] ? max : arr[j];
				min = min < arr[j] ? min : arr[j];
				
			}
			int avg = (int)Math.round(( sum - max - min ) / 8.0 ) ;
			System.out.printf("#%d %d",i+1,avg);
			System.out.println();
		}
		
		
	}

}
