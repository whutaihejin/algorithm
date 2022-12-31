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


    // 41. First Missing Positive
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    // 42. Trapping Rain Water
    public int trap(int[] height) {
        int water = 0;
        int l = 0, h = height.length - 1;
        while (l < h) {
            if (height[l] <= height[h]) {
                int k = l + 1;
                while (k < h && height[k] < height[l]) {
                    water += height[l] - height[k];
                    k++;
                }
                l = k;
            } else {
                int k = h - 1;
                while (l < k && height[k] < height[h]) {
                    water += height[h] - height[k];
                    k--;
                }
                h = k;
            }
        }
        return water;
    }

    // 43. Multiply Strings
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] digit = new int[m + n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                digit[i + j] += v / 10;
                digit[i + j + 1] += v % 10;
            }
        }
        int carry = 0;
        for (int k = m + n - 1; k >= 0; --k) {
            int v = digit[k] + carry;
            digit[k] = v % 10;
            carry = v / 10;
        }
        boolean pick = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m + n; ++i) {
            if (digit[i] != 0) pick = true;
            if (pick) builder.append(digit[i]);
        }
        if (builder.length() == 0) builder.append('0');
        return builder.toString();
    }

    // 44. Wildcard Matching
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            f[i][0] = i == 0;
        }
        for (int j = 1; j <= n; ++j) {
            f[0][j] = p.charAt(j - 1) == '*' ? f[0][j - 1] : false;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char c = p.charAt(j - 1);
                switch (c) {
                    case '*':
                        // case 1: * match zero character
                        // case 2: * match only one character
                        // case 3: * erase one character and match the rest of text
                        f[i][j] = f[i][j - 1] || f[i - 1][j - 1] || f[i - 1][j];
                        break;
                    case '?':
                        f[i][j] = f[i - 1][j - 1];
                        break;
                    default:
                        f[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && f[i - 1][j - 1];
                        break;
                }
            }
        }
        return f[m][n];
    }

    // 45. Jump Game II
    public int jump(int[] nums) {
        int step = 0;
        int far = 0, limit = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > limit) {
                limit = far;
                step++;
            }
            far = Math.max(far, nums[i] + i);
        }
        return step;
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
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> rst = new ArrayList<>();
        DoPermuteUnique(nums, used, new ArrayList<>(), rst);
        return rst;
    }

    private void DoPermuteUnique(int[] nums, boolean[] used,
                                 List<Integer> path, List<List<Integer>> rst) {
        if (path.size() == nums.length) rst.add(new ArrayList<>(path));
        else {
            for (int i = 0; i < nums.length;) {
                if (used[i]) { i++; continue;}
                int k = i; // next i
                while (k < nums.length && nums[k] == nums[i]) k++;
                path.add(nums[i]);
                used[i] = true;
                DoPermuteUnique(nums, used, path, rst);
                path.remove(path.size() - 1);
                used[i] = false;
                i = k;
            }
        }
    }

    // 48. Rotate Image
    public void rotate(int[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) return;
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int v = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = v;
            }
        }
        // reverse with column
        for (int l = 0, h = n - 1; l < h; ++l, --h) {
            for (int i = 0; i < n; ++i) {
                swap(matrix[i], l, h);
            }
        }
    }

    // 49. Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; ++i) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        for (List<String> l : map.values()) {
            rst.add(l);
        }
        return rst;
    }

    // 50. Pow(x, n)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        else if (n == 1) return x;
        else {
            double v = myPow(x, n / 2);
            double delta = n < 0 ? 1 / x : x;
            return ((n & 0x01) == 1) ? v * v * delta : v * v;
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        int n = board.length;
        for (int k = x - 1; k >= 0; --k) {
            if (board[k][y] == 'Q') return false;
        }
        int i = x - 1, j = y - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--; j--;
        }
        i = x - 1; j = y + 1;
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--; j++;
        }
        return true;
    }

    private void DoSolveNQueens(char[][] board, int i, List<List<String>> rst) {
        if (i >= board.length) {
            List<String> chess = new ArrayList<>();
            for (int k = 0; k < board.length; ++k) {
                chess.add(new String(board[k]));
            }
            rst.add(chess);
        } else {
            for (int k = 0; k < board.length; ++k) {
                board[i][k] = 'Q';
                if (isValid(board, i, k)) {
                    DoSolveNQueens(board, i + 1, rst);
                }
                board[i][k] = '.';
            }
        }
    }

    // 51. N-Queens
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        List<List<String>> rst = new ArrayList<>();
        DoSolveNQueens(board, 0, rst);
        return rst;
    }

    // 52. N-Queens II
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        return DoTotalNQueens(board, 0);
    }

    private int DoTotalNQueens(char[][] board, int i) {
        if (i >= board.length) return 1;
        else {
            int v = 0;
            for (int k = 0; k < board.length; ++k) {
                board[i][k] = 'Q';
                if (isValid(board, i, k)) {
                    v += DoTotalNQueens(board, i + 1);
                }
                board[i][k] = '.';
            }
            return v;
        }
    }

    // 53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int mx = nums[0], end = 0;
        for (int i = 0; i < nums.length; ++i) {
            end = end <= 0 ? nums[i] : end + nums[i];
            mx = Math.max(mx, end);
        }
        return mx;
    }

    // 54. Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if (matrix.length <= 0 || matrix[0].length <= 0) return rst;
        int i = 0, j = 0;
        int li = 0, hi = matrix.length - 1;
        int lj = 0, hj = matrix[0].length - 1;
        while (li <= hi && lj <= hj) {
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                rst.add(matrix[i][j]);
                j++;
            }
            i++; j--;
            li++; // shrink top row
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                rst.add(matrix[i][j]);
                i++;
            }
            i--; j--;
            hj--;
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                rst.add(matrix[i][j]);
                j--;
            }
            i--; j++;
            hi--;
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                rst.add(matrix[i][j]);
                i--;
            }
            i++; j++;
            lj++;
        }
        return rst;
    }

    // 55. Jump Game
    public boolean canJump(int[] nums) {
        int far = 0, limit = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > limit) {
                limit = far;
                if (far < i) return false;
            }
            far = Math.max(far, nums[i] + i);
        }
        return limit >= nums.length - 1;
    }

    public class MergeComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] x, int[] y) {
            return x[0] - y[0];
        }
    }

    // 56. Merge Intervals
    public int[][] merge(int[][] intervals) {
        List<int[]> rst = new ArrayList<>();
        if (intervals.length <= 0) return rst.toArray(new int[0][2]);
        // sort intervals
        Arrays.sort(intervals, new MergeComparator());
        int[] base = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= base[1]) {
                base[1] = Math.max(base[1], intervals[i][1]);
            } else {
                rst.add(new int[]{base[0], base[1]});
                base = intervals[i];
            }
        }
        rst.add(base);
        int[][] r = new int[rst.size()][2];
        return rst.toArray(r);
    }

    // 57. Insert Interval
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rst = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length && intervals[i][1] < newInterval[0]; ++i) {
            rst.add(intervals[i]);
        }
        for (; i < intervals.length && intervals[i][0] <= newInterval[1]; ++i) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        rst.add(newInterval);
        for (; i < intervals.length; ++i) {
            rst.add(intervals[i]);
        }
        return rst.toArray(new int[rst.size()][2]);
    }

    // 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        for (int h = s.length() - 1; h >= 0; --h) {
            if (s.charAt(h) != ' ') {
                int l = h - 1;
                while (l >= 0 && s.charAt(l) != ' ') l--;
                return h - l;
            }
        }
        return 0;
    }

    // 59. Spiral Matrix II
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        int i = 0, j = 0, k = 0;
        int li = 0, hi = matrix.length - 1;
        int lj = 0, hj = matrix[0].length - 1;
        while (li <= hi && lj <= hj) {
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                matrix[i][j] = ++k;
                j++;
            }
            i++; j--;
            li++; // shrink top row
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                matrix[i][j] = ++k;
                i++;
            }
            i--; j--;
            hj--;
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                matrix[i][j] = ++k;
                j--;
            }
            i--; j++;
            hi--;
            while (i >= li && i <= hi && j >= lj && j <= hj) {
                matrix[i][j] = ++k;
                i--;
            }
            i++; j++;
            lj++;
        }
        return matrix;
    }

    // 60. Permutation Sequence
    public String getPermutation(int n, int k) {
        int total = 1;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
            total *= (i + 1);
        }
        total /= n;
        for (int i = 0; i < n - 1; ++i) {
            int j = (k - 1) / total;
            swap(nums, i, i + j);
            Arrays.sort(nums, i + 1, nums.length);
            k -= j * total;
            total /= (n - 1 - i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }

    // 61. Rotate List
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;
        for (int i = 0; i < len - k && p != null; ++k) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = dummy.next;
        return newHead;
    }

    // 62. Unique Paths
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    // 63. Unique Paths II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return 0;
    }

    // 94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode entry = stack.pop();
            rst.add(entry.val);
            root = entry.right;
        }
        return rst;
    }

    // 144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode entry = stack.pop();
            rst.add(entry.val);
            if (entry.right != null) stack.push(entry.right);
            if (entry.left != null) stack.push(entry.left);
        }
        return rst;
    }


    // 145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode entry = stack.pop();
            rst.add(entry.val);
            if (entry.left != null) stack.push(entry.left);
            if (entry.right != null) stack.push(entry.right);
        }
        int l = 0, h = rst.size() - 1;
        while (l < h) {
            int v = rst.get(l);
            rst.set(l, rst.get(h));
            rst.set(h, v);
            l++; h--;
        }
        return rst;
    }

    // duplicate numbers
    public int duplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        return -1;
    }

}
