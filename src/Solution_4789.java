import java.util.Scanner;

public class Solution_4789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < tcase; i++) {
			char[] p = sc.nextLine().toCharArray();
			int[] people = new int[p.length];
			
			for (int j = 0; j < p.length; j++) {
				people[j] = p[j] -'0';
			}
			
			int sum = 0;
			int result = 0;
			
			for (int j = 0; j < people.length; j++) {
				if(j <= sum && people[j] != 0) {
					sum += people[j];
				}
				else if(j > sum){
					result += j-sum;
					sum = j + people[j];
				}
			}
			
			System.out.printf("#%d %d\n",i+1,result);
		}
		
	}

}
