package URI.Trying.NOSTATUS.STRING;
/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1458 SMS Championship
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1458
 * @Timelimit: 5 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:คำนวนการกด message ใช้เวลาน้อยที่สุด
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.HashMap;

public class P1458_SMS_Championship {

    static class Phone {
        static HashMap<Character, Button> button;

        public Phone() {
            button = new HashMap<>();
        }

        public void addButton(char buttonKey, Button button) {
            this.button.put(buttonKey, button);
        }

        public HashMap<Character, Integer> pushButton(char key) {
            HashMap<Character, Integer> button = (this.button.get(key)).moveTime;
            return button;
        }
    }

    static class Button {
        HashMap<Character, Integer> moveTime = new HashMap<>();

        public Button(HashMap<Character, Integer> moveTime) {
            this.moveTime = moveTime;
        }
    }


    static Phone phone = new Phone();

    static {

        HashMap<Character, Integer> moveTimeKey0 = getTimeMappingKey0();
        HashMap<Character, Integer> moveTimeKey1 = getTimeMappingKey1();
        HashMap<Character, Integer> moveTimeKey2 = getTimeMappingKey2();
        HashMap<Character, Integer> moveTimeKey3 = getTimeMappingKey3();
        HashMap<Character, Integer> moveTimeKey4 = getTimeMappingKey4();
        HashMap<Character, Integer> moveTimeKey5 = getTimeMappingKey5();
        HashMap<Character, Integer> moveTimeKey6 = getTimeMappingKey6();
        HashMap<Character, Integer> moveTimeKey7 = getTimeMappingKey7();
        HashMap<Character, Integer> moveTimeKey8 = getTimeMappingKey8();
        HashMap<Character, Integer> moveTimeKey9 = getTimeMappingKey9();
        HashMap<Character, Integer> moveTimeKeySharp = getTimeMappingKeySharp();
        HashMap<Character, Integer> moveTimeKeyStar = getTimeMappingKeyStar();


        phone.addButton('0', new Button(moveTimeKey0));
        phone.addButton(' ', new Button(moveTimeKey0));

        phone.addButton('1', new Button(moveTimeKey1));

        phone.addButton('2', new Button(moveTimeKey2));
        phone.addButton('a', new Button(moveTimeKey2));
        phone.addButton('b', new Button(moveTimeKey2));
        phone.addButton('c', new Button(moveTimeKey2));


        phone.addButton('3', new Button(moveTimeKey3));
        phone.addButton('d', new Button(moveTimeKey3));
        phone.addButton('e', new Button(moveTimeKey3));
        phone.addButton('f', new Button(moveTimeKey3));

        phone.addButton('4', new Button(moveTimeKey4));
        phone.addButton('g', new Button(moveTimeKey3));
        phone.addButton('h', new Button(moveTimeKey3));
        phone.addButton('i', new Button(moveTimeKey3));

        phone.addButton('5', new Button(moveTimeKey5));
        phone.addButton('j', new Button(moveTimeKey3));
        phone.addButton('k', new Button(moveTimeKey3));
        phone.addButton('l', new Button(moveTimeKey3));

        phone.addButton('6', new Button(moveTimeKey6));
        phone.addButton('m', new Button(moveTimeKey3));
        phone.addButton('n', new Button(moveTimeKey3));
        phone.addButton('o', new Button(moveTimeKey3));

        phone.addButton('7', new Button(moveTimeKey7));
        phone.addButton('p', new Button(moveTimeKey3));
        phone.addButton('q', new Button(moveTimeKey3));
        phone.addButton('r', new Button(moveTimeKey3));
        phone.addButton('s', new Button(moveTimeKey3));

        phone.addButton('8', new Button(moveTimeKey8));
        phone.addButton('t', new Button(moveTimeKey3));
        phone.addButton('u', new Button(moveTimeKey3));
        phone.addButton('v', new Button(moveTimeKey3));

        phone.addButton('9', new Button(moveTimeKey9));
        phone.addButton('w', new Button(moveTimeKey3));
        phone.addButton('x', new Button(moveTimeKey3));
        phone.addButton('y', new Button(moveTimeKey3));
        phone.addButton('z', new Button(moveTimeKey3));

        phone.addButton('*', new Button(moveTimeKeyStar));
        phone.addButton('#', new Button(moveTimeKeySharp));
    }

    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("0.00");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            char[] c = input.toCharArray();
            int size = c.length;
            bw.append(df.format(typingTime(c, size)) + "\n");
        }
        bw.flush();
    }

    static double typingTime(char[] c, int n) {
        double time = 0.00d;
        HashMap<Character, Integer> lastMap, curMap;
        char lastKey, curKey;
        for (int i = 0; i < n; i++) {
            curKey = c[i];
            curMap = phone.pushButton(curKey);
            time += curMap.get(curKey);
            lastKey = c[i];
            lastMap = curMap;
        }
        return time;
    }


    static HashMap<Character, Integer> getTimeMappingKey0() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey1() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey2() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey3() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey4() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey5() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey6() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey7() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey8() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKey9() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKeySharp() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }

    static HashMap<Character, Integer> getTimeMappingKeyStar() {
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('0', 1);
        mapping.put(' ', 1);

        mapping.put('1', 1);

        mapping.put('2', 1);
        mapping.put('a', 1);
        mapping.put('b', 1);
        mapping.put('c', 1);


        mapping.put('3', 1);
        mapping.put('d', 1);
        mapping.put('e', 1);
        mapping.put('f', 1);

        mapping.put('4', 1);
        mapping.put('g', 1);
        mapping.put('h', 1);
        mapping.put('i', 1);

        mapping.put('5', 1);
        mapping.put('j', 1);
        mapping.put('k', 1);
        mapping.put('l', 1);

        mapping.put('6', 1);
        mapping.put('m', 1);
        mapping.put('n', 1);
        mapping.put('o', 1);

        mapping.put('7', 1);
        mapping.put('p', 1);
        mapping.put('q', 1);
        mapping.put('r', 1);
        mapping.put('s', 1);

        mapping.put('8', 1);
        mapping.put('t', 1);
        mapping.put('u', 1);
        mapping.put('v', 1);

        mapping.put('9', 1);
        mapping.put('w', 1);
        mapping.put('x', 1);
        mapping.put('y', 1);
        mapping.put('z', 1);

        mapping.put('*', 1);
        mapping.put('#', 1);
        return mapping;
    }
}
