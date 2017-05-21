import static java.lang.System.out;
import java.util.*;

class SNAKPROC{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
      sc.nextInt();
      sc.nextLine();
      String str = sc.nextLine();
      //out.println("STR: "+str);
      str = str.replace(".", "");
      //out.println("Modified str: " + str);
      boolean valid = true;
      if(str.equals("")){
        out.println("Valid");
        continue;
      }
      if(str.length() % 2 !=0 || str.startsWith("T") || str.endsWith("H") || str.contains("HH") || str.contains("TT")){
        out.println("Invalid");
        continue;
      }
      else{
        int len = str.length();
        for(int i=0; i<len; i+=2){
          if(i == (len - 2)){
            break;
          }
          String temp = str.substring(i, i+2);
          //out.println("Temp: " + temp);
          if(!(temp.equals("HT"))){
            out.println("Invalid");
            valid = false;
            break;
          }
        }
        if(valid){
          out.println("Valid");
        }
      }
    }
  }
}