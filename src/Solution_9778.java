import java.util.Scanner;

public class Solution_9778 {
	static int[] cards = new int[12];
	static int go, stop;
	
	public static void init(Scanner sc) {
		for (int i = 2; i < cards.length; i++) {
			cards[i] = 4;
			if(i == 10) {
				cards[i] = 16;
			}
		}
		
		go = 0;
		stop = 0;
		
		int N = sc.nextInt();
		int select = 0;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			select = sc.nextInt();
			sum += select;
			cards[select]--;
		}
		
		Go_Stop(sum);
	}
	
	public static void Go_Stop(int sum) {
		int blackjack = 21 - sum;
		
		for (int i = 2; i < cards.length; i++) {
			if(i <= blackjack) {
				go += cards[i];
			}
			else {
				stop += cards[i];
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			if(go < stop) {
				System.out.println("#"+ t + " STOP");
			}
			else {
				System.out.println("#"+ t + " GAZUA");
			}
		}

	}

}
