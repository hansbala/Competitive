#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL);
typedef long long ll;
using namespace std;

int main(){
	fastio
	int n;
	cin >> n;
	int A[n];
	int max1=0, ans=0, pos=-1;
	for(int i=0; i<n; ++i){
		cin >> A[i];
		if(A[i] == 1){
			max1++;
		} else{
			max1--;
		}
		if(max1 > ans){
			ans = max1;
			pos = i+1;
		}
	}
	cout << ans << " " << pos << " ";
	max1=0, ans=0, pos=-1;
	int foo=0, ans2=0, pos2=-1;
	for(int i=0; i<n; ++i){
		if(A[i] == 1){
			max1++;
		} else{
			max1--;
		}
		if(A[i] == 1 && max1 == 1){
			foo=1;
			int bar=0;
			for(int j=(i+1); j<n; ++j){
				if(A[j] == 1){
					bar++;
				}
				else{
					bar--;
				}
				if(bar == -1){
					foo++;
					break;
				}
				foo++;
			}
			if(foo > ans2){
				ans2 = foo;
				pos2 = i+1;
			}
		}
	}
	cout << ans2 << " " << pos2 << endl;
	return 0;
}