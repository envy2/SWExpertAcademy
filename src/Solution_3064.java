import java.util.Arrays;
import java.util.Scanner;

public class Solution_3064 {
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int len = sc.nextInt();
			int order = sc.nextInt();
			
			int[] number = new int[len+1];
			res = new int[len+1];
			
			for (int j = 1; j < number.length; j++) {
				number[j] = sc.nextInt();
			}
			
			for (int j = 1; j < number.length; j++) {
				res[j] = res[j-1]+number[j];
			}
			System.out.printf("#%d ",i);
			for (int j = 0; j < order; j++) {
				int or = sc.nextInt();
				if(or == 1) {
					int a = sc.nextInt();
					int b = sc.nextInt();
					
					for (int k = a; k < number.length; k++) {
						res[k] += b;
					}
				}
				else if(or == 2){
					int s = sc.nextInt();
					int e = sc.nextInt();
				
					int sum = res[e] - res[s-1];
					System.out.print(sum+" ");
				}
			}
			System.out.println();
		}

	}

}
