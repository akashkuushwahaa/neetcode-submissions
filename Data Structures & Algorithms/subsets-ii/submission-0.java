class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(int[] nums, int i, List<Integer> temp, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        backtrack(nums, i + 1, temp, res);

        int curr = temp.remove(temp.size() - 1);
        while (i < nums.length && nums[i] == curr) {
            i++;
        }

        backtrack(nums, i, temp, res);
    }
}