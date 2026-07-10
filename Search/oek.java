package Search;

class Solution {
    public int findPeakElement(int[] nums) {
        int[] arr = {1,2,3,4,5};
        int n = nums.length;
        int st = 0;
        int end = n - 1;
        int mid = st + (end - st)/2;
        
        while(st<end){
            mid = st + (end - st)/2;

            if(nums[mid]<nums[mid+1]){
                st = mid + 1;
            }

            else {
                end = mid ; 
            }
        }

        return st;
    }
}
