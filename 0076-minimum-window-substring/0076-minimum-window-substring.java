class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] tCnt = new int[128];
        int[] sCnt = new int[128];
        for (char c : t.toCharArray()){
            tCnt[c]++;
        }

        int req = 0;
        for (int c : tCnt){
            if (c > 0) req++;
        }

        int left = 0;
        int formed = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++){

            char rChar = s.charAt(right);
            sCnt[rChar]++;

            if (tCnt[rChar] > 0 && sCnt[rChar] == tCnt[rChar]){
                formed++;
            }

            while (formed == req){

                int curLen = right - left + 1;
                if (curLen < minLen){
                    minLen = curLen;
                    start = left;
                }

                char lChar = s.charAt(left);
                sCnt[lChar]--;

                if (tCnt[lChar] > 0 && sCnt[lChar] < tCnt[lChar]){
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);

    }
}