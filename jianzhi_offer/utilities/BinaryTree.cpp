#include "BinaryTree.h"
using namespace std;

BinaryTreeNode::BinaryTreeNode(int root) {
    value = root;
    leftChild = nullptr;
    rightChild = nullptr;
}

void PrintTree(BinaryTreeNode& root) {
    cout << root.value << ' ';
    if (root.leftChild != nullptr)
        PrintTree(*root.leftChild);
    if (root.rightChild != nullptr)
        PrintTree(*root.rightChild);
}