package URI.Trying.NOSTATUS.BEGINNER;
//https://math.stackexchange.com/questions/2754556/smallest-number-with-at-least-n-divisors
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2869_Talking_about_Divisor {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 45360;
        int count = 0;
        int k = n;
        while (k > 0) {
            if (n % k == 0) {
                count++;
            }
            k--;
        }
        System.out.println(count);
    }

}
