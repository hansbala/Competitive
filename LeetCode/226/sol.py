# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.invert(root)
        return root
    def invert(self, node):
        if node is None:
            return
        if node.left is not None and node.right is not None:
            temp = node.left
            node.left = node.right
            node.right = temp
        elif node.left is not None:
            node.right = node.left
            node.left = None
        elif node.right is not None:
            node.left = node.right
            node.right = None
        self.invert(node.left)
        self.invert(node.right)
