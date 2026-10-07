class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        int n=intervals.size();
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b) {
    if (a[0] == b[0])
        return a[1] > b[1];

    return a[0] < b[0];
});
        int first=intervals[0][0];
        int second=intervals[0][1];
        for (int i=1;i<intervals.size();i++){
            int ff=intervals[i][0];
            int se=intervals[i][1];
            if ((first<=ff)&&(second>=se)) n=n-1;
            else{
                first=ff;
                second=max(second,se);
            }
        }
        return n;
    }
};