import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by taihejin on 16-7-19.
 */
public class P71 {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        assert path.charAt(0) == '/';
        Deque<String> deque = new ArrayDeque<String>();
        for (int i = 1; i < path.length();) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < path.length() && path.charAt(j) != '/') {
                j++;
            }
            String item = path.substring(i, j);
            if (item.equals(".")) {
                // ignore
            } else if (item.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.offer(item);
            }
            if (j >= path.length()) {
                break;
            } else {
                i = j + 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append('/').append(deque.pollFirst());
        }
        return  builder.length() == 0 ? "/" : builder.toString();
    }

    @Test
    public void test0() {
        Assert.assertEquals("/home", simplifyPath("/home/"));
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void test1() {
        Assert.assertEquals("/", simplifyPath(null));
        Assert.assertEquals("/", simplifyPath(""));
        Assert.assertEquals("/", simplifyPath("/"));
        Assert.assertEquals("/a/c", simplifyPath("/./../../a/c"));
        Assert.assertEquals("/a/b/c/d/e", simplifyPath("/a/b/c/d/e/"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("/", simplifyPath("///"));
    }
    
}
