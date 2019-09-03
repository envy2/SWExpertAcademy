import java.util.Scanner;

public class Solution_6190 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] list = new int[n];
			for (int j = 0; j < n; j++) {
				list[j] = sc.nextInt();
			}
			int max = -1;
			boolean check = true;
			for (int x = 0; x < list.length-1; x++) {
				for (int y = x+1; y < list.length; y++) {
					int number = list[x] * list[y];
					
					String line = number+"";
					for (int z = 0; z < line.length()-1; z++) {
						if((line.charAt(z) - '0' ) > (line.charAt(z+1) - '0')) {
							check = false;
							break;
						} 
						else {
							check = true;
							continue;
						}
						
					}
					
					if(check) {
						max = max > number ? max : number;
					}
					
				}
			}
			System.out.printf("#%d %d\n",i+1,max);
			
		}

	}

}
