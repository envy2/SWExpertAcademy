import java.util.Arrays;
import java.util.Scanner;

public class Solution_1860 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			int N = sc.nextInt();
			int time = sc.nextInt();
			int amount = sc.nextInt();
			int[] people = new int[N];
			int max = 0;
			for (int j = 0; j < N; j++) {
				people[j] = sc.nextInt();
				max = max > people[j] ? max : people[j];
			}
			
			int[] bread = new int[max+1];
			for (int j = 0; j < people.length; j++) {
				bread[people[j]]--;
			}
			for (int j = 1; j < bread.length; j++) {
				bread[j] += bread[j-1];
				if(j % time == 0) {
					bread[j] += amount;
				}
			}
			boolean check = false;
			for(int a : bread) {
				if(a < 0) {
					check = true;
				}
			}
			if(check) {
				System.out.println("#"+i+" "+"Impossible");
			}
			else {
				System.out.println("#"+i+" "+"Possible");
			}
		}

	}

}
