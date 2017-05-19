#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

bool isPall(string s){
  string rev = "";
  int len = s.length();
  for(int i=len-1; i>=0; --i){
    rev += s[i];
  }
  return (s == rev);
}
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while(t--){
    string s;
    cin >> s;
    if(!isPall(s)){
      cout << "NO" << endl;
    }
    else{
      cout << "YES" << " ";
      if(s.length() % 2 == 0){
        cout << "EVEN" << endl;
      }
      else{
        cout << "ODD" << endl;
      }
    }
  }
  return 0;
}
