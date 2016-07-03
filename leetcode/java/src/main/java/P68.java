/**
 * Created by taihejin on 16-7-3.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P68 {

    // the code is bull shit, try to refactoring!!!
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        int low = 0;
        int high = 0;
        int size = 0;
        int gap = 0;
        for (; high < words.length; high++) {
            size += gap + words[high].length();
            gap = 1;
            if (size == maxWidth) {
                for (int k = low; k < high; k++) {
                    builder.append(words[k]).append(' ');
                }
                builder.append(words[high]);
                list.add(builder.toString());
                builder.delete(0, builder.length());
                gap = 0;
                size = 0;
                low = high + 1;
            } else if (size > maxWidth) {
                size -= (gap + words[high].length());
                high--;
                if (low == high) {
                    for (int k = 0; k < maxWidth - size; k++) {
                        builder.append(' ');
                    }
                    builder.append(words[low]);
                    list.add(builder.toString());
                    builder.delete(0, builder.length());
                } else {
                    int evenly = (maxWidth - size) / (high - low) + 1;
                    int rest = (maxWidth - size) % (high - low);
                    for (int k = low; k < high; k++) {
                        builder.append(words[k]);
                        for (int l = 0; l < evenly; l++) {
                            builder.append(' ');
                        }
                        if (rest-- > 0) {
                            builder.append(' ');
                        }
                    }
                    builder.append(words[high]);
                    list.add(builder.toString());
                    builder.delete(0, builder.length());
                }
                gap = 0;
                size = 0;
                low = high + 1;
            }
        }
        if (low < words.length) {
            for (int k = low; k < words.length; k++) {
                builder.append(words[low]).append(' ');
            }
            if (builder.length() > maxWidth) {
                builder.delete(maxWidth + 1, builder.length());
            }
            for (int k = 0; k < maxWidth - size; k++) {
                builder.append(' ');
            }
            list.add(builder.toString());
        }
        return list;
    }

    @Test
    public void test1() {
        String[] text = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> ret = fullJustify(text, 16);
    }

    @Test
    public void test2() {
        String[] text = {"1234"};
        List<String> ret = fullJustify(text, 6);
        Assert.assertEquals(1, ret.size());
    }

    @Test
    public void test3() {
        String[] text = {"1234", "1", "12345", "12"};
        List<String> ret = fullJustify(text, 6);
        Assert.assertEquals(3, ret.size());
    }

    @Test
    public void test4() {
        String[] text = {"12", "12", "123", "12"};
        List<String> ret = fullJustify(text, 8);
        Assert.assertEquals(2, ret.size());
    }
}
