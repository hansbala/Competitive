#include <bits/stdc++.h>
typedef long long int lli;
using namespace std;

int main(){
   	ios_base::sync_with_stdio(false);
   	cin.tie(NULL);
   	int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        string s;
        cin>>s;
        int a[n];
        for(int i = 0; i < n; i++){
            cin>>a[i];
        }
        int start, stop;
        int i = 0;
        int ans = 0;
        while(i < n){
            while(i<n && s[i] == '1'){i++;}
            if(i == n)break;
            start = i - 1;
            while(i < n && s[i] == '0'){i++;}
            stop = i;
            if(start == -1){
                ans += (a[stop] - a[0]);
            }else if(stop == n){
                ans += (a[n-1] - a[start]);
            }else{
                int maxi = 0;
                for(int j = start ; j < stop; j++){
                    maxi = max(maxi, a[j+1] - a[j]);
                }
                ans += (a[stop] - a[start] - maxi);
            }
        }
        cout<<ans <<endl;
    }
    return 0;
}	
