package huawei;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by taihejin on 16-8-16.
 */
public class P1 {

    // 进制转换
    public static int decimal(String lex, int base) {
        lex = lex.toUpperCase();
        int number = 0;
        for (int i = 2; i < lex.length(); i++) {
            char ch = lex.charAt(i);
            number = number * base + ch;
            number -= (Character.isDigit(ch) ? '0' : ('A' - 10));
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lex;
        while (sc.hasNext()) {
            lex = sc.next();
            System.out.println(decimal(lex, 16));
        }
    }

    @Test
    public void test0() {
        Assert.assertEquals(10, decimal("0xA", 16));
        Assert.assertEquals(0, decimal("0x0", 16));
        Assert.assertEquals(1, decimal("0x1", 16));
        Assert.assertEquals(2, decimal("0x2", 16));
        Assert.assertEquals(3, decimal("0x3", 16));
        Assert.assertEquals(4, decimal("0x4", 16));
        Assert.assertEquals(5, decimal("0x5", 16));
        Assert.assertEquals(6, decimal("0x6", 16));
        Assert.assertEquals(7, decimal("0x7", 16));
        Assert.assertEquals(8, decimal("0x8", 16));
        Assert.assertEquals(9, decimal("0x9", 16));
    }

    @Test
    public void test1() {
        Assert.assertEquals(10, decimal("0xA", 16));
        Assert.assertEquals(11, decimal("0xB", 16));
        Assert.assertEquals(12, decimal("0xC", 16));
        Assert.assertEquals(13, decimal("0xD", 16));
        Assert.assertEquals(14, decimal("0xE", 16));
        Assert.assertEquals(15, decimal("0xF", 16));
    }

    @Test
    public void test2() {
        Assert.assertEquals(16, decimal("0x10", 16));
        Assert.assertEquals(17, decimal("0x11", 16));
    }
}
