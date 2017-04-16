#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

lli nums[65009];

int binSearch(int start, lli end, lli key, lli k){
	lli reqd = key - k;
	for(int i=start; i<end; ++i){
		if(nums[i] <= reqd){
			return i;
		}
	}
	return -1;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	lli n, k, cnt=0LL;
	cin >> n >> k;
	for(int i=0; i<n; ++i){
		cin >> nums[i];
	}
	sort(nums, nums+n, greater<lli>());
	for(int i=0; i<(n-1); ++i){
		int pos = binSearch(i+1, n, nums[i], k);
		if(pos == -1){
			continue;
		}
		cnt += (n-pos);
	}
	cout << cnt << endl;
	
	return 0;
}
	
	