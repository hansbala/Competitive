import java.io.*;
class sol{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String str = br.readLine();
			if(str.contains("010") || str.contains("101")){
				pw.println("Good");
			}
			else{
				pw.println("Bad");
			}
		}
		pw.close();
	}
}