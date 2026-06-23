class Solution {
    public boolean isAnagram(String s, String t) {
        // if (s.length() != t.length())
        //     return false;

        // HashMap<Character ,Integer> s1 = new HashMap<>();
        // HashMap<Character ,Integer> t1 = new HashMap<>();

        // for(char c:s.toCharArray()){
        //     s1.put(c,s1.getOrDefault(c,0)+1);
        // }

        // for(char c:t.toCharArray()){
        //     t1.put(c,t1.getOrDefault(c,0)+1);
        // }

        // return s1.equals(t1);

        //-----------------------------------------------------

        // HashMap<Character ,Integer> s1 = new HashMap<>();

        // for (char c : s.toCharArray()) {
        //     s1.put(c, s1.getOrDefault(c, 0) + 1);
        // }

        // for(char c : t.toCharArray()){
        //     if(!s1.containsKey(c))return false;
        //     s1.put(c,s1.get(c) - 1);
        //     if(s1.get(c) == 0)s1.remove(c);
        // }

        // return s1.isEmpty();  

        //---------------------------------------------------------

        // char[] arr1 = s.toCharArray();
        // Arrays.sort(arr1);


        // char[] arr2 = t.toCharArray();
        // Arrays.sort(arr2);


        // return Arrays.equals(arr1, arr2);

        //-------------------------------------------

        // int[] arr = new int[26];

        // for(int i=0;i<s.length();i++){
        //     arr[(s.charAt(i) - 'a')] += 1;
        // }

        // for(int i=0;i<t.length();i++){
        //     if(arr[(t.charAt(i) - 'a')] == 0)return false;
        //     arr[(t.charAt(i) - 'a')] -= 1;
        // }

        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] != 0)return false;
        // }

        // return true;


        if(s.length() != t.length()){
            return false;
        }

        int[] arr = new int[26];

        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i) - 'a'] += 1;
            arr[t.charAt(i) - 'a'] -= 1;
        }

        for(int val:arr){
            if(val != 0){
                return false;
            }
        }


        return true;


        

    }
}