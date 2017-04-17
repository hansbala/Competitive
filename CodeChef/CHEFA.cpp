#include <bits/stdc++.h>
typedef long long int lli;

using namespace std;

lli stones[100009];

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t, n;
	cin >> t;
	while(t--){
		cin >> n;
		for(int i=0; i<n; ++i){
			cin >> stones[i];
		}
		sort(stones, stones+n, greater<lli>());
		lli sum = 0;
		for(int i=0; i<n; i+=2){
			sum = sum + stones[i];
		}
		cout << sum << endl;
	}
	
	return 0;
}
	
	