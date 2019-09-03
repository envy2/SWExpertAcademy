import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_7272 {
	static char[] hole0 = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
	static char[] hole1 = {'A','D','O','P','Q','R'};
	static HashMap<Character, Integer> hole = new HashMap<>();
	
	public static void init() {
		for (int i = 0; i < hole0.length; i++) {
			hole.put(hole0[i], 0);
		}
		for (int i = 0; i < hole1.length; i++) {
			hole.put(hole1[i], 1);
		}
		hole.put('B', 2);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= iT ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			
			boolean check = true;
			if(first.length() != second.length()) {
				System.out.println("#"+i+" DIFF");
			}
			else {
				for (int j = 0; j < first.length(); j++) {
					if(hole.get(first.charAt(j)).equals(hole.get(second.charAt(j)))) {
						continue;
					}
					else {
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println("#"+i+" SAME");
				}
				else {
					System.out.println("#"+i+" DIFF");
				}
			}
		}

	}

}
