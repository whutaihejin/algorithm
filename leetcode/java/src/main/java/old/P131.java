package old; /**
 * Created by taihejin on 16-8-9.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class P131 {

    public boolean isPalindrome(String s, int low, int high) {
        for (; low < high; low++, high--) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
        }
        return true;
    }

    public void partitionHelper(String s, List<String> item, List<List<String>> ret) {
        if (s.isEmpty()) {
            ret.add(new ArrayList<String>(item));
            return;
        }
        for (int k = 1; k <= s.length(); k++) {
            if (isPalindrome(s, 0, k - 1)) {
                int index = item.size();
                item.add(s.substring(0, k));
                partitionHelper(s.substring(k), item, ret);
                item.remove(index);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<String> item = new ArrayList<String>();
        List<List<String>> ret = new ArrayList<List<String>>();
        partitionHelper(s, item, ret);
        return ret;
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, isPalindrome("1", 0, 0));
        Assert.assertEquals(true, isPalindrome("11", 0, 1));
        Assert.assertEquals(false, isPalindrome("12", 0, 1));
        Assert.assertEquals(true, isPalindrome("121", 0, 2));
        Assert.assertEquals(false, isPalindrome("122", 0, 2));
    }

    @Test
    public void test1() {
        List<List<String>> ret = partition("aab");
        Assert.assertEquals(2, ret.size());
    }

    @Test
    public void test2() {
        List<List<String>> ret = partition("aabaa");
        Assert.assertEquals(6, ret.size());
    }
}
