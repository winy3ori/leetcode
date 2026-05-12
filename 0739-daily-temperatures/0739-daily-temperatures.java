class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            while(!dq.isEmpty() && temperatures[i] > temperatures[dq.peek()]){
                int prev = dq.pop();
                result[prev] = i - prev;
            }
            dq.push(i);
        }
        return result;
    }
}

// 73 71 75 76
// 0  1  2  3