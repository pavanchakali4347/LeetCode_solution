class Solution {
public:
    int longestWPI(vector<int>& hours) {
        int ans=0;
        vector <int> v1;
        for (int i=0;i<hours.size();i++){
            if (hours[i]>8) v1.push_back(1);
            else{
                v1.push_back(-1);
            }
        }
        for (int i=0;i<hours.size();i++){
            int sum=0;
            for (int j=i;j<hours.size();j++){
                sum=sum+v1[j];
                if (sum > 0)
                    ans = max(ans, j - i + 1);            }
        }
        return ans;
    }
};