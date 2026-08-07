class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] counter = new int[nums.length];
        List<Integer> list = new ArrayList<>();

        solve(nums, counter, res, list);

        return res;
    }

    public void solve(int[] nums, int[] counter,
                      List<List<Integer>> res,
                      List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (counter[i] == 0) {

                list.add(nums[i]);
                counter[i]++;

                solve(nums, counter, res, list);

                counter[i]--;
                list.remove(list.size() - 1);
            }
        }
    }
}