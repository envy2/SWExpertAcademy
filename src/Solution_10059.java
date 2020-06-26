import java.util.Scanner;

public class Solution_10059 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			String card = sc.next();
			
			int front = Integer.parseInt(card.substring(0,2));
			int back = Integer.parseInt(card.substring(2,4));
			
			if(front >= 1 && front <= 12) {
				if(back >= 1 && back <= 12) {
					System.out.println("#" + t + " AMBIGUOUS");
				}
				else {
					System.out.println("#" + t + " MMYY");
				}
			}
			else {
				if(back >= 1 && back <= 12) {
					System.out.println("#" + t + " YYMM");
				}
				else {
					System.out.println("#" + t + " NA");
				}
			}
		}
	}

}
