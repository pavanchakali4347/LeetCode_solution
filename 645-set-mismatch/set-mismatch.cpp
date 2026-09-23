class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector <int> v1;
        unordered_map <int, int> m1;
        for (auto k: nums){
            m1[k]++;
        }
        for (auto each: m1){
            if (each.second==2){
                v1.push_back(each.first);
            }
        }
        int sum=0;
        for (int i=1;i<=nums.size();i++){
            sum=sum+i;
        }
        for (int i=0;i<nums.size();i++){
            sum=sum-nums[i];
        }
        v1.push_back(sum+v1[0]);
        return v1;
    }
};