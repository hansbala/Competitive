#include <bits/stdc++.h>
#define rf freopen("inp.in","r",stdin)
typedef long long int lli;
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  //rf;
  int n;
  cin >> n;
  string A[n];
  for(int i=0; i<n; ++i){
    cin >> A[i];
  }
  int keys[n];
  for(int i=n-1; i>=0; --i){
    int count = 0;
    for(int j=i-1; j>=0; --j){
      if(A[i].compare(A[j]) > 0){
        count++;
      }
    }
    keys[i] = count;
  }
  for(int i=0; i<n; ++i){
    cout << keys[i] << endl;
  }

  return 0;
}
