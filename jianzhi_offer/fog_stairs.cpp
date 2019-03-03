#include <iostream>
#include<vector>
using namespace std;

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法。
// reference: https://github.com/imhuay/Algorithm_Interview_Notes-Chinese/blob/master/C-%E7%AE%97%E6%B3%95/%E9%A2%98%E8%A7%A3-%E5%89%91%E6%8C%87Offer.md#103-%E5%8F%98%E6%80%81%E8%B7%B3%E5%8F%B0%E9%98%B6%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92

int jump(int number) {
    // 初始化数组，初始值设为1
    // dp[n] = dp[1] + dp[2] + dp[n - 1]
    vector<int> dp(number + 1, 1);
    for (int i = 2; i < number + 1; i++) {
        for (int j = 1; j < i; j++) {
            dp[i] += dp[j];
        }
    }
    return dp[number];
}

int main() {
    int number = 3;
    cout << "number of stairs: " << number << endl;
    int result = jump(number);
    cout << "result: " << result; 

    return 0;
}