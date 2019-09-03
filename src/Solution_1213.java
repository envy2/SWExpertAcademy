import java.util.Scanner;

public class Solution_1213 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int x = 0 ;x< 10; x++) {
			int t = Integer.parseInt(sc.nextLine());
			
			String search = sc.nextLine();
			String str = sc.nextLine();
			int count = 0;
			for(int i = 0 ; i < str.length();i++) {
				if(str.contains(search)) {
					count++;
					str = removeStr(str,str.indexOf(search) + search.length());
				}
			}
			System.out.printf("#%d %d", t,count);
			System.out.println();
		}
	}
	public static String removeStr(String str, int index) {
		String remove = "";
		for (int i = index; i < str.length(); i++) {
			remove += str.charAt(i);
		}
		return remove;
	}
}