import java.util.Arrays;
import java.util.Scanner;

public class Solution_1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 0; i < iT; i++) {
			int n = sc.nextInt();
			boolean[] ten = new boolean[10];
			int count = 0;
			int num = n;
			boolean check = true;
			
			while(check) {
				String str = num + "";
				for (int j = 0; j < str.length(); j++) {
					ten[str.charAt(j) - '0'] = true;
				}
				for (int j = 0; j < ten.length; j++) {
					if(ten[j]) {
						check = false;
					}
					else {
						check = true;
						break;
					}
				}
				
				count++;
				num = n * (count + 1);
			}
			
			System.out.printf("#%d %d\n",i+1,n*count);
		}

	}
	
}
