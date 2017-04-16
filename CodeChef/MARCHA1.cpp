#include <bits/stdc++.h>
typedef long long int lli;
typedef long int li;

using namespace std;

int notes[21];

bool solver(int i, int m, int n){
	int flag=0, sum=0;
	for(int j=i; j<n; j++){
		sum = m - notes[j];
		if(sum==0){
			return true;
		}
		else if(sum > 0){
			flag = solver(j+1, sum, n);
			if(flag)
				return true;
		}
	}
	return false;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t=0, n=0, m=0;
	cin >> t;
	while(t--){
		cin >> n >> m;
		for(int i=0; i<n; i++){
			cin >> notes[i];
		}
		sort(notes, notes+n);
		bool flag = solver(0, m, n);
		if(flag){
			cout << "Yes" << endl;
		}
		else{
			cout << "No" << endl;
		}	
	}
	
	return 0;
}
	
	