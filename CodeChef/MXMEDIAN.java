import java.util.*;
import static java.lang.System.out;

class Sol{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int size = n << 1;
			int[] A = new int[size];
			for(int i=0; i<size; ++i){
				A[i] = sc.nextInt();
			}
			Arrays.sort(A);
			int[] B = new int[n];
			for(int i=n; i<size; ++i){
				B[i - n] = A[i];
			}
			Arrays.sort(B);
			int med = B[n >> 1];
			out.println(med);
			for(int i=0; i<n; ++i){
				out.print(A[i]+" "+A[i+n]+" ");
			}
			out.println();
		}
	}
}