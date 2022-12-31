import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-9.
 */
public class P1 {

    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        //return b == 0 ? aplusb(a ^ b, (a & b) << 1) : a;
        if (a > b) return aplusb(b, a);
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int aplusbRecursive(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        return b != 0 ? aplusbRecursive(a ^ b, (a & b) << 1) : a;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, aplusbRecursive(0, 0));
        Assert.assertEquals(1, aplusbRecursive(1, 0));
        Assert.assertEquals(2, aplusbRecursive(1, 1));
        Assert.assertEquals(5, aplusbRecursive(2, 3));
        Assert.assertEquals(99, aplusbRecursive(33, 66));
        Assert.assertEquals(0, aplusbRecursive(-1, 1));
        Assert.assertEquals(-2, aplusbRecursive(-5, 3));
        Assert.assertEquals(Integer.MIN_VALUE, aplusbRecursive(Integer.MAX_VALUE, 1));
    }
}
