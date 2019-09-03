import java.util.Scanner;

public class Solution_6900 {
	static lotto[] l;
	static int winMoney;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			l = new lotto[N];
			for (int j = 0; j < N; j++) {
				l[j] = new lotto(sc.next(),sc.nextInt());
			}
			
			for (int j = 0; j < M; j++) {
				Win(sc.next());
			}
			System.out.printf("#%d %d\n",i,winMoney);
			winMoney = 0;
		}
		

	}
	public static void Win(String buy) {
		boolean check = true;
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < 8; j++) {
				if(l[i].number.charAt(j) == '*' || l[i].number.charAt(j) == buy.charAt(j)) {
					
				}
				else {
					check = false;
				}
			}
			if(check) {
				winMoney += l[i].money;
			}
			check = true;
		}
	}
}

class lotto{
	String number;
	int money;
	
	public lotto(String s, int m ) {
		this.number = s;
		this.money = m;
	}
}