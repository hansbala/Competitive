import static java.lang.System.out;
import java.util.*;
class SOL{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0){
			String str = sc.nextLine();
			char[] A = str.toCharArray();
			Arrays.sort(A);
			String res = String.valueOf(A);
			if(res.equals(str)){
				out.println("yes");
			} else{
				out.println("no");
			}
		}
	}
}