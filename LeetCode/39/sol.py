class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        self.findSolution(candidates, target, [], res)
        return res
    def findSolution(self, candidates, target, currCombo, res):
        if target < 0:
            return
        if target == 0:
            currCombo.sort()
            if currCombo not in res:
                res.append(currCombo)
            return
        for candidate in candidates:
            self.findSolution(candidates, target - candidate, currCombo + [candidate], res)
        
