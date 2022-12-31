/**
 * Created by taihejin on 16-7-28.
 */
import java.util.Scanner;

public class P1000 {

    public static int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(add(x, y));
        }
    }
}
