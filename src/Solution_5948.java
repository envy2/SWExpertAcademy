import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution_5948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i<= iT ; i++) {
			int[] a = new int[7];
			
			for (int j = 0; j < 7; j++) {
				a[j] = sc.nextInt();
			}
			
			HashSet<Integer> h = new HashSet<>();
			for (int x = 0; x < a.length-2; x++) {
				for (int y = x+1; y < a.length-1; y++) {
					for (int z = y+1; z < a.length; z++) {
						h.add(a[x]+a[y]+a[z]);
					}
				}
			}
			
			Integer[] res = new Integer[h.size()];
			res = h.toArray(res);
			Arrays.sort(res);
			System.out.printf("#%d %d\n",i,res[h.size()-5]);
		}
	}
}
