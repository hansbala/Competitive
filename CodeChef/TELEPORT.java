import static java.lang.System.out;
import java.util.Scanner;

class sol{
	static int q, r, locs[][];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		q = sc.nextInt();
		r = sc.nextInt();
		sc.nextLine();
		locs = new int[2][q+1];
		for(int i=1; i<=q; ++i){
			String[] temp = sc.nextLine().split(" ");
			if(temp[0].equals("+")){
				locs[0][i] = Integer.parseInt(temp[1]);
				locs[1][i] = Integer.parseInt(temp[2]);
			}
			else{
				int tel1 = Integer.parseInt(temp[1]);
				int tel2 = Integer.parseInt(temp[2]);
				if(isPossible(tel1, tel2)){
					out.println("DA");
				} else{
					out.println("NET");
				}
			}
		}
	}
	public static boolean isPossible(int tel1, int tel2){
		int x1 = locs[0][tel1], y1 = locs[1][tel1];
		int x2 = locs[0][tel2], y2 = locs[1][tel2];
		int dist = (int)Math.ceil(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
		return ((dist >> 1) <= r);
	}
}