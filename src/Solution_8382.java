import java.util.Scanner;

public class Solution_8382 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int[] point = new int[4];
			for(int p = 0; p< 4; p++){
			    point[p] = sc.nextInt();
			}
			
			int x = Math.abs(point[0] - point[2]);
			int y = Math.abs(point[1] - point[3]);
			int result = 0;
			int line = x > y ? x-y : y-x;
			int step = x > y ? y : x;
			
			if(line % 2 == 1) {
				result += (line - 1) * 2 + 1;
			}
			else {
				result += line * 2;
			}
			result += step * 2;
			
			System.out.println("#"+i+" "+result);
		}
	}
}
