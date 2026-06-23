class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Character> p = new HashMap<>();
        Map<Character,Character> q = new HashMap<>();
        int r = 0;

        while(r < s.length()){
            char s1 = s.charAt(r);
            char s2 = t.charAt(r);

            if(p.containsKey(s1)){
                if(p.get(s1) != s2){
                    return false;
                }
            }else{
                p.put(s1,s2);
            }

            if(q.containsKey(s2)){
                if(q.get(s2) != s1){
                    return false;
                }
            }else{
                q.put(s2,s1);
            }

            r++;
        }

        return true;
    }
}