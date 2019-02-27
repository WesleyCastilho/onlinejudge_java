package URI.Trying.WRITING.STRING;

import java.io.*;
import java.net.URL;
import java.util.TreeSet;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2588 - Game of Palindromes
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2588
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: สร้างรูปแบบจำลอง palindrome ตัวสมบูรณ์ และเปรียบเทียบขนาด
 * @Note:
 */
public class P2588_Game_of_Palindromes {
    TreeSet<String> list = new TreeSet<>();

    public P2588_Game_of_Palindromes() throws IOException {
        URL path = P1519_Abbreviations.class.getResource("input/P2588_input.txt");
        File f = new File(path.getFile());
        BufferedReader br = new BufferedReader(new FileReader(f));


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        String input;
        loop:
        while ((input = br.readLine()) != null) {
            int n = input.length();
            permutations(input, 0, n - 1);
            int minimum = n;
            for (String permuWord : list) {
                System.out.println(permuWord);
//                int now = check(permuWord, n - 1);
////                System.out.println(now);
//                if (now == 0) {
//                    minimum = 0;
//                    break;
//                } else if (minimum > now) {
//                    minimum = now;
//                }
            }
            bos.write((minimum + "\n").getBytes());
            bos.flush();
            list.clear();
        }
        bos.flush();
    }

    private void permutations(String str, int l, int r) {
        if (l == r) {
            list.add(str);
            return;
        }

        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            permutations(str, l + 1, r);
            str = swap(str, l, i);
        }

    }

    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    int check(String word, int n) {
        char[] c = new char[n + 1];
        int i = n;
        for (int j = 0; j <= n; j++) {
            c[i--] = word.charAt(j);
        }
//        int total = n - 1;
//        int l = 0, r = n;
//        while (l < r) {
//            if (word.charAt(l) != word.charAt(r)) {
//                break;
//            }
//            c[i--] = word.charAt(l);
//            l++;
//            r--;
//            total--;
//
//        }
        System.out.println("word= " + word);
        System.out.println("parindome= " + new String(c));
//        return total;
        return 9999;
    }

}
