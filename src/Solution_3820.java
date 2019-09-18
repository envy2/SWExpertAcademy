import java.util.Scanner;

public class Solution_3820 {
	static int prime = 1000000007;
	static Rail[] rail;
	static long result;
	static class Rail{
		int a,b;

		public Rail(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i<= iT ;i++) {
			int N = sc.nextInt();
			rail = new Rail[N];
			result = 1;
			
			for (int j = 0; j < rail.length; j++) {
				rail[j] = new Rail(sc.nextInt(),sc.nextInt());
			}
			quickSort(0,rail.length-1);
			slow();
			System.out.println("#" + i + " " + result);
		}
	}
	public static void slow() {
		for (int i = rail.length - 1; i >= 0; i--) {
			result = ((rail[i].a * result) % prime) + (rail[i].b % prime) % prime;
		}
	}
	public static double coster(Rail rail) {
		return (rail.a - 1) / (double)rail.b;
	}

 
    static void quickSort(int first, int last)
    {
        Rail temp;   
       
        
        if (first < last)
        {
            int pivot = first;
            int i = first;
            int j = last;
 
            while (i < j)
            {
                while (coster(rail[i]) <= coster(rail[pivot]) && i < last)
                {
                    i++;
                }
                while (coster(rail[j]) > coster(rail[pivot]))
                {
                    j--;
                }
                if (i < j)
                {
                	temp = rail[i];
                	rail[i] = rail[j];
                	rail[j] = temp;
                }
            }
 
            temp = rail[pivot];
            rail[pivot] = rail[j];
            rail[j] = temp;
 
            quickSort(first, j - 1);
            quickSort(j + 1, last);
        }
    }
}
