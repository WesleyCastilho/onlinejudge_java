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
 * @Note:
 */

import java.io.*;

public class P101_The_Blocks_Problem {

    static class StackSlot {
        int slot;
        Block firstBlock = null;
        Block lastBlock = null;

        public StackSlot(int slot, Block block) {
            this.slot = slot;
            this.firstBlock = block;
            this.lastBlock = block;
        }


//        public void moveOver(Block blockA, Block blockB) {
//
//        }
//
//        public void moveOnto(Block blockA, Block blockB) {
//
//        }
//
//        public void pileOnto(StackSlot b) {
//
//        }
//
//        public void pileOver(StackSlot b) {
//
//        }
    }

    static class Block {
        int id;
        int slot;
        Block under = null;
        Block upper = null;

        public Block(int id, int slot) {
            this.id = id;
            this.slot = slot;
        }
    }

    static Block[] block;
    static StackSlot[] slot;

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/UVA/Trying/input/P101_input.txt");
        File outputFile = new File("src/UVA/Trying/output/P101_output.txt");
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        block = new Block[n];
        slot = new StackSlot[n];
        for (int i = 0; i < n; i++) {
            block[i] = new Block(i, i);
            slot[i] = new StackSlot(i, block[i]);
        }
        String input;
        while (!(input = br.readLine()).equals("quit")) {
            System.out.println(input);


            String[] command = input.split(" ");
            int a = Integer.parseInt(command[1]);
            int b = Integer.parseInt(command[3]);
            Block blockA = block[a];
            Block blockB = block[b];
            StackSlot slotA = slot[blockA.slot];
            StackSlot slotB = slot[blockB.slot];
            Block tmpB_upper = blockB.upper;
            Block tmpA_under = blockA.under;

//            System.out.println("command: " + command[0]);
//            System.out.println("a = " + blockA.id);
//            System.out.println("b = " + blockB.id);
//            System.out.println("type: " + command[2] + "\n");

            switch (command[0]) {
                case "move":
                    switch (command[2]) {
                        case "onto": //move A Onto B  (slot: ...B <-> A)
                            slotB.lastBlock.upper = blockA;
                            blockA.under = slotB.lastBlock;
                            slotB.lastBlock = slotA.lastBlock;
                            slotA.lastBlock = tmpA_under;

                            if (slotA.lastBlock == null) {
                                slotA.firstBlock = null;
                            }
                            break;
                        case "over"://move A Over B
                            if (slotB.lastBlock != null) {
                                slotB.lastBlock.upper = blockA;
                                blockA.under = slotB.lastBlock;
                                slotB.lastBlock = slotA.lastBlock;
                            } else {
                                slotB.lastBlock = blockA;
                                slotB.firstBlock = blockA;
                            }

                            slotA.lastBlock = tmpA_under;
                            if (slotA.lastBlock == null) {
                                slotA.firstBlock = null;
                            }
                            break;
                    }
                    break;
                case "pile":
                    switch (command[2]) {
                        case "onto"://pile A Onto B
//                            if (slotB.lastBlock != null) {
//                                slotB.lastBlock.upper = blockA;
//                                slotB.lastBlock = slotA.lastBlock;
//                                slotA.lastBlock = tmpA_under;
//                            }
//
//                            if (slotA.lastBlock == null) {
//                                slotA.firstBlock = null;
//                            }

                            break;
                        case "over"://pile A Over B
                            if (slotB.lastBlock != null) {
//                                System.out.print("1");
                                slotB.lastBlock.upper = blockA;
                                slotB.lastBlock = slotA.lastBlock;

                                if (blockA == slotA.firstBlock) {
                                    System.out.println("xxxxxxxxxxxxxxxxxxx");
                                    slotA.firstBlock = null;
                                    slotA.lastBlock = null;
                                }
                            } else {
//                                System.out.println("2");
                                slotB.firstBlock = blockA;
                                slotB.lastBlock = slotA.lastBlock;
                            }


                            break;
                    }
                    break;
            }
            printResult(n);
        }

        for (int i = 0; i < n; i++) {
            bw.append(i + ":");
            Block block = slot[i].firstBlock;
            while (block != null) {
                bw.append(" " + block.id);
                block = block.upper;
            }
            bw.newLine();
        }
        bw.flush();
    }

    static void printResult(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":");
            Block block = slot[i].firstBlock;
            while (block != null) {
                System.out.print(" " + block.id);
                block = block.upper;
            }
            System.out.println();
        }
        System.out.println();
    }

}
