#include <bits/stdc++.h>
#define rf freopen("inp.in","r",stdin)
typedef long long int lli;
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  //rf;
  string s;
  int k;
  cin >> s >> k;
  int len = s.length();
  string suff[len];
  for(int i=0; i<len; ++i){
    suff[i] = s.substr(i, len-i);
  }
  sort(suff, suff+len);
  cout << suff[k-1] << endl;

  return 0;
}
