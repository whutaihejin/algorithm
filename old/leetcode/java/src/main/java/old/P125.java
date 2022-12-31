package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-14.
 */
public class P125 {

    public boolean isPalindrome(String s) {
        boolean valid = true;
        if (s.isEmpty()) {
            return valid;
        }
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            char l = Character.toLowerCase(s.charAt(low));
            char h = Character.toLowerCase(s.charAt(high));
            if (!Character.isLetterOrDigit(l)) {
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(h)) {
                high--;
                continue;
            }
            if (l == h) {
                low++;
                high--;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(false, isPalindrome("race a car"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(true, isPalindrome(""));
    }

    @Test
    public void test4() {
        Assert.assertEquals(true, isPalindrome(",%44&"));
    }
}
