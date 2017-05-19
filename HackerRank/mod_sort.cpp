#define rf freopen("inp.in","r",stdin)
#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

void sortArray(lli A[], lli n, lli k){
  for(int i=1; i<n; ++i){
    lli curr = A[i];
    int hole = i;
    while(hole > 0 && A[hole-1] % k > curr % k){
      A[hole] = A[hole-1];
      hole--;
    }
    A[hole] = curr;
  }
}
int main(){
  ios_base::sync_with_stdio(false);
  rf;
  cin.tie(NULL);
  lli n, k;
  cin >> n >> k;
  lli A[n];
  for(int i=0; i<n; ++i){
    cin >> A[i];
  }
  sortArray(A, n, k);
  for(int i=0; i<n; ++i){
    cout << A[i] << " ";
  }
  cout << endl;
  
  return 0;
}
