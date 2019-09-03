import java.util.Scanner;
import java.util.TreeSet;

public class Solution_6191 {
	static boolean[] use; 
	static int N;
	static TreeSet<String> t = new TreeSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<=iT ;i++) {
			N = sc.nextInt();
			long K = sc.nextLong();
			use = new boolean[N*2];
			dfs(use,0);
			if(K <= t.size()) {
				System.out.printf("#%d %s\n",i,t.toArray()[(int)K-1]);
			}
			else {
				System.out.printf("#%d )(\n",i);
			}
			t.clear();
		}		
	}
	public static void dfs(boolean[] use, int depth) {
		if(depth == use.length) {
			StringBuilder sb = new StringBuilder();
			if(check()) {
				for (int i = 0; i < use.length; i++) {
					if(use[i]) {
						sb.append("(");
					}
					else {
						sb.append(")");
					}
				}
				t.add(sb.toString());
			}
			return;
		}
		use[depth] = true;
		dfs(use,depth+1);
		use[depth] = false;
		dfs(use,depth+1);
	}
	
	public static boolean check() {
		int count = 0;
		for (int i = 0; i < use.length; i++) {
			if(use[i]) {
				count++;
				if(count > N) {
					return false;
				}
			}
			else {
				count--;
				if(count < 0) {
					return false;
				}
			}
		}
		if(count == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
}