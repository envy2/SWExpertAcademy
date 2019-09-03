
public class Solution_3131 {

	public static void main(String[] args) {
		boolean[] Era = new boolean[1000];
		for (int i = 2; i < Era.length; i++) {
			Era[i] = true;
		}
		for (int i = 2; i < Math.sqrt(Era.length); i++) {
			if(Era[i]) {
				for (int j = i+i; j < Era.length; j+=i) {
					Era[j] = false;
				}
			}
		}
		
		for (int i = 2; i < Era.length; i++) {
			if(Era[i]) {
				System.out.printf("%d ",i);
			}
		}

	}

}
