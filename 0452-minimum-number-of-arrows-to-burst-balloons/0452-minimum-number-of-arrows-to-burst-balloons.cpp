class Solution {
public:
    bool static compare(const vector<int>&a,const vector<int>&b){
        return a[1] < b[1];
    } 
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(),points.end(),compare);

        int last_arrow = points[0][1];
        int total_arrow = 1;

        for(int i=1;i<points.size();i++){
            if(points[i][0] > last_arrow){
                total_arrow = total_arrow + 1;
                last_arrow = points[i][1];
            }
        }
        return total_arrow;
    }
};
