import java.util.Scanner;

public class Solution_4613 {
	static int res;
	static boolean Bcheck;
	static char[][] flag;
	static int b,w,r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			flag = new char[N][M];
			res = 0;
			
			for (int j = 0; j < flag.length; j++) {
				String str = sc.next();
				for (int j2 = 0; j2 < flag[0].length; j2++) {
					flag[j][j2] = str.charAt(j2);
				}
			}
			
			for (int j = 0; j < flag[0].length; j++) { // 첫줄
				if(flag[0][j] != 'W') {
					res++;
				}
			}
			dfs(0);
			for (int j = 0; j < flag[0].length; j++) {
				if(flag[N-1][j] != 'R') {
					res++;
				}
			}
			System.out.println(res);
		}
	}
	public static void dfs(int depth) {
		if(!Bcheck) {
			if(w > b) {
				res += b;
				res += r;
			}
			else {
				res += w;
				res += r;
				Bcheck = true;
			}
		}
		else {
			if(b > r) {
				res += r;
				res += w;
			}
			else {
				res += b;
				res += w;
			}
		}
		
		for (int x = 1; x < flag.length-1; x++) {
			b = 0;
			w = 0;
			r = 0;
			for (int y = depth; y < flag[0].length; y++) {
				if(flag[x][y] == 'W') {
					w++;
				}
				else if(flag[x][y] == 'R') {
					r++;
				}
				else {
					b++;
				}
			}
		}
	}
}
