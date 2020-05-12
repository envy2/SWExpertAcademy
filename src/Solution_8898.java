import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_8898 {
	static int[] cow, horse;
	static int min_x, count;

	public static void init(Scanner sc) {
		cow = new int[sc.nextInt()];
		horse = new int[sc.nextInt()];
		
		min_x = Math.abs(sc.nextInt() - sc.nextInt());
		count = 0;
		
		for (int i = 0; i < cow.length; i++) {
			cow[i] = sc.nextInt();
		}
		for (int i = 0; i < horse.length; i++) {
			horse[i] = sc.nextInt();
		}
		
		Arrays.sort(cow);
		Arrays.sort(horse);
		
	}
	
	public static int solution() {
		ArrayList<Integer> min_z = new ArrayList<>();
		int cnt = 0;
		
		for (int i = 0; i < horse.length; i++) {
			if(horse[i] <= cow[cnt]) {
				min_z.add(Math.abs(horse[i] - cow[cnt]));
			}
			else {
				min_z.add(Math.abs(horse[i] - cow[cnt]));
				cnt++;
				i--;
			}
			if(cnt >= cow.length) {
				break;
			}
		}
		
		int min = Collections.min(min_z);
		for(int z : min_z) {
			if(min == z) {
				count++;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			int min_z = solution();
			System.out.println("#" + t + " " + (min_x + min_z) + " " + count);
		}
	}

}
