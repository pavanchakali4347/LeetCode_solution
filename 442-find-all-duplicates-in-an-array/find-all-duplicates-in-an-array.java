class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> num = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i <nums.length-1;i++){
            if(nums[i]==nums[i+1]){
            num.add(nums[i]);
        }
        }
        return num;
        
    }
}