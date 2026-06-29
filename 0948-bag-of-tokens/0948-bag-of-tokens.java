class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int max_score = 0;

        while(left <= right){
            if(tokens[left] <= power){
                power -= tokens[left++];
                score += 1;
                max_score = Math.max(max_score,score);
            }else if(score > 0){
                power += tokens[right--];
                score -= 1;
            }else{
                break;
            }
        }

        return max_score;
    }
}