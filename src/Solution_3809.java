import java.util.Scanner;

public class Solution_3809 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int tcase = sc.nextInt();
		
		for (int i = 0; i < tcase; i++) {
			int n = sc.nextInt();
			int[] list = new int[n];
			String line = "";
			for (int j = 0; j < n; j++) {
				line += sc.nextInt();
			}
			
			int count = 0;
			boolean start = true;
			System.out.println(line.indexOf("2"));
			while(start) {
				if(line.indexOf(count+"") == -1) {
					start = false;
				}
				count++;
			}
			System.out.printf("#%d %d\n",i+1,count-1);
		}

	}

}
