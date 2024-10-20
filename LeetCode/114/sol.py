# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return
        preorder = self.preorder(root)
        for idx, node in enumerate(preorder):
            if idx < len(preorder) - 1:
                node.right = preorder[idx + 1]
            node.left = None
        preorder[-1].left = None
    
    def preorder(self, node):
        res = []
        if node is None:
            return []
        res.append(node)
        res += self.preorder(node.left)
        res += self.preorder(node.right)
        return res
