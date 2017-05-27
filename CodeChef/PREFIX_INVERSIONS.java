import java.io.*;
import java.util.*;
import static java.lang.System.out;
class sol{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int ans=0;
		boolean flipped = false;
		while(true){
			if((flipped == false && (!str.contains("1"))) || (flipped == true && (!str.contains("0")))) {
				break;
			}
			ans++;
			if(!flipped){
				str = str.substring(0, findOne(str));
			} else{
				str = str.substring(0, findZero(str));
			}
			flipped = !flipped;
		}
		out.println(ans);
	}
	public static int findOne(String str){
		for(int i=(str.length()-1); i>=0; --i){
			if(str.charAt(i) == '1'){
				return i;
			}
		}
		return -1;
	}
	public static int findZero(String str){
		for(int i=(str.length()-1); i>=0; --i){
			if(str.charAt(i) == '0'){
				return i;
			}
		}
		return -1;
	}
}