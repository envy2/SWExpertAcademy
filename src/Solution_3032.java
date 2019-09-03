import java.util.Scanner;

public class Solution_3032 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//ax + by = 1
			int resx = 0;
			int resy = 0;
			
			for (int x = 0; x <= b; x++) {
				if((a*x) % b == 1) {
					resx = x;
					break;
				}
			}
			if(resx == 0 ) {
				System.out.printf("#%d %d\n",i,-1);
			}
			else {
				resy = (1 -(a*resx))/b;
				System.out.printf("#%d %d %d\n",i,resx,resy);
			}
		}

	}

}
