//
//  main.cpp
//  颜色分类
//
//  Created by 罗贤甫 on 2020/10/7.
//

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int> a;
        vector<int> b;
        vector<int> c;
        for (int i=0; i<nums.size(); i++) {
            if(nums[i]==0){
                a.push_back(nums[i]);
            }else if(nums[i]==1){
                b.push_back(nums[i]);
            }else{
                c.push_back(nums[i]);
            }
        }
        for (int i=0; i<a.size(); i++) {
            nums[i]=a[i];
        }
        for (int i=a.size(); i<a.size()+b.size(); i++) {
            nums[i]=b[i-a.size()];
        }
        for (int i=a.size()+b.size(); i<nums.size(); i++) {
            nums[i]=c[i-a.size()-b.size()];
        }
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
