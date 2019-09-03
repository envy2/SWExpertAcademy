import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_2819 {
	static TreeSet<String> t = new TreeSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int[][] board = new int[4][4];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					board[k][j] = sc.nextInt();
				}
			}
			String s = "";
			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board[0].length; k++) {
					dfs(board,j,k,0,s);
				}
			}
			
			System.out.printf("#%d %d\n",i,t.size());
			
			t.clear();
			
		}

	}
	public static void dfs(int[][] board , int a, int b, int depth, String s) {
		if(depth == 7) {
			t.add(s);
			return;
		}
		
		if(a - 1 >= 0 ) {
			s += board[a-1][b];
			dfs(board,a-1,b,depth+1,s);
			s = s.substring(0, s.length()-1);
		}	
		if(a + 1 < 4) {
			s += board[a+1][b];
			dfs(board,a+1,b,depth+1,s);
			s = s.substring(0, s.length()-1);
		}
		if(b - 1 >= 0) {
			s += board[a][b-1];
			dfs(board,a,b-1,depth+1,s);
			s = s.substring(0, s.length()-1);
		}
		if(b + 1 < 4) {
			s += board[a][b+1];
			dfs(board,a,b+1,depth+1,s);
			s = s.substring(0, s.length()-1);
		}
	}
}
