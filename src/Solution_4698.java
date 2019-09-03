import java.util.Scanner;

public class Solution_4698 {
	static boolean[] prime = new boolean[1000001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Eratos();
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int count = 0;
			int d = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for (int j = a; j <= b; j++) {
				if(!prime[j]) {
					if((j+"").contains(d+"")) {
						count++;
					}
				}
			}
			System.out.printf("#%d %d\n",i+1,count);
			
		}
	}

	public static void Eratos() {
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i < Math.sqrt(1000001); i++) {
			for (int j = i+i; j < 1000001; j+=i) {
				prime[j] = true;
			}
			
		}
		
	}
}
