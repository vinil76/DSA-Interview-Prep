class Solution {
    public final String[] m = {
        "", "",
        "abc", "def", "ghi",
        "jkl", "mno", "pqrs",
        "tuv", "wxyz"
    };
    public void f(int index,String digits,StringBuilder sb,List<String> ans){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String s = m[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {

        sb.append(s.charAt(i));

        f(index + 1, digits, sb, ans);

        sb.deleteCharAt(sb.length() - 1); 
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        
        f(0,digits,new StringBuilder(),ans);

        return ans;        
    }
}