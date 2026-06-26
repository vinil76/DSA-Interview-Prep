class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5)return false;

        Map<Integer,Integer> m = new HashMap<>();

        for(int val: bills){
            if(val == 5){
                m.put(val,m.getOrDefault(val,0) + 1);
            }else if(val == 10){
                if(m.getOrDefault(5,0) >= 1){
                    m.put(val,m.getOrDefault(val,0) + 1);
                    m.put(5,m.getOrDefault(5,0) - 1);
                }else{
                    return false;
                }
            }else{
                if(m.getOrDefault(10,0) >= 1 && m.getOrDefault(5,0) >= 1){
                    m.put(val,m.getOrDefault(val,0) + 1);
                    m.put(5,m.getOrDefault(5,0) - 1);
                    m.put(10,m.getOrDefault(10,0) - 1);
                }else if(m.getOrDefault(5,0) >= 3){
                    m.put(val,m.getOrDefault(val,0) + 1);
                    m.put(5,m.getOrDefault(5,0) - 3);                    
                }else{
                    return false;
                }
            }
        }

        return true;        
    }
}