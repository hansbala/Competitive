#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s;
  cin >> s;
  int i, c=0, max=0;
  int len = s.length();
  for(i=0; i<len; ++i){
    char x = s[i];
    if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
      c++;
      if(c > max){
        max = c;
      }
    }
    else{
      c=0;
    }
  }
  cout << max << endl;
  return 0;
}
