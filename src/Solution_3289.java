import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= iT ; i++) {
			StringTokenizer nm = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(nm.nextToken());
			int m = Integer.parseInt(nm.nextToken());
			
			parent = new int[n+1];
			for (int j = 1; j <= n; j++) {
				parent[j] = j;
			}
			
			System.out.print("#"+i+" ");
			for (int j = 0; j < m; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int zero = Integer.parseInt(st.nextToken());
				if(zero == 0) {
					int key1 = Integer.parseInt(st.nextToken());
					int key2 = Integer.parseInt(st.nextToken());
					
					union(key1,key2);
				}
				else {
					int key1 = Integer.parseInt(st.nextToken());
					int key2 = Integer.parseInt(st.nextToken());
					
					if(find(key1) == find(key2)) {
						System.out.print("1");
					}
					else {
						System.out.print("0");
					}
				}
			}
			System.out.println();
		}

	}
	public static int find(int n) {
		if(n == parent[n]) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}
	public static void union(int i , int j) {
		int p1 = find(i);
		int p2 = find(j);
		
		if(p1 != p2) {
			parent[p2] = p1;
		}
	}
}
