/**
 * Created by taihejin on 16-8-5.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P139 {

    // Time Limit Exceeded
    public boolean wordBreakRecursive(String s, Set<String> wordDict) {
        for (int k = 1; k <= s.length(); k++) {
            if (wordDict.contains(s.substring(0, k)) && wordBreak(s.substring(k), wordDict)) {
                return true;
            }
        }
        return s.isEmpty() ? true : false;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.isEmpty()) return wordDict.contains(s);
        int size = s.length();
        boolean[][] matrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = wordDict.contains(s.substring(i, i + 1)) ? true : false;
        }
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i <= size - len; i++) {
                if (wordDict.contains(s.substring(i, i + len))) {
                    matrix[i][i + len - 1] = true;
                    continue;
                }
                for (int k = i; k < i + len - 1; k++) {
                    if (matrix[i][k] && matrix[k + 1][i + len - 1]) {
                        matrix[i][i + len - 1] = true;
                    }
                }
            }
        }
        return matrix[0][size - 1];
    }

    @Test
    public void testSelf() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("ab", "c"));
        Assert.assertEquals(false, wordDict.contains(null));
        Assert.assertEquals(false, wordDict.contains(""));
        Assert.assertEquals(true, wordBreak("abc", wordDict));
    }

    @Test
    public void test0() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("leet", "code"));
        Assert.assertEquals(true, wordBreak("leetcode", wordDict));
        Assert.assertEquals(false, wordBreak("leetcodes", wordDict));
        Assert.assertEquals(true, wordBreak("leet", wordDict));
        Assert.assertEquals(true, wordBreak("code", wordDict));
        Assert.assertEquals(true, wordBreak("codeleet", wordDict));
        Assert.assertEquals(false, wordBreak("codeleets", wordDict));
    }

    @Test
    public void test1() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("leet", "code"));
        Assert.assertEquals(false, wordBreak("", wordDict));
        Assert.assertEquals(false, wordBreak("whu", wordDict));
    }

    @Test
    public void test2() {
        Set<String> wordDict = new HashSet<String>();
        Assert.assertEquals(false, wordBreak("leet", wordDict));
    }

    @Test
    public void test3() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        String line = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        String line = "aaaaaaaaaaaaab";
        Assert.assertEquals(false, wordBreak(line, wordDict));

    }
}
