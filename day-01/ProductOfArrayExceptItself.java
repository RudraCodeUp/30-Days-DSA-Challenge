import java.util.*;
// Approach: Prefix and Suffix Products

class Solution {
    public int[] productExceptSelf(int[] nums) {
       int len=nums.length;
       int[] answer=new int[len];
       answer[0]=1;

       for(int i=1;i<len;i++){
        answer[i]=answer[i-1]*nums[i-1];
       }
       int suffix=1;
       for(int i=len-1;i>=0;i--){
        answer[i]=answer[i]*suffix;
        suffix=suffix*nums[i];
       }
return answer;

    }
}