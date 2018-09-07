/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: DATA STRUCTURE AND LIBRARIES
 * @Problem: 1045 - The Halting Problem
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1405
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Build Operation + segment tree
 * @Note:
 */
package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;

public class P1405_The_Halting_Problem {

    static int L, N;
    static HashMap<String, Object> R;

    static private class Condition {
        String command;
        String ope1;
        String ope2;
        String result;

        public void setCommand(String command) {
            this.command = command;
        }

        void setOpe(String ope1, String ope2) {
            this.ope1 = ope1;
            this.ope2 = ope2;
        }

        void setResult(String result) {
            this.result = result;
        }
    }

    private static HashMap<String, Condition> function;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            L = Integer.parseInt(st[0]);
            N = Integer.parseInt(st[1]);
            R = new HashMap<>();
            function = new HashMap<>();
            Integer result = null;
            boolean createFunction = false;
            boolean endProgram = false;
            while (L-- > 0) {
                st = br.readLine().split("[ ,]");

                //create fucntion
                if (st[0].startsWith("IF")) {
                    createFunction = true;
                    Condition condition = new Condition();
                    if (st[0].endsWith("EQ")) {
                        condition.setCommand("IFEQ");
                    } else if (st[0].endsWith("NEQ")) {
                        condition.setCommand("IFNEQ");
                    } else if (st[0].endsWith("G")) {
                        condition.setCommand("IFG");
                    } else if (st[0].endsWith("L")) {
                        condition.setCommand("IFL");
                    } else if (st[0].endsWith("GE")) {
                        condition.setCommand("IFGE");
                    } else if (st[0].endsWith("LE")) {
                        condition.setCommand("IFLE");
                    }
                    condition.setOpe(st[1], st[2]);

                    st = br.readLine().split(" ");
                    condition.setResult(st[1]);

                    function.put(st[1], condition);
                }
                if (st[0].equals("ENDIF")) {
                    createFunction = false;
                    continue;
                }

                int a = (int) R.get(st[1]);
                int b = (int) R.get(st[2]);
                switch (st[0]) {
                    case "MOV":
                        int tmp1 = (int) R.get(st[1]);
                        int tmp2 = (int) R.get(st[2]);
                        R.put(st[1], tmp2);
                        R.put(st[2], tmp1);
                        break;
                    case "ADD":
                        R.put(st[1], add(a, b));
                        break;
                    case "SUB":
                        R.put(st[1], sub(a, b));
                        break;
                    case "MUL":
                        R.put(st[1], mul(a, b));
                        break;
                    case "DIV":
                        R.put(st[1], div(a, b));
                        break;
                    case "MOD":
                        R.put(st[1], mod(a, b));
                        break;
                    case "CALL":
                        Condition condition = function.get(st[1]);
                        if (condition != null) {
                            Object obj1 = R.get(condition.ope1);
                            Object obj2 = R.get(condition.ope2);
                            a = (obj1 != null ? (int) obj1 : Integer.parseInt(condition.ope1));
                            b = (obj2 != null ? (int) obj2 : Integer.parseInt(condition.ope2));

                            switch (condition.command) {
                                case "IFEQ":
                                    if (IFEQ(a, b)) {
                                        Object objResult = R.get(condition.result);
                                        result = (objResult != null ? (int) objResult : Integer.parseInt(condition.result));
                                    }
                                    break;
                                case "IFNEQ":
                                    if (IFNEQ(a, b)) {
                                        Object objResult = R.get(condition.result);
                                        result = (objResult != null ? (int) objResult : Integer.parseInt(condition.result));
                                    }
                                    break;
                                case "IFG":
                                    if (IFG(a, b)) {
                                        Object objResult = R.get(condition.result);
                                        result = (objResult != null ? (int) objResult : Integer.parseInt(condition.result));
                                    }
                                    break;
                                case "IFL":
                                    if (IFL(a, b)) {
                                        Object objResult = R.get(condition.result);
                                        result = (objResult != null ? (int) objResult : Integer.parseInt(condition.result));
                                    }
                                    break;
                                case "IFGE":
                                    if (IFGE(a, b)) {
                                        Object objResult = R.get(condition.result);
                                        result = (objResult != null ? (int) objResult : Integer.parseInt(condition.result));
                                    }
                                    break;
                                case "IFLE":
                                    if (IFLE(a, b)) {
                                        Object objResult = R.get(condition.result);
                                        result = (objResult != null ? (int) objResult : Integer.parseInt(condition.result));
                                    }
                                    break;
                            }
                        }
                        break;
                    case "RET":
                        bw.append(result == null ? "*" : result + "\n");
                        break;
                }
            }
        }
        bw.flush();
    }

    static private boolean IFEQ(int a, int b) {
        return a == b;
    }

    static private boolean IFNEQ(int a, int b) {
        return a != b;
    }

    static private boolean IFG(int a, int b) {
        return a > b;
    }

    static private boolean IFGE(int a, int b) {
        return a >= b;
    }

    static private boolean IFL(int a, int b) {
        return a < b;
    }

    static private boolean IFLE(int a, int b) {
        return a <= b;
    }


    static private int add(int a, int b) {
        return a + b;
    }

    static private int sub(int a, int b) {
        return a - b;
    }

    static private int mul(int a, int b) {
        return a * b;
    }

    static private int div(int a, int b) {
        return a / b;
    }

    static private int mod(int a, int b) {
        return a % b;
    }
}
