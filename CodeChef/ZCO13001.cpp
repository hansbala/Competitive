#include <bits/stdc++.h>
typedef long long int lli;
typedef long long ll;
using namespace std;

ll n;
ll str[200000];
ll diff[200000];


int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	for(int i=0; i<n; i++){
		cin >> str[i];
	}
	sort(str, str+n);
	diff[0]=str[0];
	for(int i=1; i<n; i++){
		diff[i]=str[i]-str[i-1];
	}
	lli sum=0;
	lli add=0;
	
	for(int i=0; i<n; i++){
		add = add+str[i];
	}
	for(int i=0; i<n; i++){
		add = add-(diff[i]*(n-i));
		sum = sum + add;
	}
	cout << sum;
	
	return 0;
}
	
	