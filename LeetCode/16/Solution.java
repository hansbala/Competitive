import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestSum = 0;
        int bestDiff = Integer.MAX_VALUE;
        List<Integer> listAns = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    int currSum = nums[i] + nums[j] + nums[mid];
                    if (currSum == target) {
                        return target;
                    } else if (currSum < target) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                    if (Math.abs(target - currSum) < bestDiff) {
                        bestDiff = Math.abs(target - currSum);
                        bestSum = currSum;
                        listAns = Arrays.asList(nums[i], nums[j], nums[mid]);
                    }
                }
            }
        }
        System.out.println(listAns);
        return bestSum;
    }
}
