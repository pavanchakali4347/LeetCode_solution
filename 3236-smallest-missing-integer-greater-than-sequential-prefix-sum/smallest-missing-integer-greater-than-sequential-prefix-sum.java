class Solution{
    public int missingInteger(int[] nums){
      int Prefixsum=nums[0];
      int n=nums.length;
      for(int i=1;i<n;i++){
        if(nums[i] == nums[i - 1] + 1){
            Prefixsum+=nums[i];
        }
        else{
            break;
        }
      }
     while(true){
            boolean found = false;
            for(int i=0;i<n;i++){
                if(nums[i]== Prefixsum){
                    found = true;
                    break;
                }
            }
            if(!found)
                return Prefixsum;
            Prefixsum++;
        }
} }