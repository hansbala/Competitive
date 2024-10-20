# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        return self.dfs(root, targetSum, root.val)
    
    def dfs(self, node: Optional[TreeNode], targetSum: int, currSum: int) -> bool:
        if currSum == targetSum and node.left is None and node.right is None:
            return True
        if node.left is not None and node.right is not None:
            return self.dfs(node.left, targetSum, currSum + node.left.val) or \
                self.dfs(node.right, targetSum, currSum + node.right.val)
        if node.left is not None:
            return self.dfs(node.left, targetSum, currSum + node.left.val)
        if node.right is not None:
            return self.dfs(node.right, targetSum, currSum + node.right.val)
        return False
