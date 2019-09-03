import java.util.Arrays;
import java.util.Scanner;

public class Solution_1247 {
	static int N;
	static Customer[] c;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			N = sc.nextInt();
			c = new Customer[N+2]; 
			
			c[0] = new Customer(sc.nextInt(), sc.nextInt()); // 회사
			c[c.length-1] = new Customer(sc.nextInt(), sc.nextInt()); // 집
			
			for (int j = 1; j < N+1; j++) {
				c[j] = new Customer(sc.nextInt(), sc.nextInt());
			}
		
			dfs(1);
			System.out.printf("#%d %d\n",i,min);
			min = Integer.MAX_VALUE;
		}
	}
	public static void dfs(int depth) {
		if(depth == N) {
			int d = distance();
			if(min > d) {
				min = d;
			}
			return;
		}
		
		for (int i = depth; i < c.length-1; i++) { //1~5 까지 섞는것
			swap(c,depth,i);
			dfs(depth+1);
			swap(c,depth,i);
		}
	}
	public static void swap(Customer[] c,int a,int b) {
		Customer t = c[a];
		c[a] = c[b];
		c[b] = t;
		
	}
	
	public static int distance() {
		int dis = 0;
		for (int i = 1; i < N+2; i++) {
			dis += Math.abs(c[i].x-c[i-1].x) + Math.abs(c[i].y-c[i-1].y);
		}
		return dis;
	}

}

class Customer{
	int x,y;

	public Customer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}