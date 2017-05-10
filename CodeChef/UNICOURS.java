import java.util.*;
import static java.lang.System.out;

class Sol{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[] A = new int[n];
			int max = 0;
			for(int i=0; i<n; ++i){
				A[i] = sc.nextInt();
				if(A[i] > max){
					max = A[i];
				}
			}
			out.println(n - max);
		}
	}
}
			