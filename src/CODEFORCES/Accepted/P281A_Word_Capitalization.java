package CODEFORCES.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODEFORCES
 * @Categories:
 * @Problem: 281A - Word Capitalization
 * @Link: https://codeforces.com/problemset/problem/281/A
 * @Timelimit: 1 sec
 * @Status: Accepted
 * @Submission: 2018-10-01 11:35:05
 * @Runtime: 278 ms
 * @Memory: 0 KB
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P281A_Word_Capitalization {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String answer = Character.toUpperCase(input.charAt(0)) + "" + input.substring(1);
        System.out.println(answer);
    }

}
