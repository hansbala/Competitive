import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Integer>> hmap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (hmap.containsKey(currNum)) {
                Set<Integer> indices = hmap.get(currNum);
                indices.add(i);
            } else {
                Set<Integer> indexSet = new HashSet<Integer>();
                indexSet.add(i);
                hmap.put(currNum, indexSet);
            }
        }
        // System.out.println(hmap);

        Set<List<Integer>> ans = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // System.out.println(nums[i] + " " + nums[j]);
                int lookFor = 0 - (nums[i] + nums[j]);
                if (!hmap.containsKey(lookFor)) {
                    continue;
                }
                Set<Integer> indexSet = hmap.get(lookFor);
                if (indexSet.size() <= 2 && (indexSet.contains(i) || indexSet.contains(j))) {
                    continue;
                }
                // System.out.println(nums[i] + " " + nums[j]);
                // System.out.println(i + " " + j);
                // System.out.println(indexSet);
                // System.out.println("------------");
                List<Integer> tuple = Arrays.asList(nums[i], nums[j], lookFor);
                Collections.sort(tuple);
                ans.add(tuple);
            }
        }
        return new ArrayList(ans);
    }
}
