import java.util.Arrays;
import java.util.Scanner;

public class Solution_4008 {
	static Character[] operater;
	static int[] arr;
	static int max,min;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			int N = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

			operater = new Character[a+b+c+d];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			int index = 0;
			for (int j = 0; j < a; j++) {
				operater[index++] = '+';
			}
			for (int j = 0; j < b; j++) {
				operater[index++] = '-';
			}
			for (int j = 0; j < c; j++) {
				operater[index++] = '*';
			}
			for (int j = 0; j < d; j++) {
				operater[index++] = '/';
			}
			arr = new int[N];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			
			dfs(0);
			System.out.printf("#%d %d\n",i,max-min);
		}

	}

	public static void dfs(int depth) {
		if(depth == operater.length) {
			int sum = arr[0];
			int index = 1;
			for (int i = 0; i < operater.length; i++) {
				if(operater[i] == '+') {
					sum += arr[index++];
				}
				else if(operater[i] =='-') {
					sum -= arr[index++];
				}
				else if(operater[i] == '*') {
					sum *= arr[index++];
				}
				else if(operater[i] == '/' && arr[index] != 0) {
					sum /= arr[index++];
				}
				else {
					return;
				}
			}
			max = max > sum ? max : sum;
			min = min < sum ? min : sum;
			return;
		}
		for (int i = depth; i < operater.length; i++) {
			swap(i,depth);
			dfs(depth+1);
			swap(i,depth);
		}
	}
	public static void swap(int a, int b) {
		if(operater[a] == operater[b]) {
			return;
		}
		char t = operater[a];
		operater[a] = operater[b];
		operater[b] = t;
	}
}
