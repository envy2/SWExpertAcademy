import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_1257 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i= 1; i<= iT ; i++) {
			int c = sc.nextInt();
			String str = sc.next();
			int len = (str.length()* (str.length()+1))/2 ;
			String[] s = new String[len];
			int index = 0;
			for (int x = 0; x < str.length(); x++) {
				for (int y = x+1; y <= str.length(); y++) {
					s[index++] = str.substring(x,y); 
				}
			}
			
			TreeSet<String> t = new TreeSet<>();
			for (int j = 0; j < s.length; j++) {
				t.add(s[j]);
			}
			String[] res = new String[t.size()];
			t.toArray(res);
			
			if(c <= res.length) {
				System.out.printf("#%d %s\n",i,res[c-1]);
			}
			else {
				System.out.printf("#%d none\n",i);
			}
		}
	}

}
