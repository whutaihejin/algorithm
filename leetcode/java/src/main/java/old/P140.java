package old; /**
 * Created by taihejin on 16-8-8.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P140 {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        int size = s.length() + 1;
        boolean[] split = new boolean[size];
        split[0] = true;
        for (int k = 1; k < size; k++) {
            for (int i = 0; i < k; i++) {
                if (split[i] && wordDict.contains(s.substring(i, k))) {
                    split[k] = true;
                    break;
                }
            }
        }
        List<String> ret = new ArrayList<String>();
        if (split[size - 1]) {
            dfs(0, "", s, split, wordDict, ret);
        }
        return ret;
    }

    private void dfs(int i, String prefix, String s, boolean[] split, Set<String> wordDict, List<String> ret) {
        if (i >= s.length()) {
            ret.add(prefix.substring(1));
            return;
        }
        for (int k = i + 1; k < split.length; k++) {
            if (split[k]) {
                String word = s.substring(i, k);
                if (wordDict.contains(word)) {
                    dfs(k, prefix + " " + word, s, split, wordDict, ret);
                }
            }
        }
    }

    @Test
    public void test0() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> ret = wordBreak("catsanddog", wordDict);
        Assert.assertEquals(2, ret.size());
        Assert.assertEquals("cat sand dog", ret.get(0));
        Assert.assertEquals("cats and dog", ret.get(1));
    }

    @Test
    public void test1() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("a", "aa"));
        List<String> ret = wordBreak("aa", wordDict);
        Assert.assertEquals(2, ret.size());
        Assert.assertEquals("a a", ret.get(0));
        Assert.assertEquals("aa", ret.get(1));
    }

    @Test
    public void test2() {
        Set<String> wordDict = new HashSet<String>(Arrays.asList("a", "aa"));
        List<String> ret = wordBreak("aaa", wordDict);
        Assert.assertEquals(3, ret.size());
        Assert.assertEquals("a a a", ret.get(0));
        Assert.assertEquals("a aa", ret.get(1));
        Assert.assertEquals("aa a", ret.get(2));
    }


}
