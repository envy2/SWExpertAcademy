import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1259 {
	static ArrayList<Integer> screw;
	static int[] result;
	static Point man, woman;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int t = 1 ;t <= iT ;t++) {
			int N = sc.nextInt();
			result = new int[N*2];
			screw = new ArrayList<>();
			
			for (int j = 0; j < result.length; j++) {
				screw.add(sc.nextInt());
			}
			
			int[] overlap = new int[100000];
			for (int i = 0; i < screw.size(); i++) {
				overlap[screw.get(i)]++;
			}
			
			int start = -1;
			int end = -1;
			for (int i = 0; i < overlap.length; i++) {
				if(overlap[i] == 1) {
					start = i;
					overlap[i]++;
					break;
				}
			}
			
			for (int i = 0; i < overlap.length; i++) {
				if(overlap[i] == 1) {
					end = i;
					break;
				}
			}
			
			boolean check = true;
			for (int i = 0; i < screw.size(); i+=2) {
				if(screw.get(i) == start) {
					check = false;
					break;
				}
			}
			if(check) {
				int temp = start;
				start = end;
				end = temp;
			}
			
			
			for (int i = 0; i < screw.size(); i+=2) {
				if(screw.get(i) == start) {
					man = new Point(i,screw.get(i));
					woman = new Point(i+1, screw.get(i+1));
					break;
				}
			}
			
			int count = 0;
			result[count++] = man.value;
			result[count++] = woman.value;
			
			while(end != woman.value) {
				for (int i = 0; i < screw.size(); i+=2) {
					if(screw.get(i) == woman.value) {
						man.index = i;
						man.value = screw.get(i);
						woman.index = i + 1;
						woman.value = screw.get(i+1);
						
						result[count++] = man.value;
						result[count++] = woman.value;
						break;
					}
				}
			}
			
			System.out.print("#"+t+" ");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+ " ");
			}
			System.out.println();
		}
		
		
		
	}

	static class Point{
		int index, value;
		public Point(int i, int v) {
			this.index = i;
			this.value = v;
		}
	}
}
