package URI.Trying.NOSTATUS.STRING;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
 * @Solution:
 * @Note:
 */
public class P2588_Game_of_Palindromes {
    TreeSet<String> list = new TreeSet<>();
    LinkedList<Integer> s = new LinkedList<>();

    public P2588_Game_of_Palindromes() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        String input;
        loop:
        while ((input = br.readLine()) != null) {
            int n = input.length();
            permutations(input, 0, n - 1);
            for (String permuWord : list) {
                System.out.println(permuWord);
                if (isPalindrome(permuWord, n - 1)) {
                    bos.write("0\n".getBytes());
                    bos.flush();
                    list.clear();
                    continue loop;
                }
            }


            for (String s : list) {
                System.out.println(s);
            }
            list.clear();
        }
        bos.flush();
    }

    private void permutations(String str, int l, int r) {
        if (l == r)
            list.add(str);
//            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutations(str, l + 1, r);
                str = swap(str, l, i);
            }
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

    boolean isPalindrome(String word, int n) {
        int l = 0, r = n;
        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
