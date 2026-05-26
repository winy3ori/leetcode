class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right){

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            } else if (nums[mid] <= nums[right]){
                right = mid;
            }

        }

        return nums[right];
        
    }
}

        
// 4 5 6 7 0 1 2
//       _     _
//           _ _
//         _ _
//         _ 