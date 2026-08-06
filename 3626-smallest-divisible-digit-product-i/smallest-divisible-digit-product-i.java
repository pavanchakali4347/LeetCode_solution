class Solution {
    public int smallestNumber(int n, int t) {
         while(true){
            int temp=1;
            int num=n;
            while(num>0){
                temp*=(num%10);
                num/=10;
            }if(temp%t==0){
                return n;
            }
         n++;
         }
    }
}