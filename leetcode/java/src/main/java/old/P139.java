package old; /**
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
        boolean[] status = new boolean[s.length() + 1];
        status[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                if (status[k] && wordDict.contains(s.substring(k, i))) {
                    status[i] = true;
                    break;
                }
            }
        }
        return status[s.length()];
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
