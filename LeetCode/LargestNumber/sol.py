from functools import cmp_to_key

def sort_by_best(a, b):
    a = str(a)
    b = str(b)
    n = len(a)
    for idx in range(n):
        if idx >= len(a) or idx >= len(b):
            break
        a_digit = a[idx]
        b_digit = b[idx]
        if a_digit > b_digit:
            return 1
        elif a_digit < b_digit:
            return -1
        else:
            # continue to check other digits
            continue
    # [34321, 3432] => 343233432, 343234323
    first_combo = a + b
    second_combo = b + a
    if int(first_combo) > int(second_combo):
        return 1
    elif int(first_combo) < int(second_combo):
        return -1
    # equal for our purposes
    return 0

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        best_arrangement = self.sort_numbers(nums)
        ans = ""
        for num in best_arrangement:
            ans += str(num)
        return str(int(ans))

    def sort_numbers(self, nums):
        return sorted(nums, key=cmp_to_key(sort_by_best), reverse=True)
    

        
