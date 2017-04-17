#include <bits/stdc++.h>

using namespace std;

int data[1000][3];

int solver(int cnt){
	int wait=0, res=0, timer=0, total=0;
	for(int i=0; i<cnt; ++i){
		res = data[i][0];
		while(res < total){
			res = res + data[i][2];
		}
		wait = res - total;
		timer = data[i][1];
		total = total + wait + timer;
	}
	return total;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t,cnt;
	cin >> t;
	while(t--){
		cin >> cnt;
		for(int i=0; i<cnt; ++i){
			cin >> data[i][0] >> data[i][1] >> data[i][2];
		}
		int sum = solver(cnt);
		cout << sum << endl;
	}
	
	return 0;
}
	
	