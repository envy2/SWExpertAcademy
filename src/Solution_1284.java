import java.util.Scanner;

public class Solution_1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();
		
		for (int i = 0; i < tcase; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();
			
			int Acharge = p * w ;
			int Bcharge = 0 ;
			if( w >= r ) {
				Bcharge = (w - r) * s + q;
			}
			else {
				Bcharge = q;
			}
			
			int charge = Acharge < Bcharge ? Acharge : Bcharge;
			System.out.printf("#%d %d",i+1,charge);
			System.out.println();
		}
		
	}

}
