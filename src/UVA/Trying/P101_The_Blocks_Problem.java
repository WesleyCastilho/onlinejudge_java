package UVA.Trying;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: UVA Online Judge
 * @Problem: 101 - The Blocks Problem
 * @Link: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=37
 * @Timelimit: 3 seconds
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: LinkedList
 * @Note: move = ย้ายตัวเดียว, pile = ย้ายแถว ,(onto = แทรกกลาง)  (over = วางต่อหลัง)
 */

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class P101_The_Blocks_Problem {

    static class StackSlot {
        int id;
        Block firstBlock = null;
        Block lastBlock = null;

        public StackSlot(int id, Block block) {
            this.id = id;
            this.firstBlock = block;
            this.lastBlock = block;
        }

        void clear() {
            this.firstBlock = null;
            this.lastBlock = null;
        }


    }

    static class Block {
        int id;
        int stackIndex;
        Block under;
        Block upper;

        public Block(int id, int stackIndex) {
            this.id = id;
            this.stackIndex = stackIndex;
            this.under = null;
            this.upper = null;
        }

        void setStackID(int stackIndex) {
            this.stackIndex = stackIndex;
        }
    }

    static Block[] block;
    static StackSlot[] stack;

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/UVA/Trying/input/P101_input.txt");
        File outputFile = new File("src/UVA/Trying/output/P101_output.txt");
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        block = new Block[n];
        stack = new StackSlot[n];
        for (int i = 0; i < n; i++) {
            block[i] = new Block(i, i);
            stack[i] = new StackSlot(i, block[i]);
        }
        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("quit")) break;
            String[] command = input.split(" ");
            int a = Integer.parseInt(command[1]);
            int b = Integer.parseInt(command[3]);
            int desStackID = block[b].stackIndex;

            Block tmpLastStackA = stack[block[a].stackIndex].lastBlock;

            switch (command[0]) {
                case "move"://ย้าย block
                    switch (command[2]) {
                        case "onto": //ยก a ไปตัวเดียว วางบน b

                            break;
                        case "over":

                            break;
                    }
                    break;
                case "pile":
                    switch (command[2]) {
                        case "onto":


                            break;
                        case "over":

                            break;
                    }
                    break;
            }
        }
        System.out.println("End Process");
        for (int i = 0; i < n; i++) {
            bw.append(i + ":");
            Block block = stack[i].firstBlock;
            while (block != null) {
                bw.append(" " + block.id);
                block = block.upper;
            }
            bw.newLine();
        }
        bw.flush();

        System.out.println("End Program");
    }

    static void setAllStackId(Block block, int desStackID) {
        Block cur = block;
        while (cur != null) {
            cur.setStackID(desStackID);
            cur = cur.upper;
        }
    }

}
