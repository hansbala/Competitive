#include <bits/stdc++.h>
using namespace std;
typedef long long int lli;

const int N = 1000009;
int A[N];
int pos, n, k, curr;
lli c=0;

int findIndex(int index){
  int look = k - curr;
  for(int i=(index+1); i<n; ++i){
    if(A[i] >= look){
      return i;
    }
  }
  return n;
}

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> k;
  for(int i=0; i<n; ++i){
    cin >> A[i];
  }
  sort(A, A+n);
  for(int i=0; i<n-1; ++i){
    curr = A[i];
    pos = findIndex(i);
    c += (pos - i - 1);
  }
  cout << c << endl;
  
  return 0;
}