from collections import deque
class Solution:
    def __init__(self):
        self.combosToValidity = {}

    def isValid(self, combo):
        if combo in self.combosToValidity:
            return self.combosToValidity[combo]
        stack = deque([])
        for ch in combo:
            if ch == '(':
                stack.append(1)
            elif ch == ')':
                if len(stack) == 0:
                    self.combosToValidity[combo] = False
                    return False
                stack.pop()
        self.combosToValidity[combo] = len(stack) == 0
        return self.combosToValidity[combo]

    def removeInvalidParentheses(self, s: str) -> List[str]:
        if self.isValid(s):
            return [s]
        # [(validCombo, numRemovals)]
        all_possibles = []
        possibles = self.getPossibles(s, 0, all_possibles)
        minRemovals = float('inf')
        for possible in possibles:
            _, removals = possible
            minRemovals = min(minRemovals, removals)
        ans = set()
        for possible in possibles:
            seq, removals = possible
            if removals == minRemovals:
                ans.add(seq)
        return ans
    
    def getPossibles(self, combo, numRemovals, possibles):
        if self.isValid(combo):
            possibles.append((combo, numRemovals))
            return
        for i, ch in enumerate(combo):
            if not (ch == '(' or ch == ')'):
                continue
            possible = combo[ : i] + combo[i + 1 : ]
            self.getPossibles(possible, numRemovals + 1, possibles)
        return possibles


