#include <bits/stdc++.h>
typedef long long int lli;
typedef long int li;
using namespace std;

int main(){

  int t=0,g,i=0,n,q,j,r;
	cin >> t;
  while(t--){
    cin >> g;
    while(g--){
      cin >> i >> n >> q;
      if(n%2){
        if(i==q)
        	r=n/2;
        else 
        	r=n/2+1;
    	}
      else 
      	r=n/2;
      cout << r << endl;
  	}
  }
  
  return 0;
} 	
	