#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int c=0, p, q, t, n, i, j;
  cin >> t;
  while(t--){
    c=0;
    cin >> n;
    int A[n][n];
    for(i=0; i<n; ++i){
      for(j=0; j<n; ++j){
        cin >> A[i][j];
      }
    }
    for(i=0; i<n; ++i){
      for(j=0; j<n; ++j){
        for(p=0; p<n; ++p){
          for(q=0; q<n; ++q){
            if((A[i][j] > A[p][q]) && (i <= p) && (j <= q)){
              c++;
            }
          }
        }
      }
    }
    cout << c << endl;
  }
  return 0;
}
