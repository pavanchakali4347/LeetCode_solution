class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int mult = k;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == mult) {
                mult += k;
            } else if (nums[i] > mult) {
                break;
            }
            i++;
        }
        return mult;        
    }
}