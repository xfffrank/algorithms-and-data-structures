#include <iostream>


class BinaryTreeNode
{
public:
    BinaryTreeNode* leftChild;
    BinaryTreeNode* rightChild;
    BinaryTreeNode(int);
    int value;
    // ~BinaryTreeNode();
};

void PrintTree(BinaryTreeNode&);