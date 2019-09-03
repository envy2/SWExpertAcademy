import java.util.Scanner;

public class Solution_6781 {
	static Card[] card;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT ; i++) {
			card = new Card[9];
			String num = sc.next();
			String col = sc.next();
			
			for (int j = 0; j < 9; j++) {
				card[j] = new Card(num.charAt(j) - '0',col.charAt(j));
			}
			
			check();
		}
	}
	public static void Suffle(int depth) {
		for (int i = 0; i < card.length; i++) {
			
		}
	}
	public static boolean check() {
		boolean run = false;
		boolean triple = false;
		
		
		return true;
	}
}

class Card{
	int number;
	char color;
	public Card(int n, char c) {
		this.number = n;
		this.color = c;
	}
}