/*
Container With Most Water

address: https://leetcode.com/problems/container-with-most-water/
*/

#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int water = 0;  // the area
        int i = 0;
        int j = height.size() - 1;
        int h; // the height of the container
        while(i < j) {
            h = min(height[i], height[j]);
            water = max(water, h * (j - i));
            // Since we have chosen the widest area,
            // the area will only be bigger 
            // when the height of the container is larger.
            while(height[i] <= h && i < j) i++;
            while(height[j] <= h && i < j) j--;
        }
        return water;
    }
};