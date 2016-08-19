import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Created by taihejin on 16-8-2.
 */
public class Varint {
    @Test
    public void test0() {
        int x = 300;
        String binary = Integer.toBinaryString(300);
//        Assert.assertEquals("0001 0010 1100", binary);
        int y = 0x7FFFFFFF;
        String express = Integer.toBinaryString(y);
//        Assert.assertEquals("1111", express);
        OutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[5];
        for (int offset = 7, k = 0; offset < 32; offset += 7) {
            byte b = (byte) ((x >>> offset) == 0 ? (x & 0x7F) : ((x & 0x7F) | 0x80));
            buf[k++] = b;
        }
    }
}
