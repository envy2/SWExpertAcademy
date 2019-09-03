import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_7810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int N = sc.nextInt();
			int[] DP = new int[N+1];
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				arr.add(sc.nextInt());
			}
			
			for (int j = DP.length-2; j >= 0; j--) {
				int count = 0;
				for (int k = 0; k < arr.size(); k++) {
					if(j+1 <= arr.get(k)) {
						count++;
						arr.remove(k);
						k--;
					}
				}
				DP[j] = count + DP[j+1];
			}
			
			int result = 0;
			for (int j = DP.length-2; j >= 0; j--) {
				if(j+1 == DP[j]) {
					result = j+1;
					break;
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}

}
