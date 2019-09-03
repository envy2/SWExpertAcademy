import java.util.Arrays;
import java.util.Scanner;

public class Solution_4111 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			int dis = sc.nextInt();
			
			int[] arr = new int[N];
			int max = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
				max = Math.max(max, arr[j]);
			}
			
			int[] camera = new int[max+1];
			for (int j = 0; j < arr.length; j++) {
				camera[arr[j]]++;
			}
			
			for (int j = 0; j < camera.length; j++) {
				
			}
		}

	}

}
