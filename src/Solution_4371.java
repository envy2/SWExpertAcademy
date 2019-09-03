import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4371 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			ArrayList<Integer> cycle = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				cycle.add(sc.nextInt());
			}
			int ship = 0;
			
			for (int j = 1; j < cycle.size(); j++) {
				int nextship = 0;
				if(cycle.get(j) != 0 ) {
					nextship = cycle.get(j) - cycle.get(0); 
					ship++;
				}
				else {
					continue;
				}
				for (int k = 1; k < cycle.size(); k++) {
					if(cycle.get(k) % nextship == 1) {
						cycle.set(k, 0);
					}
				}
			}
			System.out.printf("#%d %d\n",i,ship);
		}
	}

}
