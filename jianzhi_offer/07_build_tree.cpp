#include <iostream>
#include <vector>
#include "utilities/BinaryTree.h"
using namespace std;

BinaryTreeNode* BuildCore(int* start_pre, int* end_pre, int* start_in, int* end_in);

BinaryTreeNode* BuildTree(int *preorder, int* inorder, int length) {
    if (preorder == nullptr || inorder == nullptr || length <= 0)
        return nullptr;
    return BuildCore(preorder, preorder + length - 1, inorder, inorder + length - 1);
}

BinaryTreeNode* BuildCore(int* start_pre, int* end_pre, int* start_in, int* end_in) {
    int root_value = start_pre[0];
    BinaryTreeNode* root = new BinaryTreeNode(root_value);

    // no child
    if (start_pre == end_pre) {
        if (start_in == end_in && *start_pre == *start_in) {
            return root;
        } else {
            throw "Invalid input";
        }
    }

    // locate the root in the sequence of in-order
    int* root_in = start_in;
    while(root_in <= end_in && *root_in != root_value)
        ++ root_in;

    // check invalid values
    if (root_in == end_in && *root_in != root_value)
        throw "Invalid input";
    int left_tree_len = root_in - start_in;
    int* left_pre_end = start_pre + left_tree_len;

    // build left sub-tree
    if (left_tree_len > 0) {
        root -> leftChild = BuildCore(start_pre + 1, left_pre_end, start_in, root_in - 1);
    }
    if (left_tree_len < end_pre - start_pre) {
        root -> rightChild = BuildCore(left_pre_end + 1, end_pre, root_in + 1, end_in);
    }
    return root;
}

void Test
(string test_name, int *preorder, int* inorder, int length) {
    printf("%s begins:\n", test_name.c_str());
    printf("The preorder sequence is: ");
    for(int i = 0; i < length; ++ i)
        printf("%d ", preorder[i]);
    printf("\n");

    printf("The inorder sequence is: ");
    for(int i = 0; i < length; ++ i)
        printf("%d ", inorder[i]);
    printf("\n");

    try {
        BinaryTreeNode* root = BuildTree(preorder, inorder, length);
        PrintTree(*root);
    } catch(exception& exception) {
        printf("Invalid input.\n");
    }
}

void Test1() {
    const int length = 8;
    int preorder[length] = {1, 2, 4, 7, 3, 5, 6, 8};
    int inorder[length] = {4, 7, 2, 1, 5, 3, 8, 6};

    Test("Test1", preorder, inorder, length);
}

int main() {
    Test1();
    
    // vector<int> g1; 
    // for (int i = 1; i <= 5; i++) 
    //     g1.push_back(i); 
  
    // cout << "Output of begin and end: "; 
    // for (auto i = g1.begin(); i != g1.end(); ++i) 
    //     cout << *i << " ";


    return 0;
}

