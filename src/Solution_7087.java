import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution_7087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i=1;i <= iT ; i++) {
			int len = sc.nextInt();
			ArrayList<String> title = new ArrayList<>();
			
			for (int j = 0; j < len; j++) {
				title.add(sc.next());
			}
			HashSet<Character> h = new HashSet<>();
			for(String s : title) {
				h.add(s.charAt(0));
			}
			
			Iterator<Character> c = h.iterator();
			int count = 65; // 'A'
			while(c.hasNext()) {
				if(count == (int)c.next()) {
					count++;
					continue;
				}
				else {
					break;
				}
			}
			
			System.out.printf("#%d %d\n",i,count-65);
		}
	}

}
