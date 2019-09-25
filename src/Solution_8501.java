import java.util.Arrays;

public class Solution_8501 {
	static int[] arr;
	static int[] front_coin;
	public static void main(String[] args) {
		for (int k = 1; k < 12; k++) {
			arr = new int[k];
			front_coin = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i+1;
			}
			dfs(0);
			int sum = 0;
			System.out.println(Arrays.toString(front_coin));
			for (int i = 0; i < front_coin.length; i++) {
				sum += front_coin[i] * i;
			}
			System.out.println(k + ":"+ sum);
		}
		
	}
	public static void dfs( int depth) {
		if(depth == arr.length) {
			boolean[] front = new boolean[arr.length];
			for (int i = 0; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[i] < arr[j]) {
						front[j] = !front[j];
					}
				}
			}
			
			int sum = 0;
			for (int i = 0; i < front.length; i++) {
				if(front[i]) {
					sum++;
				}
			}
			front_coin[sum]++;
			
			return;
		}
		for (int i = depth; i < arr.length; i++) {
			swap(i,depth);
			dfs(depth+1);
			swap(i,depth);
		}
	}
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
