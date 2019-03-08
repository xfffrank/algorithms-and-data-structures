# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

'''
LeetCode address: https://leetcode.com/problems/linked-list-cycle-ii/
'''

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        fast, slow = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if fast == slow:
                cross = fast
                temp = head
                del fast, slow
                while True:
                    if cross == temp:
                        return cross
                    cross = cross.next
                    temp = temp.next
        return None