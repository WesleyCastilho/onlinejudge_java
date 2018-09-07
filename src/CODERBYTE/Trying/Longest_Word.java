package CODERBYTE.Trying;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Longest_Word {

    public Longest_Word() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        String longest = "";
        int maxlenght = 0;
        for (String s : st) {
            s = s.replaceAll("[^a-zA-Z0-9]", "");
            int length = s.length();
            if (maxlenght < length) {
                longest = s;
                maxlenght = length;
            }
        }
        System.out.println(longest);
    }
}
