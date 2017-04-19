#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
	  cin.tie(NULL);
    int t;
    cin >> t;
    while(t--){
        int a = 103993, b = 33102, k, r=0;
        cin >> k;
        for(int i=0; i<=k; i++){
            if(i==1){
                cout << '.';
            }
            cout << (a/b);
            r = a % b;
            a = r * 10;
        }
        cout << endl;
    }
    return 0;
}
