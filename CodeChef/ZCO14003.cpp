#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	lli max=0;
	cin >> n;
	lli pri[n];
	for(int i=0; i<n; ++i){
		cin >> pri[i];
	}
	sort(pri, pri+n);
	for(int i=(n-1); i>=0; --i){
		if(pri[i]*(n-i) > max){
			max = pri[i]*(n-i);
		}
	}
	cout << max << endl;	
	
	return 0;
}
	
	