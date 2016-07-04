/**
 * Created by taihejin on 16-7-3.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        int low = 0;
        int size = words.length;
        while (low < size) {
            int high = low + 1;
            int curr = words[low].length();
            for (; high < size && curr + 1 + words[high].length() <= maxWidth; high++) {
                curr += 1 + words[high].length();
            }
            String line = words[low];
            if (high == size) { // last line
                for (int k = low + 1; k < high; k++) {
                    line += " " + words[k];
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
            } else {
                int whiteNum = maxWidth - curr;
                int whiteSlots = high - low - 1;
                if (whiteSlots == 0) { // only one word
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                } else { // normal condition
                    int extraWhite = whiteNum % whiteSlots;
                    for (int i = low + 1; i < high; i++) {
                        for (int k = 0; k <= whiteNum / whiteSlots; k++) {
                            line += " ";
                        }
                        if (extraWhite-- > 0) {
                            line += " ";
                        }
                        line += words[i];
                    }
                }
            }
            low = high;
            list.add(line);
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
        String[] text = {"12", "12", "23", "12"};
        List<String> ret = fullJustify(text, 8);
        Assert.assertEquals(2, ret.size());
    }
}
