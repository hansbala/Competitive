#include <bits/stdc++.h>
#define rf freopen("inp.in","r",stdin)
typedef long long int ll;
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  //rf;
  ll t, n, k, i;
  cin >> t;
  while(t--){
    ll max = 0;
    cin >> n >> k;
    ll A[n], B[n], C[n];
    for(i=0; i<n; ++i){
      cin >> A[i];
      C[i] = (ll) (k / A[i]);
    }
    for(i=0; i<n; ++i){
      cin >> B[i];
      C[i] = (ll) (C[i] * B[i]);
      if(C[i] > max){
        max  = C[i];
      }
    }
    cout << max << endl;
  }
  return 0;
}

