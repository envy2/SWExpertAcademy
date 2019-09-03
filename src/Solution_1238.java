import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1238 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1 ; i <= 10;i++) {
			boolean[][] check = new boolean[101][101];
			int line = sc.nextInt()/2;
			int start = sc.nextInt();
			for (int j = 0; j < line; j++) {
				check[sc.nextInt()][sc.nextInt()] = true;
			}
			
			Queue<Integer> q = new LinkedList<>();
			boolean[] visit = new boolean[101];
			int a = 0;
			q.add(start);
		
			
			int[] d = new int[101];
			while(!q.isEmpty()) {
				a = q.poll();
				for (int j = 0; j < check[0].length; j++) {
					if(check[a][j] && !visit[j]) {
						q.add(j);
						visit[j] = true;
						d[j] = d[a]+1;
					}
				}
				
			}
			
			int result = 0;
			int max = 0;
			for (int j = 0; j < d.length; j++) {
				if(max <= d[j]) {
					max = d[j];
					result = j;
					
				}
			}
			System.out.printf("#%d %d\n",i,result);
		}

	}

}
