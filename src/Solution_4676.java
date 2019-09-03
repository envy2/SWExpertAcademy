import java.util.Scanner;

public class Solution_4676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < tcase; i++) {
			String line = sc.nextLine();
			int h = Integer.parseInt(sc.nextLine());
			
			int[] count = new int[line.length()+1];
			String nextline = sc.nextLine();
			for (int j = 0; j < h; j++) {
				count[Integer.parseInt(nextline.split(" ")[j])]++;
			}
			
			String[] list = new String[line.length()+1];
			for (int j = 0; j < count.length; j++) {
				list[j] = hypon(count[j]);
			}
			String l = "";
			for (int j = 0; j < line.length(); j++) {
				l += j+ "" +line.charAt(j);
			}
			line = l + line.length();
			
			
			for (int j = 0; j < list.length; j++) {
				line = line.replaceFirst(j+"", list[j]);
				
			}
			System.out.println(line);
		}

	}

	public static String hypon(int num) {
		String l ="";
		for (int i = 0; i < num; i++) {
			l += "-";
		}
		return l;
	}
}
