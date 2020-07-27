import java.util.Arrays;
import java.util.Scanner;

public class Solution_10510 {

	static int N, M, K, cook_time;
	static int[] chef;
	static boolean[] work_time;
	
	public static void init(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		cook_time = 0;
		for (int i = 0; i < N; i++) {
			cook_time += sc.nextInt();
		}
		
		chef = new int[K];
		for (int i = 0; i < chef.length; i++) {
			chef[i] = sc.nextInt();
		}
		
	}
	
	public static void Cooking() {
		work_time = new boolean[100000];
		
		for (int i = 1; i <= M; i++) {
			int start = 0;
			int end = i;
			
			while(end <= chef.length) {
				int sum = 0;
				
				for (int j = start; j < end; j++) {
					sum += chef[j];
				}
				
				work_time[sum] = true;
				start++;
				end++;
			}
		}
		
		for (int i = cook_time; i < work_time.length; i++) {
			if(work_time[i]) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			Cooking();
		}
	}

}
