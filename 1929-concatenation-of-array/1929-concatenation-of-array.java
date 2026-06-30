class Solution {
    public int[] getConcatenation(int[] nums) {
        int dow = nums.length;
        int [] ans = new int[2*nums.length];


        for (int i= 0; i<nums.length; i++){
            ans[i] = nums[i];
            ans[i+dow]=nums[i];
        }

        return ans;
    }
}