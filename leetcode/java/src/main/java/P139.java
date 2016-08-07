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
    public boolean wordBreak(String s, Set<String> wordDict) {
        for (int k = 1; k <= s.length(); k++) {
            if (wordDict.contains(s.substring(0, k)) && wordBreak(s.substring(k), wordDict)) {
                return true;
            }
        }
        return s.isEmpty() ? true : false;
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
        Assert.assertEquals(true, wordBreak("", wordDict));
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
