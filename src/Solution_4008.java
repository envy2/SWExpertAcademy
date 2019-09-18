import java.util.Arrays;
import java.util.Scanner;

public class Solution_4008 {
	static int[] operater = new int[4];
	static int[] arr;
	static int max,min;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			int N = sc.nextInt();
			for (int j = 0; j < operater.length; j++) {
				operater[j] = sc.nextInt();
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			arr = new int[N];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			
			dfs(arr[0],1);
			System.out.printf("#%d %d\n",i,max-min);
		}

	}

	public static void dfs(int value,int depth) {
		if(depth == arr.length) {
			max = max > value ? max : value;
			min = min < value ? min : value;
			return;
		}
		if(operater[0] > 0) {
			operater[0]--;
			dfs(value + arr[depth],depth+1);
			operater[0]++;
		}
		if(operater[1] > 0) {
			operater[1]--;
			dfs(value - arr[depth],depth+1);
			operater[1]++;
		}
		if(operater[2] > 0) {
			operater[2]--;
			dfs(value * arr[depth],depth+1);
			operater[2]++;
		}
		if(operater[3] > 0) {
			operater[3]--;
			dfs(value / arr[depth],depth+1);
			operater[3]++;
		}
	}
	
}
