package algorithm;

import java.util.*;

public class Problem30T60 {

    // 30. Substring with Concatenation of All Words
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        if (words.length <= 0) return rst;
        int len = words[0].length(), num = words.length;
        for (int i = 0; i <= s.length() - len *  num; ++i) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (count.containsKey(word)) {
                    if (seen.getOrDefault(word, 0) >= count.get(word)) {
                        break;
                    }
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    j++;
                } else {
                    break;
                }
            }
            if (j == num) {
                rst.add(i);
            }
        }
        return rst;
    }

    // 31. Next Permutation
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i >= 0) {
            int k = nums.length - 1;
            while (k > i && nums[k] <= nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int v = nums[i];
        nums[i] = nums[j];
        nums[j] = v;
    }

    public void reverse(int[] nums, int l, int h) {
        while (l < h) {
            swap(nums, l, h);
            l++;
            h--;
        }
    }

    // 32. Longest Valid Parentheses
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int i = 0;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                int index = stack.peek();
                if (index != -1 && s.charAt(index) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        int mx = 0;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            mx = Math.max(mx, i - index - 1);
            i = index;
        }
        return mx;
    }

    // 33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        if (nums.length <= 0) return -1;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[l] <= nums[m]) { // left half interval in order, must be with equal!!!
                if (nums[l] <= target && target < nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else { // right half interval in order
                if (nums[m] < target && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }

    // 34. Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        if (nums.length <= 0) return range;
        range[0] = searchLeft(nums, target);
        range[1] = searchRight(nums, target);
        return range;
    }

    public int searchLeft(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l + 1 < h) {
            int m = l + (h - l) / 2;
            if (target <= nums[m]) h = m;
            else l = m + 1;
        }
        if (nums[l] == target) return l;
        else return nums[h] == target ? h : -1;
    }

    public int searchRight(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l + 1 < h) {
            int m = l + (h - l) / 2;
            if (target >= nums[m]) l = m;
            else h = m - 1;
        }
        if (nums[h] == target) return h;
        else return nums[l] == target ? l : -1;
    }

    // 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) return 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (target == nums[m]) return m;
            else if (target < nums[m]) h = m - 1;
            else l = m + 1;
        }
        return l;
    }

    // 36. Valid Sudoku
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] cell = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c != '.') {
                    if (++row[i][c - '1'] > 1) return false;
                    if (++column[j][c - '1'] > 1) return false;
                    if (++cell[(i / 3) * 3 + j / 3][c - '1'] > 1) return false;
                }
            }
        }
        return true;
    }

    // 37. Sudoku Solver
    public void solveSudoku(char[][] board) {
        int[][][] c = new int[3][9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int v = board[i][j] - '1';
                    c[0][i][v] = c[1][j][v] = c[2][(i / 3) * 3 + j / 3][v] = 1;
                }
            }
        }
        DoSolveSudoku(board, 0, 0, c);
    }

    private boolean DoSolveSudoku(char[][] board, int i, int j, int[][][] c) {
        if (i >= 9) return true;
        int nexti = j == 8 ? i + 1 : i;
        int nextj = j == 8 ? 0 : j + 1;
        if (board[i][j] == '.') {
            for (char k = '1'; k <= '9'; ++k) {
                board[i][j] = k;
                int v = k - '1';
                if (c[0][i][v] == 0 && c[1][j][v] == 0 && c[2][(i / 3) * 3 + j / 3][v] == 0) {
                    c[0][i][v] = c[1][j][v] = c[2][(i / 3) * 3 + j / 3][v] = 1;
                    if (DoSolveSudoku(board, nexti, nextj, c)) {
                        return true;
                    } else {
                        c[0][i][v] = c[1][j][v] = c[2][(i / 3) * 3 + j / 3][v] = 0;
                    }
                }
            }
            board[i][j] = '.';
            return false;
        } else {
            return DoSolveSudoku(board, nexti, nextj, c);
        }
    }

    // 38. Count and Say
    public String countAndSay(int n) {
        String v = "1";
        for (int i = 2; i <= n; ++i) {
            String next = "";
            int l = 0, h = 0;
            for (; h < v.length();) {
                while (h < v.length() && v.charAt(h) == v.charAt(l)) h++;
                next += String.valueOf(h - l) + v.charAt(l);
                l = h;
            }
            v = next;
        }
        return v;
    }

    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        DoCombinationSum(candidates, 0, target, new ArrayList<>(), rst);
        return rst;
    }

    private void DoCombinationSum(int[] nums,
                                 int start,
                                 int remain,
                                 List<Integer> path,
                                 List<List<Integer>> rst) {
        if (remain < 0) return;
        else if (remain == 0) rst.add(new ArrayList<>(path));
        else {
            for (; start < nums.length; ++start) {
                path.add(nums[start]);
                DoCombinationSum(nums, start, remain - nums[start], path, rst);
                path.remove(path.size() - 1);
            }
        }
    }

    // 40. Combination Sum II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rst = new ArrayList<>();
        DoCombinationSum2(candidates, 0, target, new ArrayList<>(), rst);
        return rst;
    }

    private void DoCombinationSum2(int[] nums, int start, int remain,
                                   List<Integer> path, List<List<Integer>> rst) {
        if (remain < 0) return;
        else if (remain == 0) rst.add(new ArrayList<>(path));
        else {
            for (int k = start; k < nums.length; ++k) {
                if (k > start && nums[k] == nums[k - 1]) continue;
                path.add(nums[k]);
                DoCombinationSum2(nums, k + 1, remain - nums[k], path, rst);
                path.remove(path.size() - 1);
            }
        }
    }

    // 46. Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        DoPermute(nums, new ArrayList<>(), rst);
        return rst;
    }

    private void DoPermute(int[] nums, List<Integer> path, List<List<Integer>> rst) {
        if (path.size() == nums.length) rst.add(new ArrayList<>(path));
        else {
            for (int i = 0; i < nums.length; ++i) {
                if (path.contains(nums[i])) continue;
                path.add(nums[i]);
                DoPermute(nums, path, rst);
                path.remove(path.size() - 1);
            }
        }
    }

    // 47. Permutations II
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        DoPermuteUnique(nums, new ArrayList<>(), rst);
        return rst;
    }

    private void DoPermuteUnique(int[] nums, List<Integer> path, List<List<Integer>> rst) {
        
    }



}
