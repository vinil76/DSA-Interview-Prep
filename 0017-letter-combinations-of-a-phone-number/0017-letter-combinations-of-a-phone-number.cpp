class Solution {
public:
void combi(int index,string digits,string temp,vector<string>& ans,unordered_map<char,string>map){
        if(index==digits.size()){
            ans.push_back(temp);
            return;
        }
        for(char c: map[digits[index]])
        {
            temp.push_back(c);
            combi(index+1,digits,temp,ans,map);
            temp.pop_back();
        }
    }
    vector<string> letterCombinations(string digits) {
        if(digits=="") return { };
        unordered_map<char,string>map={{'2',"abc"},{'3',"def"},{'4',"ghi"},{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"}
        ,{'9',"wxyz"}};
        vector<string>ans;
        combi(0,digits,"",ans,map);
        return ans;        
    }
};