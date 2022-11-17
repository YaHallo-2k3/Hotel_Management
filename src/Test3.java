
import java.util.Random;

public class Test3 {

    public static void main(String[] args) {
        Random rd = new Random();
        int n = rd.nextInt(99999 - 10000) + 10000;
        System.out.println(n);
    }
}
