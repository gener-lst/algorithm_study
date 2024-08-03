package ch01.Demical;

public class Solution {
    public int solution(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j ++) {
                for(int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) count++;
                }
            }
        }
        return  count;
    }

    public boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i ==0) return false;
        }
        return true;
    }
}
