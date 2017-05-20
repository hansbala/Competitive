//http://codeforces.com/problemset/problem/797/A

#include <bits/stdc++.h>
#define rf freopen("inp.in","r",stdin)
typedef long long int lli;
using namespace std;

bool isPrime(int num){
  int sq = floor(sqrt(num));
  if(num == 1){
    return false;
  }
  else if(num == 2 || num == 3){
    return true;
  }
  else{
    for(int i=3; i<=sq; i+=2){
      if(num % i == 0){
        return false;
      }
    }
  }
  return true;
}
int getNextPrime(int num){
  num++;
  while(true){
    if(isPrime(num)){
      return num;
    }
    else{
      num++;
    }
  }
}
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  rf;
  int t;
  cin >> t;
  while(t--){
    string res="";
    int n, k, fact=2;
    bool flag = false;
    cin >> n >> k;
    while(--k){
      if(isPrime(n) && k>0){
        flag = true;
        res = "-1";
        break;
      }
      else{
        if(n % fact != 0){
          fact = getNextPrime(fact);
          k++;
          continue;
        }
        else{
          res += (fact + " ");
          n /= fact;
        }
      }
    }
    if(res == "-1"){
      cout << -1 << endl;
    }
    else{
      if(n > 0){
        res += (n + " ");
      }
      cout << res << endl;
    }
  }
  return 0;
}
