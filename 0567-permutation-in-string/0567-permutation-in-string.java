class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Cnt = new int[26];
        int[] winCnt = new int[26];
        int winSize = s1.length();

        for (int i = 0; i < winSize; i++){
            s1Cnt[s1.charAt(i) - 'a']++;
            winCnt[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Cnt, winCnt)) return true;

        for (int right = winSize; right < s2.length(); right++){
            winCnt[s2.charAt(right) - 'a']++;

            int left = right - winSize;
            winCnt[s2.charAt(left) - 'a']--;

            if (Arrays.equals(s1Cnt, winCnt)) return true;
        }

        return false;

    }
}