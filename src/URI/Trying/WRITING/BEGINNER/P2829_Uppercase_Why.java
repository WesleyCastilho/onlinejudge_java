package URI.Trying.WRITING.BEGINNER;

import java.io.*;
import java.util.LinkedList;

public class P2829_Uppercase_Why {

    static LinkedList<String> list;

    public static void main(String[] args) throws IOException {
        list = new LinkedList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            addValue(br.readLine());
        }

        for (String s : list) {
            for(int i = 0; i < s.length(); i++){
                bw.append(getValue(s.charAt(i))+" ");
            }
            bw.append(s + "\n");
        }
        bw.flush();
    }

    static int compare(String s1, String s2) {
        int result = 0;
        int size1 = s1.length();
        int size2 = s2.length();

        for (int i = 0; i < (size1 >= size2 ? size2 : size1); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            int a = compareChar(c1, c2);
            if (a != 0) return a;
        }
        return result;
    }

    static int compareChar(char c1, char c2) {
        if (c1 == c2) return 0;
        int var1 = getValue(c1);
        int var2 = getValue(c2);
        return var1 < var2 ? 1 : -1;
    }

    private static void addValue(String val) {
        if (list.size() == 0) {
            list.add(val);
        } else if (compare(list.peekFirst(), val) == 1) {
            list.add(0, val);
        } else if (compare(list.peekLast(), val) == -1) {
            list.add(list.size(), val);
        } else {
            int i = 0;
            for (String s : list) {
                if (compare(s, val) == 1) break;
                i++;
            }
            list.add(i, val);
        }
    }

    static int getValue(char c) {
        switch (c) {
            case 'A':
                return 52;
            case 'a':
                return 51;
            case 'B':
                return 50;
            case 'b':
                return 49;
            case 'C':
                return 48;
            case 'c':
                return 47;
            case 'D':
                return 46;
            case 'd':
                return 45;
            case 'E':
                return 44;
            case 'e':
                return 43;
            case 'F':
                return 42;
            case 'f':
                return 41;
            case 'G':
                return 40;
            case 'g':
                return 39;
            case 'H':
                return 38;
            case 'h':
                return 37;
            case 'I':
                return 36;
            case 'i':
                return 35;
            case 'J':
                return 34;
            case 'j':
                return 33;
            case 'K':
                return 32;
            case 'k':
                return 31;
            case 'L':
                return 30;
            case 'l':
                return 29;
            case 'M':
                return 28;
            case 'm':
                return 27;
            case 'N':
                return 26;
            case 'n':
                return 25;
            case 'O':
                return 24;
            case 'o':
                return 23;
            case 'P':
                return 22;
            case 'p':
                return 21;
            case 'Q':
                return 20;
            case 'q':
                return 19;
            case 'R':
                return 18;
            case 'r':
                return 17;
            case 'S':
                return 16;
            case 's':
                return 15;
            case 'T':
                return 14;
            case 't':
                return 13;
            case 'U':
                return 12;
            case 'u':
                return 11;
            case 'V':
                return 10;
            case 'v':
                return 9;
            case 'W':
                return 8;
            case 'w':
                return 7;
            case 'X':
                return 6;
            case 'x':
                return 5;
            case 'Y':
                return 4;
            case 'y':
                return 3;
            case 'Z':
                return 2;
            case 'z':
                return 1;
            default:
                return 0;
        }
    }
}
