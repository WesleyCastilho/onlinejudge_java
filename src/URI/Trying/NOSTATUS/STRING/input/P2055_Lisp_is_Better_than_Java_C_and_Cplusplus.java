package URI.Trying.NOSTATUS.STRING.input;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories:
 * @Problem:
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2055
 * @Timelimit: 2 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: order pattern
 * @Note:
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P2055_Lisp_is_Better_than_Java_C_and_Cplusplus {

    static HashMap<String, String> memory = new HashMap<>();
    static LinkedList<String> dictionary = new LinkedList<>();
    static HashMap<String, TreeSet<String>> numberToWord = new HashMap<>();
    static int N, T;

    static TreeMap<Character, Integer> MapNumberTable = new TreeMap<>();

    static {
        MapNumberTable.put('E', 0);
        MapNumberTable.put('e', 0);

        MapNumberTable.put('J', 1);
        MapNumberTable.put('N', 1);
        MapNumberTable.put('Q', 1);
        MapNumberTable.put('j', 1);
        MapNumberTable.put('n', 1);
        MapNumberTable.put('q', 1);

        MapNumberTable.put('R', 2);
        MapNumberTable.put('W', 2);
        MapNumberTable.put('X', 2);
        MapNumberTable.put('r', 2);
        MapNumberTable.put('w', 2);
        MapNumberTable.put('x', 2);

        MapNumberTable.put('D', 3);
        MapNumberTable.put('S', 3);
        MapNumberTable.put('Y', 3);
        MapNumberTable.put('d', 3);
        MapNumberTable.put('s', 3);
        MapNumberTable.put('y', 3);

        MapNumberTable.put('F', 4);
        MapNumberTable.put('T', 4);
        MapNumberTable.put('f', 4);
        MapNumberTable.put('t', 4);

        MapNumberTable.put('A', 5);
        MapNumberTable.put('M', 5);
        MapNumberTable.put('a', 5);
        MapNumberTable.put('m', 5);

        MapNumberTable.put('C', 6);
        MapNumberTable.put('I', 6);
        MapNumberTable.put('V', 6);
        MapNumberTable.put('c', 6);
        MapNumberTable.put('i', 6);
        MapNumberTable.put('v', 6);

        MapNumberTable.put('B', 7);
        MapNumberTable.put('K', 7);
        MapNumberTable.put('U', 7);
        MapNumberTable.put('b', 7);
        MapNumberTable.put('k', 7);
        MapNumberTable.put('u', 7);

        MapNumberTable.put('L', 8);
        MapNumberTable.put('O', 8);
        MapNumberTable.put('P', 8);
        MapNumberTable.put('l', 8);
        MapNumberTable.put('o', 8);
        MapNumberTable.put('p', 8);

        MapNumberTable.put('G', 9);
        MapNumberTable.put('H', 9);
        MapNumberTable.put('z', 9);
        MapNumberTable.put('g', 9);
        MapNumberTable.put('h', 9);
        MapNumberTable.put('z', 9);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine().trim()).equals("0")) {
            N = Integer.parseInt(input);
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                String encodeNumber = "";
                for (char c : word.toCharArray()) {
                    if (c == '\"' || c == '-' || c == '/') continue;
                    encodeNumber += MapNumberTable.get(c);
                }
                TreeSet<String> set = numberToWord.get(encodeNumber);
                if (set == null) {
                    set = new TreeSet<>();
                }

                set.add(word);
                numberToWord.put(encodeNumber, set);
            }


//            for (Map.Entry<String, TreeSet<String>> entry : numberToWord.entrySet()) {
//                System.out.println(entry.getKey() + " ->");
//                for (String sc : entry.getValue()) {
//                    System.out.println(sc);
//                }
//            }


            //find n sup String number
            T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                String number = br.readLine();
                int size = number.length();
                LinkedList<String> answer = new LinkedList<>();
                String sup =  "";
                for (int j = 0; j < size; j++) {
                    sup += number.substring(j);

                }
            }

        }
        bw.flush();
    }

}
