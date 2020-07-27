import java.util.Scanner;

public class Solution_10507 {

	static boolean[] study = new boolean[1000001];
	static int n, p, result;
	
	public static void init(Scanner sc) {
		n = sc.nextInt();
		p = sc.nextInt();
		
		int last = 0;
		for (int i = 0; i < n; i++) {
			last = sc.nextInt();
			study[last] = true;
		}
		
		Daily();
		
		for (int i = 0; i <= last; i++) {
			study[i] = false;
		}
		
	}
	
	public static void Daily() {
		result = p + 1;
		int start = 0;
		int end = 0;
		int everyday = 0;
		
		while(end < study.length) {
			if(study[end]) {
				everyday++;
				end++;
				result = Math.max(result, everyday);
			}
			else {
				if(p == 0) {
					result = Math.max(result, everyday);
					if(!study[start++]) {
						p++;
					}
					everyday--;
				}
				else {
					p--;
					everyday++;
					end++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc ; t++) {
			init(sc);
			System.out.println("#" + t + " " + result);
		}
	}

}
