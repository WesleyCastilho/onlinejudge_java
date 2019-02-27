package URI.Trying.WRITING.BEGINNER;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2828_Anagrams {


    public P2828_Anagrams() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int[] count = new int[26];

        int found = 0;
        for (char c : in.toCharArray()) {
            if (count[c - 'a'] == 0) {
                found++;
            }
            count[c - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        if (found == 1) {
            System.out.println(1);
        } else {
            int length = in.length();
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    int tmpSum = count[i];
                    for (int j = count[i] - 1; j > 1; j--) {
                        tmpSum += j;
                    }
//                    System.out.println("tmpSum >>" + tmpSum);
                    sum += tmpSum;
                }
            }
//            int answer = length / sum;
            System.out.println(sum);
        }
    }


}
