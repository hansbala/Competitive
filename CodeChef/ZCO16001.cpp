/*
NAME: HANS BALA
ROLL: 11679
SCHOOL: LA MARTINIERE FOR BOYS, KOLKATA
*/
#include <bits/stdc++.h>
#define rf freopen("inp.in", "r", stdin)
typedef long long int ll;
using namespace std;

vector<ll> v[2];

int main(){
	rf;
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	ll i, j, temp, n, k;
	cin >> n >> k;
	for(i=0; i<2; ++i){
		for(j=0; j<n; ++j){
			cin >> temp;
			v[i].push_back(temp);
		}
	}
	sort(v[0].begin(), v[0].end());
	sort(v[1].begin(), v[1].end());
	ll result = v[0].back() + v[1].back();
	for(i=1; i<=k; ++i){
		result = min(result, max(v[0][n-1], v[1][n-1]) + max(v[0][i-1], v[1][n-i-1]));
		result = min(result, max(v[0][n-1], v[1][n-1]) + max(v[0][n-i-1], v[1][i-1]));
	}
	cout << result << endl;
}