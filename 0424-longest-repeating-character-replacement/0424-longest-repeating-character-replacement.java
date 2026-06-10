class Solution {
    public int characterReplacement(String s, int k) {

        int count[] = new int[26];

        int left = 0;
        int maxFreq = 0; //현재 윈도우에서 가장 많이 등장한 문자 개수
        int answer = 0;

        for (int right = 0; right < s.length(); right++){

            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
        
    }
}