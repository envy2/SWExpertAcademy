import java.util.Scanner;

public class Solution_5515 {

	static int[] month_12 = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int month = sc.nextInt();
			int day = sc.nextInt();
			
			int week = (month_day(month) + day + 3) % 7;
			
			System.out.printf("#%d %d\n",i+1,week);
			
		}
	}
	
	public static int month_day(int month) {
		int day = 0;
		for (int i = 0; i < month-1; i++) {
			day += month_12[i];
		}
		return day;
	}

}
