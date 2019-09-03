import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution_5986 {
	static boolean[] prime = new boolean[1010]; // 999가 입력되었을때 cnt가 0이 된다. 따라서 1009 소수까지 입력이 되게 하기위해서 1010까지
	static ArrayList<Integer> p = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Eratos();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int cnt = 0;
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < p.size(); j++) {
				if(p.get(j) >= n) {
					cnt = j;
					break;
				}
			}
			int result = 0;
			for (int a = 0; a < cnt; a++) {
				for (int b = a; b < cnt; b++) {
					for (int c = b; c < cnt; c++) {
						if( p.get(a)+p.get(b)+p.get(c) == n) {
							result++;
						}
					}
					
				}
			}
			System.out.printf("#%d %d\n",i+1,result);
			
		}
	}
	
	public static void Eratos() {
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i < Math.sqrt(prime.length); i++) {
			for (int j = i+i; j < prime.length; j+=i) {
				prime[j] = true;
			}
		}
		for (int i = 0; i < prime.length; i++) {
			if(!prime[i]) {
				p.add(i);
			
			}
		}
		
	}
	
	
}
