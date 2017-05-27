import static java.lang.System.out;
import java.util.Scanner;

public class VLADIK_COMPLICATED_BOOK{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] perm = new int[n];
		for(int i=0; i<n; ++i){
			perm[i] = sc.nextInt();
		}
		for(int tt=0; tt<m; ++tt){
			int left = sc.nextInt()-1;
			int right = sc.nextInt()-1;
			int pos = sc.nextInt() - 1;
			int count = 0;
			for(int i=left; i<=right; ++i){
				if(perm[i] < perm[pos]){
					count++;
				}
			}
			if(count == pos - left){
				out.println("Yes");
			} else{
				out.println("No");
			}
		}
		sc.close();
	}
}