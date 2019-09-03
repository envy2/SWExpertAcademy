import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Solution_6808 {

	static int win,lose,Isum,Gsum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 0; i < iT; i++) {
			boolean[] card = new boolean[19];
			ArrayList<Integer> Gcard = new ArrayList<>();
			ArrayList<Integer> Icard = new ArrayList<>();
			
			for (int j = 0; j < 9; j++) {
				int n = sc.nextInt();
				Gcard.add(n);
				card[n] = true;
			}
			
			for (int j = 1; j < 19; j++) {
				if(!card[j]) {
					Icard.add(j);
				}
			}
			dfs(Icard,0,Gcard);
			System.out.printf("#%d %d %d\n",i+1,win,lose);
			win = 0;
			lose = 0;
			Isum = 0;
			Gsum = 0;
		}
	}
	
	public static void dfs(ArrayList<Integer> Icard, int depth , ArrayList<Integer> Gcard) {
		if( depth == 9 ) {
			for (int i = 0; i < 9; i++) {
				if(Icard.get(i) > Gcard.get(i)) {
					Isum += (Icard.get(i) + Gcard.get(i));
				}
				else {
					Gsum += (Icard.get(i) + Gcard.get(i));
				}
			}
			if(Isum > Gsum) {
				lose++;
			}
			else if(Isum == Gsum) {
				
			}
			else {
				win++;
			}
			Isum = 0;
			Gsum = 0;
			return;
		}
		for (int i = depth; i < Icard.size(); i++) {
			Collections.swap(Icard, i, depth);
			dfs(Icard,depth+1,Gcard);
			Collections.swap(Icard, i, depth);
		}
	}
	
}
