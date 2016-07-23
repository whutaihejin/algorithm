import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taihejin on 16-7-23.
 */
public class P76 {

    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s == null) return "";
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray()) {
            dict.put(ch, dict.get(ch) == null ? 1 : dict.get(ch) + 1);
        }
        int count = t.length(), begin = 0, delta = Integer.MAX_VALUE, head = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (dict.containsKey(ch)) {
                dict.put(ch, dict.get(ch) - 1);
                count -= (dict.get(ch) <= -1 ? 0 : 1);
            }
            while (count == 0) {
                if (end - begin < delta) {
                    delta = end - begin;
                    head = begin;
                }
                char left = s.charAt(begin++);
                if (dict.containsKey(left)) {
                    int val = dict.get(left);
                    dict.put(left, val + 1);
                    count += val >= 0 ? 1 : 0;
                }
            }
        }
        return delta == Integer.MAX_VALUE ? "" : s.substring(head, head + delta + 1);
    }

    @Test
    public void test0() {
//        Assert.assertEquals("", minWindow("", ""));
//        Assert.assertEquals("", minWindow("1", ""));
        Assert.assertEquals("1", minWindow("1", "1"));
    }

    @Test
    public void test1() {
        Assert.assertEquals("ba", minWindow("bba", "ab"));
        Assert.assertEquals("baca", minWindow("acbbaca", "aba"));
    }
}
