//
//  main.cpp
//  树中距离之和
//
//  Created by 罗贤甫 on 2020/10/6.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> ans;// return result
    vector<vector<int>> Graph;
    int num;
    vector<int> cnt;
    void dfs1(int child, int parent){
        for (int i=0; i<Graph[child].size(); i++) {
            if (Graph[child][i]!=parent) {
                dfs1(Graph[child][i], child);
                //cout <<Graph[child][i]<<cnt.size()<<endl;
                cnt[child]+=cnt[Graph[child][i]];
                ans[child]+=ans[Graph[child][i]]+cnt[Graph[child][i]];
            }
        }
    }
    void dfs2(int child, int parent){
        for (int i=0; i<Graph[child].size(); i++) {
            if (Graph[child][i]!=parent) {
                ans[Graph[child][i]] = ans[child]-cnt[Graph[child][i]]+num-cnt[Graph[child][i]];
                dfs2(Graph[child][i], child);
            }
        }
    }
    vector<int> sumOfDistancesInTree(int N, vector<vector<int>>& edges) {
        Graph= vector<vector<int>>(N);
        num=N;
        ans = vector<int>(N);
        cnt = vector<int>(N);
        for (auto &i : cnt) {
            i=1;
        }//cout << cnt[1]<<cnt.size();
        for (auto i :edges) {  // initialize Graph
            Graph[i[0]].push_back(i[1]);
            Graph[i[1]].push_back(i[0]);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }
};
int main(int argc, const char * argv[]) {
    Solution s;
    vector<vector<int>> edges{{0,1},{0,2},{2,3},{2,4},{2,5}};
    s.sumOfDistancesInTree(6, edges);
    for (auto &i : s.ans) {
        cout << i<<" ";
    }cout<<endl;
    return 0;
}
