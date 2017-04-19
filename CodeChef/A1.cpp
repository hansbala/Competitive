#include <bits/stdc++.h>
using namespace std;

bool foo(int arr[], int m, int ind, int size){
	if(ind == size-1){
		return (arr[ind]== m || m==0);
	}
	return foo(arr, m, ind+1, size) || foo(arr, m-arr[ind], ind+1, size);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	cin >> t;
	while(t--){
		int m, n;
		cin >> n >> m;
		int arr[n];
		for(int i=0; i<n; ++i){
			cin >> arr[i];
		}
		if(foo(arr, m, 0, n)){
			cout << "Yes" << endl;
		}
		else{
			cout << "No" << endl;
		}
	}	
	return 0;
}
	
	