import java.util.Arrays;
import java.util.Scanner;

public class Solution_5550 {

	
	public static int solution(Scanner sc) {
		String croak = sc.next();
		int[] frog = new int[5];
		int count = 0;
		
		for (int i = 0; i < croak.length(); i++) {
			switch(croak.charAt(i)) {
			case 'c':
				if(count > 0) {
					count--;
				}
				frog[0]++;
				break;
			case 'r':
				frog[1]++;
				break;
			case 'o':
				frog[2]++;
				break;
			case 'a':
				frog[3]++;
				break;
			case 'k':
				count++;
				frog[4]++;
				break;
			}
			
			for (int j = 0; j < 4; j++) {
				if(frog[j] < frog[j+1]) {
					return -1;
				}
			}
		}
		
		for (int i = 1; i < frog.length; i++) {
			if(frog[i] != frog[0]) {
				return -1;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			int count = solution(sc);
			System.out.println("#"+ t + " " + count);
		}

	}

}
