import java.io.*;
import java.util.*;
class sol {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
 
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String str = br.readLine().trim();
			//String sArr[]=br.readLine().trim().split(" ");
			int val = Integer.parseInt(str);
			//code it
			String key[]=new String[val];
			String value[]=new String[val];
			int ind=0;
			while(val-->0){
				String strarr[]=br.readLine().trim().split(" ");
				key[ind]=strarr[0].trim();
				value[ind]=strarr[1].trim();
				ind++;
			}
			str=br.readLine().trim();
			int flag[]=new int[str.length()];
			StringBuilder stb=new StringBuilder(str);
			Arrays.fill(flag,0);
			for(int i=0;i<ind;i++){
				for(int j=0;j<str.length();j++){
					if(flag[j]==0&&str.charAt(j)==key[i].charAt(0)){
						flag[j]=1;
						stb.setCharAt(j,value[i].charAt(0));
					}
				}
			}
			//System.out.println(stb);
			if(stb.toString().contains(".")){
				//trim front zeros
				boolean print=false;
				int front=0;
				for(int i=0;i<str.length();i++)
					if(stb.charAt(i)!='0'){
						front=i;
						//System.out.println(stb.substring(i));
						break;
					}
				//trim end  zeros
				String out ="";
				for(int i=str.length()-1;i>=0;i--)
					if(stb.charAt(i)!='0' ){
						print=true;
						if(stb.charAt(i)=='.')
							out = stb.substring(front,i);
						else
							out = stb.substring(front,i+1);
						break;
					}
				//System.out.println(print);
				if(out.trim().length()==0)
					System.out.println(0);
				else
					System.out.println(out);
			}
			else{
				//trim front zeros
				boolean print=false;
				for(int i=0;i<str.length();i++)
					if(stb.charAt(i)!='0'){
						print=true;
						System.out.println(stb.substring(i));
						break;
					}
				if(!print)
					System.out.println(0);
			}
			//need to trim zeros
			pw.println();
		}
		//pw.flush();
		pw.close();
	}
}