# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

'''
LeetCode address: https://leetcode.com/problems/linked-list-cycle/
'''

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow, fast = head, head
        while fast and fast.next:
            # fast.next != None ensures fast.next.next has no error
            slow = slow.next
            fast = fast.next.next
            # compare after change pointers
            if fast == slow:
                return True
        return False