import java.util.Scanner;

public class UserSolution_7206 {
	static int count;
	static int[] cnt = new int[100000];
	static boolean[] check = new boolean[100000];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			DP();
			count = 0;
			String s = N + "";
			dfs(s,0);
			
			System.out.printf("#%d %d\n",i,count);
			
		}

	}
	public static void DP() {
		for (int i = 0; i < 10000; i++) {
			count = 0;
			dfs(i+"",0);
			cnt[i] = count;
			check[i] = true;
		}
	}
	public static void dfs(String str, int depth) {
		if(str.length() == 1) {
			count = count > depth ? count : depth;
			return;
		}
		
		if(str.length() >= 2 ) {
			for (int i = 1; i < str.length(); i++) {
				int a = Integer.parseInt(str.substring(0, i));
				int b = Integer.parseInt(str.substring(i,str.length()));
				dfs((a*b)+"",depth+1);
			}
		}
		if(str.length() >= 3) {
			for (int i = 1; i < str.length()-1; i++) {
				for (int j = i+1; j < str.length(); j++) {
					int a = Integer.parseInt(str.substring(0, i));
					int b = Integer.parseInt(str.substring(i,j));
					int c = Integer.parseInt(str.substring(j,str.length()));
					dfs((a*b*c)+"",depth+1);
				}
			}
		}
		if(str.length() >= 4 ) {
			for (int i = 1; i < str.length()-2; i++) {
				for (int j = i+1; j < str.length()-1; j++) {
					for (int k = j+1; k < str.length(); k++) {
						int a = Integer.parseInt(str.substring(0,i));
						int b = Integer.parseInt(str.substring(i,j));
						int c = Integer.parseInt(str.substring(j,k));
						int d = Integer.parseInt(str.substring(k,str.length()));
						dfs((a*b*c*d)+"",depth+1);
					}
				}
			}
		}
		if(str.length() >= 5) {
			for (int i = 1; i < str.length()-3; i++) {
				for (int j = i+1; j < str.length()-2; j++) {
					for (int k = j+1; k < str.length()-1; k++) {
						for (int l = k+1; l < str.length(); l++) {
							int a = Integer.parseInt(str.substring(0, i));
							int b = Integer.parseInt(str.substring(i,j));
							int c = Integer.parseInt(str.substring(j,k));
							int d = Integer.parseInt(str.substring(k,l));
							int e = Integer.parseInt(str.substring(l,str.length()));
							dfs((a*b*c*d*e)+"",depth+1);
						}
					}
				}
			}
		}
	}
}
