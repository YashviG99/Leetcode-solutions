class Solution {
    public int findDuplicate(int[] nums) {

    int ans;
    Arrays.sort(nums);

        for (int i = 0; i<nums.length;i++){
           if(nums[i] == nums[i+1] ){
             return nums[i];
            }
        }
        return -1;
    }
}