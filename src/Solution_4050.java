import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_4050 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			int sum = 0;
			ArrayList<Integer> dress = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				int s = sc.nextInt();
				dress.add(s);
				sum += s;
			}
			
			Collections.sort(dress);
			for (int j = dress.size()-1; j >=2 ; j-=3) {
				sum -= dress.get(j-2);
			}
			System.out.printf("#%d %d\n",i,sum);
		}

	}

}
