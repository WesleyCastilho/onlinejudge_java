package CODERBYTE.Trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Teerapat-BSD on 7/9/2018.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        String ss = "";
        boolean hasmore = false;
        for (String s : st) {
            if (hasmore) {
                ss += " ";
            }
            loop:
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    if (s.charAt(i) == 'z' || s.charAt(i) == 'Z') {
                        ss += 'A';
                        continue loop;
                    }
                    char newChar = (char) (s.charAt(i) + 1);
                    if (newChar == 'a' || newChar == 'e' || newChar == 'i' || newChar == 'o' || newChar == 'u') {
                        ss += Character.toUpperCase(newChar);
                    } else {
                        ss += newChar;
                    }

                } else {
                    ss += s.charAt(i);
                }
            }
            hasmore = true;
        }

        System.out.println(ss);
    }
}
