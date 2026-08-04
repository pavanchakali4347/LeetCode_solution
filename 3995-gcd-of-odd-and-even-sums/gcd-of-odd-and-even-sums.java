class Solution {
    public int gcdOfOddEvenSums(int n) {
        List<Integer> Even = new ArrayList<>();
        List<Integer> Odd = new ArrayList<>();
        for(int i=1; i<=(2*n);i++){
            if(i%2==0){
                Even.add(i);
            }else{
                Odd.add(i);
            }
        }
         int sumOdd=0;
         int sumEven =0;
         for(int i:Even){
            sumEven+=i;
         }
         for(int i:Odd){
            sumOdd+=i;
         }
  return sumEven-sumOdd;
}}