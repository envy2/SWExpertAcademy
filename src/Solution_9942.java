import java.util.Arrays;
import java.util.Scanner;

public class Solution_9942 {

	static int N, K;
	static int[] sum, rule, numbers; //합계, 기준이 되는 수열, 변하는 수열
	static int[] fact = new int[11];
	
	public static void init(Scanner sc) {
		N = sc.nextInt();
		K = sc.nextInt();
		
		sum = new int[100];
		rule = new int[N];
		numbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			rule[i] = i+1;
			numbers[i] = i+1;
		}
	}
	
	public static void dfs(int depth) {
		if(depth == N) {
			solution();
			return;
		}
		for (int i = depth; i < N; i++) {
			swap(i,depth);
			dfs(depth+1);
			swap(i,depth);
		}
	}
	
	public static void solution() {
		int temp = 0;
		
		for (int i = 0; i < N; i++) {
			temp += Math.max(numbers[i], rule[i]);
		}
		sum[temp]++;
	}
	
	public static void swap(int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		Factorial();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			dfs(0);
			long result = 0;
			for (int i = 0; i < sum.length; i++) {
				if(i >= K) {
					result += sum[i];
				}
			}
			result *= fact[N];
			System.out.println("#"+ t + " " + result);
		}

	}

	public static void Factorial() {
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i-1] * i;
		}
	}
}
