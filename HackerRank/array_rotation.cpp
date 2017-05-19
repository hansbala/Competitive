#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

int main(){
  int t, i, n, k;
  scanf("%d", &t);
  while(t--){
    scanf("%d %d", &n, &k);
    k = k % n;
    int A[n];
    for(i=0; i<n; ++i){
      scanf("%d", &A[i]);
    }
    for(i=n-k; i<n; ++i){
      printf("%d ", A[i]);
    }
    for(i=0; i<n-k; ++i){
      printf("%d ", A[i]);
    }
    printf("\n");
  }
  return 0;
}
