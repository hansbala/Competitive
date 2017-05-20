//http://codeforces.com/problemset/problem/237/A

#include <bits/stdc++.h>
#define rf freopen("inp.in","r",stdin)
typedef long long int lli;
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  //rf;
  //int t;
  //cin >> t;
  //while(t--){
    int n, i, j;
    cin >> n;
    int hrs[n], mins[n];
    for(i=0; i<n; ++i){
      cin >> hrs[i] >> mins[i];
    }
    int max = 1;
    int count = 0;
    for(i=0; i<n; ++i){
      count = 1;
      if(hrs[i] == -1 && mins[i] == -1){
        continue;
      }
      for(j=i+1; j<n; ++j){
        if(hrs[j]==hrs[i] && mins[j]==mins[i]){
          hrs[j] = -1;
          mins[j] = -1;
          count++;
          continue;
        }
        break;
      }
      if(count > max){
        max = count;
      }
    }
    cout << max << endl;
 // }

  return 0;
}
