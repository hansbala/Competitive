#include <bits/stdc++.h>

using namespace std;

bool check(int r, int x1, int y1, int x2, int y2){
	if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<=r*r)
		return true;
	else
		return false;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t,r,x1,y1,x2,y2,x3,y3,cnt=0;
	cin >> t;
	while(t--){
		cnt = 0;
		cin >> r >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
		if(check(r,x1,y1,x2,y2))
			cnt++;
		if(check(r,x2,y2,x3,y3))
			cnt++;
		if(check(r,x3,y3,x1,y1))
			cnt++;
		if(cnt>=2)
			cout<<"yes"<<endl;
		else
			cout<<"no"<<endl;
	}
	
	return 0;
}
	
	