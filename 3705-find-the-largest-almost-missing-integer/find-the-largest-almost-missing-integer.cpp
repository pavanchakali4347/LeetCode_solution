class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
      int n=nums.size();
      int ans=-1;
      if (k==n) return *max_element(nums.begin(),nums.end());
      unordered_map <int,int> m1;
      for (int i=0;i<=n-k;i++){
        for (int j=i;j<i+k;j++){
            m1[nums[j]]++;
        }
      }
      for (auto kk:m1){
        if (kk.second==1){
            if (kk.first>ans) ans=kk.first;
        }
      }
      return ans; 
    }
};