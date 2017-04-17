#include <bits/stdc++.h>

using namespace std;

int main(){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		int a[n];
		for (int i = 0; i < n; ++i){
			cin>>a[i];
		}
		sort(a,a+n);
		long long ans=0;
		for (int i = 1; i < n; ++i){
			ans+=(long long)a[i];
		}
		ans*=(long long)a[0];
		printf("%lld\n",ans );
	}
	return 0;
} 
	