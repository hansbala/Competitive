class Solution {
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     // populate hashmap that is [num -> [<set of indexes the number exists>]]
    //     Map<Integer, Set<Integer>> hmap = new HashMap();
    //     for (int i = 0; i < nums.length; i++) {
    //         int currNum = nums[i];
    //         if (hmap.containsKey(currNum)) {
    //             Set<Integer> indexSet = hmap.get(currNum);
    //             indexSet.add(i);
    //         } else {
    //             Set<Integer> indexSet = new HashSet();
    //             indexSet.add(i);
    //             hmap.put(currNum, indexSet);
    //         }
    //     }
    //     System.out.println(hmap);


    //     Set<List<Integer>> answer = new HashSet();
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             for (int k = j + 1; k < nums.length; k++) {
    //                 int lookFor = target - (nums[i] + nums[j] + nums[k]);
    //                 if (!hmap.containsKey(lookFor)) {
    //                     continue;
    //                 }
    //                 Set<Integer> indexSet = hmap.get(lookFor);
    //                 // remove i, j, k temporarily
    //                 indexSet.remove(i);
    //                 indexSet.remove(j);
    //                 indexSet.remove(k);
    //                 if (indexSet.size() == 0) {
    //                     // no other distinct index exists so add back and continue
    //                     indexSet.add(i);
    //                     indexSet.add(j);
    //                     indexSet.add(k);
    //                     continue;
    //                 }
    //                 List<Integer> validQuad = Arrays.asList(
    //                     nums[i], nums[j], nums[k], lookFor
    //                 );
    //                 Collections.sort(validQuad);
    //                 answer.add(validQuad);
    //                 indexSet.add(i);
    //                 indexSet.add(j);
    //                 indexSet.add(k);
    //             }
    //         }
    //     }

    //     return new ArrayList(answer);
    // }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    long currSum = (long) nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (currSum == target) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]);
                        Collections.sort(quad);
                        ans.add(quad);
                        lo += 1;
                        hi -= 1;
                    } else if (currSum < target) {
                        lo += 1;
                    } else {
                        hi -= 1;
                    }
                }
            }
        }
        return new ArrayList(ans);
    }

    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     List<List<Integer>> quadruplets = new ArrayList<>();
    //     int n = nums.length;
    //     // Sorting the array
    //     Arrays.sort(nums);
    //     for (int i = 0; i < n - 3; i++) {
    //         // Skip duplicates
    //         if (i > 0 && nums[i] == nums[i - 1]) {
    //             continue;
    //         }
    //         for (int j = i + 1; j < n - 2; j++) {
    //             // Skip duplicates
    //             if (j > i + 1 && nums[j] == nums[j - 1]) {
    //                 continue;
    //             }
    //             int left = j + 1;
    //             int right = n - 1;
    //             while (left < right) {
    //                 long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
    //                 if (sum < target) {
    //                     left++;
    //                 } else if (sum > target) {
    //                     right--;
    //                 } else {
    //                     quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
    //                     // Skip duplicates
    //                     while (left < right && nums[left] == nums[left + 1]) {
    //                         left++;
    //                     }
    //                     while (left < right && nums[right] == nums[right - 1]) {
    //                         right--;
    //                     }
    //                     left++;
    //                     right--;
    //                 }
    //             }
    //         }
    //     }
    //     return quadruplets;
    // }
}
