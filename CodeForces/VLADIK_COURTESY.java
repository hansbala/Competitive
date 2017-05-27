//http://codeforces.com/contest/811/problem/A
import static java.lang.System.out;
import java.util.Scanner;
public class VLADIK_COURTESY{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long init = 1;
		for(int i=0; ; ++i){
			if(i % 2 == 0){
				//Vladik's turn
				if(a - init < 0){
					out.println("Vladik");
					break;
				} else{
					a -= init;
					init++;
				}
			} else{
				//Valera's Turn
				if(b - init < 0){
					out.println("Valera");
					break;
				} else{
					b -= init;
					init++;
				}
			}
		}
		sc.close();
	}
}