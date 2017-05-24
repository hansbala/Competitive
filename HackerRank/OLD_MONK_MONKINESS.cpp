// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-old-monk/
#include <bits/stdc++.h>
#define rf freopen("inp.in", "r", stdin)
typedef long long int ll;
using namespace std;

ll A[2][100009];
ll n;

int foo(ll key, ll lower, ll upper){
	ll ans = lower;
	while(lower <= upper){
		ll mid = (lower + upper) >> 1;
		if(A[1][mid] >= key){
			ans = mid;
			lower = mid+1;
		} else{
			upper = mid-1;
		}
	}
	return ans;
}	
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	ll t;
	cin >> t;
	while(t--){
		cin >> n;
		for(ll i=0; i<2; i++){
			for(ll j=0; j<n; j++){
				cin >> A[i][j];
			}
		}
		ll max1 = 0;
		for(ll i=0; i<n; i++){
			max1 = max(max1, foo(A[0][i], i, n-1) - i);
		}
		cout << max1 << endl;
	}
	return 0;
}