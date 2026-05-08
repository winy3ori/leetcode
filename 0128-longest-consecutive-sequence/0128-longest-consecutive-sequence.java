class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums){
            set.add(n);
        }

        int maxCount = 0;

        for (int n : set){
            if (!set.contains(n-1)){

                int current = n+1;
                int count = 1;

                while(true){
                    if (!set.contains(current++)){
                        break;
                    }
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;        
    }
}