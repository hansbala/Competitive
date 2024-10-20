# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        allPaths = []
        if root is None:
            return allPaths
        self.dfs(root, targetSum, root.val, [root.val], allPaths)
        return allPaths

    def dfs(self, node: Optional[TreeNode], targetSum: int, currSum: int, currPath: List[int], allPaths: List[List[int]]):
        if currSum == targetSum and node.left is None and node.right is None:
            allPaths.append(currPath)
        if node.left is not None:
            self.dfs(node.left, targetSum, currSum + node.left.val, currPath + [node.left.val], allPaths)
        if node.right is not None:
            self.dfs(node.right, targetSum, currSum + node.right.val, currPath + [node.right.val], allPaths)
        # leaf node with sum we do not want
        return
